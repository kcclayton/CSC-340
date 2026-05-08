
# Requirements – Starter Template

**Project Name:** NextDorm \
**Team:** Katie Williams | Lead Developer - Customer Section, and KC Clayton | Lead Developer - Provider Section \
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-01-30\
**Purpose:** This SRS consolidates the scope and user‑facing requirements of NextDorm and enumerates all user stories that guide development and testing.

---

## 1. Overview
**Vision.** Getting information out to thousands of college residents is tedious and inefficient. Your inbox is constantly flooded with fliers, notifications, and due dates for paperwork-- that is, if you don't use NextDorm.

Our software puts resident communication all in one place, and connects students with their RAs and other college resources. Never again wonder when the next fire drill is, who has your lost socks, or who to call when the sink won't stop running!

**Glossary** Terms used in the project
- **RA:** Resident Advisor, an individual (usually a student) hired to supervise student residents on a college campus

**Primary Users / Roles.**
- **Student** — Students will be able to interact with other residents by making, commenting on, and following posts related to their desired topics, and directly message individuals or groups. 
- **Resident Advisor** — RAs will be able to make, comment on, and moderate posts for their residents, directly message individuals or groups, and be identifiable as an RA to all users. They will be able to change basic layout details for their community pages, and will have the ability to temporarily freeze their residents' posting/commenting privelages on the grounds of inappropriate behavior (as defined by the student handbook).

**Scope (this semester).**
- Create user profile
- Login as Student/RA
- Create post
- Comment on post
- Tag a post
- Global announcements

**Out of scope (deferred).**
- Direct messaging
- Interactive map to locate posts

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario.

### 2.1 Customer Stories
- **US‑CUST‑001 — Create User Profile**  
  _Story:_ As a student, I want to create a profile so that I can interact with other users.\
  _Acceptance:_
  > Must be a student at an accepted university
  ```gherkin
  Scenario: Creating a user profile
    Given I have not registered an account
    When  I click the create profile button
    Then  I can choose a username and password for my account, and enter information about myself for others to see
  ```

- **US‑CUST‑002 — Login as Student**\
  _Story:_ As a student, I want to log in so that I can come back to what I was doing before.\
  _Acceptance:_
  
  > Username must be at least 6 characters long.\
  > Password must be at least 12 characters long, and contain at least 1 capital letter and 1 symbol
  ```gherkin
  Scenario: Logging in
    Given I want to log in to my account
    When  I go to the login screen
    Then  I enter my username and password and am logged in to my account 
  ```

  - **US‑CUST‑003 — Create Post**  
  _Story:_ As a student, I want to create posts so that I can share information with my community.\
  _Acceptance:_
  ```gherkin
  Scenario: Create a post
    Given I want to create a post
    When  I go to the create post page
    Then  I can write a title, text, add pictures, and send it out for other users to see
  ```

  - **US‑CUST‑004 — Comment on Post**  
  _Story:_ As a student, I want to respond to people's posts so that I can give them feedback on what they shared.\
  _Acceptance:_
  ```gherkin
  Scenario: Responding to a post
    Given There is a post available to respond to
    When  I click reply
    Then  I can write a text reply and publish it
  ```

  - **US‑CUST‑005 — Tag a Post**  
  _Story:_ As a student, I want to tag posts so that I can share information with who it's relevant to.\
  _Acceptance:_
  ```gherkin
  Scenario: Tagging a post
    Given I have made a post
    When  I select a pre-made tag
    Then  it is attached to my post
      And users can find the post by the new tag
  ```

### 2.2 Provider Stories
- **US‑PROV‑001 — Create RA Profile**  
  _Story:_ As an RA, I want to create a profile so that I can interact with my residents.\
  _Acceptance:_
  > Must be an employee at an accepted university
  ```gherkin
  Scenario: Creating an RA profile
    Given I have not registered an account
    When  I click the create profile button
    Then  I can choose a username and password for my account, and enter information about myself for others to see
  ```

- **US‑PROV‑002 — Login as RA**  
  _Story:_ As an RA, I want to log in so that I can access my dashboard and manage my residents.\
  _Acceptance:_
  > Must have a registered RA account
  ```gherkin
  Scenario: Logging in as an RA
    Given I have a registered RA account
    When  I go to the RA login screen and enter my email and password
    Then  I am authenticated and redirected to the Home page
  ```

- **US‑PROV‑003 — Update RA Profile**  
  _Story:_ As an RA, I want to update my profile information so that my details stay current.\
  _Acceptance:_
  > Must be logged in as an RA
  ```gherkin
  Scenario: Updating RA profile
    Given I am logged in as an RA
    When  I navigate to my profile page and edit my information
    Then  my profile is updated and I am returned to my profile page
  ```

- **US‑PROV‑004 — Delete RA Profile**  
  _Story:_ As an RA, I want to delete my profile when I no longer need it.\
  _Acceptance:_
  > Must be logged in as an RA
  ```gherkin
  Scenario: Deleting an RA profile
    Given I am logged in as an RA
    When  I go to my profile page and click the delete button
    Then  my account is permanently deleted and I am redirected to the sign-in page
  ```

- **US‑PROV‑005 — View List of All RAs**  
  _Story:_ As an RA, I want to see a list of all other RAs so I know who my coworkers are.\
  _Acceptance:_
  > Must be logged in as an RA
  ```gherkin
  Scenario: View all RAs
    Given I am logged in as an RA
    When  I navigate to the Directory page
    Then  I can see a full list of all current RAs with their usernames and residence assignments
  ```

