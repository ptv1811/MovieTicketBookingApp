package com.example.movieticketbookingapp.data;

import com.example.movieticketbookingapp.data.model.Cinema;
import com.example.movieticketbookingapp.data.model.MovieInfo;
import com.example.movieticketbookingapp.data.model.Showtime;
import com.example.movieticketbookingapp.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class DataSource
{

    private static DataSource instance;

    public static DataSource getInstance()
    {
        if (instance == null)
        {
            instance= new DataSource();
        }
        return instance;
    }

    public List<Date> getListDates(Date startDate, int nDate) {
        List<Date> listDates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        for (int i = 0; i < nDate; i++) {
            listDates.add(calendar.getTime());

            // increase 1 date
            calendar.add(Calendar.DATE, 1);
        }
        return listDates;
    }

    public List<Date> getListShowtimes(Date startTime, int nTime) {
        List<Date> listShowtimes = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        boolean available;
        for (int i = 0; i < nTime; i++) {
            Date showtimeTemp = calendar.getTime();

            //    some showtimes not available
            if (showtimeTemp.getMinutes() <= 15) {
                available = false;
            } else {
                available = true;
            }
            listShowtimes.add(calendar.getTime());

            //      increase 45 minutes
            calendar.add(Calendar.MINUTE, 45);
        }
        return listShowtimes;
    }

    public MovieInfo getMovieInfo()
    {
        return new MovieInfo
                (
                        "Avengers: Endgame",
                        4.9,
                        R.drawable.poster,
                        182,
                        "Adrift in space with no food or water, Tony Stark sends a message to Pepper Potts as his oxygen supply starts to dwindle. Meanwhile, the remaining Avengers -- Thor, Black Widow, Captain America and Bruce Banner -- must figure out a way to bring back their vanquished allies for an epic showdown with Thanos -- the evil demigod who decimated the planet and the universe.",
                        "Action"
                );
    }

}
