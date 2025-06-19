package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeaderMenuCheck {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @When("The user verifies Header menu by clicking on the Header menu links")
    public void theUserVerifiesHeaderMenuByClickingOnTheHeaderMenuLinks(DataTable menuLinks) {
        List<String> currentUrl = new ArrayList<>();
        Collections.addAll(currentUrl, "courses", "calendar", "attendance", "assignment", "grading");
        List<String> links = menuLinks.asList(String.class);

        for (int i = 0; i < links.size(); i++) {
            tn.jsClick(tn.getWebElement(links.get(i)));
            tn.wait.until(ExpectedConditions.urlContains(currentUrl.get(i)));
            ConfigReader.saveToConfigIfAbsent(links.get(i) + "URL", GWD.getDriver().getCurrentUrl());
        }
    }

    @And("The user clicks on the Hamburger menu and Hamburger submenu")
    public void theUserClicksOnTheHamburgerMenuAndHamburgerSubmenu() {
        List<String> containsURL = new ArrayList<>();
        Collections.addAll(containsURL, "new", "inbox", "outbox", "trash");

        for (int i = 0; i < 4; i++) {
            tn.myClick(tn.hamburgerMenuButton);
            tn.wait.until(ExpectedConditions.visibilityOf(tn.messagingButton));
            tn.hoverOver(tn.messagingButton);
            tn.wait.until(ExpectedConditions.visibilityOfAllElements(tn.messagingSubMenuList));
            tn.myClick(tn.messagingSubMenuList.get(i));
            tn.wait.until(ExpectedConditions.urlContains(containsURL.get(i)));
        }

        tn.myClick(tn.hamburgerMenuButton);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.financeButton));
        tn.hoverOver(tn.financeButton);
        tn.jsClick(tn.myFinanceButton);
        tn.wait.until(ExpectedConditions.urlContains("student-finance"));

        tn.myClick(tn.hamburgerMenuButton);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.attendanceButton));
        tn.hoverOver(tn.attendanceButton);
        tn.jsClick(tn.attendanceExcusesButton);
        tn.wait.until(ExpectedConditions.urlContains("attendance-excuse/list"));

        tn.myClick(tn.hamburgerMenuButton);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.videoConference));
        tn.hoverOver(tn.videoConference);
        tn.jsClick(tn.videoMeetingsButton);
        tn.wait.until(ExpectedConditions.urlContains("meetings"));

        tn.myClick(tn.hamburgerMenuButton);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.surveysMenu));
        tn.hoverOver(tn.surveysMenu);
        tn.jsClick(tn.mySurveysButton);
        tn.wait.until(ExpectedConditions.urlContains("surveys"));
    }

    @Then("The user verifies items in the upper right corner")
    public void theUserVerifiesItemsInTheUpperRightCorner() {
        tn.clickAndClose(tn.notificationButton, dc.dcTitle);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.newMessageIcon));
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.newMessageIcon));
        tn.myClick(tn.newMessageIcon);
        tn.wait.until(ExpectedConditions.visibilityOf(dc.dcTitle));
        tn.myClick(tn.escapeButton);

        tn.myClick(tn.profileButton);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.myCertificates));
        tn.myClick(tn.myCertificates);
        tn.wait.until(ExpectedConditions.urlContains("my-certificates"));

        tn.myClick(tn.profileButton);
        tn.clickAndClose(tn.myFiles, dc.dcTitle);

        tn.myClick(tn.profileButton);
        tn.clickAndClose(tn.changePassword, dc.dcTitle);
        tn.myClick(tn.escapeButton);

        tn.myClick(tn.profileButton);
        tn.clickAndClose(tn.profileSettings, dc.dcTitle);
    }
}