package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.*;

public class ProfileFeature {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();
    String firstImage;
    String secondImage;

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
        tn.setWait(4);
        dc.myClick(dc.saveButton);
    }

    @And("User deletes the current photo and selects the new photo")
    public void userDeletesTheCurrentPhotoAndSelectsTheNewPhoto() {
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.image));
        dc.jsClick(dc.image);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.deleteButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.deleteButton));
        dc.myClick(dc.deleteButton);
        dc.myClick(dc.yesButton);
        dc.myClick(dc.closeButton);
        dc.myClick(dc.escButton);
        tn.myClick(tn.coursesMenu);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.getImage));
        firstImage = dc.getImage.getDomAttribute("src");
        System.out.println("First Image Source: " + firstImage);
    }

    @Then("Sees that the new photo has changed and exits the settings")
    public void seesThatTheNewPhotoHasChangedAndExitsTheSettings() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.uploadPicture));
        dc.myClick(dc.uploadPicture);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.uploadPictureIcon));
        dc.myClick(dc.uploadPictureIcon);

        tn.setWait(3);
        tn.pressTab(10);
        tn.pressSpace();
        tn.pressEnter();
        dc.myClick(dc.uploadButton);
        tn.setWait(4);
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.saveButton));
        dc.jsClick(dc.saveButton);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.coursesMenu));
        tn.myClick(tn.coursesMenu);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.getImage));
        secondImage = dc.getImage.getDomAttribute("src");
        System.out.println("Second Image Source: " + secondImage);

        Assert.assertNotEquals(firstImage, secondImage, "The profile image did not change as expected.");
    }

    @When("The user clicks on Settings and selects the desired theme colour from the Default theme option")
    public void theUserClicksOnSettingsAndSelectsTheDesiredThemeColourFromTheDefaultThemeOption() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.profileSettings));
        tn.myClick(tn.profileSettings);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.defaultThemeButton));
        Assert.assertTrue(dc.defaultThemeButton.isDisplayed());
        dc.myClick(dc.defaultThemeButton);
    }

    @And("This can be done with any two different colours")
    public void thisCanBeDoneWithAnyTwoDifferentColours() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.purpleThemeButton));
        dc.action.moveToElement(dc.purpleThemeButton).click().build().perform();
        dc.wait.until(ExpectedConditions.visibilityOf(dc.purpleTheme));
        Assert.assertTrue(dc.purpleTheme.isDisplayed());
        dc.myClick(dc.purpleTheme);

        dc.wait.until(ExpectedConditions.visibilityOf(dc.greenThemeButton));
        dc.action.moveToElement(dc.greenThemeButton).click().build().perform();
        dc.wait.until(ExpectedConditions.visibilityOf(dc.greenTheme));
        Assert.assertTrue(dc.greenTheme.isDisplayed());
        dc.myClick(dc.greenTheme);
    }

    @Then("After changing the theme, the user sees that the colours have changed and presses the save button")
    public void afterChangingTheThemeTheUserSeesThatTheColoursHaveChangedAndPressesTheSaveButton() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.defaultTheme));
        dc.action.moveToElement(dc.defaultTheme).click().build().perform();
        dc.wait.until(ExpectedConditions.visibilityOf(dc.defaultThemeButton));
        Assert.assertTrue(dc.defaultThemeButton.isDisplayed());
        dc.myClick(dc.saveButton);
    }
}