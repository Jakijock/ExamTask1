package utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ScreenshotMaker {
    public void makeScreenshot() {
        try {
            File screenshot = Screenshots.takeScreenShotAsFile();
            InputStream targetStream = new FileInputStream(screenshot);
            Allure.addAttachment("Screenshot", "image/png", targetStream, "png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
