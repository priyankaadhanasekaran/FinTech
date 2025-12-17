Fintech Automation Framework (Selenium + TestNG + Maven)

Structure:
- src/main/java : Page Objects
- src/test/java : Test classes and BaseTest
- testng.xml : TestNG suite

Notes:
- Page object locators are placeholders 
- To run from CLI:
    mvn clean test

- If running tests from IntelliJ, enable 'Delegate IDE build/run actions to Maven' in settings
  or ensure jcommander dependency is present (already included).
