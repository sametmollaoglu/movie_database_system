import java.util.ArrayList;
import java.util.Collections;

public class listFuncs {
    public static void listRates(User user) { //printing all rates of the given user
        for (int rated_film_index = 0; rated_film_index < user.rated_film_IDs.size(); rated_film_index++) {
            for (Film film : Main.allFilms) {
                if (film.ID == user.rated_film_IDs.get(rated_film_index)) {
                    Main.output_string = Main.output_string.concat(film.title + ": " + user.film_rates.get(rated_film_index)+"\n");
                }
            }
        }
        if (user.rated_film_IDs.size() == 0) {
            Main.output_string = Main.output_string.concat("There is not any ratings so far\n");
        }
    }

    public static void listSeries() { //printing all tv series
        if (Main.tvSeries_objects.size() == 0) {
            Main.output_string = Main.output_string.concat("No result\n");
        }
        for (TVSeries series : Main.tvSeries_objects) {
            Main.output_string = Main.output_string.concat(series.title + " (" + series.startDate.split("\\.")[2] + "-" + series.endDate.split("\\.")[2] + ")\n");
            Main.output_string = Main.output_string.concat(series.numberOfSeasons + " seasons and " + series.numberOfEpisodes + " episodes\n\n");
        }
    }

    public static void listAllFilmsByCountry(String country_name) { //printing all films of given country
        boolean film_not_exist = true;
        for (Film film : Main.allFilms) {
            if (film.country.equals(country_name)) {
                film_not_exist = false;
                Main.output_string = Main.output_string.concat("Film title: " + film.title+"\n");
                Main.output_string = Main.output_string.concat(film.length + " min\n");
                Main.output_string = Main.output_string.concat("Language: " + film.language + "\n\n");
            }
        }
        if (film_not_exist) {
            Main.output_string = Main.output_string.concat("No result\n\n");
        }
    }

    public static void listFFBeforeYear(int year) { //printing all movies released before the release date
        boolean not_showed = true;
        for (FeatureFilm film : Main.featureFilm_objects) {
            if (Integer.parseInt(film.releaseDate.split("\\.")[2]) < year) {
                not_showed = false;
                Main.output_string = Main.output_string.concat("Film title: " + film.title + " (" + film.releaseDate.split("\\.")[2] + ")\n");
                Main.output_string = Main.output_string.concat(film.length + " min\n");
                Main.output_string = Main.output_string.concat("Language: " + film.language + "\n\n");
            }
        }
        if (not_showed) {
            Main.output_string = Main.output_string.concat("No result\n\n");
        }
    }

    public static void listFFAfterYear(int year) { //printing all movies released after the release date
        boolean not_showed = true;
        for (FeatureFilm film : Main.featureFilm_objects) {
            if (Integer.parseInt(film.releaseDate.split("\\.")[2]) >= year) {
                not_showed = false;
                Main.output_string = Main.output_string.concat("Film title: " + film.title + " (" + film.releaseDate.split("\\.")[2] + ")\n");
                Main.output_string = Main.output_string.concat(film.length + " min\n");
                Main.output_string = Main.output_string.concat("Language: " + film.language + "\n\n");
            }
        }
        if (not_showed) {
            Main.output_string = Main.output_string.concat("No result\n\n");
        }
    }

    public static void listFFilmsByRate(ArrayList<FeatureFilm> Films) { //printing feature films based on their scores in descending order
        Collections.sort(Films); //this line is used to sort the given feature films list by rating
        Main.output_string = Main.output_string.concat("FeatureFilm:\n");
        for (FeatureFilm film : Films) {
            Main.output_string = Main.output_string.concat(film.title + " (" + film.releaseDate.split("\\.")[2] + ")");
            Main.output_string = Main.output_string.concat(" Ratings: " + rateFuncs.ratingToPrint(rateFuncs.filmRatingCalc(film)) + "/10 from " + film.number_of_votes + " users\n");
        }
        if (Films.size() == 0) {
            Main.output_string = Main.output_string.concat("No result\n");
        }
        Main.output_string = Main.output_string.concat("\n");
    }

    public static void listSFilmsByRate(ArrayList<ShortFilm> Films) { //printing short films based on their scores in descending order
        Collections.sort(Films); //this line is used to sort the given short films list by rating
        Main.output_string = Main.output_string.concat("ShortFilm:\n");
        for (ShortFilm film : Films) {
            Main.output_string = Main.output_string.concat(film.title + " (" + film.releaseDate.split("\\.")[2] + ")");
            Main.output_string = Main.output_string.concat(" Ratings: " + rateFuncs.ratingToPrint(rateFuncs.filmRatingCalc(film)) + "/10 from " + film.number_of_votes + " users\n");
        }
        if (Films.size() == 0) {
            Main.output_string = Main.output_string.concat("No result\n");
        }
        Main.output_string = Main.output_string.concat("\n");
    }

