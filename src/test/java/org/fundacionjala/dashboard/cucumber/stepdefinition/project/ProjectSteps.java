package org.fundacionjala.dashboard.cucumber.stepdefinition.project;

import java.util.Map;

import cucumber.api.java.en.When;

import org.fundacionjala.dashboard.ui.pages.content.ConfigTableProject;
import org.fundacionjala.dashboard.ui.pages.content.ProjectTableWidget;
import org.fundacionjala.dashboard.ui.pages.content.WidgetPage;
import org.fundacionjala.dashboard.ui.pages.menu.StoryServiceForm;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class ProjectSteps {

    private Map<String, String> tableProjectValues;

    /**
     * Method to Select the features.project option form the UI.
     */
    @When("^I select the Project option$")
    public void iSelectTheProjectOption() {
        WidgetPage widgetPage = new WidgetPage();
        StoryServiceForm storyServiceForm = widgetPage.clickTableWidgetType();
        ConfigTableProject configTableForm = storyServiceForm.clickOpenProject();
        ProjectTableWidget projectTableWidget = configTableForm.clickSaveConfigurationProject();
        tableProjectValues = projectTableWidget.getProjectTable();

    }
    public Map<String, String> getTableProjectValues() {
        return tableProjectValues;
    }

}
