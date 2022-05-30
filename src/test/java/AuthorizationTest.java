import configuration.Configuration;
import hooks.Hooks;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import service.AuthorizationService;
import static org.junit.Assert.assertTrue;

@Feature("Тестирование авторизации")
public class AuthorizationTest extends Hooks {

    private AuthorizationService authorizationService = new AuthorizationService();
    private Configuration configuration = new Configuration();

    @Test
    @Story("Авторизация с валидными данными")
    public void authorization() {
        SoftAssertions softAssertions = new SoftAssertions();
        authorizationService.isAllRequiredFieldsAreVisible(softAssertions);
        authorizationService.performAuthorization(configuration.getConfigurationFile("loginMy"), configuration.getConfigurationFile("passwordMy"));
        authorizationService.isSignInButtonVisible(softAssertions);
        authorizationService.pressSignInButton();
    }

    @Test
    @Story("Авторизация с инвалидными данными")
    public void authorizationWithInvalidValues() {
        SoftAssertions softAssertions = new SoftAssertions();
        authorizationService.isAllRequiredFieldsAreVisible(softAssertions);
        authorizationService.performAuthorization(configuration.getConfigurationFile("loginInvalid"), configuration.getConfigurationFile("passwordInvalid"));
        authorizationService.isSignInButtonVisible(softAssertions);
        authorizationService.pressSignInButton();
        assertTrue(authorizationService.isErrorVisible());
    }
}
