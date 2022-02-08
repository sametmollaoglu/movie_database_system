import java.util.ArrayList;

public class Film implements Comparable<Film> {
    public double rating;
    public int number_of_votes;
    public int ID;
    public String title;
    public String language;
    public int length;
    public String country;
    public ArrayList<Integer> directorIDs;
    public ArrayList<Integer> performerIDs;

    public Film(int ID, String title, String language, int length, String country, ArrayList<Integer> directorIDs, ArrayList<Integer> performerIDs) {
        this.ID = ID;
        this.title = title;
        this.language = language;
        this.length = length;
        this.country = country;
        this.directorIDs = directorIDs;
        this.performerIDs = performerIDs;
        this.number_of_votes = 0;
        this.rating = 0;
    }

    //this function is used to ordering film arraylist by rating points
    @Override
    public int compareTo(Film o) {
        return Double.compare(o.rating, rating);
    }

}
