# USE CASE: 5 Top N Populated Countries

## CHARACTERISTIC INFORMATION

### Goal in Context

Return the top N populated countries in the world, continent and region where N is provided by the user.

### Scope

Component.

### Level

User goal.

### Preconditions

System instantiation and intra-connections being successful. User provides number of results to return, N, where N is no greater
than the total number of countries.

### Success End Condition

Displaying a list of top N populated countries in a console window.

### Failed End Condition

Displaying of an error message to why the use case has failed.

### Primary Actor

Population analyst

### Trigger

The analyst selecting an option to display language results via the command line interface

## MAIN SUCCESS SCENARIO

1. Analyst starts the program and prompted with welcome message
2. A menu is displayed with various sub-menus to select
3. Analyst selects the menu option to return the top N populated countries
4. The analyst provides N for the number of results to return (Max: number of countries)
5. A list of top N populated countries is displayed

## EXTENSIONS

Once a report has been generated, the analyst will be returned to the original menu.

## SUB-VARIATIONS

The user may opt to return the top N populated cities or capital cities.

## SCHEDULE

As this a user goal we will aim to complete the implementation by week 8.