# vdc-automation

Mobile Automation test framework support for the automation for web UI.

### Technical

This framework uses a number of open source projects to work properly:

* [Cucumber] - BDD style support for testing on Java!
* [JUnit 4&5] - Test runner tool of Java
* [Selenium] - Library use for interacting with Web Browser.
* [Appium] - Library use for interacting with Mobile App.
* [Owner] - Handle application configuration via Java properties files
* [AssertJ] - Fluent assertions for java
* [Custom Page Factory] - Core custom functional and modified the library to control the test run
  and Page Object Initialization

### Design Pattern
* Factory Design Pattern
* Fluent Interface
* Singleton
* Page Object Modal

### Environment

* Java & JDK 11
* Maven
* Docker
* Appium
* Appium Doctor

### Installation

Pull the code via git command to your local:

```sh
$ git clone https://github.com/luckhiem/mobile-automation.git
```

### Running

#### Local

1. **Checking Appium Environemnt**

```sh
$ appium-doctor
```

2. **Config Environment**

Add the `APP_PATH` to file `env.properties`

3. **Running Cucumber Test**

```sh
$ mvn clean -Dtest="TestRunner" test -Dos=[platform] -Dcucumber.filter.tags=@tag_name 
```

Example:

```sh
$ mvn clean verify -Dtest="TestRunner" -Dos=android -Dcucumber.filter.tags=@test
```

[tagName] = @ tag name e.g. @test...

| Variable Name | Meaning                                                        | Available Options |
|---------------|----------------------------------------------------------------|-------------------|
| os            | The environment that test will be run                          | android, ios      |

### Structure
```
├── log
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── core
│   │   │   │   ├── actions               // folder include mobile actions to interact with element
│   │   │   │   ├── constants             // folder include contents variables to run test
│   │   │   │   ├── driver
│   │   │   │   │   └── manager           // folder include mobile driver manager
│   │   │   │   ├── page                  // folder include page object modal
│   │   │   │   ├── server                // folder include appium service to running
│   │   │   │   └── utilities             // folder include utilities method
│   │   │   └── env
│   │   └── resources
│   └── test
│       ├── java
│       │   └── steps                     // folder include steps definitions method
│       └── resources
│           └── features
└── pom.xml
```
#### How to define a Web/Mobile Element in PageObject Class

Please use this pattern:

```
@FindBy(locator)
[Access Modifier] [?static] [ElementType] [ElementName];
```

Examples for Web Element: use **Element** type or specific elements as So **TextBox** and should
be `public static`

```java
@FindBy(id = "email")
public static Textbox Email_Textbox;
```

### Test Case Template

**Features** (stories) are explained using agile framework on user stories.

- Feature can contain one or more scenarios.
- Feature group contains locally related test scenarios.
- Feature represents small, discrete features of the system.
- Feature files start with keyword Feature, followed by feature name/terse description of feature.

Pattern:

 ```Gherkin
As a [type of user], I want to [perform some action] so that I [can achieve some goal/result/value].
 ```

Example:

```Gherkin
As a user,
I want to be able to recover the password to my account
So that I will be able to access my account in case I forgot the password
```

**Scenario**: the name for the behavior that will be described with following keywords:
`Given` some precondition
`When` I do some action
`Then` I expect some result

**Note**: Each acceptance criteria written in this format has the following statements:
`Given` – the beginning state of the scenario
`When` – specific action that the user makes
`Then` – the outcome of the action in “When”
`And` – used to continue any of three previous statements

#### Scenario Step Conventions

- Subject: `I`
- Tense: `Simple Present`
- Common Actions: `click`on Desktop Web and `tap` on Mobile App
- Using `Page` for Desktop Web and `Screen` for Mobile App
- Mobile Steps: should have `on app` at the end of the sentence to avoid duplicating with same
  action on Web
- `Then` steps (Verifying Step):  using `I should` +  `do something` to describe the expected result

### Assertion

Functions of `AssertJ` library are used in verifying steps (`Then`). Static import:

```java
import static org.assertj.core.api.Assertions.*;
```

Example:

```
assertThat(SearchPage.getAlertMessage).isEqualTo(AlertMessage);
```

In some concrete cases, using `Soft Assertions` to collects all assertion errors instead of stopping
at the first one. The instance of `Soft Assertion` always created in before step of each scenario (
Please check `test.java.steps.Hook`) and stored
by `Scenario.currentContext()`. Just call it:

```
SoftAssertions softly = currentContext().get("Assertion", SoftAssertions.class);
softly.assertThat(...)
```

Reference links:

+ https://joel-costigliola.github.io/assertj/index.html.
+ https://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#soft-assertions.

### Test Report

The Cucumber test report will be generated by using report plugin and defined at @CucumberOptions
in `steps.TestRunner`

**In Local:**
Use lifecycle `verify` instead of `test` to generate test report in
directory `target/cucumber-html-reports/`
The main report is file `overview-steps.html`


[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

[Selenium]: <https://selenium.dev/r>

[Jenkins]:<https://www.jenkins.io/>

[Selenium Grid]:  <https://github.com/SeleniumHQ/docker-selenium>

[Appium]: <http://appium.io/>

[WebDriverManager]: <https://github.com/bonigarcia/webdrivermanager>

[Owner]: <http://owner.aeonbits.org/docs/welcome/>

[AssertJ]: <https://joel-costigliola.github.io/assertj/>

[Custom Page Factory]: <https://github.com/selenium34/custom-page-factory/blob/master/src/main/java/com/example/CustomFieldDecorator.java>

[Cucumber]: <https://cucumber.io/>

[JUnit 4&5]: <https://junit.org/>