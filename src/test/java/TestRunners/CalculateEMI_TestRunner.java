package TestRunners;

import Screens.Emi_Calculator_page;
import Setup.setup;
import dataset.Dataset;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalculateEMI_TestRunner extends setup {
    Emi_Calculator_page emiCal;

    @BeforeTest
    public void startEmiCalculator() {
        emiCal = new Emi_Calculator_page(driver);
        emiCal.btnStart.click();
    }

    @Test(dataProvider = "data-provider",dataProviderClass = Dataset.class)
    public void doCalculateEMI(int loanAmount, double interest, int period_year, double processingFee, int mEMI,int tInterest, int totalpFee, int total_Payment) throws InterruptedException {
        emiCal = new Emi_Calculator_page(driver);
        emiCal.calculateEMI(loanAmount,interest,period_year,processingFee);

        String monthlyEMI = emiCal.txtMonthlyEmiAmount.getText();
        String totalInterest = emiCal.txtTotal_InterestAmount.getText();
        String totalprocessingfee = emiCal.txtResultProcessing_Fee.getText();
        String totalpayment = emiCal.totalPayment.getText();

        monthlyEMI = String.valueOf((int)Math.floor(Double.parseDouble(monthlyEMI.replace(",",""))));
        totalInterest = String.valueOf((int)Math.floor(Double.parseDouble(totalInterest.replace(",",""))));
        totalprocessingfee = String.valueOf((int)Math.floor(Double.parseDouble(totalprocessingfee.replace(",",""))));
        totalpayment  = String.valueOf((int)Math.floor(Double.parseDouble(totalpayment.replace(",",""))));

        Assert.assertEquals(monthlyEMI,String.valueOf(mEMI));
        Assert.assertEquals(totalInterest,String.valueOf(tInterest));
        Assert.assertEquals(totalprocessingfee,String.valueOf(totalpFee));
        Assert.assertEquals(totalpayment,String.valueOf(total_Payment));

        Thread.sleep(1000);
        emiCal.btnReset.click();
    }


}
