package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;

public class HomePage {

    private final Button projectButton = new Button(By.xpath("//a[@id='browse_link']"));
    private final Button viewAllButton = new Button(By.xpath("//li[@id='project_view_all_link']"));
    private final Button createTestButton = new Button(By.xpath("//a[@id='create_link']"));
    private final Label greetingJiraLabel = new Label(By.xpath("//h3[contains(text(), 'Добро пожаловать в Jira')]"));

    public Button getProjectButton() {
        return projectButton;
    }

    public Button getViewAllButton() {
        return viewAllButton;
    }

    public Button getCreateTestButton() {
        return createTestButton;
    }

    public Label getGreetingJiraLabel() {
        return greetingJiraLabel;
    }
}
