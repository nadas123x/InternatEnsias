package com.example.internatensias;

public class modelProblem {
    String NomRésidant,type,contexte,purl;
    modelProblem(){
    }
    public modelProblem(String NomRésidant, String type, String contexte,String purl) {
       this.NomRésidant=NomRésidant;
        this.type = type;
        this.contexte = contexte;
        this.purl=purl;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getNomRésidant() {
        return NomRésidant;
    }

    public void setNomRésidant(String nomRésidant) {
        NomRésidant = nomRésidant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContexte() {
        return contexte;
    }

    public void setContexte(String contexte) {
        this.contexte = contexte;
    }
}
