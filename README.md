# 🤖 Indeed Automation Project (Job Scraping & Auto Apply)

This is a Java + Selenium-based automation project that performs the following actions on job platforms like Naukri/Indeed:

- Logs in with a pre-configured Chrome profile
- Searches for custom job keywords and locations
- Scrapes job cards using Selenium WebDriver
- Automatically navigates to job pages
- Applies to jobs if the "Apply" button is available
- Supports multi-page scraping with pagination
- Handles browser windows and popups dynamically

## 📂 Project Structure

- `Indeedauto.java`: Main driver class
  - Initializes Chrome browser with existing profile
  - Sets up location, keywords, experience filter
  - Calls the `Scrappingauto` class to begin job parsing

- `Scrappingauto.java`: Logic class for scraping and applying
  - Iterates over job cards on each page
  - Switches to each job window and attempts auto-apply
  - Handles pagination across multiple result pages
  - Uses JavaScriptExecutor and dynamic waits for real-time interactions

## 💻 Technologies Used

- **Java**
- **Selenium WebDriver**
- **ChromeDriver with User Profile**
- **WebDriverManager** (for managing driver binaries)

## ⚙️ Prerequisites

- Java 11+
- Maven (optional)
- Google Chrome installed
- GitHub Repo cloned
- WebDriverManager handles driver versioning

## 🚀 How to Run

1. Clone the repository
2. Make sure `chromedriver` is installed via WebDriverManager
3. Replace your Chrome user data directory in `ChromeOptions`
4. Run the `Indeedauto` class

```java
options.addArguments("user-data-dir=C:\\Path\\To\\Your\\Chrome\\User Data");
