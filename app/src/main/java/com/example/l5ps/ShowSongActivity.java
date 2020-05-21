package com.example.l5ps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class ShowSongActivity extends AppCompatActivity {
    ListView lv;
    SongsArrayAdapter adapter;
    ArrayList<Song> al;
    Button btnShow,btnRetrieve;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_song);

        lv = (ListView) this.findViewById(R.id.lv);
        al = new ArrayList<Song>();
        btnShow = findViewById(R.id.btnShow);


        DBHelper dbh = new DBHelper(this);
        ArrayList<Song> notes = dbh.getAllSong();

        adapter = new SongsArrayAdapter(this, R.layout.showsongrow, notes);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(ShowSongActivity.this,
                        ModifySongActivity.class);
                boolean target = false;
                i.putExtra("data", target);
                startActivityForResult(i, 9);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(ShowSongActivity.this);
                int stars = getStars();
                if (stars >4){
                    btnShow.performClick();
                }

            }

            private int getStars() {
                    int stars = 1;
                    switch (rg.getCheckedRadioButtonId()) {
                        case R.id.rb1:
                            stars = 1;
                            break;
                        case R.id.rb2:
                            stars = 2;
                            break;
                        case R.id.rb3:
                            stars = 3;
                            break;
                        case R.id.rb4:
                            stars = 4;
                            break;
                        case R.id.rb5:
                            stars = 5;
                            break;
                    }
                    return stars;
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9){
            btnRetrieve.performClick();
        }
    }

}
