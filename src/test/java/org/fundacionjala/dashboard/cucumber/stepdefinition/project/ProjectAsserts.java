package org.fundacionjala.dashboard.cucumber.stepdefinition.project;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.fundacionjala.dashboard.cucumber.stepdefinition.api.ResourcesSteps;
import org.fundacionjala.dashboard.utils.DataTimeManager;

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
        List<Map<String, String>> tableProjectValues = projectSteps.getTableProjectValues();
        List<Response> responseList = resources.getResponseList();

        for (int i = 0; i < responseList.size(); i++) {
            JsonPath jsonPath = responseList.get(i).jsonPath();
            Map<String, String> row = tableProjectValues.get(i);
            assertEquals(jsonPath.get("name"), row.get("name"));
            assertEquals(jsonPath.get("current_iteration_number").toString(), row.get("current_iteration"));
            assertEquals(jsonPath.get("week_start_day"), row.get("week_start_day"));
            assertEquals(jsonPath.get("initial_velocity").toString(), row.get("current_velocity"));
            assertEquals(jsonPath.get("initial_velocity").toString(), row.get("initial_velocity"));
            assertEquals(jsonPath.get("iteration_length").toString(), row.get("iteration_length"));
            assertEquals(jsonPath.get("point_scale"), row.get("point_scale"));
            assertEquals(DataTimeManager.parserDataTimeToFirstFormat(jsonPath.get("start_date").toString()),
                    row.get("project_started_at"));
        }
    }

}
