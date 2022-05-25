package com.example.internatensias;

public class modelDem {
    String Nom, Numtel, email, contenu;

    modelDem() {
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getNumtel() {
        return Numtel;
    }

    public void setNumtel(String numtel) {
        Numtel = numtel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public modelDem(String nom, String numtel, String email, String contenu) {
        Nom = nom;
        Numtel = numtel;
        this.email = email;
        this.contenu = contenu;
    }
}