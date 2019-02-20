# USE CASE: 3 Population Information

## CHARACTERISTIC INFORMATION

### Goal in Context

The user must be able to retrieve the total population of the world, any continent, any region, any country, 
any district and any city.

### Scope

The storage of this data will be abstracted away from the user.

### Level

User goal.

### Preconditions

Connection to database is working and system is running.

### Success End Condition

Displaying to the console the name of the selected area, its total population, the percentage of people living in 
cities and the percentage of people not living in cities. The percentage totals are only valid if the selected area
is a continent, region or country.

### Failed End Condition

Displaying an error message, either that the connection failed or that the selected area does not exist.

### Primary Actor

Statistician.

### Trigger

The statistician using a CLI menu item to select that they want to get population information.

## MAIN SUCCESS SCENARIO

1. Statistician starts program and it loads to the main menu.
2. Statistician selects from this menu that they want to get population data.
3. A new menu loads which allows the statistician to select which area type they want to get the data for.
4. A new menu loads which asks the statistician what parent area their selected area would be under.
5. A list of areas in that parent area is generated and printed to the console to allow the statistician to select their
area from this list.
6. The population data for this area is then gathered and printed to the console, and the statistician is then returned
to the main menu.

## SUB-VARIATIONS

1. If the statistician does not select a parent area they will be allowed to manually enter an area name.

## SCHEDULE

**DUE DATE**: 27/02/2019