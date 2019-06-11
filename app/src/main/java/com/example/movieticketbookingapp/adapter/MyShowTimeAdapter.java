package com.example.movieticketbookingapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.movieticketbookingapp.R;
import com.example.movieticketbookingapp.data.model.Showtime;
import com.example.movieticketbookingapp.interfaces.IRecyclerItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class MyShowTimeAdapter extends RecyclerView.Adapter<MyShowTimeAdapter.ViewHolder> {

    private List<String> listShowtime;
    private Context context;
    private ArrayList<CardView> listCardview;

    public MyShowTimeAdapter(List<String> listShowtime, Context context) {
        this.listShowtime = listShowtime;
        this.context = context;
        listCardview=new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(context).inflate(R.layout.layout_showtime,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
       viewHolder.showtime.setText(listShowtime.get(i));

        if(!listCardview.contains(viewHolder.card_time))
            listCardview.add(viewHolder.card_time);

        viewHolder.setiRecyclerItemSelectedListener(new IRecyclerItemSelectedListener() {
            @Override
            public void OnItemSelectedListenre(View view, int pos) {
                for(CardView cardView:listCardview)
                    cardView.setCardBackgroundColor(context.getResources().getColor(android.R.color.black));
                viewHolder.card_time.setCardBackgroundColor(context.getResources().getColor(android.R.color.holo_blue_dark));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listShowtime.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView showtime;
        CardView card_time;

        IRecyclerItemSelectedListener iRecyclerItemSelectedListener;

        public void setiRecyclerItemSelectedListener(IRecyclerItemSelectedListener iRecyclerItemSelectedListener) {
            this.iRecyclerItemSelectedListener = iRecyclerItemSelectedListener;
        }

        public ViewHolder(View view)
        {
            super(view);
            card_time=(CardView) itemView.findViewById(R.id.card_time);
            showtime=(TextView) view.findViewById(R.id.showtime);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            iRecyclerItemSelectedListener.OnItemSelectedListenre(v,getAdapterPosition());
        }
    }
}
