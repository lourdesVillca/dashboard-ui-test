#Feature: Story Item Test
#
#  Background: create a project
#    When I send a POST request to /projects
#      | name | Project_Mach |
#    Then I expect the status code 200
#    And I store as Project
#    When I send a POST request to /projects/[Project1.id]/stories
#      | name          | Story_Mach |
#      | current_state | started    |
#      | estimate      | 1          |
#      | story_type    | feature    |
#      | owner_ids     | 2140339    |
#    Then I expect the status code 200
#    And I store as Story1
#
##  Scenario: Validate the stories from pivotal tracker are displayed when add a table widget for “Story”
##    Given I add a table widget in the board
##    When I select Story Items option
##    And I select Project option
##    Then All information of Pivotal Tracker stories should be displayed in story table widget of Mach2