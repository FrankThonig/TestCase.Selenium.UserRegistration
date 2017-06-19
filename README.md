# Browser Test Automation with Selenium
## Test Case: User Registration

##### Table of Contents
- [System / Software Environment](#system--software-environment)
  - [Third Party Software](#third-party-software)
  - [Test Data Creation / Data Source](#test-data-creation--data-source)
  - [Execution / Deployment](#execution--deployment)
  - [General Notes](#general-notes)
- [User Guide](#user-guide)
  - [Test Case](#test-case)
  - [Implementation](#implementation)
  - [Execution / Deployment](#execution--deployment-1)

## System / Software Environment

### Third Party Software

#### Programming Language

- Java

#### Computing Platform

- JDK 1.8.0_121

#### Browser Automation Framework

- Selenium 3.4.0

#### Testing Framework

- TestNG 6.11

#### Browsers

- Chrome 57 (32 bit, 64 bit)

#### WebDrivers

- Chromedriver 2.28

#### Build / Deployment Tools

- Eclipse Neon
- Maven 3.5.0
- Jenkins 2.57

#### Operating Systems (OS)

- Windows 10 (64 bit)

### Test Data Creation / Data Source

- TestNG DataProvider

### Execution / Deployment

- TestNG Suite
- Maven build
- Jenkins Pipeline

### General Notes

#### Third Party Software Files

The third party software files are not part of this project's file repository. However, the project's setup contains notations of paths and file names of that software to be used for the project setup. With the help of these notations, after obtaining the files, a project user can place them in the respective directories.

#### File Directory Structure

The file directories are set up in a way to facilitate the use of Maven.

Within the "resources" directory there are two subdirectories:

- "int"
- "ext"

"int" stands for "internal". This directory contains all the files whose content is customized by the project user and which are therefore related to the internal setup of the project.

"ext" stands for "external". This directory contains all the third party application software files.

#### Utility Files

This projects java implementations contain a number of files serving as utilities for common tasks that are not explicitly related to the specific test scope. Therefore, in this documentation, these files are only described more in detail if relevant for the understanding of the test topic.

## User Guide

### Test Case

The project comprehends one single test case.

#### General Notes

#### *Multiple Asserts*

The purpose of this test project is to show several topics related to a user registration test. All the topics are covered in one single test case containing multiple asserts. The aim is to give an overview of the overal process in one single script. In a real world test setup, it might be desirable to creat individual test cases - each one containing only one single assert.

#### *Anonymized Data*

Since this project deals with registering a new user account, it does have an effect on the vendors service backend, e.g. its user account database. To keep away harm from any particular vendor, the vendor specific data within this documentation is anonymized. The anonymized values are indicated as such, using the term "anonymized".

#### Test Sequence

The complete test sequence consists of four parts. Following are the sequence steps for all sequence parts in continuous numeration:

00. start browser

*Sequence Part 1*
01. navigate to vendor web site start page
02. register new user
03. get validation message
04. execute test assert 1

*Sequence Part 2*
05. logout new user
06. get logged out message
07. execute test assert 2

*Sequence Part 3*
08. navigate to vendor web site start page
09. login new user
10. check logged in text
11. execute test assert 3

*Sequence Part 4*
12. logout new user
13. get logged out message
14. execute test assert 4

#### Test Asserts Textual Phrasings

Assert 1:

_The new user account was successfully created._

Assert 2:

_The new user was successfully logged out._

Assert 3:

_The new user was successfully logged in._

Assert 4:

_The new user was successfully logged out._

The concrete test assert implementations are given in a different segment of this documentation.

### Implementation

The project contains one single test class `RegisterUserTestCase` which again contains one single test method `testRegisterUserAndLoginAndLogout`.

#### Test Data

#### *Test Data Container*

`UserIDTestData` is a container class holding all the necessary new user account values for a single test run:

- first name
- last name
- username
- email address
- password

```
public class UserIDTestData
{

	public String FirstName;
	public String LastName;
	public String Username;
	public String EMailAddress;
	public String Password;
	
	[...]

}
```

#### *Constant Test Data*

The `ConstantPageTestData` class and `ConstantUserTestData` class hold values that are equal for each test run.

`ConstantPageTestData` contains values regarding the web page properties.

```
public static String StartPageURL=
	"anonymized";	
```

`ConstantUserTestData` contains values regarding the new user account.

```
public static String UserDescriptor1=
	"anonymized";

public static String UserDescriptor2=
	"anonymized";



public static int MinimumValidUserIDNumberPart=
	1;

public static long MaximumValidUserIDNumberPart=
	(long)Math.pow(
		10,
		10) - 1;



public static String FirstName=
	UserDescriptor1;



public static String UsernamePrefix=
	UserDescriptor1;



public static String EMailAddressPrefix=
	UserDescriptor2;

public static String EMailAddressSuffix=
	"anonymized";



public static String Password=
	UserDescriptor1;
```

#### *Dynamic Test Data*

The `DynamicTestData` class is a Test NG `DataProvider` and supplies individual test data for each test run:

- `UserIDTestData`

```
@DataProvider(
	name=
		"testData",
	parallel=
		true)
public static Object[][] createTestData()
{
	
	return new Object[][]
		{
			
			{
				
				DynamicTestDataHelper.generateRandomUserIDTestData()
				
			}
			
		};
			
}
```

The `DynamicTestDataHelper` class provides methods for generating the concrete test data for each individual test run.

```
public static UserIDTestData generateRandomUserIDTestData()
{
	
	String randomUserIDNumberPart=
		generateRandomUserIDNumberPartAsString();
		
	return new UserIDTestData(
		generateFirstName(),
		generateLastName(
			randomUserIDNumberPart),
		generateUsername(
			randomUserIDNumberPart),
		generateEMailAddress(
			randomUserIDNumberPart),
		generatePassword());
	
}

[...]
```

The dynamic test data provided by the `DynamicTestData` class is handed over to the test method `testRegisterUserAndLoginAndLogout` in the `RegisterUserTestCase` class.

```
@Test(
	dataProvider=
		"testData",
	dataProviderClass=
		DynamicTestData.class)
public void testRegisterUserAndLoginAndLogout(
	UserIDTestData userIDTestData)
```

#### *Test Data Supply for Data Driven Testing*

This project setup uses the TestNG `DataProvider` for handling the test data. It is also possible to use the TestNG XML file for data provision. `DataProvider` was chosen here to facilitate maintainability.

#### Assert Data

The `ValidatePageAssertData`, `MyAnonymizedPageAssertData` and `LogoutPageAssertData` classes hold constant values related to the test asserts. They serve the purpose of increasing maintainablity and readability of the source code by extracting this constant assert data from the `RegisterUserTestCase` class.

#### Test class `RegisterUserTestCase`

#### *Before and After Methods*

The `beforeMethod` takes care of instantiating a `WebDriverManager`. Retrieving a `WebDriver` instance causes the browser to start.

```
_WebDriverManager=
	_WebDriverManagerFactory.createWebDriverManager();

if(_WebDriverManager!=null)
{
	
	_WebDriver=
		_WebDriverManager.createWebDriver();
	
}
```

The `afterMethod` takes care of closing the respective browser instance after each individual test run.

#### *Test Method*

The test method `testRegisterUserAndLoginAndLogout` manages the realization of the test sequence.

*Sequence Part 1*

The first test sequence handles registering the new user.

First, the browser is called to navigate to vendor web site start page.

```
WebDriverNavigate.navigateToURL(
	_WebDriver,
	ConstantPageTestData.StartPageURL);
```

The user data gets entered, the register button pressed.

```
ValidatePage validatePage=
	new StartPage(
		_WebDriver).navigateToRegisterPage().fillOutAndExecuteRegistration(
			userIDTestData);
```

Afterwards, the displayed registration validation message is retrieved.

```
String displayedRegistrationValidationMessage=
	validatePage.getValidationMessage();
```

For being able to later execute the assert, the expected registration validation message is getting assembled.

```
String expectedRegistrationValidationMessage=
	assembleExpectedRegistrationValidationMessage(
		userIDTestData);
```

In the end the assertion is called. A specific error message is set for when an assertion error gets thrown.

```
Assert.assertTrue(
	isDisplayedRegistrationValidationMessageCorrect(
		expectedRegistrationValidationMessage,
		displayedRegistrationValidationMessage),
	"\n" +
	"Displayed registration validation message is not correct.\n" +
	"Expected registration validation message:\n" +
	expectedRegistrationValidationMessage +
	"\n" +
	"Displayed registration validation message:\n" +
	displayedRegistrationValidationMessage +
	"\n");
```

The auxiliary method `isDisplayedRegistrationValidationMessageCorrect` determines if the contents of the expected and the displayed registration validation messages match.

*Sequence Part 2*

The second test sequence is logging out the newly created user from the registration validation web site.

The logout link is being made visible and then clicked.

```
LogoutPage logoutPage=
	validatePage.logout();
```

Afterwards, the displayed logged out message is retrieved.

```
String displayedLoggedOutMessage=
	validatePage.getValidationMessage();
```

For being able to later execute the assert, the expected logged out message is getting assembled.

```
String expectedLoggedOutMessage=
	assembleExpectedLoggedOutMessage(
		userIDTestData);
```

In the end the assertion is called. A specific error message is set for when an assertion error gets thrown.

```
Assert.assertTrue(
	isDisplayedLoggedOutMessageCorrect(
		expectedLoggedOutMessage,
		displayedLoggedOutMessage),
	"\n" +
	"Logout after new user registration.\n" +
	"Displayed logged out message is not correct.\n" +
	"Expected logged out message:\n" +
	expectedLoggedOutMessage +
	"\n" +
	"Displayed logged out message:\n" +
	displayedLoggedOutMessage +
	"\n");
```

The auxiliary method `isDisplayedLoggedOutMessageCorrect` determines if the contents of the expected and the displayed logged out messages match.

*Sequence Part 3*

The third test sequence handles logging in the new user.

First, the browser is called to navigate to vendor web site start page.

```
WebDriverNavigate.navigateToURL(
	_WebDriver,
	ConstantPageTestData.StartPageURL);
```

The login link is being made visible and then clicked. The user data gets entered and another login button gets pressed.

```
MyAnonymizedPage myAnonymizedPage=
	new StartPage(
		_WebDriver).navigateToLoginPage().login(
			userIDTestData);
```

Afterwards, the displayed logged in text is retrieved.

```
String displayedLoggedInText=
	validatePage.getValidationText();
```

For being able to later execute the assert, the expected logged in text is getting assembled.

```
String expectedLoggedInText=
	assembleExpectedLoggedInText(
		userIDTestData);
```

In the end the assertion is called. A specific error text is set for when an assertion error gets thrown.

```
Assert.assertTrue(
	isDisplayedLoggedInTextCorrect(
		expectedLoggedInText,
		displayedLoggedInText),
	"\n" +
	"Displayed logged in text is not correct.\n" +
	"Expected logged in text:\n" +
	expectedLoggedInText +
	"\n" +
	"Displayed logged in text:\n" +
	displayedLoggedInText +
	"\n");
```

The auxiliary method `isDisplayedLoggedInTextCorrect` determines if the contents of the expected and the displayed logged in texts match.

*Sequence Part 4*

The fourth test sequence is logging out the newly created user from the user home (/user logged in) web site.

This sequence is analog to Sequence 3.

#### Browser Executable and `WebDriver` Handling Overview

Browser Executable and `WebDriver` handling in this project happens in a three level system.

1. `WebDriverManagerFactory`
2. `WebDriverManager`
3. browser specific `ChromeWebDriverManager`

The `WebDriverManagerFactory` instantiates the `WebDriverManager`.

`WebDriverManager` is an abstract class implementing common behaviour of browser specific `WebDriver` implementations.

The `ChromeWebDriverManager` classes contain browser specific information and system setups for instantiating the respective `WebDriver` implementation.

#### *Browser Executable Handling Details for Chrome*

This project uses one single Chrome release version but both the 32 bit and 64 bit architecture version of it.

Chrome browser files need to be placed in the respective directories specified in the `ChromeWebDriverManager` class. The directories and the browser release versions can be chosen by the tester.

Depending on the OS bit architecture, the corresponding Chrome bit architecture version needs to be used.

The directory to the Chrome browser binary is getting set via `ChromeOptions`. The Constructor of the `ChromeDriver` takes the `ChromeOptions` as an argument.

```
if(OperatingSystem.is64bitOS())
{
	
	_ChromeOptions.setBinary(
		new File(
			createPathToChromeBinary(
				"64")));
	
}
else
{
	
	_ChromeOptions.setBinary(
		new File(
			createPathToChromeBinary(
				"32")));
	
}

_WebDriver=
	new ChromeDriver(
		_ChromeOptions);
```

#### `WebDriver` handling details

The path to the respective `WebDriver` executables is being set in the system properties.

#### *`WebDriver` handling details for Chrome*

For Windows OS there is only one Chromedriver bit architecture version available of this Chromedriver release version. It works for both the 32 bit and the 64 bit Chrome executable.

```
System.setProperty(
	"webdriver.chrome.driver",
	PathRetrieve.retrieveAbsolutePathStringFromRelativePathString(
		this,
		"/ext/bin/selenium/driver/chrome/chromedriver.exe"));
```

#### Browser Automation

Following are the details of the browser automation parts of this project's specific test case described in a different segment of this documentation.

#### *General Notes*

Browser actions are executed as "safe" actions, i.e. before interacting with a certain web element, the algorithm waits for that element to be ready for interaction.

#### *Page Objects*

The test case covers the following web sites:

- start web site
- registration web site
- validation web site
- login web site
- logout web site
- my anonymized (user home) web site

In the source code, each of these web sites is represented by its own `[...]Page` class. For implementation the page object pattern was applied.

##### *`PageObject`* class

`PageObject` is an abstract class implementing common behaviour of all `[...]Page` classes.

##### *`StartPage`* class

The `StartPage` class represents the vendor start web site. Following are the web elements relevant to the test case:

- user hover field
- login link
- register link

```
@FindBy(
	className=
		"header-user-column")
private WebElement _UserHoverField;

@FindBy(
	linkText=
		"Login")
private WebElement _LoginLink;

@FindBy(
	linkText=
		"Register")
private WebElement _RegisterLink;
```

##### *`RegisterPage`* class

The `RegisterPage` class represents the new user registratin web site. Following are the web elements relevant to the test case:

- first name text field
- last name text field
- username text field
- email text field
- password text field
- privacy policy check box
- register button

```
@FindBy(
	id=
		"firstname")
private WebElement _FirstNameTextField;

@FindBy(
	id=
		"lastname")
private WebElement _LastNameTextField;

@FindBy(
	id=
		"username")
private WebElement _UsernameTextField;

@FindBy(
	id=
		"email")
private WebElement _EMailTextField;

@FindBy(
	id=
		"password")
private WebElement _PasswordTextField;

@FindBy(
	id=
		"accept_privacy")
private WebElement _AcceptPrivacyCheckBox;

@FindBy(
	id=
		"register_submit")
private WebElement _RegisterButton;
```

##### *`ValidatePage`* class

The `ValidatePage` class represents the web site shown to the user after having successfully registered a new user, displaying a validation message. Following are the web elements relevant to the test case:

- validation message text
- user hover field
- logout link

```
@FindBy(
	id=
		"validate_email_hint")
private WebElement _ValidateEMailText;

@FindBy(
	className=
		"header-user-column")
private WebElement _UserHoverField;

@FindBy(
	linkText=
		"Logout")
private WebElement _LogoutLink;
```

##### *`LoginPage`* class

The `LoginPage` class represents the web site on which the user data is to be entered to execute the user login. Following are the web elements relevant to the test case:

- username text field
- password text field
- login button

```
@FindBy(
	id=
		"username")
private WebElement _UsernameTextField;

@FindBy(
	id=
		"login_credentials_password")
private WebElement _PasswordTextField;

@FindBy(
	id=
		"login_submit")
private WebElement _LoginButton;
```

##### *`LogoutPage`* class

The `LogoutPage` class represents the web site shown to the user after having successfully logged out, displaying a logged out message. Following are the web elements relevant to the test case:

- logged out message text

```
@FindBy(
	className=
		"bye-text")
private WebElement _ByeText;
```

##### *`MyAnonymizedPage`* class

The `MyAnonymizedPage` class represents the web site shown to the user after having successfully logged in, displaying user specific information. Following are the web elements relevant to the test case:

- user hover field
- logout link

```
@FindBy(
	css=
		".header-user-welcome.logged-in-state")
private WebElement _UserLoggedInHoverField;

@FindBy(
	linkText=
		"Logout")
private WebElement _LogoutLink;
```

#### *Test Sequence Browser Automation*

The test sequence is executed by the `testRegisterUserAndLoginAndLogout` method of the `RegisterUserTestCase` class. Following are the test sequence parts concerning browser automation. The test assert implementations are described in a different segment of this documentation.

##### *`WebDriverNavigate` class and `WebElementActions` class*

Navigating the browser is implementet in the `WebDriverNavigate` class.

```
public static void navigateToURL(
	WebDriver webDriver,
	String url)
{
	
	if(webDriver!=null)
	{
		
		webDriver.get(
			url);
		
	}
	
}
```

Interactions with `WebElements` within the page objects happen on an abstract basis. The interactions' concrete implentations are contained in the `WebElementActions` class.

```
static void setElementToStateSelected(
	WebElement webElement)
{
	
	if(webElement!=null)
	{
		
		if(!isSelected(
			webElement))
		{
			
			click(
				webElement);
			
		}
		
	}
	
}

static void moveToElement(
	WebDriver webdriver,
	WebElement webElement)
{
	
	if(webElement!=null)
	{
		
		Actions action=
			new Actions(
				webdriver);
		
		action.moveToElement(
			webElement).perform();
		
	}
	
}

static void clear(
	WebElement webElement)
{
	
	if(webElement!=null)
	{
		
		webElement.clear();
		
	}
	
}

static void sendKeys(
	WebElement webElement,
	String keysToSend)
{
	
	if(webElement!=null)
	{
		
		webElement.sendKeys(
			keysToSend);
		
	}
	
}

static void click(
	WebElement webElement)
{
	
	if(webElement!=null)
	{
		
		webElement.click();
		
	}
	
}

static void sendReturnKey(
	WebElement webElement)
{
	
	sendKeys(
		webElement,
		Keys.RETURN);
	
}

private static void sendKeys(
	WebElement webElement,
	CharSequence key)
{
	
	if(webElement!=null)
	{

		webElement.sendKeys(
			key);
		
	}
	
}

private static Boolean isSelected(
	WebElement webElement)
{
	
	return webElement!=null?
		webElement.isSelected():
		null;
	
}

static String getText(
	WebElement webElement)
{
	
	return webElement!=null?
		webElement.getText():
		null;
	
}
```

##### *Test Sequence steps*

*Sequence Part 1*

Whole sequence part:

```
WebDriverNavigate.navigateToURL(
	_WebDriver,
	ConstantPageTestData.StartPageURL);

ValidatePage validatePage=
	new StartPage(
		_WebDriver).navigateToRegisterPage().fillOutAndExecuteRegistration(
			userIDTestData);

String displayedRegistrationValidationMessage=
	validatePage.getValidationMessage();
```

Single sequence steps:

01. navigate to vendor web site start page

```
WebDriverNavigate.navigateToURL(
	_WebDriver,
	ConstantPageTestData.StartPageURL);
```

02. register new user

```
new StartPage(
	_WebDriver).navigateToRegisterPage().fillOutAndExecuteRegistration(
		userIDTestData)
```

First the register link is made visible. Then it is being clicked to navigate to the register page. The sequence of these steps is defined in the `StartPage` class.

```
public RegisterPage navigateToRegisterPage()
{
	
	return moveToElementUserHoverField().clickRegisterLink();
	
}
```

Filling out the registration form, setting the privacy policy check mark and pressing the register button is defined in the `RegisterPage` class.

```
public ValidatePage fillOutAndExecuteRegistration(
	UserIDTestData userIDTestData)
{
	
	return clearFirstNameTextFieldAndEnterFirstName(
		userIDTestData).clearLastNameTextFieldAndEnterLastName(
			userIDTestData).clearUsernameTextFieldAndEnterUsername(
				userIDTestData).clearEMailTextFieldAndEnterEMailAddress(
					userIDTestData).clearPasswordTextFieldAndEnterPassword(
						userIDTestData).setAcceptPrivacyCheckBoxToStateSelected().clickRegisterButton();
	
}
```

03. get validation message

```
validatePage.getValidationMessage()
```

After successful registration, a validation message is displayed. This message is retrieved by the `ValidatePage` class.

```
public String getValidationMessage()
{
	
	return super.getText(
		_ValidateEMailText);
	
}
```

*Sequence Part 2*

Whole sequence part:

```
LogoutPage logoutPage=
	validatePage.logout();

String displayedLoggedOutMessage=
	logoutPage.getLoggedOutMessage();
```

Single sequence steps:

05. logout new user

```
validatePage.logout()
```

First the logout link is made visible. Then it is being clicked and the browser automatically gets navigated to the logout page. The sequence of these steps is defined in the `ValidatePage` class.

```
public LogoutPage logout()
{
	
	return moveToElementUserHoverField().clickLogoutLink();
	
}
```

06. get logged out message

```
logoutPage.getLoggedOutMessage()
```

After successful logout, a logged out message is displayed. This message is retrieved by the `LogoutPage` class.

```
public String getLoggedOutMessage()
{
	
	return super.getText(
		_ByeText);
	
}
```

*Sequence Part 3*

Whole sequence part:

```
WebDriverNavigate.navigateToURL(
	_WebDriver,
	ConstantPageTestData.StartPageURL);

MyAnonymizedPage myAnonymizedPage=
	new StartPage(
		_WebDriver).navigateToLoginPage().login(
			userIDTestData);

String displayedLoggedInText=
	myAnonymizedPage.getUserLoggedInHoverFieldText();
```

Single sequence steps:

08. navigate to vendor web site start page

```
WebDriverNavigate.navigateToURL(
	_WebDriver,
	ConstantPageTestData.StartPageURL);
```

09. login new user

```
new StartPage(
	_WebDriver).navigateToLoginPage().login(
		userIDTestData)
```

First the login link is made visible. Then it is being clicked to navigate to the login page. The sequence of these steps is defined in the `StartPage` class.

```
public LoginPage navigateToLoginPage()
{
	
	return moveToElementUserHoverField().clickLoginLink();
	
}
```

Filling out the login form and pressing the login button is defined in the `LoginPage` class.

```
public MyAnonymizedPage login(
	UserIDTestData userIDTestData)
{
	
	return clearUsernameTextFieldAndEnterUsername(
		userIDTestData).clearPasswordTextFieldAndEnterPassword(
			userIDTestData).clickLoginButton();
	
}
```

10. check logged in text

```
myAnonymizedPage.getUserLoggedInHoverFieldText()
```

After successful login, a logged in text is displayed. This text is retrieved by the `MyAnonymizedPage` class.

```
public String getUserLoggedInHoverFieldText()
{
	
	return super.getText(
		_UserLoggedInHoverField);
	
}
```

*Sequence Part 4*

Whole sequence part:

```
logoutPage=
	myAnonymized.logout();

displayedLoggedOutMessage=
	logoutPage.getLoggedOutMessage();
```

Single sequence steps:

12. logout new user

```
myAnonymized.logout()
```

First the logout link is made visible. Then it is being clicked and the browser automatically gets navigated to the logout page. The sequence of these steps is defined in the `MyAnonymized` class.

```
public LogoutPage logout()
{
	
	return moveToElementUserLoggedInHoverField().clickLogoutLink();
	
}
```

13. get logged out message

```
logoutPage.getLoggedOutMessage()
```

This step is analog to the one in sequence part 2.

#### Test Assert Implementations

The test asserts are executed by the `testRegisterUserAndLoginAndLogout` method of the `RegisterUserTestCase` class.

The test asserts textual phrasings are given in a different segment of this documentation.

*Assert 1*

Assert 1 states that the new user account was successfully created.

A boolean statement about the acoount creation success is retrieved by comparing the expected registration validation message with the displayed registration validation message. The comparison result needs to be retrieved for the assert. This is done by the auxiliary method `isDisplayedRegistrationValidationMessageCorrect`.

```
Assert.assertTrue(
	isDisplayedRegistrationValidationMessageCorrect(
		expectedRegistrationValidationMessage,
		displayedRegistrationValidationMessage),
	"\n" +
	"Displayed registration validation message is not correct.\n" +
	"Expected registration validation message:\n" +
	expectedRegistrationValidationMessage +
	"\n" +
	"Displayed registration validation message:\n" +
	displayedRegistrationValidationMessage +
	"\n");
```

*Assert 2*

Assert 2 states that the new user was successfully logged out.

A boolean statement about the logout success is retrieved by comparing the expected logged out message with the displayed logged out message. The comparison result needs to be retrieved for the assert. This is done by the auxiliary method `isDisplayedLoggedOutMessageCorrect`.

```
Assert.assertTrue(
	isDisplayedLoggedOutMessageCorrect(
		expectedLoggedOutMessage,
		displayedLoggedOutMessage),
	"\n" +
	"Logout after new user registration.\n" +
	"Displayed logged out message is not correct.\n" +
	"Expected logged out message:\n" +
	expectedLoggedOutMessage +
	"\n" +
	"Displayed logged out message:\n" +
	displayedLoggedOutMessage +
	"\n");
```

*Assert 3*

Assert 3 states that the new user was successfully logged in.

A boolean statement about the login success is retrieved by comparing the expected logged in text with the displayed logged in text. The comparison result needs to be retrieved for the assert. This is done by the auxiliary method `isDisplayedLoggedInTextCorrect`.

```
Assert.assertTrue(
	isDisplayedLoggedInTextCorrect(
		expectedLoggedInText,
		displayedLoggedInText),
	"\n" +
	"Displayed logged in text is not correct.\n" +
	"Expected logged in text:\n" +
	expectedLoggedInText +
	"\n" +
	"Displayed logged in text:\n" +
	displayedLoggedInText +
	"\n");
```

*Assert 4*

Assert 4 is analog to assert 2.

### Execution / Deployment

#### TestNG Suite

`RegisterUserTestCase.xml` is the TestNG XML file which can be run directly.

#### Maven build

The projects directory structure is suited to be used with a Maven build. `pom.xml` is the respective Maven XML file. The Maven build can be used to compile the source, copy the resources and run the test by using the Maven goal `test`.

#### Jenkins

This project contains a setup for using continuous integration in Jenkins. The project specific integration process comprehends:

- Git clone / pull of the project repository
- Maven build with goal `test`
- filing test results

Jenkins needs to be configured to set up the respective software for this process.
Applying the `test` goal to the maven build includes:

- compiling of the java source files
- running the tests

Therefore, a JDK and TestNG need to be set up, too. The complete setup consists of:

- Git setup
- JDK setup
- TestNG setup
- Maven setup
- Test Result setup

The setup itself comprehends two parts:

- installation
- configuration

It is not necessary for all setups to include both the installation and the configuration.

##### Installations

##### *Git Installation*

The Git installation is given the name of `gitInstallation` and the directory of a local Git executable is specified.

![](/img/Jenkins_Config_Git.JPG)

##### *JDK Installation*

The JDK installation is given the name of `jdkInstallation` and the directory of a local JDK executable is specified.

![](/img/Jenkins_Config_JDK.JPG)

##### *Maven Installation*

The Maven installation is given the name of `mavenInstallation` and the directory of a local Maven executable is specified.

![](/img/Jenkins_Config_Maven.JPG)

##### Configuration

Configuration of the Jenkins Pipeline is handled by the `userRegistrationPipeline_Jenkinsfile` Jenkinsfile.

*Git configuration*

The project user needs to specify his Git repository URL and the credentials ID. The credentials can be managed via Jenkins.

```
git([
	url: 'YOUR_GIT_REPO_URL',
	credentialsId: 'YOUR_JENKINS_CREDENTIALS_ID'])
```

*Maven configuration*

The project user needs to specify the name of the JDK and Maven versions. Here, the name of the JDK Installation `jdkInstallation` and the name of the Maven Installation `mavenInstallation` are to be used.
For the Goals the configuration gets set to `test`. Additionally, the behaviour in case of failing tests can be specified.
The POM file is taken from the directory set in the `bat` command. This directory needs to match the project's diretory structure.

```
String javaHome = tool("jdkInstallation");		
String mvnHome = tool("mavenInstallation") + "\\bin";

[...]

withEnv([
	"PATH+WHATEVER=${javaHome}",
	"PATH+WHATEVER2=${mvnHome}",
	"JAVA_HOME=${javaHome}"])
	{
	
	bat "mvn -Dmaven.test.failure.ignore=true test"
	
	}
```

*Test Result configuration*

The project user needs to specify the report filename pattern to match this project's directory structure.

```
step([
	$class: 'hudson.plugins.testng.Publisher',
	reportFilenamePattern: '**/target/surefire-reports/testng-results.xml'])
```
