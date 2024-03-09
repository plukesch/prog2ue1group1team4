package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    public void testGetTitle() {
        //given
        Movie movie = new Movie("The Wolf of Wall Street", "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", List.of(new Genre("Crime"), new Genre("Comedy")));

        //when & then
        assertEquals("The Wolf of Wall Street", movie.getTitle());
    }
    @Test
    public void testGetDescription() {
        //given
        Movie movie = new Movie("The Wolf of Wall Street", "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", List.of(new Genre("Crime"), new Genre("Comedy")));

        //when & then
        assertEquals("Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", movie.getDescription());
    }

    @Test
    public void testGetGenres() {
        //given
        List<Genre> expectedGenres = new ArrayList<>();
        expectedGenres.add(new Genre("Science Fiction"));
        expectedGenres.add(new Genre("Adventure"));

        Movie movie = new Movie("Dune", "It is the first of a two-part adaptation of the 1965 novel of the same name by Frank Herbert. Set in the distant future, the film follows Paul Atreides as his family, the noble House Atreides, is thrust into a war for the deadly and inhospitable desert planet Arrakis.", expectedGenres);

        //when & then
        List<Genre> actualGenres = movie.getGenres();
        assertEquals(expectedGenres.size(), actualGenres.size());
        for (int i = 0; i < expectedGenres.size(); i++) {
            assertEquals(expectedGenres.get(i).getName(), actualGenres.get(i).getName());
        }
    }

}