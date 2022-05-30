package service;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import pages.HomePage;

import static utils.Assertions.isVisible;

public class HomePageService extends HomePage {

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
}
