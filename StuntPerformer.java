import java.util.ArrayList;

public class StuntPerformer extends Performer {
    public int height;
    public ArrayList<Integer> actorIDs;

    public StuntPerformer(int ID, String name, String surName, String country, int height, ArrayList<Integer> actorIDs) {
        super(ID, name, surName, country);
        this.height = height;
        this.actorIDs = actorIDs;
    }
}
