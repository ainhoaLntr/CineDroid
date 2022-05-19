package com.example.cinedroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

//réalisée par Marius
public class Reservation extends AppCompatActivity {

    private TextView tv_titreFilm;
    private Spinner s_horaires;
    private TextView tv_nbNormal;
    private TextView tv_nbEtudiant;
    private TextView tv_nbJeune;
    private Button b_plusNormal;
    private Button b_plusEtudiant;
    private Button b_plusJeune;
    private Button b_moinsNormal;
    private Button b_moinsEtudiant;
    private Button b_moinsJeune;
    private Button b_reserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        Serializable idFilm = getIntent().getSerializableExtra("id");

        tv_titreFilm = findViewById(R.id.tv_titreFilm);
        s_horaires = findViewById(R.id.s_horaires);
        tv_nbNormal = findViewById(R.id.tv_nbNormal);
        tv_nbEtudiant = findViewById(R.id.tv_nbEtudiant);
        tv_nbJeune = findViewById(R.id.tv_nbJeune);
        b_plusNormal = findViewById(R.id.b_plusNormal);
        b_plusEtudiant = findViewById(R.id.b_plusEtudiant);
        b_plusJeune = findViewById(R.id.b_plusJeune);
        b_moinsNormal = findViewById(R.id.b_moinsNormal);
        b_moinsEtudiant = findViewById(R.id.b_moinsEtudiant);
        b_moinsJeune = findViewById(R.id.b_moinsJeune);
        b_reserver = findViewById(R.id.b_reserver);

        FilmDAO film = new FilmDAO(getApplicationContext());

        tv_titreFilm.setText(film.getFilm(Long.parseLong(idFilm.toString())).getTitreF());

        SeanceDAO seances = new SeanceDAO(getApplicationContext());
        ArrayList<Seance> listeSeances = seances.getSeancesIdF(Long.parseLong(idFilm.toString()));
        ArrayAdapter<String> adapteurHoraires = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1);
        for (int i = 0; i < listeSeances.size(); i++) {
            adapteurHoraires.add(listeSeances.get(i).getHeureS());
        }
        s_horaires.setAdapter(adapteurHoraires);

        b_plusNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nbNormal = Integer.parseInt(tv_nbNormal.getText().toString());
                if (nbNormal < 9) {
                    nbNormal++;
                    tv_nbNormal.setText(String.valueOf(nbNormal));
                }
            }
        });

        b_moinsNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nbNormal = Integer.parseInt(tv_nbNormal.getText().toString());
                if (nbNormal > 0) {
                    nbNormal--;
                    tv_nbNormal.setText(String.valueOf(nbNormal));
                }
            }
        });

        b_plusEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nbEtudiant = Integer.parseInt(tv_nbEtudiant.getText().toString());
                if (nbEtudiant < 9) {
                    nbEtudiant++;
                    tv_nbEtudiant.setText(String.valueOf(nbEtudiant));
                }
            }
        });

        b_moinsEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nbEtudiant = Integer.parseInt(tv_nbEtudiant.getText().toString());
                if (nbEtudiant > 0) {
                    nbEtudiant--;
                    tv_nbEtudiant.setText(String.valueOf(nbEtudiant));
                }
            }
        });

        b_plusJeune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nbJeune = Integer.parseInt(tv_nbJeune.getText().toString());
                if (nbJeune < 9) {
                    nbJeune++;
                    tv_nbJeune.setText(String.valueOf(nbJeune));
                }
            }
        });

        b_moinsJeune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nbJeune = Integer.parseInt(tv_nbJeune.getText().toString());
                if (nbJeune > 0) {
                    nbJeune--;
                    tv_nbJeune.setText(String.valueOf(nbJeune));
                }
            }
        });

        b_reserver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double coutTotal = Long.parseLong(tv_nbNormal.getText().toString())*9.6
                                 + Long.parseLong(tv_nbEtudiant.getText().toString())*7
                                 + Long.parseLong(tv_nbJeune.getText().toString())*5;
                Intent intent = new Intent(getApplicationContext(), Bilan.class);
                intent.putExtra("nomFilm", tv_titreFilm.getText().toString());
                intent.putExtra("heureFilm", s_horaires.getSelectedItem().toString());
                intent.putExtra("total", String.valueOf(coutTotal));
                intent.putExtra("idFilm", String.valueOf(idFilm));
                startActivity(intent);
            }
        });
    }
}