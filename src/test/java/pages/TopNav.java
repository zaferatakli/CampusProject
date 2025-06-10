package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import utilities.*;

import java.util.List;

public class TopNav extends ReusableMethods {

    public TopNav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//div[@fxlayout='row']/div/img")
    public WebElement homePageLogo;

    @FindBy(xpath = "(//span[contains(text(),'Courses')])[1]")
    public WebElement coursesMenu;

    @FindBy(xpath = "//span[text()='Calendar']")
    public WebElement calendarButton;

    @FindBy(xpath = "//span[text()='Attendance']")
    public WebElement attendanceMenu;

    @FindBy(xpath = "//span[text()='Assignments']")
    public WebElement assignmentsMenu;

    @FindBy(xpath = "//*[@icon='analytics']/button")
    public WebElement gradingMenu;

    @FindBy(xpath = "//user-announcement-bell/button")
    public WebElement notificationButton;

    @FindBy(xpath = "//span[text()='Messaging']")
    public WebElement messagingButton;

    @FindBy(xpath = "(//div[@class='cdk-overlay-pane'])[2]//button")
    public List<WebElement> messagingSubMenuList;

    @FindBy(xpath = "//span[text()='Send Message']")
    public WebElement sendMessageButton;

    @FindBy(xpath = "(//*[@class='mdc-button__label'])[6]")
    public List<WebElement> hamburgerMenuSubMenus;

    @FindBy(xpath = "//span[text()='My Finance']")
    public WebElement myFinanceButton;

    @FindBy(xpath = "//span[text()='Finance']")
    public WebElement financeButton;

    @FindBy(xpath = "//span[text()='Outbox']")
    public WebElement outboxButton;

    @FindBy(xpath = "//span[text()='Trash']")
    public WebElement trashButton;

    @FindBy(xpath = "//user-message-bell//button")
    public WebElement  newMessageIcon;

    @FindBy(xpath = "(//span[@class='mdc-button__label'])[6]")
    public WebElement hamburgerMenuButton;

    @FindBy(xpath = "//span[text()=' S. 11A']")
    public WebElement studentAccount;

    @FindBy(xpath = "(//span[text()='Attendance'])[3]")
    public WebElement attendanceButton;

    @FindBy(xpath = "//span[contains(text(),'Attendance Excuses')]")
    public WebElement attendanceExcusesButton;

    @FindBy(xpath = "//span[contains(text(),'Video ')]")
    public WebElement videoConference;

    @FindBy(xpath = "//span[text()='Video Meetings']")
    public WebElement videoMeetingsButton;

    @FindBy(xpath = "//span[text()='Surveys']")
    public WebElement surveysMenu;

    @FindBy(xpath = "//span[text()='My Surveys']")
    public WebElement mySurveysButton;

    @FindBy(xpath = "//span[text()='My Certificates']")
    public WebElement myCertificates;

    @FindBy(xpath = "//span[text()='My Files']")
    public WebElement myFiles;

    @FindBy(xpath = "//span[text()='Change Password']")
    public WebElement changePassword;

    @FindBy(xpath = "//div[@fxlayoutalign='start center']/button")
    public WebElement profileButton;

    @FindBy(xpath = "//span[text()='Settings']")
    public WebElement profileSettings;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    public WebElement escapeButton;

    @FindBy(xpath="(//button[@matbadgecolor='accent'])[2]")
    public WebElement receiversButton;

    @FindBy(xpath ="(//*[text()='User'])[10]")
    public WebElement receiversCheckbox;

    @FindBy(xpath ="//span[text()='Add & Close']")
    public WebElement addAndCloseButton;

    @FindBy(xpath ="//input[@placeholder='Subject']")
    public WebElement subjectInput;

    @FindBy(xpath ="//iframe[@class='tox-edit-area__iframe']")
    public WebElement messageTextIframe;

    @FindBy(xpath ="//span[text()='Attach Files...']")
    public WebElement attachInput;

    @FindBy(xpath ="//span[text()='From My Files']")
    public WebElement fromMyFiles;

    @FindBy(xpath = "//*[@type='checkbox']")
    public WebElement attachCheckbox;

    @FindBy(xpath ="//span[text()='Select']")
    public WebElement selectButton;

    @FindBy(xpath = "(//*[text()=' Info '])[1]")
    public WebElement selectMessageButton;

    @FindBy(xpath ="//*[text()='Move to Trash']")
    public WebElement moveToTrashButton;

    @FindBy(xpath ="//span[text()=' Yes ']")
    public WebElement yesButton;

    @FindBy (xpath ="//*[contains(text(), 'Message successfully')]")
    public WebElement successMessage;

    @FindBy (xpath = "//body[@id='tinymce']")
    public WebElement messageTextBody;

    @FindBy(xpath = "//span[text()='Send']")
    public WebElement sendButton;

    @FindBy(xpath = "(//*[@icon='trash-restore'])[1]")
    public WebElement restoreButton;

    public WebElement getWebElement(String element) {
        switch (element) {
            case "sendMessage": return this.sendMessageButton;
            case "outboxMessage": return this.outboxButton;
            case "newMessageIcon": return this.newMessageIcon;
            case "grading": return this.gradingMenu;
            case "calendar": return this.calendarButton;
            case "courses": return this.coursesMenu;
            case "attendance": return this.attendanceMenu;
            case "assignments": return this.assignmentsMenu;
            case "notificationsIcon": return this.notificationButton;
        }
        return null;
    }
}