import java.util.ArrayList;

public class User extends Person {
    public ArrayList<Integer> rated_film_IDs = new ArrayList<Integer>();
    public ArrayList<Integer> film_rates = new ArrayList<Integer>();

    public User(int ID, String name, String surName, String country) {
        super(ID, name, surName, country);
    }
}
