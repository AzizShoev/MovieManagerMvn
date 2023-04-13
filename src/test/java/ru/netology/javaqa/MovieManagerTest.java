package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    MovieManager manager = new MovieManager();

    @Test
    public void shouldFindAllEmpty() {  //find null movie

        String[] findAllExpected = {};
        Assertions.assertArrayEquals(findAllExpected, manager.findAll());
    }

    @Test
    public void shouldFindLastEmpty() { //find last null movie

        String[] findLastExpected = {};
        Assertions.assertArrayEquals(findLastExpected, manager.findLast());
    }

    @Test
    public void shouldAddAndFindLastMovieToArrayWithDefaultLimit() { //Low array - Default limit

        manager.addMovies("Movie 1");
        manager.addMovies("Movie 2");
        manager.addMovies("Movie 3");
        manager.addMovies("Movie 4");

        String[] findAllExpected = {"Movie 1", "Movie 2", "Movie 3", "Movie 4"};
        Assertions.assertArrayEquals(findAllExpected, manager.findAll());

        String[] findLastExpected = {"Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        Assertions.assertArrayEquals(findLastExpected, manager.findLast());
    }

    @Test
    public void shouldFindLastMovieWithDefaultLimitInHighFilledArray() {  //High array - Default limit

        manager.addMovies("Movie 1");
        manager.addMovies("Movie 2");
        manager.addMovies("Movie 3");
        manager.addMovies("Movie 4");
        manager.addMovies("Movie 5");
        manager.addMovies("Movie 6");
        manager.addMovies("Movie 7");

        String[] expected = {"Movie 7", "Movie 6", "Movie 5", "Movie 4", "Movie 3"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastMovieWithHighLimitInLowFilledArray() {  //Low array - High limit
        MovieManager manager = new MovieManager(7);
        manager.addMovies("Movie 1");
        manager.addMovies("Movie 2");
        manager.addMovies("Movie 3");
        manager.addMovies("Movie 4");

        String[] expected = {"Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastMovieWithLowLimitInHighFilledArray() {    //High array - Low limit
        MovieManager manager = new MovieManager(4);
        manager.addMovies("Movie 1");
        manager.addMovies("Movie 2");
        manager.addMovies("Movie 3");
        manager.addMovies("Movie 4");
        manager.addMovies("Movie 5");
        manager.addMovies("Movie 6");
        manager.addMovies("Movie 7");
        manager.addMovies("Movie 8");

        String[] expected = {"Movie 8", "Movie 7", "Movie 6", "Movie 5"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastMovieWithHighLimitInHighFilledArray() {    //High array - High limit
        MovieManager manager = new MovieManager(6);
        manager.addMovies("Movie 1");
        manager.addMovies("Movie 2");
        manager.addMovies("Movie 3");
        manager.addMovies("Movie 4");
        manager.addMovies("Movie 5");
        manager.addMovies("Movie 6");
        manager.addMovies("Movie 7");
        manager.addMovies("Movie 8");

        String[] expected = {"Movie 8", "Movie 7", "Movie 6", "Movie 5", "Movie 4", "Movie 3"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }
}
