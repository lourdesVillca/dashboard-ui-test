Feature: Project widget

  Background: Create project and synchronaze Mach2
    Given I send a POST request to /projects
      | name                              | AT01 project-01 |
      | iteration_length                  | 1               |
      | week_start_day                    | Monday          |
      | point_scale                       | 0,1,2,3         |
      | start_date                        | 2016-08-29      |
      | number_of_done_iterations_to_show | 12              |
      | initial_velocity                  | 10              |
    And I expect the status code 200
    And Synchronize Mach2 and Pivotal

  @deleteAllProjects
  Scenario: Validate All information from the "current service" are displayed in Mach2 table widget
    When I add a table widget in the default board
    And I select the Project option
    Then Validate project table against pivotal project

