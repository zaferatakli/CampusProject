package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;
import pages.TopNav;

import java.awt.*;
import java.time.Duration;

public class ProfileFeature {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();
    Robot rbt = new Robot();

    public ProfileFeature() throws AWTException {
    }

    @Given("Clicks on the profile photo in the top right corner")
    public void clicksOnTheProfilePhotoInTheTopRightCorner() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.profileButton));
        tn.myClick(tn.profileButton);
    }

    @When("Click on settings and there again click on the profile photo")
    public void clickOnSettingsAndThereAgainClickOnTheProfilePhoto() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.profileSettings));
        tn.myClick(tn.profileSettings);
    }

    @Then("Clicks on the upload image here and selects the image on your computer")
    public void clicksOnTheUploadImageHereAndSelectsTheImageOnYourComputer() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.uploadPicture));
        dc.myClick(dc.uploadPicture);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.uploadPictureIcon));
        dc.myClick(dc.uploadPictureIcon);


        tn.setWait(3);
        tn.pressTab(10);
        tn.pressSpace();
        tn.pressEnter();
        dc.myClick(dc.uploadButton);
        dc.myClick(dc.saveButton);
    }

    @And("User deletes the current photo and selects the new photo")
    public void userDeletesTheCurrentPhotoAndSelectsTheNewPhoto() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.settingsButton));
        tn.myClick(tn.settingsButton);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.profileSettings));

        tn.myClick(tn.profileSettings);
        tn.setWait(10);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.image));
        dc.jsClick(dc.image);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.deleteButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.deleteButton));
        dc.jsClick(dc.deleteButton);
    }

    @Then("Sees that the new photo has changed and exits the settings")
    public void seesThatTheNewPhotoHasChangedAndExitsTheSettings() {
    }

    @When("The user clicks on Settings and selects the desired theme colour from the Default theme option")
    public void theUserClicksOnSettingsAndSelectsTheDesiredThemeColourFromTheDefaultThemeOption() {
    }

    @And("This can be done with any two different colours")
    public void thisCanBeDoneWithAnyTwoDifferentColours() {
    }

    @Then("After changing the theme, the user sees that the colours have changed and presses the save button")
    public void afterChangingTheThemeTheUserSeesThatTheColoursHaveChangedAndPressesTheSaveButton() {
    }
}
