package org.fundacionjala.dashboard.cucumber.stepdefinition.project;

<<<<<<< HEAD
import java.util.List;
import java.util.Map;

=======
>>>>>>> upstream/develop
import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.cucumber.stepdefinition.dashboard.WidgetSteps;
import org.fundacionjala.dashboard.ui.pages.content.ConfigTableProject;
import org.fundacionjala.dashboard.ui.pages.content.ProjectTableWidget;
import org.fundacionjala.dashboard.ui.pages.content.Widget;
import org.fundacionjala.dashboard.ui.pages.content.WidgetPage;
import org.fundacionjala.dashboard.ui.pages.menu.StoryServiceForm;

import java.util.Map;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class ProjectSteps {
    private WidgetSteps widgetSteps;

<<<<<<< HEAD
    private List<Map<String, String>> tableProjectValues;

=======
    public ProjectSteps (WidgetSteps widgetSteps){
        this.widgetSteps = widgetSteps;
    }
>>>>>>> upstream/develop
    /**
     * Method to Select the features.project option form the UI.
     */
    @When("^I select the Project option$")
    public void iSelectTheProjectOption() {
        final Widget type = widgetSteps.getType();
        WidgetPage widgetPage = new WidgetPage();
        StoryServiceForm storyServiceForm = widgetPage.clickWidgetType(type);
        ConfigTableProject configTableForm = storyServiceForm.clickOpenProject();
        ProjectTableWidget projectTableWidget = configTableForm.clickSaveConfigurationProject();
        tableProjectValues = projectTableWidget.getProjectTable();

    }
    public List<Map<String, String>> getTableProjectValues() {
        return tableProjectValues;
    }

}
