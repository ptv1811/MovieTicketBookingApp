package com.example.movieticketbookingapp.data.model;

import com.example.movieticketbookingapp.data.CinemaShowtimeRepo;
import com.example.movieticketbookingapp.data.DataSource;

import java.util.Date;
import java.util.List;

public class Cinema {
    private String Name;
    private List<Date> dateList;
    private List<Date> showtimeList;

    public Cinema(String Name, List<Date> dateList, List<Date> showtimeList)
    {
        this.Name=Name;
        this.dateList=dateList;
        this.showtimeList=showtimeList;
    }

    public String getName() {
        return Name;
    }

    public List<Date> getDateList() {
        return dateList;
    }

    public List<Date> getShowtimeList() {
        return showtimeList;
    }
}
