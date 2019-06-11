package com.example.movieticketbookingapp;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.movieticketbookingapp.adapter.MyDateAdapter;
import com.example.movieticketbookingapp.adapter.MyShowTimeAdapter;
import com.example.movieticketbookingapp.data.CinemaShowtimeRepo;
import com.example.movieticketbookingapp.data.DataSource;
import com.example.movieticketbookingapp.data.model.Cinema;
import com.example.movieticketbookingapp.data.model.Showtime;
import com.example.movieticketbookingapp.interfaces.IAllCineLoadListener;
import com.example.movieticketbookingapp.interfaces.SpacesItemDecoration;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeatBooking extends AppCompatActivity {
    DataSource dataSource ;
    CinemaShowtimeRepo dataRepo;

    private ArrayList<String> listDate=new ArrayList<>();
    private ArrayList<String> listShowtimes=new ArrayList<>();

    IAllCineLoadListener iAllCineLoadListener;

    com.jaredrummler.materialspinner.MaterialSpinner spinner;
    List<String> listCinema= new ArrayList<>();
    ArrayAdapter<String> adapter;
    @BindView(R.id.recycler_date)
    RecyclerView recycler_date;
    @BindView(R.id.recycler_showtime)
    RecyclerView recycler_showtime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_booking);
        dataSource= DataSource.getInstance();
        dataRepo=CinemaShowtimeRepo.getInstance(dataSource);

        Date startDate = new Date(2019, 03, 11);
        List<Date> listDates = dataRepo.getListDate(startDate);

        Date startTime = new Date(0, 0, 0, 10, 30);
        List<Date> listTimes = dataRepo.getListShowtime(startTime);

        List<Integer> adaptday= new ArrayList<>();
        List<Integer> adaptmonth=new ArrayList<>();
        List<Integer> adaptHours=new ArrayList<>();
        List<Integer> adaptMinute=new ArrayList<>();

        for(int i=0;i<listDates.size();++i)
        {
            adaptday.add(i,listDates.get(i).getDate());
            adaptmonth.add(i,listDates.get(i).getMonth());
        }

        for (int i=0;i<listTimes.size();++i)
        {
            adaptHours.add(i,listTimes.get(i).getHours());
            adaptMinute.add(i,listTimes.get(i).getMinutes());
        }


        Cinema Cine[]=new Cinema[2];
        Cine[0]= new Cinema("CGV Su Van Hanh",listDates,listTimes);
        Cine[1]= new Cinema("CGV Aeon Mall",listDates,listTimes );

        listCinema.add(0,"Where do you want to watch?");
        listCinema.add(1,Cine[0].getName());
        listCinema.add(2,Cine[1].getName());

        spinner= (MaterialSpinner) findViewById(R.id.spinner);
        spinner.setItems(listCinema);
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                if (position > 0)
                {
                    initRecyclerView_date(recycler_date);
                }

            }
        });

        for (int i=0; i< adaptday.size();++i)
        {
            listDate.add(i,adaptday.get(i).toString() + "/" + adaptmonth.get(i).toString());

        }

        for (int i=0;i<adaptHours.size();++i)
        {
            listShowtimes.add(i,adaptHours.get(i).toString()+ ":"+adaptMinute.get(i).toString());
        }

    }


    private void initRecyclerView_date(RecyclerView recyclerView)
    {
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView= findViewById(R.id.recycler_date);
        recyclerView.setLayoutManager(layoutManager);
        MyDateAdapter adapter= new MyDateAdapter(listDate,this);
        recyclerView.setAdapter(adapter);
       // recyclerView.addItemDecoration(new SpacesItemDecoration(5));
        initRecyclerView_showtime(recycler_showtime);
    }

    private void initRecyclerView_showtime(RecyclerView recyclerView)
    {
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView=findViewById(R.id.recycler_showtime);
        recyclerView.setLayoutManager(layoutManager);
        MyShowTimeAdapter adapter=new MyShowTimeAdapter(listShowtimes,this);
        recyclerView.setAdapter(adapter);
       // recyclerView.addItemDecoration(new SpacesItemDecoration(5));
    }
}
