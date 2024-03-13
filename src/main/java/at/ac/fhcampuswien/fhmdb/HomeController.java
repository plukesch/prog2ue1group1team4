package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox<String> genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes
    public JFXButton clearBtn;

    /**
     * Initializes the controller with necessary setup for the movie list view, genre filter combo box,
     * and action handlers for the UI components.
     *
     * This method is called automatically after the FXML fields have been injected and is used to set up
     * the initial state of the UI components and their interactions. It performs the following tasks:
     *
     * - Populates the observable list of movies and sets it to the movie list view.
     * - Initializes the movie list view to use a custom cell factory for rendering movie items.
     * - Populates the genre combo box with a list of predefined genres and sets a prompt text.
     * - Assigns action handlers to the search button, genre combo box, sort button, and clear filter button.
     *   These handlers invoke the corresponding methods to filter, sort, or clear the movie list based on user interactions.
     * - Sets the initial text of the sort button to indicate the current sorting order is ascending.
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);
        movieListView.setItems(observableMovies);
        movieListView.setCellFactory(movieListView -> new MovieCell());

        // Populate the genre ComboBox
        genreComboBox.getItems().addAll("Action", "Comedy", "Drama", "Crime", "Science Fiction", "Sport", "Thriller", "Mystery", "Romance", "Musical", "Western", "Adventure"); // Add all relevant genres here
        genreComboBox.setPromptText("Filter by Genre");

        // Add action listeners
        searchBtn.setOnAction(event -> applyFilters());
        genreComboBox.setOnAction(event -> applyFilters());
        sortBtn.setOnAction(event -> toggleSort());

        clearBtn.setOnAction(event -> clearFilters());

        sortBtn.setText("Sort (asc)");
    }

    /**
     * Clears all active filters, resetting the search text, genre selection, and the movie list.
     *
     * This method is responsible for:
     * - Clearing any text in the search field.
     * - Deselecting any selected genre.
     * - Resetting the observable list of movies to show the complete, unfiltered list.
     *
     */
    private void clearFilters() {
        // Clearing the search text and genre selection
        searchField.setText("");
        genreComboBox.getSelectionModel().clearSelection();

        // Resetting the list to show all movies
        observableMovies.setAll(allMovies);
    }

    /**
     * Applies filters based on the current text in the search field and the selected genre, updating
     * the observable list of movies to only include those that match the criteria.
     *
     * This method filters the list of all movies by:
     * - Including only those movies whose title or description contains the search text, if any.
     * - Including only those movies that belong to the selected genre, if one is selected.
     *
     * The filtering is case-insensitive for both the search text and the genre names. If no search text
     * is provided or no genre is selected, those respective filters are not applied.
     *
     */
    private void applyFilters() {
        String searchText = searchField.getText().toLowerCase();
        String selectedGenreName = genreComboBox.getSelectionModel().getSelectedItem();

        List<Movie> filteredMovies = allMovies.stream()
                .filter(movie -> movie.getTitle().toLowerCase().contains(searchText) ||
                        (movie.getDescription() != null && movie.getDescription().toLowerCase().contains(searchText)))
                .filter(movie -> selectedGenreName == null ||
                        movie.getGenres().stream().anyMatch(genre -> genre.getName().equalsIgnoreCase(selectedGenreName)))
                .collect(Collectors.toList());

        observableMovies.setAll(filteredMovies);
    }

    /**
     * Toggles the sorting order of the observable list of movies based on their titles.
     *
     * This method sorts the list of movies maintained in an observable list. The sorting order
     * is determined by the text of a sort button. If the button indicates that the current
     * order is ascending, the method sorts the movies in descending order, and vice versa.
     * After sorting, it updates the button text to reflect the next available sorting order.
     */
    private void toggleSort() {
        Comparator<Movie> comparator = Comparator.comparing(Movie::getTitle);
        if (sortBtn.getText().equals("Sort (asc)")) {
            FXCollections.sort(observableMovies, comparator);
            sortBtn.setText("Sort (desc)");
        } else {
            FXCollections.sort(observableMovies, comparator.reversed());
            sortBtn.setText("Sort (asc)");
        }
    }

    /**
     * Filters a list of movies based on the provided search text and selected genre.
     *
     * This method iterates over a list of movies, applying two filters:
     * 1. It filters movies by checking if their title or description contains the provided search text
     *    (ignoring case). If the search text is empty, all movies pass this filter.
     * 2. It filters movies by their genre. A movie passes this filter if it contains the selected genre.
     *    If the selected genre is null, all movies pass this filter.
     *
     * Note: The filtering process is case-insensitive
     *
     * @param searchText The text used to filter movies by their title or description. The filter is
     *                   bypassed if this parameter is empty.
     * @param selectedGenreName The name of the genre used to filter the movies. If null, the filter
     *                          is bypassed, and movies are not filtered by genre.
     * @param movies The list of Movie objects to be filtered.
     * @return A list of filtered Movie objects that match the given search text and belong to the
     *         specified genre. If no filters are applied, returns the original list of movies.
     */
    public List<Movie> filterMovies(String searchText, String selectedGenreName, List<Movie> movies) {
        return movies.stream()
                .filter(movie -> searchText.isEmpty() || movie.getTitle().toLowerCase().contains(searchText) ||
                        (movie.getDescription() != null && movie.getDescription().toLowerCase().contains(searchText)))
                .filter(movie -> selectedGenreName == null ||
                        movie.getGenres().stream().anyMatch(genre -> genre.getName().equalsIgnoreCase(selectedGenreName)))
                .collect(Collectors.toList());
    }
}