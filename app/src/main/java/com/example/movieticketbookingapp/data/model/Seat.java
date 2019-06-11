package com.example.movieticketbookingapp.data.model;

import android.content.Context;
import android.util.AttributeSet;

import com.example.movieticketbookingapp.R;

public class Seat extends android.support.v7.widget.AppCompatButton {

    private String ID;
    private String SeatID;
    private int rowNum;
    private int colNum;
    private boolean isChosen;
    private boolean Reserved=false;
    private final double price=5.00;

    public Seat(Context context) {
        super(context);
    }

    public Seat(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Seat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Seat(Context context, int row, int col) {
        super(context);
        this.rowNum = row;
        this.colNum = col;
        this.SeatID = Integer.toString(this.rowNum) + "," + Integer.toString(this.colNum);
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }


    public boolean setBackground(){
        if(this.Reserved)
        {
            this.setBackgroundResource(R.drawable.reserved);
            return false;
        }
        if(this.isChosen)
        {
            this.setBackgroundResource(R.drawable.chosen);
            return true;
        }
        else
        {
            this.setBackgroundResource(R.drawable.available);
            this.isChosen=true;
            return true;
        }
    }


    public void setStatus(boolean status) {
        this.isChosen = status;
    }

    public boolean getStatus() {
        return isChosen;
    }

    public double getPrice() {
        return price;
    }

    public String getSeatID(){
        return this.SeatID;
    }

    public void setReserved(){
        this.Reserved = true;
    }

    public boolean Reserved(){
        return this.Reserved;
    }
}
