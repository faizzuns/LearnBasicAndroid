package com.user.profileapplication;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDatabase.class)
public class Friend extends BaseModel {
    @PrimaryKey
    @Column
    private String nama;
    @Column
    private int umur;
    @Column
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
