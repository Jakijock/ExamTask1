package service;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CreateTestPage;
import utils.ScreenshotMaker;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utils.Assertions.isVisible;

public class CreateTestService extends CreateTestPage {

    private ScreenshotMaker screenshotMaker = new ScreenshotMaker();

    @Step("Создание задачи с названием = {summary}, описанием = {description}")
    public void performCreateTest(
            String summary,
            String description
    ) {
        getSummaryInput().clearAndType(summary);
        getWebDriver().switchTo().frame((WebElement) getWebDriver().findElement(By.xpath("//div[@id='description-wiki-edit']/descendant::iframe")));
        getDescriptionInpute().clearAndType(description);
        getWebDriver().switchTo().defaultContent();
        screenshotMaker.makeScreenshot();
    }

    @Step("Нажатие кнопки \"Создать\"")
    public void pressCreateButton() {
        getCreateButton().click();
    }

    @Step("Проверка видимости полей с названием и описанием")
    public void isAllRequiredFieldsAreVisible(SoftAssertions softAssertion){
        isVisible(softAssertion, getSummaryInput(), "Summary");
        isVisible(softAssertion, getDescriptionIframeButton(), "Description");
    }
}
