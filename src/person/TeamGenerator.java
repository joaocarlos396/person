/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author joao
 */



public class TeamGenerator {

    public static void main(String[] args) {
        List<Person> people = FileReader.loadPeopleFromFile("MOCK_DATA.csv");

        Map<String, List<Person>> teams = generateTeams(people);

        // Print each team to the console
        for (Map.Entry<String, List<Person>> entry : teams.entrySet()) {
            System.out.println("Team: " + entry.getKey());
            System.out.println("Members: ");
            for (Person person : entry.getValue()) {
                System.out.println(person);
            }
            System.out.println();
        }
    }

    private static Map<String, List<Person>> generateTeams(List<Person> people) {
        // Shuffle the list of people
        Collections.shuffle(people);

        Map<String, List<Person>> teams = new HashMap<>();
        List<String> countryNames = Arrays.asList(
            "Brazil", "Ireland", "USA", "Germany", "Spain",
            "France", "Italy", "Japan", "Canada", "Australia",
            "China", "India", "Mexico", "Argentina", "Russia",
            "South Africa", "Egypt", "Sweden", "Netherlands", "United Kingdom"
        );

        for (String countryName : countryNames) {
            // Pick the first 5 people as team members
            List<Person> teamMembers = new ArrayList<>(people.subList(0, 5));
            people.subList(0, 5).clear(); // Remove these people from the main list

            // Store the team in the map
            teams.put(countryName, teamMembers);
        }

        return teams;
    }
}
