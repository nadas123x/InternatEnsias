package com.example.internatensias;

public class demande
{
    String name,filiere,email,NumChambre,NumTel,purl;
    demande()
    {

    }
    public demande(String name, String filiere, String email, String NumChambre, String NumTel, String purl) {
        this.name = name;
        this.filiere = filiere;
        this.email = email;
        this.purl = purl;
        this.NumChambre=NumChambre;
        this.NumTel=NumTel;
    }




    public String getNumChambre() {
        return NumChambre;
    }

    public void setNumChambre(String numChambre) {
        NumChambre = numChambre;
    }

    public String getNumTel() {
        return NumTel;
    }

    public void setNumTel(String numTel) {
        NumTel = numTel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfiliere() {
        return filiere;
    }

    public void setfiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}
