package pages;

import elements.Button;
import elements.Collection;
import elements.Label;
import org.openqa.selenium.By;

public class RapidBoardPage {

    private final Button tasksButton = new Button(By.xpath("//span[contains(text(), 'Список задач')]/ancestor::li"));
    private final Collection<Button> tasksListButtons = new Collection<>(Button.class, By.xpath("//div[contains(text(), 'Список задач')]/ancestor::div[2]/descendant::div[@title]/span"));
    private final Collection<Button> allTasksButtons = new Collection<>(Button.class, By.xpath("//div[contains(@data-issue-key,'TEST-')]"));
    private final Label numberTasksLabel = new Label(By.xpath("//div[contains(text(), 'Список задач')]/following-sibling::div[contains(text(), 'проблем(ы)')]"));
    private final Button showAllTasksButton = new Button(By.xpath("//a[@title='Show All']"));
    private final Label versionLabel = new Label(By.xpath("//span[@id='versions-field']/span"));
    private final Label statusLabel = new Label(By.xpath("//span[@id='status-val']/span"));
    private final Button showProblemButton = new Button(By.xpath("//a[@title='Просмотреть эту проблему']"));

    public Button getTasksButton() {
        return tasksButton;
    }

    public Collection<Button> getTasksListButtons() {
        return tasksListButtons;
    }

    public Label getNumberTasksLabel() {
        return numberTasksLabel;
    }

    public Button getShowAllTasksButton() {
        return showAllTasksButton;
    }

    public Collection<Button> getAllTasksButtons() {
        return allTasksButtons;
    }

    public Label getVersionLabel() {
        return versionLabel;
    }

    public Label getStatusLabel() {
        return statusLabel;
    }

    public Button getShowProblemButton() {
        return showProblemButton;
    }
}
