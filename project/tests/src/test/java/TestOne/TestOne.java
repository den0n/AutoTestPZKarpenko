package TestOne;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestOne {
    WebDriver driver;
    RegPage regPage;
    LogInPage logInPage;
    Screenshot screenshot;
    private String work = "http://localhost:3000";

    @BeforeClass
    public void initDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void RegistrationUser(){
        String name = "Poroh", surname = "Petro", location = "Ukraine",
                occupat = "Chokoladniy King", picrure = "C:\\src\\tss\\work_folder\\src\\main\\resources\\poroh.png";
        String email = "Test12@gmail.com", password = "123456AA";
        driver.get(work);
        logInPage = new LogInPage(driver);
        logInPage.redirectRegPage();
        regPage = new RegPage(driver);
        regPage.RegisterUser(name,surname,location,occupat,email,password,picrure);


    }

    @Test
    public void LogInUser() throws IOException, InterruptedException {
        String email = "Test12@gmail.com", password = "123456AA";
        String screenshotName = "MainPage";
        driver.get(work);
        logInPage = new LogInPage(driver);
        logInPage.logInUser(email,password);
        screenshot = new Screenshot();
        screenshot.screenshot(driver, screenshotName);
    }

    @AfterClass
    public void endTest(){
        // закрытие браузера
        //driver.quit();
    }
}
