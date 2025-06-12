package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import utilities.*;

import java.util.List;

public class DialogContent extends ReusableMethods {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    /// US-001,003,023,024,025 locators
    @FindBy(css = "input[formcontrolname='username']")
    public WebElement usernameField;

    @FindBy(css = "input[formcontrolname='password']")
    public WebElement passwordField;

    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()=' Welcome, Student_4 11A ! ']")
    public WebElement loginCheck;

    @FindBy(xpath = "//div[text()='Invalid username or password']")
    public WebElement invalidMessage;

    @FindBy(xpath = "//span[@class='title dialog-title']")
    public WebElement dcTitle;

    @FindBy(xpath = "(//div/button)[8]")
    public WebElement previousButton;

    @FindBy(xpath = "(//div/button)[9]")
    public WebElement todayButton;

    @FindBy(xpath = "(//div/button)[10]")
    public WebElement nextButton;

    @FindBy(css = "div[fxlayout='row'] h4 strong")
    public WebElement dateCheck;

    @FindBy(xpath = "(//table)[1]")
    public WebElement weeklyPlanTableCheck;

    @FindBy(xpath = "//*[text()=' P ']")
    public WebElement publishedIcon;

    @FindBy(xpath = "//*[text()=' Published ']")
    public WebElement publishedDescription;

    @FindBy(xpath = "//*[text()=' S ']")
    public WebElement startedIcon;

    @FindBy(xpath = "//*[text()=' Started ']")
    public WebElement startedDescription;

    @FindBy(xpath = "//*[text()=' E ']")
    public WebElement endedIcon;

    @FindBy(xpath = "//*[text()=' Ended ']")
    public WebElement endedDescription;

    @FindBy(xpath = "//*[text()=' C ']")
    public WebElement cancelledIcon;

    @FindBy(xpath = "//*[text()=' Cancelled ']")
    public WebElement cancelledDescription;

    @FindBy(xpath = "//*[contains(text(),' Weekly Course Plan ')]")
    public WebElement weeklyCoursePlanButton;

    @FindBy(xpath = "(//*[text()=' Calendar '])[2]")
    public WebElement calendarPageButton;

    @FindBy(xpath = "//table[@role='grid']")
    public WebElement calendarTableCheck;

    @FindBy(xpath = "(//td/div//span[contains(text(),'11A')])[1]")
    public WebElement lessonsButton;

    @FindBy(xpath = "//mat-panel-description[@class='mat-expansion-panel-header-description']")
    public WebElement lessonMessage;

    @FindBy(xpath = "//span[@class='title dialog-title']")
    public WebElement popUpLessonTitle;

    @FindBy(xpath = "//span[contains(text(),'Teacher')]")
    public List<WebElement> lessonTeacherName;

    @FindBy(xpath = "//span[@class='mat-badge-content mat-badge-active'][text()='E']")
    public List<WebElement> endedLessonIcons;

    @FindBy(xpath = "//span[@class='mat-badge-content mat-badge-active'][text()='P']")
    public List<WebElement> publishedLessonIcons;

    @FindBy(xpath = "//span[@class='mat-badge-content mat-badge-active'][text()='S']")
    public List<WebElement> startedLessonIcons;

    @FindBy(xpath = "//span[@class='mat-badge-content mat-badge-active'][text()='C']")
    public List<WebElement> cancelledLessonIcons;

    @FindBy(xpath = "//span[text()='Recording']")
    public WebElement recordingButton;

    @FindBy(xpath = "//button[@title='Play Video']")
    public WebElement playVideoButton;

    @FindBy(xpath = "(//div[@class='vjs-time-tooltip'])[2]")
    public WebElement videoTimer;

    @FindBy(xpath = "(//button[@aria-label='Close dialog'])[2]")
    public WebElement videoCloseButton;

    @FindBy(tagName = "iframe")
    public WebElement videoIframe;






    @FindBy(xpath = "//*[contains(text(),'not been started')]")
    public WebElement lessonMessageNotStarted;

    @FindBy(xpath = "//*[text()=' E-mail is required ']")
    public WebElement emailRequiredMessage;

    @FindBy(xpath = "//*[text()=' Password is required ']")
    public WebElement passwordRequiredMessage;

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

    public WebElement getWebElement(String dcElement) {
        switch (dcElement) {
            case "previousButton":
                return this.previousButton;
            case "todayButton":
                return this.todayButton;
            case "nextButton":
                return this.nextButton;
        }
        return null;
    }

    public List<WebElement> getWebElements(String dcElement) {
        switch (dcElement) {
            case "endedLessonIcons":
                return this.endedLessonIcons;
            case "publishedLessonIcons":
                return this.publishedLessonIcons;
            case "startedLessonIcons":
                return this.startedLessonIcons;
            case "cancelledLessonIcons":
                return this.cancelledLessonIcons;
        }
        return null;
    }
}