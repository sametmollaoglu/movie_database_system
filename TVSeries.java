import java.util.ArrayList;

public class TVSeries extends Film{
    public String startDate;
    public String endDate;
    public int numberOfSeasons;
    public int numberOfEpisodes;
    public ArrayList<Integer> writerIDs;
    public ArrayList<String> genres;

    public TVSeries(int ID, String title, String language, int length, String country, ArrayList<Integer> directorIDs, ArrayList<Integer> performerIDs, String startDate, String endDate, int numberOfSeasons, int numberOfEpisodes, ArrayList<Integer> writerIDs, ArrayList<String> genres) {
        super(ID, title, language, length, country, directorIDs, performerIDs);
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfSeasons = numberOfSeasons;
        this.numberOfEpisodes = numberOfEpisodes;
        this.writerIDs = writerIDs;
        this.genres = genres;
    }
}
