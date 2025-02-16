package uitests.testng.milestone8;

import java.awt.AWTException;
import java.lang.reflect.Method;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import cares.cwds.salesforce.constants.SalesforceConstants;
import cares.cwds.salesforce.pom.Home;
import cares.cwds.salesforce.pom.Login;
import cares.cwds.salesforce.pom.Logout;
import cares.cwds.salesforce.pom.folio.FolioContactLog;
import cares.cwds.salesforce.pom.folio.FolioDocuments;
import cares.cwds.salesforce.pom.folio.FolioPerson;
import cares.cwds.salesforce.pom.folio.FolioTask;
import cares.cwds.salesforce.pom.folio.GenerateDocument;
import cares.cwds.salesforce.pom.foliocase.RecordAlertsAndTasks;
import cares.cwds.salesforce.pom.foliocase.placement.FolioBackgroundChecks;
import cares.cwds.salesforce.pom.foliocase.placement.FolioChildLocations;
import cares.cwds.salesforce.pom.foliocase.placement.FolioInspections;
import cares.cwds.salesforce.pom.foliocase.placement.FolioPlacement;
import cares.cwds.salesforce.pom.foliocase.placement.FolioProviderSearch;
import cares.cwds.salesforce.pom.foliocase.placement.KnowledgeArticle;
import cares.cwds.salesforce.pom.foliocase.placement.LegalAuthority;
import cares.cwds.salesforce.pom.foliocase.placement.ProviderOptions;
import cares.cwds.salesforce.pom.foliocase.placement.Removal;
import cares.cwds.salesforce.utilities.testng.TestNGCommon;
import cares.cwds.salesforce.utilities.testng.TestNGListener;
import cares.cwds.salesforce.utilities.web.SalesforceCommon;
import uitests.testng.datasetup.CaseDataSetup1;

@Listeners(TestNGListener.class)
public class T4275 extends TestNGCommon  {
	
		String testCaseName = "To Verify user is able to make a Placement ina Resource Family Home or Tribal Home, document the Emergency Placement Pre-RFA Approval and Pre-Tribal Home Approval";
		String moduleName = "cares";
		String fileName = "ScriptMasterSheet"; 
		
		@BeforeMethod
		public void setUpReport()
		{
	        setTestAttributes("testCaseParam",testCaseParam);
		}


