package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class HomeControllerTest {

    @Test
    void does_filter_work_when_selecting_genre() {
        // Given
        HomeController controller = new HomeController();
        List<Movie> allMovies = Movie.initializeMovies(); // Make sure this is populated for the test

        // When
        List<Movie> filteredMovies = controller.filterMovies("crime", "Crime", allMovies);

        // Then
        assertTrue(filteredMovies.stream().allMatch(movie -> movie.getTitle().toLowerCase().contains("crime") ||
                        movie.getGenres().stream().anyMatch(genre -> genre.getName().equalsIgnoreCase("Crime"))),
                "Filtered movies should only include movies that match the criteria.");
    }
}
