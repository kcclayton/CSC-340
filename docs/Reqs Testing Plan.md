**Project Name:** NextDorm  
**Version:** 1.0 <br>
**Date:** 05-07-2026 <br>
**Purpose:** This document outlines comprehensive test scenarios for each functional requirement (user story) in the NextDorm system.

## Actors
- Provider P: Resident Advisor (RA)
- Customer C: Student
- Service S: Posting

## Use Cases
#### 1. Customer: US‑CUST‑001 — Register & manage profile
1. Customer C1 logs in for the first time and creates a profile.
2. C1 edits their profile to modify personal information.
3. C1 exists.

#### 2. Customer: US-CUST-002 — Log-in to profile
1. C1 has an existing account.
2. C1 inputs their username and password.
3. C1 is directed to the student dashboard.

#### 3. Customer: US-CUST-003 — Create and view a post
1. C1 logs in.
2. C1 selects "Add Post" from their dashboard.
3. C1 writes a post and clicks "Post". 

#### 4. Customer: US-CUST-003 — Create and view a post
1. C2 logs in.
2. C2 is sent to their dashboard containing all posts.
3. C2 views the post from C1, along with all other posts.
4. C2 clicks "My Building" and sees all posts from their residence hall.
5. C2 clicks "Important" and sees all important posts.

#### 5. Customer: US-CUST-003 — Create and view a post, Provider: US-PROV-005 — Block users from posting
1. C3 logs in.
2. C3 creates an offensive/inappropriate post.
4. Resident Advisor R1 logs in and views the post.
4. R1 bans the user, giving a reason and a ban duration.
5. C3 logs back in.
6. C3 attempts to make a post.
7. C3 is blocked from posting.

#### 6. Customer: US-CUST-004 — Create and view a reply
1. C2 logins in.
2. C2 views a post from C1.
3. C2 clicks the reply icon on the post.
4. C2 writes a reply and clicks "Post". 

#### 7. Provider: US‑PROV‑001 — Create RA Profile, US‑PROV‑002 — Login as RA, US‑PROV‑003 — Update RA Profile
1. Resident Advisor R1 navigates to the RA sign-up page and creates a new profile with a username and password.
2. R1 logs out and returns to the RA sign-in page.
3. R1 enters their credentials and is redirected to the RA home/dashboard page.
4. R1 navigates to their profile page and edits their personal information (e.g., residence assignment, bio).
5. R1 confirms the changes and verifies the updated profile is displayed.

#### 8. Provider: US‑PROV‑005 — View List of All RAs, US‑PROV‑006 — View Specific RA Profile, US‑PROV‑007 — Create Event, US‑PROV‑008 — Update Existing Event, US‑PROV‑009 — Delete Event, US‑PROV‑010 — View All Events, US‑PROV‑011 — View My Events
1. R1 logs in and navigates to the Directory page.
2. R1 views the full list of RAs and clicks on a specific RA's name to view their profile details.
3. R1 navigates to the Events page and clicks the create event button.
4. R1 fills in event details (title, description, date/time) and submits, confirming the event appears on the Events page.
5. R1 clicks the edit button on the event just created, updates its details, and confirms the event is updated.
6. R1 clicks the "My Events" filter and verifies only their own events are shown.
7. R1 clicks the delete button on their event, confirms deletion, and verifies the event is removed from the list.

#### 9. Provider: US‑PROV‑012 — Issue a Ban, US‑PROV‑013 — Update Existing Ban, US‑PROV‑014 — Delete a Ban, US‑PROV‑005 — Block users from posting
1. R1 logs in and navigates to the Bans page.
2. R1 clicks "Issue New Ban," enters a student ID, a reason, and a ban duration, then submits.
3. R1 confirms the ban record appears on the Bans page.
4. R1 clicks the edit button on the ban, updates its details, and confirms the ban record is updated.
5. C3 (a banned student) logs in and attempts to create a post — C3 is blocked from posting.
6. R1 navigates back to the Bans page, clicks delete on the ban, and confirms it is permanently removed.

## CROSS-CUTTING TEST SCENARIOS (Non-Functional Requirements)

### Performance Requirements

**Scenario P1: Discover page response time < 1.5 seconds**
- **Setup:** Server under typical load
- **Steps:**
  1. Measure response time for "Browse" page load with 5 active students and 5 active RAs, 10+ posts for each category (event, replies, and posts).
  2. Repeat 10 times
- **Expected Outcome:** 95% of requests ≤ 1.5 seconds

**Scenario P2: Post details page load < 1 second**
- **Setup:** Server under typical cload
- **Steps:**
  1. Measure response time for the "Posts" page.
  2. Repeat 10 times
- **Expected Outcome:** 99% of requests ≤ 1 second

### Security & Privacy Requirements

**Scenario S1: Role-based access control**
- **Setup:** Student tries to access RA dashboard
- **Steps:**
  1. Student logs in
  2. Student attemps to navigate to "/ras"/dashboard"
  3. Observes system response
- **Expected Outcome:** 
  - User is redirected to the sign-in page.
  - No RA data is exposed.

**Scenario S2: RA cannot access student routes**
- **Setup:** RA is logged in with a valid RA account
- **Steps:**
  1. RA logs in via `/ras/signin`, establishing an `raID` session attribute
  2. RA attempts to navigate to `/students` (the student dashboard)
  3. Observes system response
- **Expected Outcome:**
  - RA is redirected to `/students/signin`
  - No student data is exposed

### Usability Requirements

**Scenario U1: New User creates first post in ≤ 2 minutes**
- **Setup:** New user participation in hallway test
- **Steps:**
  1. User logs in
  2. User is directed to their dashboard
  3. User clicks "Create Post"
  4. User inputs relevant information and clicks "post"
  5. Record time
- **Expected Outcome:** Time to complete first post ≤ 2 minutes

**Scenario U2: RA can create first event in ≤ 5 minutes**
- **Setup:** New RA account; interview/walkthrough observed
- **Steps:**
  1. RA logs in
  2. RA navigates to the Events page
  3. RA clicks "Create Event" and fills in event details (title, description, date/time)
  4. RA submits the event
  5. Record total time
- **Expected Outcome:** Time to complete first event creation ≤ 5 minutes