		@Test (dataProvider = "data-provider")
		public void testT4275(String scriptIteration) throws AWTException, InterruptedException{
			driver = (WebDriver) getTestAttribute("driver");
			
			
			/** PreReq Data ***/
		    //Read Investigative Case record from datasheet
	    	SalesforceConstants.setConstantValue("INV_CASE_ID1", readOutputSheet("Case", false, "Contra"));
	    	
	    	//PreData Setup scenario
	    	//Running preData setup scenario if case record is null from output data sheet
//	    	if(Objects.isNull(SalesforceConstants.getConstantValue("INV_CASE_ID1")) ){
//		    	CaseDataSetup1 caseDataSetup = new CaseDataSetup1();
//		    	caseDataSetup.testCaseDataSetup1("1");
//	    	} 
	    		
	    	/*** T4275*****/
		///////////////////////// Login As CM Worker /////////////////////////////////////////////////////

			Login login = new Login(driver);
//	    	login.processLoginNew( scriptIteration,SalesforceConstants.POMITERATION1, SalesforceConstants.LOGINUSER); 
			
			Home home = new Home(driver);
//			home.closeAllTabs();
//		    home.searchFolioRecord(scriptIteration, scriptIteration);
		 
		    /////////////////////////////  Pre-Condition 2///////////////////////////////////////////////////////
			
		    FolioProviderSearch providerSearch = new FolioProviderSearch(driver);		
//			providerSearch.navigateToProviderSearch(scriptIteration,SalesforceConstants.POMITERATION1);
//			providerSearch.searchProvderType(scriptIteration,SalesforceConstants.POMITERATION1);
//			providerSearch.enterNewPlacementDetails(scriptIteration,SalesforceConstants.POMITERATION1);
     
        ////////////////////////////Validation As Per-Condition 2 ////////////////////////////////////////////////	
		    			
			ProviderOptions providerOptions = new ProviderOptions(driver);
/*			SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			providerOptions.navigateToProvideOptions(scriptIteration,SalesforceConstants.POMITERATION1);
			providerOptions.navigateToExistingPlacementOptionsRecord(scriptIteration,SalesforceConstants.POMITERATION1);
			providerOptions.editExistingPlacementOptionsRecord(scriptIteration,SalesforceConstants.POMITERATION1);
			providerSearch.verifyProviderPlacement(scriptIteration,SalesforceConstants.POMITERATION1);
						
			providerOptions = new ProviderOptions(driver);
			SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			providerOptions.navigateToProvideOptions(scriptIteration,SalesforceConstants.POMITERATION2);
			providerOptions.navigateToExistingPlacementOptionsRecord(scriptIteration,SalesforceConstants.POMITERATION1);
			providerOptions.editExistingPlacementOptionsRecord(scriptIteration,SalesforceConstants.POMITERATION2);
			providerSearch.verifyProviderPlacement(scriptIteration,SalesforceConstants.POMITERATION1);
	   //////////////////////////// Pre-Condition 4 ///////////////////////////////////////////////////////
			
			FolioPerson folioPerson = new FolioPerson(driver);
			SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			folioPerson.navigateToFolioPersonsTab(scriptIteration, SalesforceConstants.POMITERATION1);
			folioPerson.addFolioPerson(scriptIteration, SalesforceConstants.POMITERATION1);
			
			SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			folioPerson.navigateToFolioPersonsTab(scriptIteration, SalesforceConstants.POMITERATION2);
			folioPerson.addFolioPerson(scriptIteration, SalesforceConstants.POMITERATION2);
			
			providerSearch = new FolioProviderSearch(driver);
			SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			providerSearch.navigateToProviderSearch(scriptIteration,SalesforceConstants.POMITERATION2);
			providerSearch.searchProvderType(scriptIteration,SalesforceConstants.POMITERATION2);
			providerSearch.enterNewPlacementDetails(scriptIteration,SalesforceConstants.POMITERATION2);
		
			SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);		
			FolioPlacement placement= new FolioPlacement(driver);
			placement.navigateToPlacement(scriptIteration, SalesforceConstants.POMITERATION1);
*/			
            Removal removal = new Removal(driver);
//            removal.navigateToRemovalTab(scriptIteration, SalesforceConstants.POMITERATION1);
//            removal.addRemovalDetails(scriptIteration, SalesforceConstants.POMITERATION1); 
            
       ////////////////////////////Validation As Per-Condition 4 ////////////////////////////////////////////////	
			
	   /******************** Create Child Location *****************************************/
//            SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);			
//            FolioPlacement placement= new FolioPlacement(driver);
//			placement.navigateToPlacement(scriptIteration, SalesforceConstants.POMITERATION1);
			
			FolioChildLocations childLocations = new FolioChildLocations(driver);
//			childLocations.clickNewChildLocationType(scriptIteration, SalesforceConstants.POMITERATION1);
//			childLocations.enterChildLocationPlacementDetails(scriptIteration, SalesforceConstants.POMITERATION1);
	
		/******************** Task Notification handle*****************************************/
/*			 home = new Home(driver);
			 SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			 home.clickOnNotification("FOLIO_ID", scriptIteration, SalesforceConstants.POMITERATION1);
					
			 Logout logout = new Logout(driver);
			 logout.processLogout(scriptIteration, SalesforceConstants.POMITERATION1);
       ///////////////////// Login RFA ///////////////////////////////////////////////////////////		
			login = new Login(driver);
	    	login.processLoginNew( scriptIteration,SalesforceConstants.POMITERATION1, SalesforceConstants.CLERICALWORKER); 
			
	    	home = new Home(driver);
	        home.verifyNotification(scriptIteration, SalesforceConstants.POMITERATION1);
	     
			logout = new Logout(driver);
			logout.processLogout(scriptIteration, SalesforceConstants.POMITERATION1);
			 
       ///////////////////// Login Back As CM Worker  ///////////////////////////////////////////////////////////     
	        login = new Login(driver);
	    	login.processLoginNew( scriptIteration,SalesforceConstants.POMITERATION1, SalesforceConstants.LOGINUSER); 
	  
	    	home = new Home(driver);
			home.closeAllTabs();
		    home.searchFolioRecord(scriptIteration, scriptIteration);
		    
	   ///////////////////// Navigate to Provider Record ///////////////////////////////////////////////////////////
	    	providerOptions = new ProviderOptions(driver);
			SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			providerOptions.navigateToProvideOptions(scriptIteration,SalesforceConstants.POMITERATION3);
			providerOptions.navigateToExistingPlacementOptionsRecord(scriptIteration,SalesforceConstants.POMITERATION3);
			providerOptions.editExistingPlacementOptionsRecord(scriptIteration,SalesforceConstants.POMITERATION3);
	  
			FolioBackgroundChecks	backgroundChecks = new FolioBackgroundChecks(driver);
			backgroundChecks.navigateToPlacmentBackgroundChecksTab(scriptIteration, SalesforceConstants.POMITERATION1);
			backgroundChecks.createPlacementBackgroundCheckRecord(scriptIteration, SalesforceConstants.POMITERATION1);
			
			providerOptions = new ProviderOptions(driver);
			SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			providerOptions.navigateToProvideOptions(scriptIteration,SalesforceConstants.POMITERATION3);
			providerOptions.navigateToExistingPlacementOptionsRecord(scriptIteration,SalesforceConstants.POMITERATION3);
			
			FolioInspections inspections = new FolioInspections(driver);
			inspections.navigateToFolioInspectionsTab(scriptIteration, SalesforceConstants.POMITERATION1);
			inspections.createFolioInspectionsRecord(scriptIteration, SalesforceConstants.POMITERATION1);
			
			providerOptions = new ProviderOptions(driver);
			SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			providerOptions.navigateToProvideOptions(scriptIteration,SalesforceConstants.POMITERATION3);
			providerOptions.navigateToExistingPlacementOptionsRecord(scriptIteration,SalesforceConstants.POMITERATION3);
			
			backgroundChecks = new FolioBackgroundChecks(driver);
			backgroundChecks.navigateToFolioBackgroundChecksTab(scriptIteration, SalesforceConstants.POMITERATION2);
			backgroundChecks.editBackgroundChecksRecord(scriptIteration,  SalesforceConstants.POMITERATION2);
		
			logout = new Logout(driver);
			logout.processLogout(scriptIteration, SalesforceConstants.POMITERATION1);
*/			 
	    ///////////////////////// Organization /////////////////////////////////////////
			login = new Login(driver);
		    login.processLoginNew( scriptIteration,SalesforceConstants.POMITERATION1, SalesforceConstants.LOGINUSER); 
		  
		    home = new Home(driver);
			home.closeAllTabs();
		    home.searchFolioRecord(scriptIteration, SalesforceConstants.POMITERATION1);
		    
        /////////////////////////////// Validation as Pre-Condition 7 ///////////////////////////////////////////	
		    FolioPerson folioPerson = new FolioPerson(driver);
			folioPerson.navigateToFolioPersonsTab(scriptIteration, SalesforceConstants.POMITERATION3);
			folioPerson.addFolioPerson(scriptIteration, SalesforceConstants.POMITERATION3);
			
			SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			FolioPlacement placement= new FolioPlacement(driver);
			placement.navigateToPlacement(scriptIteration, SalesforceConstants.POMITERATION1);
			
			removal = new Removal(driver);
			removal.navigateToRemovalTab(scriptIteration, SalesforceConstants.POMITERATION2);
			removal.addRemovalDetails(scriptIteration, SalesforceConstants.POMITERATION2);
			
			LegalAuthority legalAuthority = new LegalAuthority(driver);
			legalAuthority.navigateToLegalAuthorityTab(scriptIteration,SalesforceConstants.POMITERATION1);
			legalAuthority.clickNewLegalAuthority(scriptIteration,SalesforceConstants.POMITERATION1);
			legalAuthority.addLegalInfo(scriptIteration,SalesforceConstants.POMITERATION1);
		
			FolioDocuments folioDocuments = new FolioDocuments(driver);
			SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			folioDocuments.navigateToDocuments(scriptIteration, SalesforceConstants.POMITERATION1);
			folioDocuments.uploadDocument(scriptIteration, SalesforceConstants.POMITERATION1);
			folioDocuments.verifyingDocumentListFieldsHeaders(scriptIteration,SalesforceConstants.POMITERATION1);
			
			providerSearch = new FolioProviderSearch(driver);
			SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			providerSearch.navigateToProviderSearch(scriptIteration,SalesforceConstants.POMITERATION3);
			providerSearch.searchProvderType(scriptIteration,SalesforceConstants.POMITERATION3);
			providerSearch.enterNewPlacementDetails(scriptIteration,SalesforceConstants.POMITERATION3);
			
			providerOptions = new ProviderOptions(driver);
			SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			providerOptions.navigateToProvideOptions(scriptIteration,SalesforceConstants.POMITERATION4);
			providerOptions.navigateToExistingPlacementOptionsRecord(scriptIteration,SalesforceConstants.POMITERATION4);
			providerOptions.editExistingPlacementOptionsRecord(scriptIteration,SalesforceConstants.POMITERATION4);
			
			folioDocuments = new FolioDocuments(driver);
			folioDocuments.navigateToDocuments(scriptIteration, SalesforceConstants.POMITERATION2);
			folioDocuments.uploadDocument(scriptIteration, SalesforceConstants.POMITERATION2);
			folioDocuments.verifyingDocumentListFieldsHeaders(scriptIteration,SalesforceConstants.POMITERATION1);
			
			
       ////////////////////Create Child Location ///////////////////////////////////////////////
	        childLocations = new FolioChildLocations(driver);
	        SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
	        childLocations.navigateToChildLocationTab(scriptIteration, SalesforceConstants.POMITERATION3);
	        childLocations.clickNewChildLocationType(scriptIteration, SalesforceConstants.POMITERATION3);
	        childLocations.enterChildLocationPlacementDetails(scriptIteration, SalesforceConstants.POMITERATION3);
      
	        SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
	        childLocations.navigateToChildLocationRecord(scriptIteration, SalesforceConstants.POMITERATION3);
	        childLocations.verifyChildLocationHeaders(scriptIteration, SalesforceConstants.POMITERATION3);
	        childLocations.enterChildLocationPlacementDetails(scriptIteration, SalesforceConstants.POMITERATION4);
	        
	        GenerateDocument generateDocument = new GenerateDocument(driver);
	        generateDocument.generateDocument(scriptIteration, SalesforceConstants.POMITERATION1);
	        generateDocument.submitDocument();
	        
	        generateDocument = new GenerateDocument(driver);
	        generateDocument.generateDocument(scriptIteration, SalesforceConstants.POMITERATION2);
	        generateDocument.submitDocument();
	        
	        generateDocument = new GenerateDocument(driver);
	        generateDocument.generateDocument(scriptIteration, SalesforceConstants.POMITERATION3);
	        generateDocument.submitDocument();
	        
	        generateDocument = new GenerateDocument(driver);
	        generateDocument.generateDocument(scriptIteration, SalesforceConstants.POMITERATION4);
	        generateDocument.submitDocument();
	        
	        folioDocuments = new FolioDocuments(driver);
	        SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
			folioDocuments.navigateToDocuments(scriptIteration, SalesforceConstants.POMITERATION3);
			folioDocuments.uploadDocument(scriptIteration, SalesforceConstants.POMITERATION3);
			folioDocuments.verifyingDocumentListFieldsHeaders(scriptIteration,SalesforceConstants.POMITERATION3);
			
			////////////////////////////////////////////////////////////////////////////////////////////
			childLocations = new FolioChildLocations(driver);
		    SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
		    childLocations.navigateToChildLocationTab(scriptIteration, SalesforceConstants.POMITERATION4);
		    childLocations.navigateToChildLocationRecord(scriptIteration, SalesforceConstants.POMITERATION4);
		    childLocations.enterChildLocationPlacementDetails(scriptIteration, SalesforceConstants.POMITERATION4);
	      				
	        FolioContactLog contactLog = new FolioContactLog(driver);
	        SalesforceCommon.navigateToRecordURL(driver, SalesforceConstants.FOLIO);
	        contactLog.navigateToFolioContactLogsAndTribalInquiresTab(scriptIteration, SalesforceConstants.POMITERATION1);
	        contactLog.addFolioContactLog(scriptIteration, SalesforceConstants.POMITERATION1);
			
	        KnowledgeArticle knowledgeArticle = new KnowledgeArticle(driver);
	        knowledgeArticle.navigateToKnowledgeArticle(scriptIteration, SalesforceConstants.POMITERATION1);
	        knowledgeArticle.searchKnowledge(scriptIteration, SalesforceConstants.POMITERATION1);
	        knowledgeArticle.verifyKnowledgeArticle(scriptIteration, SalesforceConstants.POMITERATION1);
	}
		 @DataProvider (name = "data-provider")
		    public String[] dpMethod(Method method){
			 testCaseParam.setTestCaseName(testCaseName);
		        testCaseParam.setModuleName(moduleName);
		        testCaseParam.setBrowser(browser);
		        testCaseParam.setTestCaseDescription(testCaseParam.getTestCaseName());
		        testCaseParam.setTestCaseDescription(testCaseParam.getTestCaseName());
		        testCaseParam.setTestNGTestMethodName(method.getName());
		    	return setScriptIterationFlag(fileName,moduleName, method.getName());
		   
		    }
}