- **US‑PROV‑006 — View Specific RA Profile**  
  _Story:_ As an RA, I want to view another RA's profile so I can learn more about them.\
  _Acceptance:_
  > Must be logged in as an RA
  ```gherkin
  Scenario: Viewing a specific RA's profile
    Given I am on the Directory page
    When  I click on an RA's name
    Then  I am taken to that RA's profile page showing their details
  ```

- **US‑PROV‑007 — Create Event**  
  _Story:_ As an RA, I want to create event posts so that I can inform residents of upcoming activities.\
  _Acceptance:_
  > Must be logged in as an RA
  ```gherkin
  Scenario: Creating an event
    Given I am logged in as an RA
    When  I navigate to the Events page and click the create event button
    Then  I can fill in the event details and submit to publish the event
  ```

- **US‑PROV‑008 — Update Existing Event**  
  _Story:_ As an RA, I want to edit an event I created so that I can correct or update its details.\
  _Acceptance:_
  > Must be logged in as an RA
  ```gherkin
  Scenario: Updating an event
    Given I am on the Events page
    When  I click the edit button on an event and update its details
    Then  the event is updated and I am returned to the Events page
  ```

- **US‑PROV‑009 — Delete Event**  
  _Story:_ As an RA, I want to delete an event I created so that I can remove outdated or cancelled events.\
  _Acceptance:_
  > Must be logged in as an RA
  ```gherkin
  Scenario: Deleting an event
    Given I am on the Events page
    When  I click the delete button on an event and confirm
    Then  the event is permanently removed and the Events page refreshes
  ```

- **US‑PROV‑010 — View All Events**  
  _Story:_ As an RA, I want to see all posted events so that I stay informed about what is happening across residences.\
  _Acceptance:_
  > Must be logged in as an RA
  ```gherkin
  Scenario: Viewing all events
    Given I am logged in as an RA
    When  I navigate to the Events page
    Then  I can see a list of all events posted by all RAs
  ```

- **US‑PROV‑011 — View My Events**  
  _Story:_ As an RA, I want to filter events to only those I created so that I can manage my own posts easily.\
  _Acceptance:_
  > Must be logged in as an RA
  ```gherkin
  Scenario: Viewing my events
    Given I am on the Events page
    When  I click the My Events filter
    Then  the list updates to show only events I have created
  ```

- **US‑PROV‑012 — Issue a Ban**  
  _Story:_ As an RA, I want to issue a ban to a student so that I can enforce community guidelines.\
  _Acceptance:_
  > Must be logged in as an RA
  ```gherkin
  Scenario: Issuing a ban
    Given I am logged in as an RA
    When  I navigate to the Bans page and click Issue New Ban
    Then  I can enter the student ID, reason, and ban length and submit to record the ban
  ```

- **US‑PROV‑013 — Update Existing Ban**  
  _Story:_ As an RA, I want to edit an existing ban so that I can correct its details if needed.\
  _Acceptance:_
  > Must be logged in as an RA
  ```gherkin
  Scenario: Updating a ban
    Given I am on the Bans page
    When  I click the edit button on a ban and update its details
    Then  the ban record is updated and I am returned to the Bans page
  ```

- **US‑PROV‑014 — Delete a Ban**  
  _Story:_ As an RA, I want to delete a ban record so that I can remove bans that were issued in error or have expired.\
  _Acceptance:_
  > Must be logged in as an RA
  ```gherkin
  Scenario: Deleting a ban
    Given I am on the Bans page
    When  I click the delete button on a ban and confirm
    Then  the ban record is permanently removed and the Bans page refreshes
  ```

- **US‑PROV‑015 — View All Bans**  
  _Story:_ As an RA, I want to see all issued bans so that I have a complete record of disciplinary actions.\
  _Acceptance:_
  > Must be logged in as an RA
  ```gherkin
  Scenario: Viewing all bans
    Given I am logged in as an RA
    When  I navigate to the Bans page
    Then  I can see a list of all bans issued across all RAs, including student ID, reason, and ban length
  ```

---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** Main post feed should be loaded within 3 seconds given a stable/good network connection. 
- **Availability/Reliability:** The app should have ~99% uptime besides needed maintenance.
- **Security/Privacy:** Hashed passwords. RA login requires two-factor authentication.
- **Usability:** New users should be able to publish a post within 5 minutes. App should meet accessability standards so
individuals with disabilities can use the app effectively. 

---

## 4. Assumptions, Constraints, and Policies
- Using modern browsers (Chrome, Firefox, Edge, Safari, etc.).
- User can connect to the website and can stay connected.
- User is a university student.
- Constraints for working within the allotted course timeline. 
- Policies: Reports are accurately assessed to avoid cases of harassment or inaccurate information. 

---

## 5. Milestones (course‑aligned)
- **M2 Requirements** — this file + stories opened as issues. 
- **M3 High‑fidelity prototype** — core customer/provider flows fully interactive. 
- **M4 Design** — architecture, schema, API outline. 
- **M5 Backend API** — key endpoints + tests. 
- **M6 Increment** — ≥2 use cases end‑to‑end. 
- **M7 Final** — complete system & documentation. 

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.  
- Major changes should update this SRS.
