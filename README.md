# 🏨 Hotel Reservation System

A RESTful Hotel Reservation System built with **Java Spring Boot**, featuring room management, booking workflows, user authentication, and payment processing.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Framework | Spring Boot 3 |
| Database | PostgreSQL (H2 for local dev/testing) |
| ORM | Spring Data JPA + Hibernate |
| Security | Spring Security + JWT |
| Build Tool | Maven |
| API Docs | Swagger UI (Springdoc) |
| Frontend (optional) | Thymeleaf or React |

---

## 📁 Project Structure

```
hotel-reservation-system/
├── src/
│   └── main/
│       ├── java/com/hotel/
│       │   ├── HotelApplication.java
│       │   ├── model/
│       │   │   ├── User.java
│       │   │   ├── Room.java
│       │   │   ├── Reservation.java
│       │   │   └── Payment.java
│       │   ├── repository/
│       │   │   ├── UserRepository.java
│       │   │   ├── RoomRepository.java
│       │   │   ├── ReservationRepository.java
│       │   │   └── PaymentRepository.java
│       │   ├── service/
│       │   │   ├── UserService.java
│       │   │   ├── RoomService.java
│       │   │   ├── ReservationService.java
│       │   │   └── PaymentService.java
│       │   ├── controller/
│       │   │   ├── AuthController.java
│       │   │   ├── RoomController.java
│       │   │   ├── ReservationController.java
│       │   │   └── PaymentController.java
│       │   ├── dto/
│       │   │   ├── RegisterRequest.java
│       │   │   ├── LoginRequest.java
│       │   │   ├── ReservationRequest.java
│       │   │   └── RoomResponse.java
│       │   ├── exception/
│       │   │   ├── GlobalExceptionHandler.java
│       │   │   ├── RoomNotFoundException.java
│       │   │   └── ReservationConflictException.java
│       │   └── security/
│       │       ├── JwtUtil.java
│       │       ├── SecurityConfig.java
│       │       └── UserDetailsServiceImpl.java
│       └── resources/
│           ├── application.properties
│           └── data.sql
├── pom.xml
└── README.md
```

---

## 🗃️ Core Entities & Relationships

```
User ──────────< Reservation >────────── Room
                     │
                     └──────────< Payment
```

| Entity | Key Fields |
|---|---|
| **User** | id, name, email, password, role (GUEST / ADMIN) |
| **Room** | id, roomNumber, type, pricePerNight, status (AVAILABLE / BOOKED) |
| **Reservation** | id, userId, roomId, checkIn, checkOut, status, totalPrice |
| **Payment** | id, reservationId, amount, paymentDate, method, status |

---

## 🌐 API Endpoints

### Auth
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Login and receive JWT token |

### Rooms
| Method | Endpoint | Access | Description |
|---|---|---|---|
| GET | `/api/rooms` | Public | List all rooms |
| GET | `/api/rooms/{id}` | Public | Get room details |
| GET | `/api/rooms/search?checkIn=&checkOut=` | Public | Check availability |
| POST | `/api/rooms` | ADMIN | Add a room |
| PUT | `/api/rooms/{id}` | ADMIN | Update a room |
| DELETE | `/api/rooms/{id}` | ADMIN | Remove a room |

### Reservations
| Method | Endpoint | Access | Description |
|---|---|---|---|
| POST | `/api/reservations` | User | Book a room |
| GET | `/api/reservations/my` | User | View my bookings |
| GET | `/api/reservations/{id}` | User | Get booking details |
| PUT | `/api/reservations/{id}/cancel` | User | Cancel a booking |
| GET | `/api/reservations` | ADMIN | View all bookings |

### Payments
| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/payments` | Process a payment |
| GET | `/api/payments/{reservationId}` | Get payment for a booking |

---

## 🔑 Key Business Logic

- **Availability Check** — Before confirming a booking, the system verifies no overlapping reservation exists for the requested date range.
- **Role-Based Access** — Guests can only view and cancel their own reservations. Admins can manage all resources.
- **Automatic Price Calculation** — `totalPrice = number of nights × pricePerNight`
- **Reservation Status Flow:**

```
PENDING → CONFIRMED → CHECKED_IN → CHECKED_OUT
                                 ↘ CANCELLED
```

---

## ⚙️ Getting Started

### Prerequisites
- Java 17 or 21
- Maven
- PostgreSQL (or H2 for local development)
- IntelliJ IDEA (recommended)

### 1. Clone the repository
```bash
git clone https://github.com/your-username/hotel-reservation-system.git
cd hotel-reservation-system
```

### 2. Configure the database

For **H2 (quick local dev)**, update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:h2:mem:hoteldb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=create-drop
```

For **PostgreSQL**:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hoteldb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the application
```bash
mvn spring-boot:run
```

### 4. Access the API docs
```
http://localhost:8080/swagger-ui.html
```

---

## 🧪 Running Tests
```bash
mvn test
```

---

## 🗺️ Build Roadmap

- [x] Project setup
- [ ] Models & database entities
- [ ] Repository layer
- [ ] Service layer (business logic)
- [ ] REST controllers
- [ ] JWT authentication & role-based security
- [ ] Swagger API documentation
- [ ] Unit tests (JUnit)
- [ ] Frontend (optional)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).