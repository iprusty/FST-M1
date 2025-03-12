@activity6
Feature: To test input with Datatables

@TasksDataTable
Scenario: Adding iteams to a To-Do list
  Given user is on the To-Do list page
  When user adds the following tasks
    | task1 |
    | task2 |
    | task3 |
  Then they can see the task added to the list
  