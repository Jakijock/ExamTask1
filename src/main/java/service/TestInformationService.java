package service;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import pages.TestInformationPage;
import utils.ScreenshotMaker;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utils.Assertions.isVisible;

public class TestInformationService extends TestInformationPage {

    private ScreenshotMaker screenshotMaker = new ScreenshotMaker();

    @Step("Проверка открытия информации о задаче")
    public void isAllRequiredFieldsAreVisible(SoftAssertions softAssertion){
        isVisible(softAssertion, getBusinessProcessesButton(), "BusinessProcesses");
    }

    @Step("Перевод задачи в статус \"ЗАКРЫТО\"")
    public void completeTask() {
        getBusinessProcessesButton().click();
        getWebDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        getDoneButton().click();
        screenshotMaker.makeScreenshot();
    }

}
