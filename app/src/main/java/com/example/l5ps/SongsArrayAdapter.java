package com.example.l5ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class SongsArrayAdapter extends ArrayAdapter<Song> {
    Context context;
    ArrayList<Song> songs;
    int resource;
    ImageView iv1, iv2, iv3, iv4, iv5;


    public SongsArrayAdapter(@NonNull Context context, int resource, ArrayList<Song> songs) {
        super(context, resource, songs);
        this.context = context;
        this.resource = resource;
        this.songs = songs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        TextView tvYear = (TextView) rowView.findViewById(R.id.tvYear);
        TextView tvTitle = (TextView) rowView.findViewById(R.id.tvTitle);
        TextView tvSingers = (TextView) rowView.findViewById(R.id.tvSingers);


        ImageView iv1 = (ImageView) rowView.findViewById(R.id.imageView1star);
        ImageView iv2 = (ImageView) rowView.findViewById(R.id.imageView2star);
        ImageView iv3 = (ImageView) rowView.findViewById(R.id.imageView3star);
        ImageView iv4 = (ImageView) rowView.findViewById(R.id.imageView4star);
        ImageView iv5 = (ImageView) rowView.findViewById(R.id.imageView5star);

        Song note = songs.get(position);
        tvYear.setText(note.getYear());
        tvTitle.setText(note.getTitle());
        tvSingers.setText(note.getSingers());

        //Check if the property for starts == 5, if so, "light" up the stars
        if (note.getStars() == 5) {
            iv5.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (note.getStars() == 4) {
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (note.getStars() == 3) {
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if (note.getStars() == 2) {
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else {
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }

        return rowView;
    }
}
