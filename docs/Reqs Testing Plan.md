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

#### 7. Provider: 
1.
2.

#### 8. Provider: 
1.
2.

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

**Scenario S2:**
- **Setup:** 
- **Steps:**
  1. x
  2. y
- **Expected Outcome:**

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

**Scenario U2:**
- **Setup:** 
- **Steps:**
  1. x
  2. y
- **Expected Outcome:** 