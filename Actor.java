public class Actor extends Performer {
    public int height;

    public Actor(int ID, String name, String surName, String country, int height) {
        super(ID, name, surName, country);
        this.height = height;
    }
}
