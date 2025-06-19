package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.*;
import utilities.*;

import java.util.List;

public class FinanceFunctionality {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @Given("The user has been redirected to the my finance page")
    public void theUserHasBeenRedirectedToTheMyFinancePage() {
        tn.myClick(tn.hamburgerMenuButton);
        tn.hoverOver(tn.financeButton);
        tn.myClick(tn.myFinanceButton);
    }

    @And("The user should be on the My Finance page")
    public void theUserShouldBeOnTheMyFinancePage() {
        tn.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("myFinanceURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("myFinanceURL")));
        dc.verifyContainsText(dc.studentFees, "Students Fees");
    }

    @When("The user clicks on their payment in processing")
    public void theUserClicksOnTheirPaymentInProcessing() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.processingPayment));
        Assert.assertTrue(dc.processingPayment.isDisplayed(), "Processing payment is not displayed!");
        dc.myClick(dc.processingPayment);
    }

    @Then("The user verify that go to the Student Fee page")
    public void theUserVerifyThatGoToTheStudentFeePage() {
        dc.verifyContainsText(dc.studentFee, "Student Fee");
    }

    @And("The user clicks on the following buttons to reach the pay button")
    public void theUserClicksOnTheFollowingButtonsToReachThePayButton(DataTable buttons) {
        List<String> buttonsList = buttons.asList(String.class);

        for (int i = 0; i < buttonsList.size(); i++) {
            dc.wait.until(ExpectedConditions.elementToBeClickable(dc.getWebElement(buttonsList.get(i))));
            Assert.assertTrue(dc.getWebElement(buttonsList.get(i)).isDisplayed());
            dc.myClick(dc.getWebElement(buttonsList.get(i)));
        }
    }

    @And("The user enter the payment amount in the Amount field.")
    public void theUserEnterThePaymentAmountInTheAmountField() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.amountField));
        Assert.assertTrue(dc.amountField.isDisplayed(), "Amount Field is not displayed!");
        dc.mySendKeys(dc.amountField, ConfigReader.getProperty("amount"));
    }

    @And("The user double clicks on the pay button")
    public void theUserDoubleClicksOnThePayButton() {
        dc.myClick(dc.payButton);
        dc.myClick(dc.paymentButton);
    }

    @When("The user verifies that the field to enter credit card information has been opened")
    public void theUserVerifiesThatTheFieldToEnterCreditCardInformationHasBeenOpened() {
        dc.verifyContainsText(dc.cardPaymentTitle, "Pay $");
    }

    @And("The user enters credit card details")
    public void theUserEntersCreditCardDetails() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.paymentIframe));
        GWD.getDriver().switchTo().frame(dc.paymentIframe);
        dc.wait.until(ExpectedConditions.visibilityOfAllElements(dc.creditCardField));
        dc.mySendKeys(dc.cardNumberInput, ConfigReader.getProperty("cardNumber") + Keys.TAB + ConfigReader.getProperty("expirationDate") + Keys.TAB + ConfigReader.getProperty("securityCode"));
        GWD.getDriver().switchTo().defaultContent();
    }

    @And("The user clicks on the stripe payments button")
    public void theUserClicksOnTheStripePaymentsButton() {
        dc.myClick(dc.paymentsButton);
    }

    @And("The user sees the message of success")
    public void theUserSeesTheMessageOfSuccess() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.paymentSuccessMessage));
        dc.verifyContainsText(dc.paymentSuccessMessage, "success");
    }

    @Given("The user clicks on the button with three dots in the lower left corner")
    public void theUserClicksOnTheButtonWithThreeDotsInTheLowerLeftCorner() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.threeDotButton));
        Assert.assertTrue(dc.threeDotButton.isDisplayed());
        dc.myClick(dc.threeDotButton);
    }

    @And("the user downloads the document by clicking the Excel Export button in the drop-down menu")
    public void theUserDownloadsTheDocumentByClickingTheExcelExportButtonInTheDropDownMenu() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.excelDownload));
        Assert.assertTrue(dc.excelDownload.isDisplayed(), "Excel download button not displayed");
        dc.myClick(dc.excelDownload);
    }

    @And("the user downloads the document by clicking the Pdf Export button in the drop-down menu")
    public void theUserDownloadsTheDocumentByClickingThePdfExportButtonInTheDropDownMenu() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.pdfDownload));
        Assert.assertTrue(dc.pdfDownload.isDisplayed(), "Pdf download button not displayed");
        dc.myClick(dc.pdfDownload);
    }

    @Then("The user confirms the balance has decreased.")
    public void theUserConfirmsTheBalanceHasDecreased() {
        dc.setWait(1);
        String balanceText = dc.totalBalance.getText();
        int actualBalance = Integer.parseInt(balanceText.replaceAll("[^0-9]", ""));
        String firstBalance = ConfigReader.getProperty("balance");
        int firstBalanceInt = Integer.parseInt(firstBalance);
        int expectedBalanceInt = firstBalanceInt - Integer.parseInt(ConfigReader.getProperty("amount"));
        Assert.assertTrue(actualBalance == expectedBalanceInt, "Balance has not decreased as expected!");
    }

    @Given("The user memorizes balance.")
    public void theUserMemorizesBalance() {
        String balance = dc.totalBalance.getText().replaceAll("[^0-9]", "");
        ConfigReader.saveToConfig("balance", balance);
    }

    @Then("The user views new installment payment form")
    public void theUserViewsNewInstallmentPaymentForm() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.newInstallmentPlansPageTitle));
        Assert.assertTrue(dc.newInstallmentPlansPageTitle.isDisplayed(), "Installment payment form is not displayed!");
        dc.verifyContainsText(dc.newInstallmentPlansPageTitle, "New Installment Plans");
    }
}