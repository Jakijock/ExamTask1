package service;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import pages.TestInformationPage;
import utils.ScreenshotMaker;

import static com.codeborne.selenide.Selenide.$x;
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
        getDoneButton().click();
        $x("//span[contains(text(), 'Выполнено')]/parent::a").waitUntil(Condition.visible, 20000);
        screenshotMaker.makeScreenshot();
    }

}
