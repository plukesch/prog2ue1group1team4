package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenreTest {

    @Test
    public void testGetName() {
        //given
        String expectedName = "Action";
        Genre genre = new Genre(expectedName);

        //when
        String actualName = genre.getName();

        //then
        assertEquals(expectedName, actualName);
    }
}