
##** Table of Content**

1.Overview
2.Prerequisites
3.Running the Tests
4.Test Steps
5.Dependencies



Overview:
1.The YahooFinanceTest class automates the following steps on the Yahoo Finance website:

2.Search for a stock symbol (e.g., "TSLA").

3.Verify the autosuggested entry.

4.Click on the first autosuggested entry.

5.Verify the stock price is greater than a specified value (e.g., $200).


Prerequisites :
1.Before running the tests, ensure the following are installed:

2.Java Development Kit (JDK): Version 8 or higher.

3.Maven: For managing dependencies.

4.ChromeDriver: Download the version compatible with your Chrome browser.

5.Chrome Browser: Installed on your system.


Running the Tests
1.Run the Test:

Execute the main method in the YahooFinanceTest class.

The test will:

Open the Yahoo Finance website.

Search for the stock symbol "TSLA".

Verify the autosuggested entry.

Click on the first suggestion.

Verify the stock price and log additional data.

2.View Output:

The test results will be printed in the console.

 
Test Steps:
1.Navigate to Yahoo Finance.
2.Search for the stock symbol "TSLA".
3.Verify that the first autosuggested entry is "TESLA Inc".
4.Click on the first autosuggested entry.
5.Verify that the stock price is greater than $200.
6.Capture and log additional stock data (e.g., "Previous Close" and "Volume").

Dependencies:
1.Selenium Java: For browser automation.
2.ChromeDriver: For controlling the Chrome browser.
