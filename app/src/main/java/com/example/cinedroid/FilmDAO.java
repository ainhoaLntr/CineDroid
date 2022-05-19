package com.example.cinedroid;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

// réalisée par Aïnhoa
public class FilmDAO {
    private static String base = "BDCineDroid";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public FilmDAO(Context ct) { accesBD = new BdSQLiteOpenHelper(ct, base, null, version);}

    public Film getFilm(long idF) {
        Film leFilm = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery(
                "select * from film where idF=" + idF + ";",
                null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            leFilm = new Film(idF, curseur.getString(1), curseur.getString(2), curseur.getLong(3), curseur.getString(4));
        }
        return leFilm;
    }

    public ArrayList<Film> getFilms() {
        Cursor curseur;
        String req = "select * from film;";
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        return cursorToFilmArrayList(curseur);
    }

    private ArrayList<Film> cursorToFilmArrayList(Cursor curseur) {
        ArrayList<Film> listeFilms = new ArrayList<Film>();
        long idF;
        String titreF;
        String realF;
        long dureeF;
        String langueF;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            idF = curseur.getLong(0);
            titreF = curseur.getString(1);
            realF = curseur.getString(2);
            dureeF = curseur.getLong(3);
            langueF = curseur.getString(4);

            listeFilms.add(new Film(idF, titreF, realF, dureeF, langueF));
            curseur.moveToNext();
        }
        return listeFilms;
    }
}
