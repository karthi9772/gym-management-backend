**Gym Management System - API Documentation**

This document outlines the REST API endpoints for managing **members** and **subscriptions** within the Gym Management System.

---

## 🣍 Member Endpoints

### Basic CRUD

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/members/add`           | Add a new gym member |
| GET    | `/members/{id}`          | Get specific member by ID |
| GET    | `/members/all`           | List all members |
| PUT    | `/members/update/{id}`   | Update member information |
| DELETE | `/members/delete/{id}`   | Remove member from system |

### Extra Features

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/members/search?name=John`   | Find members by partial/full name |
| GET    | `/members/active`             | Get list of members with active subscriptions |
| GET    | `/members/no-subscription`    | Identify members not subscribed |

---

## 💳 Subscription Endpoints

### Basic CRUD

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/subscriptions/add`           | Create a subscription for a member |
| GET    | `/subscriptions/{id}`          | Get subscription by ID |
| GET    | `/subscriptions/all`           | List all subscriptions |
| PUT    | `/subscriptions/update/{id}`   | Modify existing subscription |
| DELETE | `/subscriptions/delete/{id}`   | Remove a subscription record |

### Useful Queries

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/subscriptions/member/{memberId}` | Get all subscriptions of a member |
| GET    | `/subscriptions/active`           | List all ongoing subscriptions |
| GET    | `/subscriptions/expired`          | List all past subscriptions |
| GET    | `/subscriptions/ending-soon`      | Subscriptions ending in next 7 days |

---

## 📊 Dashboard/Statistics Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET    | `/stats/total-members`           | Count of all registered members |
| GET    | `/stats/active-subscriptions`    | Count of currently active subscriptions |
| GET    | `/stats/new-members?month=2025-04` | Count of new members in given month |

---
