package com.example.cinedroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

// réalisée par Aïnhoa
public class BdSQLiteOpenHelper extends SQLiteOpenHelper {
    private String table_film = "create table film("
            + "idF INTEGER PRIMARY KEY,"
            + "titreF TEXT NOT NULL,"
            + "realF TEXT NOT NULL,"
            + "dureeF INTEGER,"
            + "langueF TEXT NOT NULL);";

    private String table_seance = "create table seance("
            + "idS INTEGER PRIMARY KEY,"
            + "heureS TEXT NOT NULL,"
            + "idF INTEGER,"
            + "foreign key (idF) references film(idF));";

    private String table_avis = "create table avis("
            + "idA INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "idF INTEGER NOT NULL,"
            + "note NUMERIC,"
            + "commentaire TEXT NOT NULL);";

    public BdSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_film);
        db.execSQL(table_seance);

        db.execSQL("insert into film (idF, titreF, realF, dureeF, langueF) values(1, 'Inception', 'Ridley Scott', 200, 'VO')");
        db.execSQL("insert into film (idF, titreF, realF, dureeF, langueF) values(2, 'Batman', 'Steven Spielberg', 180, 'VO')");
        db.execSQL("insert into film (idF, titreF, realF, dureeF, langueF) values(3, 'Spiderman', 'Jacques Dupre', 120, 'VF')");
        db.execSQL("insert into film (idF, titreF, realF, dureeF, langueF) values(4, 'Prestige', 'Martin Bonhomme', 80, 'VOSTFR')");
        db.execSQL("insert into film (idF, titreF, realF, dureeF, langueF) values(5, 'Robin des bois', 'Ainhoa Dupontel', 190, 'VF')");
        db.execSQL("insert into film (idF, titreF, realF, dureeF, langueF) values(6, 'Dune', 'Guigui', 200, 'VF')");

        db.execSQL("insert into seance (idS, heureS, idF) values(1, '10h00', 4)");
        db.execSQL("insert into seance (idS, heureS, idF) values(2, '10h30', 2)");
        db.execSQL("insert into seance (idS, heureS, idF) values(3, '17h00', 1)");
        db.execSQL("insert into seance (idS, heureS, idF) values(4, '20h30', 5)");
        db.execSQL("insert into seance (idS, heureS, idF) values(5, '22h00', 3)");
        db.execSQL("insert into seance (idS, heureS, idF) values(6, '11h00', 4)");
        db.execSQL("insert into seance (idS, heureS, idF) values(7, '17h30', 2)");
        db.execSQL("insert into seance (idS, heureS, idF) values(8, '14h00', 1)");
        db.execSQL("insert into seance (idS, heureS, idF) values(9, '15h30', 5)");
        db.execSQL("insert into seance (idS, heureS, idF) values(10, '11h00', 3)");
        db.execSQL("insert into seance (idS, heureS, idF) values(11, '20h00', 4)");
        db.execSQL("insert into seance (idS, heureS, idF) values(12, '21h30', 2)");
        db.execSQL("insert into seance (idS, heureS, idF) values(13, '19h00', 1)");
        db.execSQL("insert into seance (idS, heureS, idF) values(14, '16h30', 5)");
        db.execSQL("insert into seance (idS, heureS, idF) values(15, '19h00', 3)");
    }

    //public void insererCommentaire(double note, String com, int idFilm) {
    //    base.execSQL("insert into avis (idF, note, commentaire) values(idFilm, note, com)");
    //    Log.d("test", String.valueOf(note));
    //}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("update film SET langueF = VF where idF = 4");
        onCreate(sqLiteDatabase);
    }
}
