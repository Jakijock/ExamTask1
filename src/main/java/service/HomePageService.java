package service;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import pages.HomePage;
import utils.ScreenshotMaker;

import java.util.concurrent.TimeUnit;

import static utils.Assertions.isVisible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePageService extends HomePage {

    private ScreenshotMaker screenshotMaker = new ScreenshotMaker();

    @Step("Открытие страницы с проектами")
    public void openBrowseProjectsPage() {
        getProjectButton().click();
        getViewAllButton().click();
    }

    @Step("Проверка открытия домашней страницы")
    public void isAllRequiredFieldsAreVisible(SoftAssertions softAssertion){
        isVisible(softAssertion, getProjectButton(), "Project");
        isVisible(softAssertion, getViewAllButton(), "ViewAll");
        isVisible(softAssertion, getCreateTestButton(), "Create");
        getGreetingJiraLabel().isVisible();
    }

    @Step("Открытие страницы создания задачи")
    public void openCreateTestPage() {
        getCreateTestButton().click();
    }

    @Step("Проверка открытия домашней страницы")
    public boolean isHomePageOpen() {
        getWebDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        screenshotMaker.makeScreenshot();
        return getProjectButton().isVisible();
    }
}
