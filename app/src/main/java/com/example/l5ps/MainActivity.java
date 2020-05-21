package com.example.l5ps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etSong,etSingers,etYear;
    Button btnInsert, btnShowList;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSong = findViewById(R.id.etSong);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);
        rg = findViewById(R.id.rgStars);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String song = etSong.getText().toString().trim();
                String singers = etSingers.getText().toString().trim();
                String years = etYear.getText().toString().trim();

                if (song.length() == 0){
                    return;
                } else if (singers.length() == 1){
                    return;
                }else if (years.length() == 2){
                    return;
                }

                DBHelper dbh = new DBHelper(MainActivity.this);
                if (dbh.isExistingNote(etSong.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Same note already exists", Toast.LENGTH_LONG).show();
                } else {
                    String data = etSong.getText().toString();
                    int stars = getStars();
                    dbh.insertSong(data, stars);
                    Toast.makeText(MainActivity.this, "Song Inserted successfully", Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent(MainActivity.this,ShowSongActivity.class);
                boolean target = false;
                i.putExtra("songs",target);
                startActivityForResult(i, 9);
            }
        });
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
}
