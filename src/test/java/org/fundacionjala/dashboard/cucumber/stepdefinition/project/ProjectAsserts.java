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
        JsonPath jsonPath = resources.getResponse().jsonPath();

        for(Map<String,String> objectPage: tableProjectValues){
            assertEquals(jsonPath.get("name"), objectPage.get("name"));
            assertEquals(jsonPath.get("current_iteration_number").toString(),objectPage.get("current_iteration"));
            assertEquals(jsonPath.get("week_start_day"), objectPage.get("week_start_day"));
            assertEquals(jsonPath.get("initial_velocity").toString(),objectPage.get("current_velocity"));
            assertEquals(jsonPath.get("initial_velocity").toString(), objectPage.get("initial_velocity"));
            assertEquals(jsonPath.get("iteration_length").toString(), objectPage.get("iteration_length"));
            assertEquals(jsonPath.get("point_scale"), objectPage.get("point_scale"));
            assertEquals(DataTimeManager.parserDataTimeToFirstFormat(jsonPath.get("start_date").toString()),
                    objectPage.get("project_started_at"));

        }

    }
    /**
     * Method to assert the pivotal tracker features.project with the Mach2 features.project tables.
     */
    @Then("^Validate project table against pivotal project2$")
    public void allInformationOfPivotalTrackerProjectsShouldBeDisplayedInProjectTableWidgetOfMach2() {
        List<Map<String, String>> tableProjectValues = projectSteps.getTableProjectValues();
        List<Response> responseList = resources.getResponseList();
        JsonPath jsonPath = resources.getResponse().jsonPath();

        for(int i=0;i<responseList.size();i++){
            assertEquals(responseList.get(i).jsonPath().get("name"), tableProjectValues.get(i).get("name"));
            assertEquals(responseList.get(i).jsonPath().get("current_iteration_number").toString(),tableProjectValues.get(i).get("current_iteration"));
            assertEquals(responseList.get(i).jsonPath().get("week_start_day"), tableProjectValues.get(i).get("week_start_day"));
            assertEquals(responseList.get(i).jsonPath().get("initial_velocity").toString(),tableProjectValues.get(i).get("current_velocity"));
            assertEquals(responseList.get(i).jsonPath().get("initial_velocity").toString(), tableProjectValues.get(i).get("initial_velocity"));
            assertEquals(responseList.get(i).jsonPath().get("iteration_length").toString(), tableProjectValues.get(i).get("iteration_length"));
            assertEquals(responseList.get(i).jsonPath().get("point_scale"), tableProjectValues.get(i).get("point_scale"));
            assertEquals(DataTimeManager.parserDataTimeToFirstFormat(responseList.get(i).jsonPath().get("start_date").toString()),
                    tableProjectValues.get(i).get("project_started_at"));

        }

    }
}
