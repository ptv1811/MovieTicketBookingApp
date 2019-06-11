package com.example.movieticketbookingapp.data;

import com.example.movieticketbookingapp.data.model.Showtime;
import com.example.movieticketbookingapp.data.model.MovieInfo;

import java.util.Date;
import java.util.List;

public class CinemaShowtimeRepo {
    private static CinemaShowtimeRepo instance;
    private DataSource dataSource;

    public CinemaShowtimeRepo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static CinemaShowtimeRepo getInstance(DataSource dataSource) {
        if (instance == null) {
            instance = new CinemaShowtimeRepo(dataSource);
        }
        return instance;
    }

    public List<Date> getListDate(Date startDate) {
        return this.dataSource.getListDates(startDate,7 );
    }

    public List<Date> getListShowtime(Date startTime) {
        return this.dataSource.getListShowtimes(startTime, 7);
    }

    public MovieInfo getMovieInfo() {
        return this.dataSource.getMovieInfo();

    }
}
