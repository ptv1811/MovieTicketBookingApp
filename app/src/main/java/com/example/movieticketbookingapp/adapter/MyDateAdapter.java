package com.example.movieticketbookingapp.adapter;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.movieticketbookingapp.R;
import com.example.movieticketbookingapp.interfaces.IRecyclerItemSelectedListener;

import java.util.ArrayList;


public class MyDateAdapter extends RecyclerView.Adapter<MyDateAdapter.ViewHolder>{

    private ArrayList<String> listDate;
    private ArrayList<CardView> listCardview;
    private Context context;

    public MyDateAdapter(ArrayList<String> listDate, Context context) {
        this.listDate = listDate;
        this.context = context;
        listCardview=new ArrayList<>();
    }

    @Override
    public  ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view =LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_date,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        viewHolder.daytime.setText(listDate.get(i));

        if(!listCardview.contains(viewHolder.card_date))
            listCardview.add(viewHolder.card_date);

        viewHolder.setiRecyclerItemSelectedListener(new IRecyclerItemSelectedListener() {
            @Override
            public void OnItemSelectedListenre(View view, int pos) {
                for(CardView cardView:listCardview)
                    cardView.setCardBackgroundColor(context.getResources().getColor(android.R.color.black));
                viewHolder.card_date.setCardBackgroundColor(context.getResources().getColor(android.R.color.holo_blue_dark));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDate.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView daytime;
        CardView card_date;

        IRecyclerItemSelectedListener iRecyclerItemSelectedListener;

        public void setiRecyclerItemSelectedListener(IRecyclerItemSelectedListener iRecyclerItemSelectedListener) {
            this.iRecyclerItemSelectedListener = iRecyclerItemSelectedListener;
        }

        public ViewHolder(View itemView)
        {
            super(itemView);

            card_date=(CardView) itemView.findViewById(R.id.card_date);
            daytime=(TextView) itemView.findViewById(R.id.daytime);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            iRecyclerItemSelectedListener.OnItemSelectedListenre(v,getAdapterPosition());
        }
    }


}
