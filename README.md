<p align="center">
  <img src="XCall.png" width="200" height="200" alt="XCall"/>
</p>

# XCall

**XCall** is a modern Android app for blocking spam and unwanted calls. Built with Kotlin, MVVM, Room, and Hilt, it provides a robust, extensible foundation for call management and privacy.

---

## 🚀 Goal
To provide users with a powerful, privacy-focused Android app to block spam calls, manage blacklists/whitelists, and keep track of blocked call logs with a clean, modern UI and scalable architecture.

---

## ✨ Features
- Block calls from blacklisted numbers
- Allow calls from whitelisted numbers
- Log and view blocked calls
- Import/export blacklist and whitelist
- Customizable settings
- Modern, reactive UI
- Built with best practices (MVVM, DI, Room)

---

## 🗂️ Project Structure
```
app/src/main/java/com/loading/xcall
├── data
│   ├── BlacklistEntry.kt, WhitelistEntry.kt, BlockedCallLogEntry.kt
│   ├── BlacklistDao.kt, WhitelistDao.kt, BlockedCallLogDao.kt
│   ├── BlacklistRepository.kt, WhitelistRepository.kt, BlockedCallLogRepository.kt
│   ├── AppDatabase.kt
│   ├── DatabaseModule.kt, RepositoryModule.kt (Hilt DI)
│   └── lookup/ (import/export, settings, number lookup)
├── ui
│   ├── whitelist/ (Fragment, Adapter, ViewModel)
│   ├── blacklist/ (Fragment, Adapter, Dialog, ViewModel)
│   ├── blockedlog/ (Fragment, Adapter, ViewModel)
│   ├── calllogs/ (Fragment, ViewModel)
│   └── settings/ (Fragment, ViewModel)
├── util
│   ├── NotificationHelper.kt, PermissionManager.kt
├── XCallApp.kt (Application class)
├── MainActivity.kt
└── CallBlockingService.kt
```

---

## 🏗️ Architecture
- **MVVM Pattern**: Clean separation of UI, business logic, and data
- **Room Database**: Persistent storage for blacklists, whitelists, and blocked call logs
- **Repository Pattern**: Abstracts data access and business logic
- **Hilt**: Dependency injection for scalable, testable code
- **StateFlow/LiveData**: Reactive UI updates

---

## ⚙️ Setup
1. **Clone the repo:**
   ```sh
   git clone https://github.com/Loading617/XCall.git
   cd XCall
   ```
2. **Open in Android Studio** (Arctic Fox or newer)
3. **Build & Run** on an Android device or emulator (API 24+)

---

## 📱 Usage
- Add numbers to the blacklist to block them
- Add numbers to the whitelist to always allow
- View blocked call logs in the Blocked Log tab
- Adjust settings as needed

---

## 🤝 Contribution
Contributions are welcome! Please open issues or submit pull requests for improvements, bug fixes, or new features.

---

## 📄 License
[MIT License](LICENSE)

---

## 💡 Architecture & Feature Suggestions
- Modularization (core/data/feature modules)
- Cloud sync (Firebase/Google Drive)
- Community spam list integration
- Advanced analytics and reporting
- Custom block rules (pattern/time/region-based)
- Accessibility improvements
- Comprehensive testing (unit/UI)

---

App Icon Color Inspired by [JetBrains](https://github.com/JetBrains) Amazing Programming Language [Kotlin](https://github.com/JetBrains/kotlin)!
