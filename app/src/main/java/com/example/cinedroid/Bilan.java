package com.example.cinedroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.Serializable;

// réalisée par Marius
public class Bilan extends AppCompatActivity {

    private TextView tv_nomFilm;
    private TextView tv_heureSeance;
    private TextView tv_coutTotal;
    private Button b_enregistrer;
    private RatingBar rb_note;
    private EditText et_commentaires;
    //private double note;
    //private BdSQLiteOpenHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilan);

        tv_nomFilm = findViewById(R.id.tv_nomFilm);
        tv_heureSeance = findViewById(R.id.tv_heureSeance);
        tv_coutTotal = findViewById(R.id.tv_coutTotal);
        b_enregistrer = findViewById(R.id.b_enregistrer);
        rb_note = findViewById(R.id.rb_note);
        et_commentaires = findViewById(R.id.et_commentaires);

        Serializable nomFilm = getIntent().getSerializableExtra("nomFilm");
        Serializable horaires = getIntent().getSerializableExtra("heureFilm");
        Serializable total = getIntent().getSerializableExtra("total");
        Serializable idFilm = getIntent().getSerializableExtra("idFilm");

        tv_nomFilm.setText(nomFilm.toString());
        tv_heureSeance.setText("Séance de " + horaires.toString());
        tv_coutTotal.setText("Coût total : " + total.toString() + " €");

        b_enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //bd.insererCommentaire(note, et_commentaires.getText().toString(), Integer.parseInt(idFilm.toString()));
            }
        });

        rb_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RatingBar rb = (RatingBar) v;
                //note = rb.getRating();
            }
        });

        rb_note.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float newRating, boolean fromUser) {
                //note = newRating;
            }
        });
    }
}