/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static List<Person> loadPeopleFromFile(String filename) {
        List<Person> people = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int number = Integer.parseInt(parts[0]);
                String name = parts[1];
                String lastName = parts[2];
                String email = parts[3];

                people.add(new Person(number, name, lastName, email));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return people;
    }
}
