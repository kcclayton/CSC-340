
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
- **US‑PROV‑001 — <Announce Globally>**  
  _Story:_ As a provider, I want to make announcements to all my residents so that they all get the same information at the same time. 
  _Acceptance:_
  ```gherkin
  Scenario: Make global announcements
    Given I want to send all my residents the same announcement
    When  I open the announcements tab
    Then  I can write an announcement with a subject and body text that will be sent to all the residents I'm responsible for
  ```

- **US‑PROV‑002 — <Block Users from Posting>**  
  _Story:_ As a provider, I want to stop a specific person from making or commenting on posts so that I can hold people responsible for going against community guidelines. 
  _Acceptance:_
  ```gherkin
  Scenario: Freeze user abilities
    Given I want to stop a user from posting for a certain amount of time
    When  I click on a username
    Then  I can open a menu, select to freeze their abilities, and specify for which reason and for how long
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
