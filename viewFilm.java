public class viewFilm {
    public static boolean View(FeatureFilm viewFFilm) {//viewfilm command printing to feature films
        Main.output_string = Main.output_string.concat(viewFFilm.title + " (" + viewFFilm.releaseDate.split("\\.")[2] + ")\n");
        Main.output_string = Main.output_string.concat(viewFFilm.genres.toString().replace("[", "").replace("]", "")+"\n");
        Main.output_string = Main.output_string.concat("Writers: ");
        for (int y = 0; y < viewFFilm.writerIDs.size(); y++) {
            for (Writer writer : Main.writer_objects) {
                if (writer.ID == viewFFilm.writerIDs.get(y)) {
                    Main.output_string = Main.output_string.concat(writer.name + " " + writer.surName);
                    Main.output_string = Main.output_string.concat(((y == viewFFilm.writerIDs.size() - 1) ? "\n" : ", "));
                }
            }
        }
        viewDirectors(viewFFilm);
        viewStars(viewFFilm);
        viewRating(viewFFilm);
        return true;
    }

    public static boolean View(ShortFilm viewSFilm) {//viewfilm command printing to short films
        Main.output_string = Main.output_string.concat(viewSFilm.title + " (" + viewSFilm.releaseDate.split("\\.")[2] + ")\n");
        Main.output_string = Main.output_string.concat(viewSFilm.genres.toString().replace("[", "").replace("]", "")+"\n");
        Main.output_string = Main.output_string.concat("Writers: ");
        for (int y = 0; y < viewSFilm.writerIDs.size(); y++) {
            for (Writer writer : Main.writer_objects) {
                if (writer.ID == viewSFilm.writerIDs.get(y)) {
                    Main.output_string = Main.output_string.concat(writer.name + " " + writer.surName);
                    Main.output_string = Main.output_string.concat(((y == viewSFilm.writerIDs.size() - 1) ? "\n" : ", "));
                }
            }
        }
        viewDirectors(viewSFilm);
        viewStars(viewSFilm);
        viewRating(viewSFilm);
        return true;
    }

    public static boolean View(Documentary viewDocumentary) {//viewfilm command printing to documentaries
        Main.output_string = Main.output_string.concat(viewDocumentary.title + " (" + viewDocumentary.releaseDate.split("\\.")[2] + ")\n");
        viewDirectors(viewDocumentary);
        viewStars(viewDocumentary);
        viewRating(viewDocumentary);
        return true;
    }

    public static boolean View(TVSeries viewTVSeries) {//viewfilm command printing to TV Series
        Main.output_string = Main.output_string.concat(viewTVSeries.title + " (" + viewTVSeries.startDate.split("\\.")[2] + "-" + viewTVSeries.endDate.split("\\.")[2] + ")\n");
        Main.output_string = Main.output_string.concat(viewTVSeries.numberOfSeasons + " seasons, " + viewTVSeries.numberOfEpisodes + " episodes\n");
        Main.output_string = Main.output_string.concat(viewTVSeries.genres.toString().replace("[", "").replace("]", "")+"\n");
        Main.output_string = Main.output_string.concat("Writers: ");
        for (int y = 0; y < viewTVSeries.writerIDs.size(); y++) {
            for (Writer writer : Main.writer_objects) {
                if (writer.ID == viewTVSeries.writerIDs.get(y)) {
                    Main.output_string = Main.output_string.concat(writer.name + " " + writer.surName);
                    Main.output_string = Main.output_string.concat(((y == viewTVSeries.writerIDs.size() - 1) ? "\n" : ", "));
                }
            }
        }
        viewDirectors(viewTVSeries);
        viewStars(viewTVSeries);
        viewRating(viewTVSeries);
        return true;
    }

    public static void viewDirectors(Film film) {//printing directors of the given film
        Main.output_string = Main.output_string.concat("Directors: ");
        for (int y = 0; y < film.directorIDs.size(); y++) {
            for (Director director : Main.director_objects) {
                if (director.ID == film.directorIDs.get(y)) {
                    Main.output_string = Main.output_string.concat(director.name + " " + director.surName);
                    Main.output_string = Main.output_string.concat(((y == film.directorIDs.size() - 1) ? "\n" : ", "));
                }
            }
        }
    }

    public static void viewStars(Film film) {//printing stars of the given film
        Main.output_string = Main.output_string.concat("Stars: ");
        for (int y = 0; y < film.performerIDs.size(); y++) {
            for (Performer performer : Main.actor_objects) {
                if (performer.ID == film.performerIDs.get(y)) {
                    Main.output_string = Main.output_string.concat(performer.name + " " + performer.surName);
                    Main.output_string = Main.output_string.concat(((y == film.performerIDs.size() - 1) ? "\n" : ", "));
                }
            }
            for (Performer performer : Main.childActor_objects) {
                if (performer.ID == film.performerIDs.get(y)) {
                    Main.output_string = Main.output_string.concat(performer.name + " " + performer.surName);
                    Main.output_string = Main.output_string.concat(((y == film.performerIDs.size() - 1) ? "\n" : ", "));
                }
            }
        }
    }

    public static void viewRating(Film film) {//printing rating point of the given film
        Main.output_string = Main.output_string.concat(film.number_of_votes != 0 ? ("Ratings: " + rateFuncs.ratingToPrint(rateFuncs.filmRatingCalc(film)) + "/10 from " + film.number_of_votes + " users\n\n") : "Awaiting for votes\n\n");
    }
}
