public class ChildActor extends Performer {
    public int age;

    public ChildActor(int ID, String name, String surName, String country, int age) {
        super(ID, name, surName, country);
        this.age = age;
    }
}
