package TestOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    public LogInPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "css-8fr21b-MuiTypography-root")
    private WebElement regButton;

    @FindBy(className = "MuiButton-fullWidth")
    private WebElement logInButton;

    @FindBy(id = ":r1:")
    private WebElement emailField;
    @FindBy(id = ":r3:")
    private WebElement passwordField;

    public void redirectRegPage(){
        regButton.click();
    }

    public void logInUser(String email,String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        logInButton.click();
    }
}
