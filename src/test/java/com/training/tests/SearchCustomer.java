package com.training.tests;

import org.testng.annotations.Test;

import com.training.pages.DOXCOM;

import AutoHackathon.Project.AutomationConstants;
import AutoHackathon.Project.DataDriver;
import AutoHackathon.Project.DataDriver.HashMapNew;
import AutoHackathon.Project.MyTestNGBaseClass;

public class SearchCustomer extends MyTestNGBaseClass{
       DataDriver oData = new DataDriver();
       HashMapNew dictionary;
       
       public void getData()
       {
              dictionary = oData.fGetData(AutomationConstants.testDataPath + "Calendar.xlsx", "SearchCustomer");
       }

       @Test
       public void verify()
       {
    	   	getData();
    	   	oExtentTest = oExtentReport.startTest("Search Customer");
              DOXCOM obj = new DOXCOM(oDriver, oExtentReport, oExtentTest, dictionary);
              obj.fCheckHomePage();
              obj.fSearchCustomer();
              obj.fRechargePageValidation();
              obj.fRechargeFinal();
              
       }
}
