package elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class Label extends BaseElement{

    public Label(By by) {
        super(by);
    }

    public Label(SelenideElement wrappedElement) {
        super(wrappedElement);
    }

    public boolean isDisplayed() {
        return this.getWrappedElement()
                .waitUntil(Condition.visible, 20000)
                .isDisplayed();
    }

    public String getText() {
        return this.getWrappedElement()
                .text();
    }
}