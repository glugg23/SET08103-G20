# USE CASE: 1 Habitat Populations

## CHARACTERISTIC INFORMATION

### Goal in Context

Operating the system to return the combined population of any cities, districts, counties, regions,
continents and the entire world under a constraint with any relevant metadata.

### Scope

The storage mechanisms of these habitats are abstracted from the analyst.

### Level

High level summary.

### Preconditions

System instantiation and intra-connections being successful. 

### Success End Condition

Displaying onscreen the correct population total of the specified areas with constraint criteria applied, and 
any metadata calculation being taken place (e.g. % of population in a country that live in a city).

### Failed End Condition

Displaying an error message onscreen and closing any connections and instances of the system.

### Primary Actor

Population analyst.

### Trigger

The analyst interacting with CLI submenus that will lead to a generated report.

## MAIN SUCCESS SCENARIO

1. Analyst starts program and successful start message is displayed.
2. Menu displays numbered options of area types. Analyst selects child areas
by typing number that correlates to aforementioned area.
3. New numbered menu displays possible parent areas, and Analyst selects 
a valid parent area (or none at all for a specific singular area).
4. New menu if parent chosen with constraints for sorting, biggest population in a range of N, display those living in
cities and those that are not (option displayed if city is a child area). If no parent the constraint is area name.
5. Query compiled and population report displayed onscreen.

## EXTENSIONS

Once a report is generated the analyst can restart the process to the first menu.

## SUB-VARIATIONS

1. On the first menu the analyst will also have the option to select a language speaker count.
2. Once selected the report will display the number of speakers for Chinese,
Arabic, English, Hindi and Spanish; ordered greatest to smallest and percentage
of world population.

## SCHEDULE

As this is a high level summary this should be met by Week 12 with possible further extension Week 15 with any finalisations.