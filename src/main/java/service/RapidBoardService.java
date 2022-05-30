package service;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import pages.RapidBoardPage;
import utils.ScreenshotMaker;

import static com.codeborne.selenide.Condition.text;
import static utils.Assertions.isVisible;

public class RapidBoardService extends RapidBoardPage {

    private ScreenshotMaker screenshotMaker = new ScreenshotMaker();

    @Step("Открытие списка задач")
    public void openListOfTasks(SoftAssertions softAssertion){
        isVisible(softAssertion, getTasksButton(), "Tasks");
        getTasksButton().click();
        screenshotMaker.makeScreenshot();
    }

    @Step("Получение цифры с количеством задач")
    public Integer getNumberOfTasks(){
        getNumberTasksLabel().isDisplayed();
        String numberString = getNumberTasksLabel().getText();
        Integer number = Integer.valueOf(numberString.split(" ")[0]);
        return number;
    }

    @Step("Получение количества задач из списка")
    public Integer getNumberOfTasksInLisy(){
        getTasksListButtons().getModel(0).isVisible();
        getShowAllTasksButton().click();
        Integer number = getTasksListButtons().size();;
        return number;
    }

    @Step("Выбор задачи {testName}")
    public void selectTest(String testName) {
        getAllTasksButtons().filterBy(text(testName)).first().click();
        screenshotMaker.makeScreenshot();
    }

    @Step("Получение статуса задачи")
    public String getStatusValue(SoftAssertions softAssertion){
        isVisible(softAssertion, getStatusLabel(), "Email");
        return getStatusLabel().getText();
    }

    @Step("Получение версии задачи")
    public String getVersionValue(SoftAssertions softAssertion){
        isVisible(softAssertion, getVersionLabel(), "Email");
        return getVersionLabel().getText();
    }

    @Step("Открытие страницы с информацией о проекте")
    public void openTestInformationPage(SoftAssertions softAssertion) {
        isVisible(softAssertion, getShowProblemButton(), "ShowProblem");
        getShowProblemButton().click();
        screenshotMaker.makeScreenshot();
    }

    @Step("Нажатие кнопки просмотра всех задач")
    public void showAllTasks() {
        getShowAllTasksButton().click();
    }
}
