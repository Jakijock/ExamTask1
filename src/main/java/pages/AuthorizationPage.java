package pages;

import elements.Button;
import elements.Input;
import elements.Label;
import org.openqa.selenium.By;

public class AuthorizationPage {

    private final Input emailInput = new Input(By.id("login-form-username"));
    private final Input passwordInput = new Input(By.id("login-form-password"));
    private final Button signInButton = new Button(By.id("login"));
    private final Label errorSingIn = new Label(By.id("usernameerror"));

    public Input getEmailInput() {
        return emailInput;
    }

    public Input getPasswordInput() {
        return passwordInput;
    }

    public Button getSignInButton() {
        return signInButton;
    }

    public Label getErrorSingIn() {
        return errorSingIn;
    }
}
