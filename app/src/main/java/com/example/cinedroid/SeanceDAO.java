package com.example.cinedroid;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

// réalisée par Aïnhoa
public class SeanceDAO {
    private static String base = "BDCineDroid";
    private static int version = 1;
    private BdSQLiteOpenHelper accesBD;

    public SeanceDAO(Context ct) { accesBD = new BdSQLiteOpenHelper(ct, base, null, version);}

    public Seance getSeance(long idS) {
        Seance laSeance = null;
        Cursor curseur;
        curseur = accesBD.getReadableDatabase().rawQuery(
                "select * from seance where idS=" + idS + ";",
                null);
        if (curseur.getCount() > 0) {
            curseur.moveToFirst();
            laSeance = new Seance(idS, curseur.getString(1), curseur.getLong(2));
        }
        return laSeance;
    }

    public ArrayList<Seance> getSeances() {
        Cursor curseur;
        String req = "select * from seance;";
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        return cursorToSeanceArrayList(curseur);
    }

    public ArrayList<Seance> getSeancesIdF(long idF) {
        Cursor curseur;
        String req = "select * from seance where idF=" + idF + ";";
        curseur = accesBD.getReadableDatabase().rawQuery(req, null);
        return cursorToSeanceArrayList(curseur);
    }

    private ArrayList<Seance> cursorToSeanceArrayList(Cursor curseur) {
        ArrayList<Seance> listeSeances = new ArrayList<Seance>();
        long idS;
        String heureS;
        long idF;

        curseur.moveToFirst();
        while (!curseur.isAfterLast()) {
            idS = curseur.getLong(0);
            heureS = curseur.getString(1);
            idF = curseur.getLong(2);
            listeSeances.add(new Seance(idS, heureS, idF));
            curseur.moveToNext();
        }
        return listeSeances;
    }
}