    public static void listDFilmsByRate(ArrayList<Documentary> Films) { //printing documentaries based on their scores in descending order
        Collections.sort(Films); //this line is used to sort the given documentaries list by rating
        Main.output_string = Main.output_string.concat("Documentary:\n");
        for (Documentary film : Films) {
            Main.output_string = Main.output_string.concat(film.title + " (" + film.releaseDate.split("\\.")[2] + ")");
            Main.output_string = Main.output_string.concat(" Ratings: " + rateFuncs.ratingToPrint(rateFuncs.filmRatingCalc(film)) + "/10 from " + film.number_of_votes + " users\n");
        }
        if (Films.size() == 0) {
            Main.output_string = Main.output_string.concat("No result\n");
        }
        Main.output_string = Main.output_string.concat("\n");
    }

    public static void listTVFilmsByRate(ArrayList<TVSeries> Films) { //printing TV series based on their scores in descending order
        Collections.sort(Films); //this line is used to sort the given TV Series list by rating
        Main.output_string = Main.output_string.concat("TVSeries:\n");
        for (TVSeries film : Films) {
            Main.output_string = Main.output_string.concat(film.title + " (" + film.startDate.split("\\.")[2] + "-" + film.endDate.split("\\.")[2] + ")");
            Main.output_string = Main.output_string.concat(" Ratings: " + rateFuncs.ratingToPrint(rateFuncs.filmRatingCalc(film)) + "/10 from " + film.number_of_votes + " users\n");
        }
        if (Films.size() == 0) {
            Main.output_string = Main.output_string.concat("No result\n");
        }
        Main.output_string = Main.output_string.concat("\n");
    }

    public static void listArtistsFromCountry(String country) { //listing all artists from given country
        //these boolean variables are used for check artist category is empty or not
        boolean exist1 = false; //director existing control
        boolean exist2 = false; //writer existing control
        boolean exist3 = false; //actor existing control
        boolean exist4 = false; //child actor existing control
        boolean exist5 = false; //stunt performer existing control
        Main.output_string = Main.output_string.concat("Directors:\n");
        for (Director director : Main.director_objects) {
            if (director.country.equals(country)) {
                exist1 = true;
                Main.output_string = Main.output_string.concat(director.name + " " + director.surName + " " + director.agent+"\n");
            }
        }
        if (exist1) {
            Main.output_string = Main.output_string.concat("\n");
        } else {
            Main.output_string = Main.output_string.concat("No result\n\n");
        }
        Main.output_string = Main.output_string.concat("Writers:\n");
        for (Writer writer : Main.writer_objects) {
            if (writer.country.equals(country)) {
                exist2 = true;
                Main.output_string = Main.output_string.concat(writer.name + " " + writer.surName + " " + writer.wStyle+"\n");
            }
        }
        if (exist2) {
            Main.output_string = Main.output_string.concat("\n");
        } else {
            Main.output_string = Main.output_string.concat("No result\n\n");
        }
        Main.output_string = Main.output_string.concat("Actors:\n");
        for (Actor actor : Main.actor_objects) {
            if (actor.country.equals(country)) {
                exist3 = true;
                Main.output_string = Main.output_string.concat(actor.name + " " + actor.surName + " " + actor.height + " cm\n");
            }
        }
        if (exist3) {
            Main.output_string = Main.output_string.concat("\n");
        } else {
            Main.output_string = Main.output_string.concat("No result\n\n");
        }
        Main.output_string = Main.output_string.concat("ChildActors:\n");
        for (ChildActor childActor : Main.childActor_objects) {
            if (childActor.country.equals(country)) {
                exist4 = true;
                Main.output_string = Main.output_string.concat(childActor.name + " " + childActor.surName + " " + childActor.age+"\n");
            }
        }
        if (exist4) {
            Main.output_string = Main.output_string.concat("\n");
        } else {
            Main.output_string = Main.output_string.concat("No result\n\n");
        }
        Main.output_string = Main.output_string.concat("StuntPerformers:\n");
        for (StuntPerformer stuntPerformer : Main.stuntPerformer_objects) {
            if (stuntPerformer.country.equals(country)) {
                exist5 = true;
                Main.output_string = Main.output_string.concat(stuntPerformer.name + " " + stuntPerformer.surName + " " + stuntPerformer.height + " cm\n");
            }
        }
        if (exist5) {
            Main.output_string = Main.output_string.concat("\n");
        } else {
            Main.output_string = Main.output_string.concat("No result\n\n");
        }
    }
}