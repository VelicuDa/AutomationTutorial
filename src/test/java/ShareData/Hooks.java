package ShareData;

import ExtentUtility.ExtentReport;

import InputFile.PropertiesUtility;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class Hooks extends ShareData{
    public HashMap<String, String> TestData;
    private String TestName;

    //implementam o logica de generare a unui singur raport pt n teste

    public static ExtentReport ExtentReportUtility = new ExtentReport(); //sa pastreze toate info
    public static List<Log> logContext = new ArrayList<>();
    public ExtentReport testReport;

    @BeforeMethod
    public void PrepareEnvironment(){
        Setup();
        TestName = this.getClass().getSimpleName(); ////returneaza numele clasei care ruleaza
        PropertiesUtility propertiesUtility = new PropertiesUtility(TestName);
        TestData = propertiesUtility.GetAllData();
        testReport = new ExtentReport(TestName);

    }

    @AfterMethod
    public void ClearEnvironment(ITestResult testResult){ //listener din testng
        if(testResult.getStatus() == ITestResult.FAILURE){
            testReport.attacheReport("fail", testResult.getThrowable().getMessage(), getDriver(), TestName);
        }
        //facem o logica care sa genereze raportul inainte sa inchide driver ul;//daca testele au ajusn in acelasi punct => daca mai multe thereduri nu se suprapun */
        testReport.attacheReport("info", " --- finish "+TestName+" test ---");

        synchronized (ExtentReportUtility){

            ExtentTest currentTest = ExtentReportUtility.getExtent().createTest(" " + TestName+ "- report");
            logContext.addAll(testReport.getTestReport().getModel().getLogs());
            for(Log log:logContext){
                currentTest.getModel().getLogs().add(log);
                if(log.getStatus().equals(Status.FAIL)){
                    currentTest.getModel().setStatus(Status.FAIL);
                }
            }
            ExtentReportUtility.getExtent().flush();
            logContext.clear(); //curatam lista de loguri
        }

        //trebuie sa tratam cazul in care cade un test




        Clear();

    }

}
