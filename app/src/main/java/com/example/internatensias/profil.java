package com.example.internatensias;

public class profil
{
    String name,email,adress,NumTel,purl;
    profil()
    {

    }
    public profil(String name, String email, String adress,String NumTel,String purl) {
        this.name = name;
        this.email = email;

        this.adress=adress;
        this.NumTel=NumTel;
        this.purl = purl;
    }




    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        adress = adress;
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
