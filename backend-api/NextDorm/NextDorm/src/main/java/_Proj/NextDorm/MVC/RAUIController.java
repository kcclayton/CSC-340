package _Proj.NextDorm.MVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import _Proj.NextDorm.Bans.Ban;
import _Proj.NextDorm.Bans.BanService;
import _Proj.NextDorm.Events.Event;
import _Proj.NextDorm.Events.EventService;
import _Proj.NextDorm.RA.RA;
import _Proj.NextDorm.RA.RAService;
import _Proj.NextDorm.Post.PostService;
import _Proj.NextDorm.User.User;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ras")
public class RAUIController {

    @Autowired
    private RAService raService;

    @Autowired
    private EventService eventService;

    @Autowired
    private BanService banService;

    @Autowired
    private PostService postService;

    // -------------------------------------------------------------------------
    // SIGN IN / SIGN UP
    // -------------------------------------------------------------------------

    // Show the RA sign-in page
    // GET /ras/signin  ->  ra-signin.ftlh
    @GetMapping("/signin")
    public String showSigninPage() {
        return "ra-signin";
    }

    // Process RA sign-in — mirrors StudentUIController.signin() exactly
    // POST /ras/signin
    @PostMapping("/signin")
    public String signin(@RequestParam String email,
                         @RequestParam String password,
                         HttpSession session,
                         Model model) {
        try {
            RA ra = raService.authenticate(email, password);
            session.setAttribute("raID", ra.getUserId());
            return "redirect:/ras/dashboard";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid email or password.");
            return "ra-signin";
        }
    }

    // Show the RA sign-up page
    // GET /ras/signup  ->  ra-signup.ftlh
    @GetMapping("/signup")
    public String showSignupPage() {
        return "ra-signup";
    }

    // Process RA sign-up: create a new RA account
    // POST /ras/signup
    @PostMapping("/signup")
    public String createNewRA(RA ra) {
        ra.setRole(User.UserRole.RA);
        raService.createRA(ra);
        return "redirect:/ras/signin";
    }

    // Show the posts feed (home page for RAs)
    // GET /ras/dashboard  ->  ra-posts.ftlh
    @GetMapping("/dashboard")
    public String viewPosts(Model model, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        RA ra = raService.getRAById(raID).orElse(null);
        model.addAttribute("ra", ra);
        model.addAttribute("commentsList", postService.getAllPosts());
        return "ra-posts";
    }

    // Sign out: clear session, redirect to sign-in
    // GET /ras/signout
    @GetMapping("/signout")
    public String signout(HttpSession session) {
        session.invalidate();
        return "redirect:/ras/signin";
    }

    // -------------------------------------------------------------------------
    // EVENTS PAGE (all events)
    // -------------------------------------------------------------------------

    // Show the RA events page with all events
    // GET /ras/eventposts  ->  ra-dashboard.ftlh
    @GetMapping("/eventposts")
    public String dashboard(Model model, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        RA ra = raService.getRAById(raID).orElse(null);
        model.addAttribute("ra", ra);
        model.addAttribute("eventsList", eventService.getAllEvents());
        return "ra-dashboard";
    }

    // Show only this RA's own events
    // GET /ras/eventposts/my-events  ->  ra-dashboard.ftlh (filtered)
    @GetMapping("/eventposts/my-events")
    public String myEvents(Model model, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        RA ra = raService.getRAById(raID).orElse(null);
        model.addAttribute("ra", ra);
        model.addAttribute("eventsList", eventService.getEventsByRa(raID));
        return "ra-dashboard";
    }

    // -------------------------------------------------------------------------
    // PROFILE (view + edit + delete)
    // -------------------------------------------------------------------------

    // Show the logged-in RA's own profile/edit page
    // GET /ras/profile  ->  ra-profile.ftlh
    @GetMapping("/profile")
    public String showProfile(Model model, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        RA ra = raService.getRAById(raID).orElse(null);
        model.addAttribute("ra", ra);
        return "ra-profile";
    }

