package org.fundacionjala.dashboard.cucumber.stepdefinition.dashboard;

import cucumber.api.java.en.When;

import org.fundacionjala.dashboard.ui.pages.content.BoardPage;
import org.fundacionjala.dashboard.ui.pages.content.Widget;
import org.fundacionjala.dashboard.ui.pages.content.WidgetPage;
import org.fundacionjala.dashboard.ui.pages.menu.TopMenu;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class WidgetSteps {
    private Widget type;

    /**
     * Method to add a widget for a features.project.
     */
    @When("^I add a (table|info|list) widget in the board$")
    public void iAddATableWidgetInTheBoard(String type) {
        this.type = Widget.valueOf(type.toUpperCase());
        TopMenu topMenu = new TopMenu();
        BoardPage boardPage = topMenu.clickAddBoardMenu();
        WidgetPage widgetPage = boardPage.clickAddWidgetMenu();
    }

    /**
     * Obtain Widget type.
     * @return Widget type.
     */
    public Widget getType(){
        return type;
    }
}
