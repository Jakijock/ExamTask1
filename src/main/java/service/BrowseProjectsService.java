package service;

import io.qameta.allure.Step;
import pages.BrowseProjectsPage;
import utils.ScreenshotMaker;

import static com.codeborne.selenide.Condition.text;

public class BrowseProjectsService extends BrowseProjectsPage {

    private ScreenshotMaker screenshotMaker = new ScreenshotMaker();

    @Step("Выбор проекта {projectName}")
    public void selectProject(String projectName){
        getProjectsCollection().filterBy(text(projectName)).first().click();
        screenshotMaker.makeScreenshot();
    }

}
