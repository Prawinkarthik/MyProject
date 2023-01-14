$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/com/feature/amazon.feature");
formatter.feature({
  "line": 1,
  "name": "Amazon Application",
  "description": "",
  "id": "amazon-application",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Home page",
  "description": "",
  "id": "amazon-application;home-page",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@smoke"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user Launch the Application Url",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user Select The value from DropDown",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user Select The product In Search Field",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user Click The Search button",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefination.user_Launch_the_Application_Url()"
});
formatter.result({
  "duration": 28074513600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefination.userSelectTheValueFromDropDown()"
});
formatter.result({
  "duration": 3272493200,
  "status": "passed"
});
formatter.match({
  "location": "StepDefination.userSelectTheProductInSearchField()"
});
formatter.result({
  "duration": 1314311400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefination.user_Click_The_Search_button()"
});
formatter.result({
  "duration": 7270394000,
  "status": "passed"
});
});