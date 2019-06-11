package com.example.movieticketbookingapp.databinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.movieticketbookingapp.R;



public class GlideBindingApdater {
    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView view, int imageUrl){

        Context context = view.getContext();

        RequestOptions option = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .setDefaultRequestOptions(option)
                .load(imageUrl)
                .into(view);
    }


    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView view, String imageUrl){

        Context context = view.getContext();

        RequestOptions option = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .setDefaultRequestOptions(option)
                .load(imageUrl)
                .into(view);
    }
}

