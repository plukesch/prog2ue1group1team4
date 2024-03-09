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

        sortBtn.setText("Sort (asc)");
    }

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
}