    // Process profile update
    // POST /ras/profile/update
    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute RA updatedRA, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        updatedRA.setRole(User.UserRole.RA);
        raService.updateRA(raID, updatedRA);
        return "redirect:/ras/profile";
    }

    // Delete own account
    // POST /ras/profile/delete
    @PostMapping("/profile/delete")
    public String deleteProfile(HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        raService.deleteRA(raID);
        session.invalidate();
        return "redirect:/ras/signin";
    }

    // View another RA's profile by ID
    // GET /ras/directory/{id}  ->  ra-view-profile.ftlh
    @GetMapping("/directory/{id}")
    public String viewRAProfile(@PathVariable Long id, Model model, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        RA ra = raService.getRAById(id).orElse(null);
        model.addAttribute("ra", ra);
        return "ra-view-profile";
    }

    // -------------------------------------------------------------------------
    // RA DIRECTORY (view all + filter by residence)
    // -------------------------------------------------------------------------

    // Show all RAs
    // GET /ras/directory  ->  ra-directory.ftlh
    @GetMapping("/directory")
    public String directory(Model model, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        model.addAttribute("raList", raService.getAllRAs());
        model.addAttribute("residence", "");
        return "ra-directory";
    }

    // Filter RAs by residence description
    // GET /ras/directory/search?residence=North Hall  ->  ra-directory.ftlh
    @GetMapping("/directory/search")
    public String searchByResidence(@RequestParam String residence, Model model, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        model.addAttribute("raList", raService.searchRAsByResidenceDescription(residence));
        model.addAttribute("residence", residence);
        return "ra-directory";
    }

    // -------------------------------------------------------------------------
    // EVENTS (create, edit, delete)
    // -------------------------------------------------------------------------

    // Show create event form
    // GET /ras/events/create  ->  ra-create-event.ftlh
    @GetMapping("/events/create")
    public String showCreateEventPage(Model model, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        model.addAttribute("event", new Event());
        return "ra-create-event";
    }

    // Process new event submission
    // POST /ras/events/create
    @PostMapping("/events/create")
    public String createEvent(@ModelAttribute Event event, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        RA ra = raService.getRAById(raID).orElse(null);
        event.setRa(ra);
        eventService.createEvent(event);
        return "redirect:/ras/eventposts";
    }

    // Show edit event form
    // GET /ras/events/edit/{id}  ->  ra-edit-event.ftlh
    @GetMapping("/events/edit/{id}")
    public String showEditEventPage(@PathVariable Long id, Model model, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        Event event = eventService.getEventById(id).orElse(null);
        model.addAttribute("event", event);
        return "ra-edit-event";
    }

    // Process event update
    // POST /ras/events/edit/{id}
    @PostMapping("/events/edit/{id}")
    public String updateEvent(@PathVariable Long id, @ModelAttribute Event event, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        RA ra = raService.getRAById(raID).orElse(null);
        event.setRa(ra);
        eventService.updateEvent(id, event);
        return "redirect:/ras/eventposts";
    }

    // Delete an event
    // POST /ras/events/delete/{id}
    @PostMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable Long id, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        eventService.deleteEvent(id);
        return "redirect:/ras/eventposts";
    }

    // -------------------------------------------------------------------------
    // BANS (create, edit, delete, view)
    // -------------------------------------------------------------------------

    // Show create ban form
    // GET /ras/bans/create  ->  ra-create-ban.ftlh
    @GetMapping("/bans/create")
    public String showCreateBanPage(Model model, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        model.addAttribute("ban", new Ban());
        return "ra-create-ban";
    }

    // Process new ban submission
    // POST /ras/bans/create
    @PostMapping("/bans/create")
    public String createBan(@ModelAttribute Ban ban, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        RA ra = raService.getRAById(raID).orElse(null);
        ban.setRa(ra);
        banService.issueBan(ban);
        return "redirect:/ras/bans";
    }

    // Show all bans issued by the logged-in RA
    // GET /ras/bans  ->  ra-bans.ftlh
    @GetMapping("/bans")
    public String showBans(Model model, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        model.addAttribute("bansList", banService.getAllBans());
        return "ra-bans";
    }

    // Show edit ban form
    // GET /ras/bans/edit/{id}  ->  ra-edit-ban.ftlh
    @GetMapping("/bans/edit/{id}")
    public String showEditBanPage(@PathVariable Long id, Model model, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        Ban ban = banService.getBanById(id).orElse(null);
        model.addAttribute("ban", ban);
        return "ra-edit-ban";
    }

    // Process ban update
    // POST /ras/bans/edit/{id}
    @PostMapping("/bans/edit/{id}")
    public String updateBan(@PathVariable Long id, @ModelAttribute Ban ban, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        RA ra = raService.getRAById(raID).orElse(null);
        ban.setRa(ra);
        banService.updateBan(id, ban);
        return "redirect:/ras/bans";
    }

    // Delete a ban
    // POST /ras/bans/delete/{id}
    @PostMapping("/bans/delete/{id}")
    public String deleteBan(@PathVariable Long id, HttpSession session) {
        Long raID = (Long) session.getAttribute("raID");
        if (raID == null) return "redirect:/ras/signin";

        banService.deleteBan(id);
        return "redirect:/ras/bans";
    }
}
