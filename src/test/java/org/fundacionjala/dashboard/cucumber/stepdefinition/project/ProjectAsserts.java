package org.fundacionjala.dashboard.cucumber.stepdefinition.project;

import java.util.Map;

import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;

import org.fundacionjala.dashboard.cucumber.stepdefinition.api.ResourcesSteps;

import static org.junit.Assert.assertEquals;

/**
 * Class to manage Step definition  for table widget of features.project.
 */
public class ProjectAsserts {

    private ResourcesSteps resources;
    private ProjectSteps projectSteps;

    public ProjectAsserts(ResourcesSteps resources, ProjectSteps projectSteps) {
        this.resources = resources;
        this.projectSteps = projectSteps;
    }

    /**
     * Method to assert the pivotal tracker features.project with the Mach2 features.project tables.
     */
    @Then("^Validate project table against pivotal project$")
    public void allInformationOfPivotalTrackerProjectsShouldBeDisplayedInProjectTableWidgetOfMach() {
        Map<String, String> tableProjectValues = projectSteps.getTableProjectValues();
        JsonPath jsonPath = resources.getResponse().jsonPath();
        assertEquals(jsonPath.get("name"), tableProjectValues.get("name"));
        assertEquals(jsonPath.get("current_iteration_number").toString(),tableProjectValues.get("current_iteration"));
        assertEquals(jsonPath.get("week_start_day"), tableProjectValues.get("week_start_day"));
    }

}
