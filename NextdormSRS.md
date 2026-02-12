
# Requirements – Starter Template

**Project Name:** NextDorm \
**Team:** Katie Williams | Lead Developer - Customer Section, and KC Clayton | Lead Developer - Provider Section \
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-01-30

---

## 1. Overview
**Vision.** Getting information out to thousands of college residents is tedious and inefficient. Your inbox is constantly flooded with fliers, notifications, and due dates for paperwork-- that is, if you don't use NextDorm.

Our software puts resident communication all in one place, and connects students with their RAs and other college resources. Never again wonder when the next fire drill is, who has your lost socks, or who to call when the sink won't stop running!

**Glossary** Terms used in the project
- **Term 1:** description.
- **Term 2:** description

**Primary Users / Roles.**
- **Student** — Students will be able to interact with other residents by making, commenting on, and following posts related to their desired topics, and directly message individuals or groups. 
- **Resident Advisor** — RAs will be able to make, comment on, and moderate posts for their residents, directly message individuals or groups, and be identifiable as an RA to all users. They will be able to change basic layout details for their community pages, and will have the ability to temporarily freeze their residents' posting/commenting privelages on the grounds of inappropriate behavior (as defined by the student handbook).

**Scope (this semester).**
- <capability 1> Create user profile
- <capability 2> Login as Student/RA
- <capability 3> Create post
- <capability 4> Comment on post
- <capability 5> Tag a post
- <capability 6> Global announcements

**Out of scope (deferred).**
- <deferred 1> Direct messaging
- <deferred 2> Interactive map to locate posts

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario.

### 2.1 Customer Stories
- **US‑CUST‑001 — <Create User Profile>**  
  _Story:_ As a student, I want to create a profile so that I can interact with other users.
  _Acceptance:_
  > Must be a student at an accepted university
  ```
  Scenario: Creating a user profile
    Given I want to create a profile
    When  I click the create profile button
    Then  I can choose a username and password for my account, and enter information about myself for others to see
  ```

- **US‑CUST‑002 — <Login as Student>**
  _Story:_ As a student, I want to log in so that I can come back to what I was doing before.
  _Acceptance:_
  > Username must be at least 6 characters long
  > Password must be at least 12 characters long, and contain at least 1 captial letter and 1 symbol
  ```
  Scenario: Logging in
    Given I want to log in to my account
    When  I go to the login screen
    Then  I want to enter my username and password and 
  ```

  - **US‑CUST‑003 — <Create Post>**  
  _Story:_ As a student, I want to create posts so that I can share information with my community.
  _Acceptance:_
  ```
  Scenario: Create a post
    Given I want to create a post
    When  I go to the create post page
    Then  I can write a title, text, add pictures, and send it out for other users to see
  ```

  - **US‑CUST‑004 — <Comment on Post>**  
  _Story:_ As a student, I want to respond to people's posts so that I can give them feedback on what they shared.
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

  - **US‑CUST‑005 — <Tag a Post>**  
  _Story:_ As a student, I want to tag posts so that I can share information with who it's relevant to.
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

### 2.2 Provider Stories
- **US‑PROV‑001 — <Announce Globally>**  
  _Story:_ As a provider, I want to make announcements to all my residents so that they all get the same information at the same time. 
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑PROV‑002 — <Block Users from Posting>**  
  _Story:_ As a provider, I want to stop a specific person from making or commenting on posts so that I can hold people responsible for going against community guidelines. 
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** description 
- **Availability/Reliability:** description
- **Security/Privacy:** description
- **Usability:** description

---

## 4. Assumptions, Constraints, and Policies
- list any rules, policies, assumptions, etc.

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
