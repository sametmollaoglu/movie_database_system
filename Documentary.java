import java.util.ArrayList;

public class Documentary extends Film{
    public String releaseDate;

    public Documentary(int ID, String title, String language, int length, String country, ArrayList<Integer> directorIDs, ArrayList<Integer> performerIDs, String releaseDate) {
        super(ID, title, language, length, country, directorIDs, performerIDs);
        this.releaseDate = releaseDate;
    }
}
