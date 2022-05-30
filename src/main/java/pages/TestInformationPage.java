package pages;

import elements.Button;
import org.openqa.selenium.By;

public class TestInformationPage {

    private final Button businessProcessesButton = new Button(By.xpath("//span[contains(text(), 'Бизнес-процесс')]"));
    private final Button doneButton = new Button(By.xpath("//span[contains(text(), 'Выполнено')]/parent::a"));

    public Button getBusinessProcessesButton() {
        return businessProcessesButton;
    }

    public Button getDoneButton() {
        return doneButton;
    }
}
