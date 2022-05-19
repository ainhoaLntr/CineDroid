package com.example.cinedroid;

// réalisée par Aïnhoa
public class Film {
    private long idF;
    private String titreF;
    private String realF;
    private long dureeF;
    private String langueF;

    public Film(long idF, String titreF, String realF, long dureeF, String langueF) {
        this.idF = idF;
        this.titreF = titreF;
        this.realF = realF;
        this.dureeF = dureeF;
        this.langueF = langueF;
    }

    public long getIdF() {
        return idF;
    }

    public void setIdF(long idF) {
        this.idF = idF;
    }

    public String getTitreF() {
        return titreF;
    }

    public void setTitreF(String titreF) {
        this.titreF = titreF;
    }

    public String getRealF() {
        return realF;
    }

    public void setRealF(String realF) {
        this.realF = realF;
    }

    public long getDureeF() {
        return dureeF;
    }

    public void setDureeF(long dureeF) {
        this.dureeF = dureeF;
    }

    public String getLangueF() {
        return langueF;
    }

    public void setLangueF(String langueF) {
        this.langueF = langueF;
    }

    @Override
    public String toString() {
        return "Film{" +
                "idF=" + idF +
                ", titreF='" + titreF + '\'' +
                ", realF='" + realF + '\'' +
                ", dureeF=" + dureeF +
                ", langueF='" + langueF + '\'' +
                '}';
    }
}
