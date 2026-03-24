# NextDorm - Backend API Documentation

**Version:** 1.0
**Last Updated:** March 23, 2026
**Base URL:** `http://localhost:8080/api`

---
## Table of Contents

1. [Overview](#1-overview)
2. [User Roles](#2-user-roles)
3. [UML Class Diagram](#3-uml-class-diagram)
4. [API Endpoints](#4-api-endpoints)
   - [Student Management](#student-management)
   - [RA Management](#ra-management)
   - [Post Management](#post-management)
   - [Reply Management](#reply-management)
   - [Event Management](#event-management)
   - [Ban Management](#ban-management)
5. [Use Case Mapping](#5-use-case-mapping)

---
## 1. Overview

NextDorm Backend API provides REST endpoints for a campus community platform where students and resident advisors (RAs) can register, post messages, comment, manage events, and enforce community rules.

Core domains:
- **Users**: Students and RA profiles, authentication data.
- **Posts**: Community posts created by any authorized user.
- **Replies**: Comments for posts.
- **Events**: RA announcements and community activities.
- **Bans**: RA-driven temporary bans for community misuse.

---
## 2. User Roles

| Role | Description | Primary Responsibilities |
|------|-------------|--------------------------|
| **STUDENT** | In-app community resident | register, login, create posts, comment, browse events |
| **RA** | Resident Advisor / moderator | register, login, create posts/events, ban users, moderate community |

---
## 3. UML Class Diagram
![UML Class Diagram](../../../docs/uml_diagram.png)

---
## 4. API Endpoints

### Student Management
 <!-- Student info goes here! -->

---

### RA Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/ras` | Get all RAs |
| GET | `/ras/{id}` | Get an RA by ID |
| GET | `/ras/residence/{residenceDescription}` | Get all RAs by residence description |
| POST | `/ras` | Create a new RA |
| PUT | `/ras/{id}` | Update an existing RA |
| DELETE | `/ras/{id}` | Delete an RA |
 
**Example POST /ras request body:**
```json
{
  "username": "ra_johnson",
  "email": "johnson@uncg.edu",
  "userPassword": "SecurePass123!",
  "name": "Alex Johnson",
  "residenceDescription": "North Hall - 2nd Floor"
}
```
 
**Example response:**
```json
{
  "userId": 1,
  "username": "ra_johnson",
  "email": "johnson@uncg.edu",
  "name": "Alex Johnson",
  "role": "RA",
  "residenceDescription": "North Hall - 2nd Floor",
  "bans": [],
  "eventPosts": []
}
```

---

### Post Management
<!-- Post info goes here! -->

---

### Reply Management
<!-- Reply info goes here! -->

---

### Event Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/eventposts` | Get all event posts |
| GET | `/eventposts/{id}` | Get an event post by ID |
| GET | `/eventposts/ra/{raId}` | Get all event posts created by a specific RA |
| GET | `/eventposts/search?description={description}` | Search event posts by description |
| POST | `/eventposts` | Create a new event post |
| PUT | `/eventposts/{id}` | Update an existing event post |
| DELETE | `/eventposts/{id}` | Delete an event post |
 
**Example POST /eventposts request body:**
```json
{
  "organizationName": "North Hall RAs",
  "eventDate": "2026-04-01",
  "location": "North Hall Front Lawn",
  "description": "Mandatory fire drill for all residents",
  "ra": { "userId": 1 }
}
```
 
**Example response:**
```json
{
  "eventPostId": 1,
  "organizationName": "North Hall RAs",
  "eventDate": "2026-04-01",
  "location": "North Hall Front Lawn",
  "description": "Mandatory fire drill for all residents",
  "ra": { "userId": 1 }
}
```

---

### Ban Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/bans` | Get all bans |
| GET | `/bans/{id}` | Get a ban by ID |
| GET | `/bans/student/{studentId}` | Get all bans for a specific student |
| GET | `/bans/ra/{raId}` | Get all bans issued by a specific RA |
| POST | `/bans` | Issue a new ban |
| PUT | `/bans/{id}` | Update an existing ban |
| DELETE | `/bans/{id}` | Delete a ban record |
 
**Example POST /bans request body:**
```json
{
  "studentId": 2,
  "ra": { "userId": 1 },
  "description": "Violation of community guidelines",
  "banLength": 30
}
```
 
**Example response:**
```json
{
  "banId": 1,
  "studentId": 2,
  "ra": { "userId": 1 },
  "description": "Violation of community guidelines",
  "banLength": 30
}
```

---

## 5. Use Case Mapping

| Use Case | ID | Endpoint(s) |
|----------|----|-------------|
| Create RA Profile | US-PROV-001 | `POST /ras` |
| Login as RA | US-PROV-002 | `GET /ras/{id}` |
| Create Post / Announcement | US-PROV-003 | `POST /eventposts` |
| Announce Globally | US-PROV-004 | `POST /eventposts`, `GET /eventposts` |
| Block Users from Posting | US-PROV-005 | `POST /bans`, `DELETE /bans/{id}` |