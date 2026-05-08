# NextDorm - MVC Application

A Spring MVC web application connecting residents with fellow students and their resident advisors (RA) to stay on top of information and foster a sense of community.
For ease of use when building the application, the finished MVC-app can be found within the backend-api folder. The additions were the .ftlh pages, public images and css styling, and the respective controllers for students and RAs.

## Architecture Overview

This application follows the **Model-View-Controller (MVC)** pattern:

### Models (Entities)
Located in `src/main/java/_Proj_/NextDorm`

- **User** - Base entity for authentication (abstract parent class)
- **Student** - Extends User; manages posts and replies
- **RA** - Extends User; manages events and bans
- **Bans** - Manages student bans for inappropriate conduct
- **Events** - Posts about events around campus
- **Post** - General posts, which can be further split into tags
- **Reply** - Replies to posts


### Views (Templates)
Located in `src/main/resources/templates/`

**Customer Views:**
- `comments-hall-list.ftlh` - View all posts for a specific residence hall
- `comments-important-list.ftlh` - View all posts tagged as "emergency"
- `comments-list.ftlh` - View all posts
- `create-post.ftlh` - Create a post
- `create-reply.ftlh` - Create a reply for a post
- `events.ftlh` - View all events created by RAs
- `personal-profile.ftlh` - View and update student profile
- `profile.ftlh` - View profiles for students
- `student-ban.ftlh` - If a user is banned and attempts to post, redirects here and provides the ban reason and length

**Farmer Views:**
- `ra-bans.ftlh` - Current bans, time frame, and associated students
- `ra-create-bans.ftlh` - Create a ban for a specific student
- `ra-create-events.ftlh` - Create an event
- `ra-dashboard.ftlh` - View the RA dashboard
- `ra-directory.ftlh` - View all RAs currently registered
- `ra-edit-ban.ftlh` - Edit bans
- `ra-edit-event.ftlh` - Edit events
- `ra-posts.ftlh` - View all current posts created by students
- `ra-profile.ftlh` - View and edit RA profile


**Public Pages:**
- `signin.ftlh` - Sign in as a student
- `signin.ftlh` - Sign up as a student
- `ra-signin.ftlh` - Sign in as an RA
- `ra-signup.ftlh` - Sign up as an RA

### Controllers

**API Controllers** - RESTful endpoints for data operations:
- `BanController` - Ban management
- `EventController` - Event operations
- `PostController` - Post operations
- `RAController` - RA CRUD operations
- `ReplyController` - Reply operations
- `StudentController` - Student CRUD operations

**UI Controllers** - Page rendering and navigation:
- `AppUiController` - Public pages (home, auth)
- `FarmerUiController` - Farmer dashboard and all farmer views
- `CustomerUiController` - Customer dashboard and all customer views

### Services
Located in `src/main/java/_Proj/NextDorm`

Business logic layer providing CRUD operations and domain-specific functionality:
- `BanService` - Ban CRUD, retrieval and management
- `EventService` - Event CRUD, data and management
- `PostService` - Post CRUD, data and management
- `RAService` - Student registration, profile, account management
- `ReplyService` - Reply CRUD, data and management
- `StudentService` - Student registration, profile updates, account management

### Repositories
Located in `src/main/java/_Proj/NextDorm`

Data access layer interfacing with the database (Spring Data JPA):
- `BanRepository` - Ban lookup by student and RA
- `EventRepository` -Event queries (by RA, by description)
- `PostRepository` - Post quieres (by student ID, by residence hall, by tag)
- `RARepository` - Student lookup by email and residence hall
- `ReplyRepository` - Reply queries (by post, by student ID)
- `StudentRepository` - Student lookup by email and residence hall

## Key Features

### User Roles & Authentication
- **Student**: Browse and create posts and replies, view events
- **RA**: Create/manage bans, view posts and replies, create events

### Student Flow
1. Sign up and create student profile
2. Browse posts from all students, only students in your hall, or only emergency posts
3. Create replies for posts
4. View students profiles


### RA Flow
1. Sign up and create RA profile
2. Create and manage bans (reason, duration)
3. View all posts and replies
4. Create, edit, and delete events
5. View all current RAs


## Session Management
- Uses `HttpSession` for storing `studentID` and `raID`
- Automatic redirect to signin for unauthenticated access to protected pages
- Session validation on all sensitive endpoints

## Database Relationships
- **One-to-Many**: Student → Posts, Students → Replies, RA → Bans,  RA → Events, Posts → Replies
- **Many-to-One**: Reply → Post, Posts/Replies → Students, Events → RA,  Bans → RA
- **Cascade Operations**: Automatic cascading for related entity changes
- **JsonIgnoreProperties**: Prevents circular reference serialization