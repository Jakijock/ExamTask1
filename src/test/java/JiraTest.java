import configuration.Configuration;
import hooks.Hooks;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.*;

import static org.junit.Assert.assertTrue;

@Feature("Тестирование функций джиры")
public class JiraTest extends Hooks {

    private HomePageService homePageService = new HomePageService();
    private BrowseProjectsService browseProjectsService = new BrowseProjectsService();
    private RapidBoardService rapidBoardService = new RapidBoardService();
    private SoftAssertions softAssertion = new SoftAssertions();
    private CreateTestService createTestService = new CreateTestService();
    private TestInformationService testInformationService = new TestInformationService();
    private Configuration configuration = new Configuration();

    @BeforeEach
    public void authorization() {
        AuthorizationService authorizationService = new AuthorizationService();
        authorizationService.isAllRequiredFieldsAreVisible(softAssertion);
        authorizationService.performAuthorization(configuration.getConfigurationFile("loginMy"), configuration.getConfigurationFile("passwordMy"));
        authorizationService.isSignInButtonVisible(softAssertion);
        authorizationService.pressSignInButton();
    }

    @Test
    @Story("Проверка совпадения числа задач с количеством")
    public void checkNumberOfTasks() {
        homePageService.isAllRequiredFieldsAreVisible(softAssertion);
        homePageService.openBrowseProjectsPage();
        browseProjectsService.selectProject("Test");
        rapidBoardService.openListOfTasks(softAssertion);
        Integer numberOfTasks = rapidBoardService.getNumberOfTasks();
        Integer numberOfTasksInList = rapidBoardService.getNumberOfTasksInLisy();
        assertTrue("Заявленное количество и количество задач в листе различны", numberOfTasks.equals(numberOfTasksInList));
    }

    @Test
    @Story("Проверка статуса и версии задачи TestSelenium")
    public void checkTaskTestSelenium() {
        homePageService.isAllRequiredFieldsAreVisible(softAssertion);
        homePageService.openBrowseProjectsPage();
        browseProjectsService.selectProject("Test");
        rapidBoardService.openListOfTasks(softAssertion);
        rapidBoardService.showAllTasks();
        rapidBoardService.selectTest("TestSelenium");
        String statusTest = rapidBoardService.getStatusValue(softAssertion);
        String versionTest = rapidBoardService.getVersionValue(softAssertion);
        assertTrue("Ожидался статус задачи \"В РАБОТЕ\"", statusTest.equals("В РАБОТЕ"));
        assertTrue("Ожидалась версия \"Version 2.0\"", versionTest.equals("Version 2.0"));
    }

    // ===============================      П Р О В Е Р И Т Ь       ===========================================
    @Test
    @Story("Создание новой задачи")
    public void createNewTask() {
        homePageService.isAllRequiredFieldsAreVisible(softAssertion);
        homePageService.openCreateTestPage();
        createTestService.isAllRequiredFieldsAreVisible(softAssertion);
        createTestService.performCreateTest("TestSirozh64455", "Description");
        createTestService.isAllRequiredFieldsAreVisible(softAssertion);
        createTestService.pressCreateButton();
    }

    // ===============================      П Р О В Е Р И Т Ь       ============================================
    @Test
    @Story("Изменение статуса задачи")
    public void changeStatusTaskToClosed() throws InterruptedException {
        homePageService.isAllRequiredFieldsAreVisible(softAssertion);
        homePageService.openBrowseProjectsPage();
        browseProjectsService.selectProject("Test");
        rapidBoardService.openListOfTasks(softAssertion);
        rapidBoardService.showAllTasks();
        rapidBoardService.selectTest("TestSirozh5");
        rapidBoardService.openTestInformationPage(softAssertion);
        testInformationService.isAllRequiredFieldsAreVisible(softAssertion);
        testInformationService.completeTask();
        Thread.sleep(3000);
        String statusTest = rapidBoardService.getStatusValue(softAssertion);
        assertTrue("Ожидался статус задачи \"ГОТОВО\"", statusTest.equals("ГОТОВО"));
    }
}
