package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    private List<Genre> genres;

    public Movie(String title, String description, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres != null ? genres : new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public static List<Movie> initializeMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Wolf of Wall Street", "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", List.of(new Genre("Crime"), new Genre("Comedy"))));
        movies.add(new Movie("Dune", "It is the first of a two-part adaptation of the 1965 novel of the same name by Frank Herbert. Set in the distant future, the film follows Paul Atreides as his family, the noble House Atreides, is thrust into a war for the deadly and inhospitable desert planet Arrakis.", List.of(new Genre())));
        movies.add(new Movie("Le Mans 66 - Ford vs Ferrari", "The plot follows a determined team of American and English engineers and designers, led by automotive designer Carroll Shelby and his British driver, Ken Miles, who are hired by Henry Ford II and Lee Iacocca to build a race car to defeat the perennially dominant Italian racing team Scuderia Ferrari at the 1966 24 Hours ..."));
        movies.add(new Movie("American Fiction", "Based on the 2001 novel Erasure by Percival Everett, it follows a frustrated novelist-professor who writes an outlandish satire of stereotypical \"Black\" books, only for it to be mistaken by the liberal elite for serious literature and published to both high sales and critical praise."));
        movies.add(new Movie("Oppenheimer", "Oppenheimer, American and British dramatic biographical film, released in 2023, that explores the life and legacy of the American physicist J. Robert Oppenheimer, who played a key role in the development of the atomic bomb."));
        movies.add(new Movie("Scarface", "It tells the story of Cuban refugee Tony Montana (Pacino), who arrives penniless in Miami during the Mariel boatlift and becomes a powerful drug lord. The film co-stars Steven Bauer, Michelle Pfeiffer, Mary Elizabeth Mastrantonio, Robert Loggia, Míriam Colón and F. Murray Abraham."));

        return movies;
    }
}

