package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    MovieManager manager = new MovieManager();

    @Test
    public void shouldAddMovieToArray() {

        manager.addMovies("Movie 1");
        manager.addMovies("Movie 2");
        manager.addMovies("Movie 3");
        String[] expected = {"Movie 1", "Movie 2", "Movie 3"};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }
    @Test
    public void shouldFindAllEmpty() {

        String[] expected = {};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldFindLastMovieToArrayBeforeLimit() {

        manager.addMovies("Movie 1");
        manager.addMovies("Movie 2");
        manager.addMovies("Movie 3");
        manager.addMovies("Movie 4");
        String[] expected = {"Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldFindLastMovieToArrayWithLimit() {

        manager.addMovies("Movie 1");
        manager.addMovies("Movie 2");
        manager.addMovies("Movie 3");
        manager.addMovies("Movie 4");
        manager.addMovies("Movie 5");
        String[] expected = {"Movie 5", "Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }
    @Test
    public void shouldFindLastMovieToArrayAfterLimit() {
        MovieManager manager = new MovieManager(6);
        manager.addMovies("Movie 1");
        manager.addMovies("Movie 2");
        manager.addMovies("Movie 3");
        manager.addMovies("Movie 4");
        manager.addMovies("Movie 5");
        manager.addMovies("Movie 6");
        String[] expected = {"Movie 6", "Movie 5", "Movie 4", "Movie 3", "Movie 2", "Movie 1"};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }
    @Test
    public void shouldFindLastEmpty() {

        String[] expected = {};
        Assertions.assertArrayEquals(expected, manager.findLast());
    }
}
