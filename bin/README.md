## Gym Management System - API Documentation

This document outlines the REST API endpoints for managing **members** and **subscriptions** within the Gym Management System.

**Base URL:** `/api/gym`

---

## 🏋️‍♀️ Member Endpoints

### Basic CRUD

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/api/gym/members/add`           | Add a new gym member |
| GET    | `/api/gym/members/{id}`          | Get specific member by ID |
| GET    | `/api/gym/members/all`           | List all members |
| PUT    | `/api/gym/members/update/{id}`   | Update member information |
| DELETE | `/api/gym/members/delete/{id}`   | Remove member from system |

### Extra Features

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/gym/members/search?name=John`   | Find members by partial/full name |
| GET    | `/api/gym/members/active`             | Get list of members with active subscriptions |
| GET    | `/api/gym/members/no-subscription`    | Identify members not subscribed |

---

## 💳 Subscription Endpoints

### Basic CRUD

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/api/gym/subscriptions/add`           | Create a subscription for a member |
| GET    | `/api/gym/subscriptions/{id}`          | Get subscription by ID |
| GET    | `/api/gym/subscriptions/all`           | List all subscriptions |
| PUT    | `/api/gym/subscriptions/update/{id}`   | Modify existing subscription |
| DELETE | `/api/gym/subscriptions/delete/{id}`   | Remove a subscription record |

### Useful Queries

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/gym/subscriptions/member/{memberId}` | Get all subscriptions of a member |
| GET    | `/api/gym/subscriptions/active`           | List all ongoing subscriptions |
| GET    | `/api/gym/subscriptions/expired`          | List all past subscriptions |
| GET    | `/api/gym/subscriptions/ending-soon`      | Subscriptions ending in next 7 days |

---

## 📊 Dashboard/Statistics Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/api/gym/stats/total-members`           | Count of all registered members |
| GET    | `/api/gym/stats/active-subscriptions`    | Count of currently active subscriptions |
| GET    | `/api/gym/stats/new-members?month=2025-04` | Count of new members in given month |

---
