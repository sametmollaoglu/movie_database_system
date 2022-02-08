public class rateFuncs {
    public static double filmRatingCalc(Film film) {//the votes from each user summed and divide to number of votes to calculate rating of the given film
        double vote_sum = 0;
        for (User user : Main.user_objects) {
            if (user.rated_film_IDs.contains(film.ID)) {
                vote_sum += (double) user.film_rates.get(user.rated_film_IDs.indexOf(film.ID));
            }
        }
        String a = String.format("%.1f", vote_sum / film.number_of_votes);

        return film.number_of_votes != 0 ? Double.parseDouble(a) : 0;
    }

    public static String ratingToPrint(double rating) {//the rating of the movie is made available for printing
        String g = String.valueOf(rating);
        String[] ary = g.split("\\.");
        if (ary[1].equals("0")) {
            return ary[0];
        } else {
            return ary[0] + "," + ary[1];
        }
    }


    public static void allRateProcess(String rateProcess, String[] commandline, String txtLine) { //all rate commands (new rate, edit, remove) are executed in this function
        Main.output_string = Main.output_string.concat(txtLine + "\n\n");
        boolean user_not_found = true;
        boolean film_not_found = true;
        for (User user : Main.user_objects) {
            if (user.ID == (rateProcess.equals("rate") ? Integer.parseInt(commandline[1]) : Integer.parseInt(commandline[2]))) {
                user_not_found = false;


                switch (rateProcess) {
                    case "edit": //to change the old vote of user to new vote point
                        if (user.rated_film_IDs.contains(Integer.parseInt(commandline[3]))) {
                            film_not_found = false;
                            int indexOfFilm = user.rated_film_IDs.indexOf(Integer.parseInt(commandline[3]));
                            user.film_rates.set(indexOfFilm, Integer.parseInt(commandline[4]));
                            Main.output_string = Main.output_string.concat("New ratings done successfully\n");
                            for (Film film : Main.allFilms) {
                                if (film.ID == Integer.parseInt(commandline[3])) {
                                    film.rating = rateFuncs.filmRatingCalc(film);
                                    Main.output_string = Main.output_string.concat("Film Title: " + film.title+"\n");
                                }
                            }
                            Main.output_string = Main.output_string.concat("Your rating: " + commandline[4]+"\n");
                        }
                        break;
                    case "remove": //to remove the old vote of user
                        if (user.rated_film_IDs.contains(Integer.parseInt(commandline[3]))) {
                            film_not_found = false;
                            int indexOfFilm = user.rated_film_IDs.indexOf(Integer.parseInt(commandline[3]));
                            user.film_rates.remove(indexOfFilm);
                            user.rated_film_IDs.remove(indexOfFilm);
                            Main.output_string = Main.output_string.concat("Your film rating was removed successfully\n");
                            for (Film film : Main.allFilms) {
                                if (film.ID == Integer.parseInt(commandline[3])) {
                                    film.number_of_votes--;
                                    film.rating = rateFuncs.filmRatingCalc(film);
                                    Main.output_string = Main.output_string.concat("Film Title: " + film.title+"\n");
                                }
                            }
                        }
                        break;
                    case "rate": //to give a new vote
                        for (Film my_film : Main.allFilms) {
                            if (my_film.ID == Integer.parseInt(commandline[2])) {
                                film_not_found = false;

                                if (user.rated_film_IDs.contains(my_film.ID)) {
                                    Main.output_string = Main.output_string.concat("The film was earlier rated\n");
                                } else {
                                    user.rated_film_IDs.add(my_film.ID);
                                    user.film_rates.add(Integer.parseInt(commandline[3]));
                                    my_film.number_of_votes++;
                                    my_film.rating = rateFuncs.filmRatingCalc(my_film);
                                    Main.output_string = Main.output_string.concat("Film rated successfully\nFilm type: " + my_film.getClass().toString().split(" ")[1] + "\nFilm title: " + my_film.title+"\n");
                                }
                            }
                        }
                        break;
                }


            }
        }
        if (user_not_found || film_not_found) {
            Main.output_string = Main.output_string.concat("Command Failed\n");
            Main.output_string = Main.output_string.concat("User ID: " + (rateProcess.equals("rate") ? Integer.parseInt(commandline[1]) : Integer.parseInt(commandline[2]))+"\n");
            Main.output_string = Main.output_string.concat("Film ID: " + (rateProcess.equals("rate") ? Integer.parseInt(commandline[2]) : Integer.parseInt(commandline[3]))+"\n");
        }
        Main.output_string = Main.output_string.concat("\n");
    }
}
