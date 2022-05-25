package com.example.internatensias;

public class demande
{
    String nom,email,NumTel,content;
    demande()
    {

    }
    public demande(String nom, String email, String NumTel, String content) {
        this.nom = nom;
        this.email = email;
        this.content = content;
        this.NumTel=NumTel;
    }






    public String getNumTel() {
        return NumTel;
    }

    public void setNumTel(String numTel) {
        NumTel = numTel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
