package org.fundacionjala.dashboard.cucumber.stepdefinition.story;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.dashboard.cucumber.stepdefinition.api.ResourcesSteps;
import org.fundacionjala.dashboard.ui.pages.content.StoryItemPage;
import org.fundacionjala.dashboard.ui.pages.content.StoryItemTable;
import org.fundacionjala.dashboard.ui.pages.content.WidgetPage;
import org.fundacionjala.dashboard.ui.pages.menu.StoryServiceForm;

import java.util.Map;

import static org.fundacionjala.dashboard.ui.pages.content.Widget.TABLE;
import static org.junit.Assert.assertEquals;

/**
 * Created by juanarodriguez on 9/23/2016.
 */
public class StorySteps {
    private ResourcesSteps resources;
    private WidgetPage widgetPage;
    private Map<String, String> tableStoryValues;
    private StoryServiceForm storyServiceForm;

    /**
     * Method to Select the Story Items option form the UI.
     */
    @When("^I select Story Items option$")
    public void iSelectTheProjectOption() {
        storyServiceForm = widgetPage.clickWidgetType(TABLE);
        StoryItemPage storyItemPage = storyServiceForm.clickOpenStoryItem();
        StoryItemTable storyItemTable = storyItemPage.clickSaveConfigurationStoryItem();
        tableStoryValues = storyItemTable.getStoryTable();
    }

    /**
     * Method to assert the pivotal tracker stories with the Mach2 stories tables.
     */
    @Then("^All information of Pivotal Tracker stories should be displayed in story table widget of Mach2$")
    public void allInformationOfPivotalTrackerprojectsShouldBeDisplayedInProjectTableWidgetOfMach() {
        assertEquals(tableStoryValues.get("name"), resources.getResponse().jsonPath().get("name"));
        assertEquals(tableStoryValues.get("current_state"),
                resources.getResponse().jsonPath().get("current_state"));
        assertEquals(tableStoryValues.get("estimate"),
                resources.getResponse().jsonPath().get("estimate"));
        assertEquals(tableStoryValues.get("story_type"),
                resources.getResponse().jsonPath().get("story_type"));
    }
}
