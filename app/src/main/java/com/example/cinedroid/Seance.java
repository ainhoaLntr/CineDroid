package com.example.cinedroid;

// réalisée par Aïnhoa
public class Seance {
    private long ifS;
    private String heureS;
    private long idF;

    public Seance(long ifS, String heureS, long idF) {
        this.ifS = ifS;
        this.heureS = heureS;
        this.idF = idF;
    }

    public long getIfS() {
        return ifS;
    }

    public void setIfS(long ifS) {
        this.ifS = ifS;
    }

    public String getHeureS() {
        return heureS;
    }

    public void setHeureS(String heureS) {
        this.heureS = heureS;
    }

    public long getIdF() {
        return idF;
    }

    public void setIdF(long idF) {
        this.idF = idF;
    }

    @Override
    public String toString() {
        return "Seance{" +
                "ifS=" + ifS +
                ", heureS='" + heureS + '\'' +
                ", idF=" + idF +
                '}';
    }
}
