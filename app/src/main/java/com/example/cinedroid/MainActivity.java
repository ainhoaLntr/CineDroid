package com.example.cinedroid;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ll_listeSeances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll_listeSeances = findViewById(R.id.ll_listeSeances);

        FilmDAO listeFilmDAO = new FilmDAO(this);
        ArrayList<Film> lstFilms = listeFilmDAO.getFilms();
        for (int i = 0; i < lstFilms.size(); i++) {
            afficherSeances(lstFilms.get(i).getIdF(), lstFilms.get(i).getTitreF(), lstFilms.get(i).getRealF(), lstFilms.get(i).getDureeF(), lstFilms.get(i).getLangueF());
        }
    }

    // réalisée par Aïnhoa
    @SuppressLint("NewApi")
    public void afficherSeances(long id, String titre, String real, long duree, String langue) {
        // layout d'une séance
        LinearLayout linear_seance = new LinearLayout(getApplicationContext());

        LinearLayout.LayoutParams layoutParamsLlSeance
                = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        layoutParamsLlSeance.setMargins(40, 20, 40, 20);
        linear_seance.setLayoutParams(layoutParamsLlSeance);

        linear_seance.setBackgroundColor(getColor(R.color.grey));
        linear_seance.setOrientation(LinearLayout.HORIZONTAL);

        linear_seance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Reservation.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        // image par défaut
        LinearLayout linear_image = new LinearLayout(getApplicationContext());
        layoutParamsLlSeance.setMargins(40, 20, 40, 20);

        linear_image.setOrientation(LinearLayout.VERTICAL);

        ImageView imgFilm = new ImageView(getApplicationContext());

        LinearLayout.LayoutParams layoutParamsImg
                = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        layoutParamsImg.setMargins(25, 25, 25, 25);
        imgFilm.setLayoutParams(layoutParamsImg);

        imgFilm.setImageDrawable(getDrawable(R.drawable.dune));

        linear_image.addView(imgFilm);

        // layout des info d'une séance : nomF, real, duree et langue
        LinearLayout linear_info = new LinearLayout(getApplicationContext());

        LinearLayout.LayoutParams layoutParamsLlInfo
                = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        linear_info.setLayoutParams(layoutParamsLlInfo);
        linear_info.setOrientation(LinearLayout.VERTICAL);

        // paramètres des textview
        LinearLayout.LayoutParams layoutParamsText
                = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParamsText.setMargins(0, 35, 0, 10);

        // nom du film
        TextView nomF = new TextView(getApplicationContext());
        nomF.setLayoutParams(layoutParamsText);
        nomF.setText(titre);
        nomF.setTextSize(26);

        // realisateur du film
        TextView realF = new TextView(getApplicationContext());
        realF.setLayoutParams(layoutParamsText);
        realF.setText(real);
        realF.setTextSize(26);
        nomF.setTypeface(Typeface.DEFAULT_BOLD);

        // layout pour la durée et la langue
        LinearLayout linear_DL = new LinearLayout(getApplicationContext());

        LinearLayout.LayoutParams layoutParamsLlDL
                = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        linear_DL.setLayoutParams(layoutParamsLlDL);
        linear_DL.setOrientation(LinearLayout.HORIZONTAL);

        // duree du film
        TextView dureeF = new TextView(getApplicationContext());
        dureeF.setLayoutParams(layoutParamsText);
        dureeF.setText(String.valueOf(calculDuree(duree)));
        dureeF.setTextSize(26);

        // ajout des infos dans le layout d'info
        linear_info.addView(nomF);
        linear_info.addView(realF);

        // langue du film
        TextView languef = new TextView(getApplicationContext());
        languef.setLayoutParams(layoutParamsText);
        languef.setText(langue);
        languef.setTextSize(26);
        languef.setPadding(220, 0, 0, 0);

        // ajout de la langue dans le layout de la langue
        linear_DL.addView(dureeF);
        linear_DL.addView(languef);

        linear_info.addView(linear_DL);

        // ajout du layout d'info dans le layout de seance
        linear_seance.addView(linear_image);
        linear_seance.addView(linear_info);

        // ajout de la seance dans le layout du scrollview
        ll_listeSeances.addView(linear_seance);
    }

    // réalisée par Marius
    private String calculDuree(long temps) {
            String heure;
            String minutes;
            long heu = temps/60;
            if (heu < 10)
            {
                heure = "0" + heu;
            }
            else
            {
                heure = Long.toString(heu);
            }
            long min = temps % 60;
            if (min == 0) {
                minutes = "00";
            }
            else
            {
                minutes = Long.toString(min);
            }
        return  heure + ':' + minutes;
    }
}