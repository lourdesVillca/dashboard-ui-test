package org.fundacionjala.dashboard.ui.pages.content;

import org.fundacionjala.dashboard.ui.pages.AbstractBasePage;
import org.fundacionjala.dashboard.ui.pages.menu.StoryServiceForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This is WidgetPage class.
 */
public class WidgetPage extends AbstractBasePage {

    /**
     * This method get a Story service form.
     *
     * @param type Widget type for example table, info, list.
     * @return StoryServiceForm.
     */
    public StoryServiceForm clickWidgetType(final Widget type) {
        WebElement specificWidget = driver.findElement(By.cssSelector("div.circular i." + type + "-type"));
        specificWidget.click();
        return new StoryServiceForm();
    }
}
