package com.example.cinedroid;

// réalisée par Aïnhoa
public class Avis {
    private long idA;
    private long idF;
    private float note;
    private String commentaire;

    public Avis(long idA, long idF, float note, String commentaire) {
        this.idA = idA;
        this.idF = idF;
        this.note = note;
        this.commentaire = commentaire;
    }

    public long getIdA() {
        return idA;
    }

    public void setIdA(long idA) {
        this.idA = idA;
    }

    public long getIdF() {
        return idF;
    }

    public void setIdF(long idF) {
        this.idF = idF;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Avis{" +
                "idA=" + idA +
                ", idF=" + idF +
                ", note=" + note +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
