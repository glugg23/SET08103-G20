# USE CASE: 6 Cities Ordered by Population

## CHARACTERISTIC INFORMATION

### Goal in Context

The user needs to be able to get a list of all the cities in a given area ordered by their population, from largest to
smallest.

### Scope

The storage of this data will be abstracted away from the user.

### Level

Primary task.

### Preconditions

Connection to database is working and system is running.

### Success End Condition

Displaying to the console a list of all cities ordered by population with the following details:
city name, country city is in, district city is in and population of the city. 

### Failed End Condition

Displaying an error message if the parent region selected by the user does not exist.

### Primary Actor

Population analyst.

### Trigger

The population analyst using a CLI menu item to select that they want to get city information.

## MAIN SUCCESS SCENARIO

1. Population analyst starts program and it loads to the main menu.
2. Population analyst selects from this menu that they want to get city data.
3. A new menu loads which asks the population analyst what parent area type they want.
4. The population analyst selects from this list what parent area they want.
5. The city data list for this area is then gathered and printed to the console, and the population analyst is then
returned to the main menu.

## SUB-VARIATIONS

1. If the population analyst does not select a parent area they will be allowed to type in a parent area name.

## SCHEDULE

**DUE DATE**: 06/03/2019