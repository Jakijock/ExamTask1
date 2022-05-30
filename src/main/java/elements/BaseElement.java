package elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BaseElement {
    private final SelenideElement wrappedElement;

    public BaseElement(By by) {
        this.wrappedElement = $(by);
    }

    public BaseElement(SelenideElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    protected SelenideElement getWrappedElement() {
        return wrappedElement;
    }

    public boolean isVisible(){
        return getWrappedElement().isDisplayed();
    }
}

