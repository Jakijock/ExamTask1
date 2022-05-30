package pages;

import elements.Button;
import elements.Collection;
import org.openqa.selenium.By;

public class BrowseProjectsPage {

    private final Collection<Button> projectsCollection = new Collection(Button.class, By.xpath("//tbody/tr/td/a"));

    public Collection<Button> getProjectsCollection() {
        return projectsCollection;
    }

}
