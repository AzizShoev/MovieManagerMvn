package ru.netology.javaqa;

public class MovieManager {
    private int limitFilms = 5; //лимит фильмов
    private String[] movies = new String[0]; //массив фильмов

    public MovieManager() {
    }

    public MovieManager(int limitFilms) {
        this.limitFilms = limitFilms;
    }

    public void addMovies(String movie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int limitArray = 0;
        if (movies.length < limitFilms) {
            limitArray = movies.length;
        } else {
            limitArray = limitFilms;
        }
        String[] tmp = new String[limitArray];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = movies[movies.length - 1 - i];
        }
        return tmp;
    }
}
