package com.example.pcportatil.shottyapp.attrs;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by PC portatil on 04/06/2017.
 */

public class Global {
    @BindingAdapter("app:imgUrl")
    public static void setImage(ImageView img , String url){
        Picasso.with(img.getContext()).load(Uri.parse(url))
                                        .into(img);
    }

}
