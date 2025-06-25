# 💬 Khuluma Nami — Java Chat Application

**Khuluma Nami** is a console-based chat application built in Java using socket programming.  
The project evolves in two major phases:

1. **Phase 1**: A basic client-server chat with a single connection (no threads).
2. **Phase 2**: A multi-client chat server using Java threads for concurrent communication.

---

## 📚 Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)

---

## ✨ Features

### ✅ Phase 1: Single Client-Server Chat
- Local socket-based communication between client and server
- Send and receive messages in real time (one client only)

### ✅ Phase 2: Multi-Client Chat (With Threads)
- Multiple clients can connect to the server simultaneously
- Each client handled in its own thread
- Server broadcasts messages from one client to all others

---

## 🛠 Tech Stack

- **Language**: Java (SE 8+)
- **Libraries**: Core Java APIs (`java.net`, `java.io`, `java.util`)
- **Environment**: Console-based (no GUI)
- **Build Tool**: Manual compilation or any IDE (e.g., IntelliJ, Eclipse)

---

## 📁 Project Structure

```
khuluma-nami/
├── client/
│   └── ChatClient.java # Handles client-side logic and user interaction
│
├── server/
│   ├── ChatServer.java # Starts server, accepts client connections
│   └── ClientHandler.java # (Phase 2) Handles each client in a separate thread
```
