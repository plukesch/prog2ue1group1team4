package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private int year;
    private double rating;

    public Movie(String title, String description, int year, double rating) {
        this.title = title;
        this.description = description;
        this.year = year;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getYear() {return year;}

    public double getRating() {return rating;}

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("The Wolf of Wall Street", "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", 2013, 8.2));
        movies.add(new Movie("Dune", "It is the first of a two-part adaptation of the 1965 novel of the same name by Frank Herbert. Set in the distant future, the film follows Paul Atreides as his family, the noble House Atreides, is thrust into a war for the deadly and inhospitable desert planet Arrakis.", 2021, 8.0));
        movies.add(new Movie("Le Mans 66 - Ford vs Ferrari", "The plot follows a determined team of American and English engineers and designers, led by automotive designer Carroll Shelby and his British driver, Ken Miles, who are hired by Henry Ford II and Lee Iacocca to build a race car to defeat the perennially dominant Italian racing team Scuderia Ferrari at the 1966 24 Hours ...", 2019, 8.1));
        movies.add(new Movie("American Fiction", "Based on the 2001 novel Erasure by Percival Everett, it follows a frustrated novelist-professor who writes an outlandish satire of stereotypical \"Black\" books, only for it to be mistaken by the liberal elite for serious literature and published to both high sales and critical praise.", 2023, 7.6));
        movies.add(new Movie("Oppenheimer", "Oppenheimer, American and British dramatic biographical film, released in 2023, that explores the life and legacy of the American physicist J. Robert Oppenheimer, who played a key role in the development of the atomic bomb.", 2023, 8.4));
        movies.add(new Movie("Scarface", "It tells the story of Cuban refugee Tony Montana (Pacino), who arrives penniless in Miami during the Mariel boatlift and becomes a powerful drug lord. The film co-stars Steven Bauer, Michelle Pfeiffer, Mary Elizabeth Mastrantonio, Robert Loggia, Míriam Colón and F. Murray Abraham.", 1983, 8.3));
        movies.add(new Movie("12 Angry Men", "The film tells the story of a jury of 12 men as they deliberate the conviction or acquittal of a teenager charged with murder on the basis of reasonable doubt; disagreement and conflict among them force the jurors to question their morals and values.", 1958, 8.9));
        movies.add(new Movie("Maestro", "Maestro is a towering and fearless love story chronicling the lifelong relationship between Leonard Bernstein and Felicia Montealegre Cohn Bernstein. A love letter to life and art, Maestro at its core is an emotionally epic portrayal of family and love.", 2023, 6.6));
        movies.add(new Movie("The good the bad and the ugly", "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.", 1966, 8.8));
        movies.add(new Movie("The Hangover", "Two days before his wedding, Doug (Justin Bartha) and three friends (Bradley Cooper, Ed Helms, Zach Galifianakis) drive to Las Vegas for a wild and memorable stag party. In fact, when the three groomsmen wake up the next morning, they can't remember a thing; nor can they find Doug.", 2009, 7.7));

        return movies;
    }
}
