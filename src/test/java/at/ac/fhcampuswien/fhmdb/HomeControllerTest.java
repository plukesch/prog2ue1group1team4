package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class HomeControllerTest {
    @Test
    void does_filter_work_when_selecting_genre() {
        // Given
        HomeController controller = new HomeController();
        List<Movie> allMovies = Movie.initializeMovies();

        // When
        List<Movie> filteredMovies = controller.filterMovies("", "Crime", allMovies);

        // Then
        assertTrue(filteredMovies.stream().allMatch(movie -> movie.getGenres().stream().anyMatch(genre -> genre.getName().equalsIgnoreCase("Crime"))),
                "Filtered movies should only include movies that match the criteria.");
    }

    @Test
    void does_sort_function_work_in_ascending_order(){
        // Given
        List<Movie> moviesAscending = new ArrayList<>();
        moviesAscending.add(new Movie("12 Angry Men", "The film tells the story of a jury of 12 men as they deliberate the conviction or acquittal of a teenager charged with murder on the basis of reasonable doubt; disagreement and conflict among them force the jurors to question their morals and values.", List.of(new Genre("Crime"), new Genre("Thriller"))));
        moviesAscending.add(new Movie("American Fiction", "Based on the 2001 novel Erasure by Percival Everett, it follows a frustrated novelist-professor who writes an outlandish satire of stereotypical \"Black\" books, only for it to be mistaken by the liberal elite for serious literature and published to both high sales and critical praise.", List.of(new Genre("Comedy"), new Genre("Drama"))));
        moviesAscending.add(new Movie("Dune", "It is the first of a two-part adaptation of the 1965 novel of the same name by Frank Herbert. Set in the distant future, the film follows Paul Atreides as his family, the noble House Atreides, is thrust into a war for the deadly and inhospitable desert planet Arrakis.", List.of(new Genre("Science Fiction"), new Genre("Adventure"))));
        moviesAscending.add(new Movie("Le Mans 66 - Ford vs Ferrari", "The plot follows a determined team of American and English engineers and designers, led by automotive designer Carroll Shelby and his British driver, Ken Miles, who are hired by Henry Ford II and Lee Iacocca to build a race car to defeat the perennially dominant Italian racing team Scuderia Ferrari at the 1966 24 Hours of Le Mans race in France.", List.of(new Genre("Sport"), new Genre("Action"))));
        moviesAscending.add(new Movie("Maestro", "Maestro is a towering and fearless love story chronicling the lifelong relationship between Leonard Bernstein and Felicia Montealegre Cohn Bernstein. A love letter to life and art, Maestro at its core is an emotionally epic portrayal of family and love.", List.of(new Genre("Romance"), new Genre("Musical"))));
        moviesAscending.add(new Movie("Oppenheimer", "Oppenheimer, American and British dramatic biographical film, released in 2023, that explores the life and legacy of the American physicist J. Robert Oppenheimer, who played a key role in the development of the atomic bomb.", List.of(new Genre("Thriller"), new Genre("Mystery"))));
        moviesAscending.add(new Movie("Scarface", "It tells the story of Cuban refugee Tony Montana (Pacino), who arrives penniless in Miami during the Mariel boatlift and becomes a powerful drug lord. The film co-stars Steven Bauer, Michelle Pfeiffer, Mary Elizabeth Mastrantonio, Robert Loggia, Míriam Colón and F. Murray Abraham.", List.of(new Genre("Crime"), new Genre("Thriller"))));
        moviesAscending.add(new Movie("The Good, the Bad and the Ugly", "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.", List.of(new Genre("Western"), new Genre("Action"))));
        moviesAscending.add(new Movie("The Hangover", "Two days before his wedding, Doug (Justin Bartha) and three friends (Bradley Cooper, Ed Helms, Zach Galifianakis) drive to Las Vegas for a wild and memorable stag party. In fact, when the three groomsmen wake up the next morning, they can't remember a thing; nor can they find Doug.", List.of(new Genre("Comedy"), new Genre("Adventure"))));
        moviesAscending.add(new Movie("The Wolf of Wall Street", "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", List.of(new Genre("Crime"), new Genre("Comedy"))));

        // Shuffled Movies nur
        ObservableList<Movie> moviesShuffled = FXCollections.observableArrayList();
        moviesShuffled.addAll(moviesAscending);
        Collections.shuffle(moviesShuffled);

        //Ordnen
        Comparator<Movie> comparator = Comparator.comparing(Movie::getTitle);

        FXCollections.sort(moviesShuffled, comparator);

        // When & Then
        int i = 0;
        while (i < moviesAscending.size()){
            assertEquals(moviesAscending.get(i).getTitle(), moviesShuffled.get(i).getTitle());
            i++;
        }
    }
    @Test
    void does_sort_function_work_in_descending_order(){
        // Given
        List<Movie> moviesDescending = new ArrayList<>();
        moviesDescending.add(new Movie("The Wolf of Wall Street", "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", List.of(new Genre("Crime"), new Genre("Comedy"))));
        moviesDescending.add(new Movie("The Hangover", "Two days before his wedding, Doug (Justin Bartha) and three friends (Bradley Cooper, Ed Helms, Zach Galifianakis) drive to Las Vegas for a wild and memorable stag party. In fact, when the three groomsmen wake up the next morning, they can't remember a thing; nor can they find Doug.", List.of(new Genre("Comedy"), new Genre("Adventure"))));
        moviesDescending.add(new Movie("The Good, the Bad and the Ugly", "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.", List.of(new Genre("Western"), new Genre("Action"))));
        moviesDescending.add(new Movie("Scarface", "It tells the story of Cuban refugee Tony Montana (Pacino), who arrives penniless in Miami during the Mariel boatlift and becomes a powerful drug lord. The film co-stars Steven Bauer, Michelle Pfeiffer, Mary Elizabeth Mastrantonio, Robert Loggia, Míriam Colón and F. Murray Abraham.", List.of(new Genre("Crime"), new Genre("Thriller"))));
        moviesDescending.add(new Movie("Oppenheimer", "Oppenheimer, American and British dramatic biographical film, released in 2023, that explores the life and legacy of the American physicist J. Robert Oppenheimer, who played a key role in the development of the atomic bomb.", List.of(new Genre("Thriller"), new Genre("Mystery"))));
        moviesDescending.add(new Movie("Maestro", "Maestro is a towering and fearless love story chronicling the lifelong relationship between Leonard Bernstein and Felicia Montealegre Cohn Bernstein. A love letter to life and art, Maestro at its core is an emotionally epic portrayal of family and love.", List.of(new Genre("Romance"), new Genre("Musical"))));
        moviesDescending.add(new Movie("Le Mans 66 - Ford vs Ferrari", "The plot follows a determined team of American and English engineers and designers, led by automotive designer Carroll Shelby and his British driver, Ken Miles, who are hired by Henry Ford II and Lee Iacocca to build a race car to defeat the perennially dominant Italian racing team Scuderia Ferrari at the 1966 24 Hours of Le Mans race in France.", List.of(new Genre("Sport"), new Genre("Action"))));
        moviesDescending.add(new Movie("Dune", "It is the first of a two-part adaptation of the 1965 novel of the same name by Frank Herbert. Set in the distant future, the film follows Paul Atreides as his family, the noble House Atreides, is thrust into a war for the deadly and inhospitable desert planet Arrakis.", List.of(new Genre("Science Fiction"), new Genre("Adventure"))));
        moviesDescending.add(new Movie("American Fiction", "Based on the 2001 novel Erasure by Percival Everett, it follows a frustrated novelist-professor who writes an outlandish satire of stereotypical \"Black\" books, only for it to be mistaken by the liberal elite for serious literature and published to both high sales and critical praise.", List.of(new Genre("Comedy"), new Genre("Drama"))));
        moviesDescending.add(new Movie("12 Angry Men", "The film tells the story of a jury of 12 men as they deliberate the conviction or acquittal of a teenager charged with murder on the basis of reasonable doubt; disagreement and conflict among them force the jurors to question their morals and values.", List.of(new Genre("Crime"), new Genre("Thriller"))));

        //Shuffled Movies nur
        ObservableList<Movie> moviesShuffled = FXCollections.observableArrayList();
        moviesShuffled.addAll(moviesDescending);
        Collections.shuffle(moviesShuffled);

        //Ordnen
        Comparator<Movie> comparator = Comparator.comparing(Movie::getTitle);

        FXCollections.sort(moviesShuffled, comparator.reversed());

        // When & Then
        int i = 0;
        while (i < moviesDescending.size()){
            assertEquals(moviesDescending.get(i).getTitle(), moviesShuffled.get(i).getTitle());
            i++;
        }
    }
}
