/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package person;

/**
 *
 * @author joao
 */
public class Person {
    private int number;
    private String name;
    private String lastName;
    private String email;

    public Person(int number, String name, String lastName, String email) {
        this.number = number;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        String formattedName = lastName != null ? name + " " + lastName : name;
        return String.format("Person {number=%d, name='%s', email='%s'}", number, formattedName, email);
    }
}

