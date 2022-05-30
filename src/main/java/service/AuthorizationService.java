package service;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import pages.AuthorizationPage;
import utils.ScreenshotMaker;

import static utils.Assertions.isVisible;

public class AuthorizationService extends AuthorizationPage {

    private ScreenshotMaker screenshotMaker = new ScreenshotMaker();

    @Step("Авторизация пользователя с логином = {email}, паролем = {password}")
    public void performAuthorization(
            String email,
            String password
    ) {
        getEmailInput().clearAndType(email);
        getPasswordInput().clearAndType(password);
        screenshotMaker.makeScreenshot();
    }

    @Step("Нажатие кнопки \"Войти\"")
    public void pressSignInButton() {
        getSignInButton().click();
    }

    @Step("Проверка видимости полей ввода пароля и e-mail")
    public void isAllRequiredFieldsAreVisible(SoftAssertions softAssertion) {
        isVisible(softAssertion, getEmailInput(), "Email");
        isVisible(softAssertion, getPasswordInput(), "Password");
    }

    @Step("Проверка видимости кнопки \"Войти\"")
    public void isSignInButtonVisible(SoftAssertions softAssertion) {
        isVisible(softAssertion, getSignInButton(), "Enter");
    }

    @Step("Проверка видимости ошибки некорректного ввода почты и пароля")
    public boolean isErrorVisible() {
        screenshotMaker.makeScreenshot();
        return getErrorSingIn().isVisible();
    }

}

