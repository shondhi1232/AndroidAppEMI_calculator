package Screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Setup.setup.PACKAGE_ID;

public class Emi_Calculator_page {

    @FindBy(id = PACKAGE_ID+"id/btnStart")
    public AndroidElement btnStart;

    @FindBy(id = PACKAGE_ID+"id/etLoanAmount")
    AndroidElement txtLoanAmount;

    @FindBy(id = PACKAGE_ID+"id/etInterest")
    AndroidElement txtInterest;

    @FindBy(id = PACKAGE_ID+"id/etYears")
    AndroidElement txtYears;

    @FindBy(id = PACKAGE_ID+"id/etEMI")
    AndroidElement txtEMI;  //we won't write in this field

    @FindBy(id = PACKAGE_ID+"id/etFee")
    AndroidElement txtProcessingFee;

    @FindBy(id = PACKAGE_ID+"id/btnCalculate")
    AndroidElement btnCalculate;

    @FindBy(id ="com.continuum.emi.calculator:id/btnReset")
    public AndroidElement btnReset;
//--------------------------------------------------------

    @FindBy(id = PACKAGE_ID+"id/monthly_emi_result")
    public AndroidElement txtMonthlyEmiAmount;

    @FindBy(id = PACKAGE_ID+"id/total_interest_result")
    public AndroidElement txtTotal_InterestAmount;

    @FindBy(id = PACKAGE_ID+"id/processing_fee_result")
    public AndroidElement txtResultProcessing_Fee;

    @FindBy(id = PACKAGE_ID+"id/total_payment_result")
    public AndroidElement totalPayment;

    public Emi_Calculator_page(AndroidDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    public void calculateEMI(int loanAmount, double loanInterest,int timePeriod_inYear, double processingFee){
        //As we know that sendKeys always expect string type value that's why I make the integer type value accepted in appropriate way,
        // or I could use only ""+loanAmount
        txtLoanAmount.sendKeys(""+loanAmount+"");
        txtInterest.sendKeys(""+loanInterest+"");
        txtYears.sendKeys(""+timePeriod_inYear+"");
        txtProcessingFee.sendKeys(""+processingFee+"");
        btnCalculate.click();
    }
}
