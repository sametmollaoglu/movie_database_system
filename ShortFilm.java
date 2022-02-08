import java.util.ArrayList;

public class ShortFilm extends Film {
    public String releaseDate;
    public ArrayList<Integer> writerIDs;
    public ArrayList<String> genres;

    public ShortFilm(int ID, String title, String language, ArrayList<Integer> directorIDs, int length, String country, ArrayList<Integer> performerIDs, ArrayList<String> genres, String releaseDate, ArrayList<Integer> writerIDs) {
        super(ID, title, language, length, country, directorIDs, performerIDs);
        this.releaseDate = releaseDate;
        this.writerIDs = writerIDs;
        this.genres = genres;
    }
}
