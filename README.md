# Selenium-POM-Framework
This repository describes Selenium POM Automation Framework

To run this project, right click on testng.xml file and run as TestNG Suite

After running the full test suite, refresh the Reports root folder by right-clicking on it and selecting Refresh. 
Then, within the Reports folder, right-click on the first report file and select Open With > Web Browser.

Project Overflow - 
```
pom.xml
   │
   ▼
testng.xml
   │
   ▼
Driver Layer
(DriverFactory + BrowserManager)
   │
   ▼
BaseTest
(Setup / Teardown / Config / Logging)
   │
   ▼
Page Objects
(POM Design Pattern)
   │
   ▼
Test Classes
(Data Providers + Test Scripts)
   │
   ▼
Listeners
(Extent Reports)
   │
   ▼
Reports & Logs
├── test-output/
├── logs/
└── reports/

```
