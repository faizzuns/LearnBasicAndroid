package com.user.profileapplication;

public class Friend {
    private String nama;
    private int umur;
    private String tingkatan;

    public Friend() {
    }

    public Friend(String nama, int umur, String tingkatan) {
        this.nama = nama;
        this.umur = umur;
        this.tingkatan = tingkatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getTingkatan() {
        return tingkatan;
    }

    public void setTingkatan(String tingkatan) {
        this.tingkatan = tingkatan;
    }
}
