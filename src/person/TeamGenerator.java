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
 *this java class get dates of the list of 100 person from  a file to create 20 teams
 * each team has 5 members
 * @author joao
 */



public class TeamGenerator {

    public static void main(String[] args) {
        List<Person> people = FileReader.loadPeopleFromFile("MOCK_DATA.csv"); // read a file.csv

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
        
        Collections.shuffle(people); // Shuffle the list of people

        Map<String, List<Person>> teams = new HashMap<>(); // Array list of 20 countries as a list of team
        List<String> countryNames = Arrays.asList(
            "Brazil", "Ireland", "USA", "Germany", "Spain",
            "France", "Italy", "Japan", "Canada", "Australia",
            "China", "India", "Mexico", "Argentina", "Russia",
            "South Africa", "Egypt", "Sweden", "Netherlands", "United Kingdom"
        );

        for (String countryName : countryNames) {
            List<Person> teamMembers = new ArrayList<>(people.subList(0, 5)); // Pick the first 5 people as team members
            people.subList(0, 5).clear(); // Remove these people from the main list

            // Store the team in the map
            teams.put(countryName, teamMembers);
        }

        return teams;
    }
}
