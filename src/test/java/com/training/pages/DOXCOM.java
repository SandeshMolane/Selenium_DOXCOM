package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AutoHackathon.Project.CommonLib;
import AutoHackathon.Project.DataDriver.HashMapNew;


public class DOXCOM {
                By header = By.xpath("//*[@id='header']/h1");
                By inpCustId = By.id("CustID");
                By btnSearch = By.id("OpenButton");
                By custDetails = By.xpath("//h4");
                By btnRecharge = By.id("RechargeButton");
                By Recharge = By.xpath("//h2");
                By rechargeAmt = By.id("Amount");
                By paymentAmt = By.id("PaymentType");
                By btnSubmit = By.id("submitButton");
                By rechargeInfo = By.id("Message");
                
public WebDriver oDriver;
public ExtentReports oExtentReports;
public ExtentTest oExtentTest;
public HashMapNew dictionary;

                public DOXCOM(WebDriver oDriver, ExtentReports oExtentReports,ExtentTest oExtentTest,HashMapNew dictionary )
                {
                                this.oDriver = oDriver;
                                this.oExtentReports = oExtentReports;
                                this.oExtentTest = oExtentTest;
                                this.dictionary = dictionary;
                }
                public boolean fCheckHomePage()
                {
                                WebElement eHeader = oDriver.findElement(header);
                                if (eHeader.isDisplayed())
                                {
                                                oExtentTest.log(LogStatus.PASS, "DOXCOM Page is visible");
                                                return true;
                                }
                                oExtentTest.log(LogStatus.FAIL, "Unable to open DOXCOM Page");
                                return false;
                }
                public boolean fSearchCustomer()
                {
                                CommonLib.sendKeys(oDriver, inpCustId, dictionary.get("CUSTOMER_ID"));
                                WebElement eBtnSearch = oDriver.findElement(btnSearch);
                                
                                if (eBtnSearch.isEnabled())
                                {
                                                eBtnSearch.click();
                                                oExtentTest.log(LogStatus.INFO, "Search Button is Clicked");
                                }
                                else
                                {
                                                oExtentTest.log(LogStatus.FAIL, "Search Button is disabled");
                                                return false;
                                }
                                WebDriverWait oWait = new WebDriverWait(oDriver,30);
                                WebElement e = oWait.until(ExpectedConditions.visibilityOf(oDriver.findElement(custDetails)));
                                
                                if(e.isDisplayed())
                                {
                                                oExtentTest.log(LogStatus.PASS, "Search Customer is successful");
                                                return true;
                                }
                                
                                oExtentTest.log(LogStatus.FAIL, "Failed to perform Search customer");
                                return false;
                }
                
                public boolean fRechargePageValidation()

                {
                                                                
                                WebElement eBtnRecharge = oDriver.findElement(btnRecharge);
                                
                                if (eBtnRecharge.isEnabled())
                                {
                                                eBtnRecharge.click();
                                                oExtentTest.log(LogStatus.INFO, "Recharge Button is Clicked");
                                }
                                else
                                {
                                                oExtentTest.log(LogStatus.FAIL, "Recharge Button is disabled");
                                                return false;
                                }
                                WebDriverWait oWait = new WebDriverWait(oDriver,30);
                                WebElement e = oWait.until(ExpectedConditions.visibilityOf(oDriver.findElement(Recharge)));
                                
                                if(e.isDisplayed())
                                {
                                                oExtentTest.log(LogStatus.PASS, "Recharge page is displayed");
                                                
                                                return true;
                                }
                                                                
                                oExtentTest.log(LogStatus.FAIL, "Failed to load Recharge page");
                                return false;
                }

                public boolean fRechargeFinal()
                {
                                CommonLib.sendKeys(oDriver, rechargeAmt, dictionary.get("RECHARGE_AMT"));
                                CommonLib.sendKeys(oDriver, paymentAmt, dictionary.get("PAYMENT_TYPE"));
                                WebElement eBtnSubmit = oDriver.findElement(btnSubmit);
                                
                                if (eBtnSubmit.isEnabled())
                                {
                                                eBtnSubmit.click();
                                                oExtentTest.log(LogStatus.INFO, "Submit Button is Clicked");
                                }
                                else
                                {
                                                oExtentTest.log(LogStatus.FAIL, "Submit Button is disabled");
                                                return false;
                                }
                                WebDriverWait oWait = new WebDriverWait(oDriver,30);
                                WebElement e = oWait.until(ExpectedConditions.visibilityOf(oDriver.findElement(rechargeInfo)));
                                
                                if(e.isDisplayed())
                                {
                                                oExtentTest.log(LogStatus.PASS, "Customer Recharge is successful");
                                                return true;
                                }
                                
                                oExtentTest.log(LogStatus.FAIL, "Failed to perform customer Recharge");
                                return false;
                }
}


