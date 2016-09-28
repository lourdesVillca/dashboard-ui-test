#Feature: Project widget - Table
#
#  Background: test
#    Given I send a POST request with list to /projects
#      | name           | iteration_length | week_start_day | point_scale | start_date | number_of_done_iterations_to_show | initial_velocity |
#      | AT01 project01 | 1                | Monday         | 0,1,2,3     | 2016-08-29 | 12                                | 10               |
#      | AT01 project02 | 1                | Monday         | 0,1,2,3,5,8 | 2016-09-05 | 12                                | 10               |
#
#    And I expect the status code 200
#    And Synchronize Mach2 and Pivotal
#
#  @deleteAllProjects
#  Scenario: T644 - Verify that ALL Projects from PT are displayed when adding the TABLE widget
#    When I add a table widget in the default board2
#    And I select the Project option
#    Then Validate project table widget display all projects from pivotal tracker