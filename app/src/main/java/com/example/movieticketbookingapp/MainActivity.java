package com.example.movieticketbookingapp;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.movieticketbookingapp.data.model.MovieInfo;
import com.example.movieticketbookingapp.data.DataSource;
import com.example.movieticketbookingapp.databinding.ActivityMainBinding;




public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    TextView scroll;

    public void clickFunction(View view) {
        Log.i("Info","Pressed!");


    }

    public MovieInfo movie_info;

    Button btn_booking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        DataSource movie= new DataSource();
        movie_info= movie.getMovieInfo();
        scroll=(TextView) findViewById(R.id.synopsis);
        scroll.setMovementMethod(new ScrollingMovementMethod());

        mainBinding.setMovie(movie_info);

        btn_booking=(Button) findViewById(R.id.Booking);
        btn_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SeatBooking.class);
                startActivity(intent);
            }
        });

        }
    }

