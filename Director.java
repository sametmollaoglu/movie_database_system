public class Director extends Artist {
    public String agent;

    public Director(int ID, String name, String surName, String country, String agent) {
        super(ID, name, surName, country);
        this.agent = agent;
    }
}
