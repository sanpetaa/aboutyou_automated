# Calkoo Test Automation Base

#### About 
The goal of this project is to fulfill the homework I get from the Global Blue REX Team.
##### Task

* Please identify at least two test cases for the automation:
* * explain why you would choose specifically those
* * automate them using Cypress, Robot, or Selenium (if having experience)

#### Actual Testcases

##### testcase.CheckCalculations.java 

Checking the whole calculation process and comparing it to my local calculation, because this is the main function of the site.

 I selected the 3 most commonly used countries from global blue TOP destinations: https://www.globalblue.com/corporate/media/press/global-blue-research-confirms-the-chinese-are-still-the-most-valuable-globe-shoppers, because I do not have business information about the most important countries. 

Check on all available VAT rates
even If  I am filling the Net price, VatSum, or Price fields
And Checking the pie chart if it is correct or not. 

I used soft assertions.
In case of any failure and the application taking screenshots.

##### testcase.VatRateAvailable.java 
If any change on the webpage will happen
And if  multipliers will not be equivalent to the VAT rates
Then the calculation would be wrong. 
These pieces of information are necessary for my first test case.

# GLOBAL BLUE - HOMEWORK

Background info
Calkoo introduced a simple online VAT calculator for calculating the tax on their website:

http://www.calkoo.com/?lang=3&page=8

##### User story
As a traveler, I want to calculate the various purchase/tax amounts to verify that my shop
receipt is correct, and the merchant correctly charged the VAT for my recently bought items.

##### ACCEPTANCE CRITERIA
* User must select a country which applies VAT scheme
* User must be able to choose a valid VAT rate for the selected country
* One of the following amounts are supported as an input:
* * Net
* * Gross
* * VAT
* Amounts can be entered with maximum 2 decimal digit precision
* Given all mandatory fields (country, vat rate, one of the amounts) are provided,
the website will calculate and show the other 2 amounts which were not
provided originally as an input value
* The API provides an error with meaningful error message, in case of:
* * negative input
* * amount >999.999.999

##### TECHNICAL REQUIREMENTS
* Please document test cases (manual) that come to your mind.
* In case you encounter bugs - which one and how would you report them (provide
example)
* In case there are open questions regarding requirements/acceptance criteria:
* * Document the questions you would like to ask/clarify with End
users/business/product owner based on the given information.

#### Technological prerequisites
 
* Installed Java JDK version 9+ 
* Make sure environment path to Java JDK
* Installed GIT or clone from website
* Installed the newest version of Chrome/Firefox browser
* IDE of your choice for code development (Eclipse recommended and supported)

##### Tools to be installed before importing: 
* TestNG- can be installed from Eclipse- Help- Eclipse Marketplace- Search for 'testng' and download it
* Maven is an in-built application in Eclipse

* How to add project: Import project--> Projects from Git (the first one)--> Next-->
Clone URl--> https://github.com/sanpetaa/calkoo_automated.git
--> next--> check in master only--> next--> select directory (stay as-is)--> next--> next --> finish

*Please run the test cases from the /testrunner/testng.xml folder (in the base folder)-->(right click)-->Run As-->1 TestNGSuite

##### If the program can not start, then right click on project --> Maven --> Update Project --> ok

#### Download with use of GIT:
The remote repository is public and it can be found below. 
```
 git clone: https://github.com/sanpetaa/calkoo_automated.git
```