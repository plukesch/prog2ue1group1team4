package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;

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
}