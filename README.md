# 🎓 Campus UI Automation Project

## 📌 Table of Contents

* [Project Description](#project-description)
* [Project Structure](#project-structure)
* [Technologies Used](#technologies-used)
* [Installation](#installation)
* [Usage](#usage)
* [Dependencies](#dependencies)
* [User Stories & Test Scenarios](#user-stories--test-scenarios)
* [Test Coverage Table](#test-coverage-table)
* [Test Reports](#test-reports)
* [Bug Reports](#bug-reports)
* [Project Team](#project-team)
* [GitHub Links](#github-links)
* [License](#license)
* [Contact](#contact)

---

## 📄 Project Description

This project includes automated UI tests for the **Campus Education System** available
at [test.mersys.io](https://test.mersys.io/). Our goal is to verify the accuracy of all critical functions from the
student's perspective to ensure usability and system stability.

The project is developed using **Java**, **Selenium WebDriver**, **Cucumber**, **TestNG**, and the **Page Object Model (
POM)** structure. User stories, scenarios, and test steps are thoroughly documented.

---

## 🏠 Project Structure

```plaintext
CampusProject/
├── src/
│   └── test/
│       ├── java/
│       │   ├── featureFiles/         # .feature files in Gherkin format
│       │   ├── hooks/                # Cucumber Hooks
│       │   ├── pages/                # Page Object Model classes
│       │   ├── runners/              # TestNG runners
│       │   ├── stepDefinitions/      # Step definitions
│       │   └── utilities/            # Driver, ConfigReader, etc.
│       └── resources/
│           └── extent.properties     # Report configurations
├── testReports/                      # HTML & PDF reports
├── configuration.properties          # Environment configuration
├── pom.xml                           # Maven dependencies
└── README.md                         # Documentation file
```

---

## 🧰 Technologies Used

| Technology / Library            | Description                     |
|---------------------------------|---------------------------------|
| Java JDK 21                     | Programming language            |
| Selenium WebDriver 4.32.0       | UI test automation              |
| Cucumber 7.20.0                 | BDD scenario management         |
| TestNG 7.10.2                   | Test framework                  |
| ExtentReports Cucumber7 Adapter | HTML + PDF reporting            |
| Apache POI 4.1.0                | Excel operations                |
| JavaFaker 1.0.2                 | Fake data generation            |
| Maven                           | Build and dependency management |

---

## 🚀 Installation

1. Clone the project:

   ```bash
   git clone https://github.com/kullaniciniz/CampusProject.git
   ```
2. Open the project with IntelliJ IDEA or your preferred IDE.
3. Load Maven dependencies:

   ```bash
   mvn clean install
   ```

---

## 🛠️ Usage

To run all tests:

```bash
mvn test
```

To run specific tests using an XML file, navigate to the related runner file and execute it.

---

## 📦 Dependencies

All dependencies are defined in the `pom.xml` file and managed automatically by Maven.

---

## 📝 User Stories & Test Scenarios

**All stories in the Campus User Story document have been tested. Each serves the following purposes:**

* **US-001 Login**: Ensures the student can log in to the system.
* **US-002 Home - Logo Click**: Verifies redirection to the homepage when clicking the logo.
* **US-003 Home - Main Menu**: Checks functionality of all menu buttons on the homepage.
* **US-004 Messaging View**: Verifies accessibility of message links from the hamburger menu.
* **US-005 Sending New Message**: Ensures a student can create and send messages via the system.
* **US-006 Deleting Message**: Tests moving sent messages to the trash folder.
* **US-007 Trash Operations**: Allows deleted messages to be restored or permanently deleted.
* **US-008 Finance Page**: Tests access to online payment transactions.
* **US-009 Paying for Course**: Verifies that the student can make course payments.
* **US-010 Debt Update After Payment**: Ensures debt balance updates after a successful payment.
* **US-011 Stripe Payment**: Tests making payments using the Stripe infrastructure.
* **US-012 Downloading Financial Reports**: Allows downloading financial info as Excel/PDF.
* **US-013 Submit Excuse Note**: Lets students notify the system of absence from class.
* **US-014 Upload Profile Photo**: Enables uploading and updating a profile photo.
* **US-015 Theme Selection**: Allows users to personalize the interface via themes.
* **US-016 View Grades and Transcript**: Lets students view their grades and transcript.
* **US-017 Download Grades as PDF**: Enables downloading grades as a PDF document.
* **US-018 View Assignment List**: Lists all assigned tasks for the student.
* **US-019 Start Assignment Discussion**: Enables starting a discussion related to an assignment.
* **US-020 Assignment Shortcut Buttons**: Verifies functionality of quick action buttons.
* **US-021 Submit Assignment**: Allows students to upload and submit assignments.
* **US-022 Assignment Search & Filtering**: Tests search and sorting among assigned tasks.
* **US-023 Calendar - Course Status**: Displays published, upcoming, and finished course statuses.
* **US-024 Calendar - Prevent Access to Unstarted Course**: Ensures students can't access unstarted classes.
* **US-025 Access to Completed Class Materials**: Allows viewing videos and content from completed classes.

---

## 📊 Test Coverage Table

| Module      | Number of Stories | Test Status |
|-------------|-------------------|-------------|
| Login       | 1                 | ✅ Passed    |
| Home        | 3                 | ✅ Passed    |
| Messaging   | 4                 | ✅ Passed    |
| Finance     | 5                 | ✅ Passed    |
| Attendance  | 1                 | ✅ Passed    |
| Profile     | 2                 | ✅ Passed    |
| Grading     | 2                 | ✅ Passed    |
| Assignments | 5                 | ✅ Passed    |
| Calendar    | 3                 | ✅ Passed    |

---

## 📊 Test Reports

Test results are automatically generated in the following folders:

* `testReports/SparkReport/`  (HTML)
* `testReports/PDFReport/`    (PDF)

---

## 💥 Bug Reports

There are currently no known bugs. Any new bugs can be reported via the GitHub Issues page.

---

## 👥 Project Team

| Name         | Role                     | Responsible Modules |
|--------------|--------------------------|---------------------|
| Zafer Atakli | Project Lead/QA Engineer |                     |
| ...          | QA Engineer              |                     |
| ...          | QA Engineer              |                     |

---

**Contributors:**

- **[Zafer Ataklı](https://github.com/zaferatakli)**
- **[Rıfat Batır](https://github.com/rftbtr)**
- **[Yiğit Çam](https://github.com/Yigit-Cam)**
- **[Tugba Kilic](https://github.com/TugbaKilic33)**
- **[Nuri Öztürk](https://github.com/NuriOzturk)**
- **[Azim Korkmaz](https://github.com/AzimKorkmaz)**
- **[Mert Can Özdemir](https://github.com/lioncarnes)**
- **[Sibel Öztemel](https://github.com/Sibel52)**
- **[Eren Icinozbebek](https://github.com/theeren123)**

---

## 🔗 GitHub Links

* [Main Repository](https://github.com/kullaniciniz/CampusProject)

---

## 📜 License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

The tested website [https://test.mersys.io/](https://test.mersys.io/) belongs to Techno Study's education platform. This
project is created **strictly for educational and internal testing** purposes. It is not intended for commercial use.

---

