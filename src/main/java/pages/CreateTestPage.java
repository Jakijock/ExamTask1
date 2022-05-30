package pages;

import elements.Button;
import elements.Input;
import org.openqa.selenium.By;

public class CreateTestPage {

    private final Input summaryInput = new Input(By.xpath("//input[@id='summary']"));
    private final Button descriptionIframeButton = new Button(By.xpath("//div[@id='description-wiki-edit']/descendant::iframe"));
    private final Input descriptionInpute = new Input(By.xpath("html/body"));
    private final Button createButton = new Button(By.xpath("//input[contains(@value, 'Создать')]"));

    public Input getSummaryInput() {
        return summaryInput;
    }

    public Button getDescriptionIframeButton() {
        return descriptionIframeButton;
    }

    public Button getCreateButton() {
        return createButton;
    }

    public Input getDescriptionInpute() {
        return descriptionInpute;
    }
}
