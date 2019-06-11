package com.example.movieticketbookingapp.data.model;

public class MovieInfo {
    private String title;
    private double rating;
    private int poster;
    private int runtime; //in minute
    private String synopsis;
    private String genres;

    public MovieInfo(
            String title,
            double rating,
            int poster,
            int runtime,
            String synopsis,
            String genres) {
        this.title=title;
        this.rating=rating;
        this.poster=poster;
        this.runtime=runtime;
        this.synopsis=synopsis;
        this.genres=genres;
    }

    public String getTitle()
    {
        return title;
    }

    public double getRating()
    {
        return rating;
    }

    public int getPoster(){ return poster;}

    public int getRuntime()
    {
        return runtime;
    }

    public String getSynopsis()
    {
        return synopsis;
    }

    public String getGenres()
    {
        return genres;
    }
}

