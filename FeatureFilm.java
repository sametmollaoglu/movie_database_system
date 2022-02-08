import java.util.ArrayList;

public class FeatureFilm extends Film {
    public String releaseDate;
    public int budget;
    public ArrayList<Integer> writerIDs;
    public ArrayList<String> genres;

    public FeatureFilm(int ID, String title, String language, ArrayList<Integer> directorIDs, int length, String country, ArrayList<Integer> performerIDs, ArrayList<String> genres, String releaseDate, ArrayList<Integer> writerIDs, int budget) {
        super(ID, title, language, length, country, directorIDs, performerIDs);
        this.releaseDate = releaseDate;
        this.budget = budget;
        this.writerIDs = writerIDs;
        this.genres = genres;
    }
}
