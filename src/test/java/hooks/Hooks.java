package hooks;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Hooks extends configuration.Configuration {

    @BeforeEach
    public void openBrowser() {
        Configuration.startMaximized = true;
        open(getConfigurationFile("jiraUrl"));
    }

    @AfterEach
    public void closeDriver() {
        closeWebDriver();
    }
}
