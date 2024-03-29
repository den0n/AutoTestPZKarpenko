package TestOne;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    private WebDriver driver;

    public void screenshot(WebDriver driver, String nameScreen) throws IOException, InterruptedException {
        this.driver = driver;
        Thread.sleep(1500);
        // создаем объект класса TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        // делаем скриншот текущего экрана
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        // указываем путь к файлу, в который нужно сохранить скриншот
        String filePath = "C:\\src\\tss\\work_2\\screenshot" + nameScreen;
        // копируем скриншот в указанный файл
        FileUtils.copyFile(srcFile, new File(filePath));

    }
}
