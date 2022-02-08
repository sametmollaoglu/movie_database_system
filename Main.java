import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    //all type of objects arraylist initialized static to be able to use from everywhere
    static ArrayList<User> user_objects = new ArrayList<>();
    static ArrayList<Director> director_objects = new ArrayList<>();
    static ArrayList<Writer> writer_objects = new ArrayList<>();
    static ArrayList<Actor> actor_objects = new ArrayList<>();
    static ArrayList<ChildActor> childActor_objects = new ArrayList<>();
    static ArrayList<StuntPerformer> stuntPerformer_objects = new ArrayList<>();

    static ArrayList<FeatureFilm> featureFilm_objects = new ArrayList<>();
    static ArrayList<ShortFilm> shortFilm_objects = new ArrayList<>();
    static ArrayList<Documentary> documentary_objects = new ArrayList<>();
    static ArrayList<TVSeries> tvSeries_objects = new ArrayList<>();
    static ArrayList<Film> allFilms = new ArrayList<>();

    static String output_string = "";    //All outputs are summed up in this variable to print to output.txt file

    public static void main(String[] args) {

        try {//people text read
            BufferedReader file = new BufferedReader(new FileReader(args[0]));
            String txtLine;

            while ((txtLine = file.readLine()) != null) {

                String[] peopleline = txtLine.split("\t");

                //common attributes of every type of user object initialized earlier
                int ID = Integer.parseInt(peopleline[1]);
                String name = peopleline[2];
                String surName = peopleline[3];
                String country = peopleline[4];
                String agent;
                String wStyle;
                int height;
                int age;
                ArrayList<Integer> actorIDs = new ArrayList<>();


                switch (peopleline[0]) {
                    //non common attributes with type of user objects initialized here and added to object arraylists
                    case "User:":
                        User temp_user = new User(ID, name, surName, country);
                        user_objects.add(temp_user);
                        break;
                    case "Director:":
                        agent = peopleline[5];
                        Director temp_director = new Director(ID, name, surName, country, agent);
                        director_objects.add(temp_director);
                        break;
                    case "Writer:":
                        wStyle = peopleline[5];
                        Writer temp_writer = new Writer(ID, name, surName, country, wStyle);
                        writer_objects.add(temp_writer);
                        break;
                    case "Actor:":
                        height = Integer.parseInt(peopleline[5]);
                        Actor temp_actor = new Actor(ID, name, surName, country, height);
                        actor_objects.add(temp_actor);
                        break;
                    case "ChildActor:":
                        age = Integer.parseInt(peopleline[5]);
                        ChildActor temp_childActor = new ChildActor(ID, name, surName, country, age);
                        childActor_objects.add(temp_childActor);
                        break;
                    case "StuntPerformer:":
                        height = Integer.parseInt(peopleline[5]);
                        for (String s : peopleline[6].split(",")) actorIDs.add(Integer.parseInt(s));
                        StuntPerformer temp_stuntPerformer = new StuntPerformer(ID, name, surName, country, height, actorIDs);
                        stuntPerformer_objects.add(temp_stuntPerformer);
                        break;
                }

            }
            file.close();
        } catch (IOException a) {
            System.out.println(args[0] + " file cannot be read.");
        }

        try {//films text read
            BufferedReader file = new BufferedReader(new FileReader(args[1]));
            String txtLine;


            while ((txtLine = file.readLine()) != null) {

                String[] filmline = txtLine.split("\t");

                //common attributes of every type of film object initialized earlier
                int ID = Integer.parseInt(filmline[1]);
                String title = filmline[2];
                String language = filmline[3];

                ArrayList<Integer> directorIDs = new ArrayList<>();
                for (String s : filmline[4].split(",")) directorIDs.add(Integer.parseInt(s));

                int length = Integer.parseInt(filmline[5]);
                String country = filmline[6];

                ArrayList<Integer> performerIDs = new ArrayList<>();
                for (String s : filmline[7].split(",")) performerIDs.add(Integer.parseInt(s));

                ArrayList<String> genres = new ArrayList<>();
                String releaseDate;
                ArrayList<Integer> writerIDs = new ArrayList<>();
                int budget;
                String startDate;
                String endDate;
                int numberOfSeasons;
                int numberOfEpisodes;

                switch (filmline[0]) {
                    //non common attributes with type of film objects initialized here and added to object arraylists
                    case "FeatureFilm:":
                        Collections.addAll(genres, filmline[8].split(","));
                        releaseDate = filmline[9];
                        for (String s : filmline[10].split(",")) writerIDs.add(Integer.parseInt(s));
                        budget = Integer.parseInt(filmline[11]);
                        FeatureFilm temp_featureFilm = new FeatureFilm(ID, title, language, directorIDs, length, country, performerIDs, genres, releaseDate, writerIDs, budget);
                        featureFilm_objects.add(temp_featureFilm);
                        allFilms.add(temp_featureFilm);
                        break;
                    case "ShortFilm:":
                        Collections.addAll(genres, filmline[8].split(","));
                        releaseDate = filmline[9];
                        for (String s : filmline[10].split(",")) writerIDs.add(Integer.parseInt(s));
                        if (length <= 40) {
                            ShortFilm temp_shortFilm = new ShortFilm(ID, title, language, directorIDs, length, country, performerIDs, genres, releaseDate, writerIDs);
                            shortFilm_objects.add(temp_shortFilm);
                            allFilms.add(temp_shortFilm);
                        } else {
                            System.out.println(title + " named Short Film's length is longer than 40 minutes");
                        }

                        break;
                    case "Documentary:":
                        releaseDate = filmline[8];
                        Documentary temp_documentary = new Documentary(ID, title, language, length, country, directorIDs, performerIDs, releaseDate);
                        documentary_objects.add(temp_documentary);
                        allFilms.add(temp_documentary);
                        break;
                    case "TVSeries:":
                        Collections.addAll(genres, filmline[8].split(","));
                        for (String s : filmline[9].split(",")) writerIDs.add(Integer.parseInt(s));
                        startDate = filmline[10];
                        endDate = filmline[11];
                        numberOfSeasons = Integer.parseInt(filmline[12]);
                        numberOfEpisodes = Integer.parseInt(filmline[13]);
                        TVSeries temp_TVSeries = new TVSeries(ID, title, language, length, country, directorIDs, performerIDs, startDate, endDate, numberOfSeasons, numberOfEpisodes, writerIDs, genres);
                        tvSeries_objects.add(temp_TVSeries);
                        allFilms.add(temp_TVSeries);
                        break;
                }


            }
            file.close();
        } catch (IOException a) {
            System.out.println(args[1] + " file cannot be read.");
        }

        try {//commands text read
            BufferedReader file = new BufferedReader(new FileReader(args[2]));
            String txtLine;

            while ((txtLine = file.readLine()) != null) {

                String[] commandline = txtLine.split("\t");
                //switch case to every line of commands text
                switch (commandline[0]) {
                    case "RATE":
                        rateFuncs.allRateProcess("rate", commandline, txtLine);
                        break;
                    case "ADD":
                        //initialize temp variables attributes to use as parameters when creating feature film object
                        ArrayList<Integer> directorIDs = new ArrayList<>();
                        for (String s : commandline[5].split(",")) directorIDs.add(Integer.parseInt(s));

                        ArrayList<Integer> performerIDs = new ArrayList<>();
                        for (String s : commandline[8].split(",")) performerIDs.add(Integer.parseInt(s));

                        ArrayList<String> genres = new ArrayList<>();
                        Collections.addAll(genres, commandline[9].split(","));

                        ArrayList<Integer> writerIDs = new ArrayList<>();
                        for (String s : commandline[11].split(",")) writerIDs.add(Integer.parseInt(s));

                        boolean can_be_created = true;
                        //checked in here if there are other movies with the same id
                        for (Film film : allFilms) {
                            if (film.ID == Integer.parseInt(commandline[2])) {
                                can_be_created = false;
                                break;
                            }
                        }

                        //Checking whether given directors exist
                        ArrayList<Integer> allDirectorIDs = new ArrayList<>();
                        for (Director director : director_objects) {
                            allDirectorIDs.add(director.ID);
                        }
                        if (!allDirectorIDs.containsAll(directorIDs)) {
                            can_be_created = false;
                        }

                        //Checking whether given writers exist
                        ArrayList<Integer> allWriterIDs = new ArrayList<>();
                        for (Writer writer : writer_objects) {
                            allWriterIDs.add(writer.ID);
                        }
                        if (!allWriterIDs.containsAll(writerIDs)) {
                            can_be_created = false;
                        }

                        //Checking whether given actors exist
                        ArrayList<Integer> allPerformerIDs = new ArrayList<>();
                        for (Actor actor : actor_objects) {
                            allPerformerIDs.add(actor.ID);
                        }
                        for (ChildActor childActor : childActor_objects) {
                            allPerformerIDs.add(childActor.ID);
                        }
                        for (StuntPerformer stuntPerformer : stuntPerformer_objects) {
                            allPerformerIDs.add(stuntPerformer.ID);
                        }
                        if (!allPerformerIDs.containsAll(performerIDs)) {
                            can_be_created = false;
                        }
                        Main.output_string = Main.output_string.concat(txtLine + "\n\n");
                        //we define the object if all conditions are met
                        if (can_be_created) {
                            FeatureFilm temp_featureFilm = new FeatureFilm(Integer.parseInt(commandline[2]), commandline[3], commandline[4], directorIDs, Integer.parseInt(commandline[6]), commandline[7], performerIDs, genres, commandline[10], writerIDs, Integer.parseInt(commandline[12]));
                            featureFilm_objects.add(temp_featureFilm);
                            allFilms.add(temp_featureFilm);
                            Main.output_string = Main.output_string.concat("FeatureFilm added successfully\n");
                        } else {
                            Main.output_string = Main.output_string.concat("Command Failed\n");
                        }
                        Main.output_string = Main.output_string.concat("Film ID: " + Integer.parseInt(commandline[2]) + "\nFilm title: " + commandline[3] + "\n\n");
                        break;

                    case "VIEWFILM":
                        Main.output_string = Main.output_string.concat(txtLine + "\n\n");
                        boolean viewed = false;
                        for (Film film : allFilms) {
                            if (film.ID == Integer.parseInt(commandline[1])) {//the appropriate function for the movie type is executed
                                if (film instanceof FeatureFilm) {
                                    viewed = viewFilm.View((FeatureFilm) film);

                                } else if (film instanceof ShortFilm) {
                                    viewed = viewFilm.View((ShortFilm) film);

                                } else if (film instanceof Documentary) {
                                    viewed = viewFilm.View((Documentary) film);

                                } else if (film instanceof TVSeries) {
                                    viewed = viewFilm.View((TVSeries) film);

                                }
                            }
                        }
                        if (!viewed) {

                            Main.output_string = Main.output_string.concat("Command Failed\n");
                            Main.output_string = Main.output_string.concat("Film ID: " + commandline[1] + "\n\n");
                        }
                        break;
                    case "LIST": //all list commands are executed here
                        Main.output_string = Main.output_string.concat(txtLine + "\n\n");
                        if (commandline[1].equals("USER")) {
                            boolean user_not_found = true;
                            for (User user : user_objects) {
                                if (user.ID == Integer.parseInt(commandline[2])) {
                                    user_not_found = false;
                                    listFuncs.listRates(user); //if the user exist, listRates function take this user as a parameter
                                }
                            }
                            if (user_not_found) {
                                Main.output_string = Main.output_string.concat("Command Failed\n");
                                Main.output_string = Main.output_string.concat("User ID: " + commandline[2]+"\n");
                            }
                            Main.output_string = Main.output_string.concat("\n");
                        } else if (commandline[1].equals("FILM") && commandline[2].equals("SERIES")) {
                            listFuncs.listSeries();
                        } else if (commandline[1].equals("FILMS") && commandline[2].equals("BY") && commandline[3].equals("COUNTRY")) {
                            listFuncs.listAllFilmsByCountry(commandline[4]);
                        } else if (commandline[1].equals("FEATUREFILMS") && commandline[2].equals("BEFORE")) {
                            listFuncs.listFFBeforeYear(Integer.parseInt(commandline[3]));
                        } else if (commandline[1].equals("FEATUREFILMS") && commandline[2].equals("AFTER")) {
                            listFuncs.listFFAfterYear(Integer.parseInt(commandline[3]));
                        } else if (commandline[1].equals("FILMS") && commandline[2].equals("BY") && commandline[3].equals("RATE")) {
                            listFuncs.listFFilmsByRate(featureFilm_objects); //list films by rate functions will be executed for each film category separately
                            listFuncs.listSFilmsByRate(shortFilm_objects);
                            listFuncs.listDFilmsByRate(documentary_objects);
                            listFuncs.listTVFilmsByRate(tvSeries_objects);
                        } else if (commandline[1].equals("ARTISTS") && commandline[2].equals("FROM")) {
                            listFuncs.listArtistsFromCountry(commandline[3]);
                        }
                        break;
                    case "EDIT":
                        if (commandline[1].equals("RATE")) {
                            rateFuncs.allRateProcess("edit", commandline, txtLine);
                        }
                        break;
                    case "REMOVE":
                        if (commandline[1].equals("RATE")) {
                            rateFuncs.allRateProcess("remove", commandline, txtLine);
                        }
                        break;
                }
                Main.output_string = Main.output_string.concat("-----------------------------------------------------------------------------------------------------\n");
            }
            file.close();
        } catch (IOException a) {
            System.out.println(args[2] + " file cannot be read.");
        }
        try {//this try catch block create output text file
            PrintWriter writer = new PrintWriter(args[3], "UTF-8");
            writer.print(output_string);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
