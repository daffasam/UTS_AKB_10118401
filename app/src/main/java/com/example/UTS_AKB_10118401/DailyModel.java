package com.example.UTS_AKB_10118401;

// Tanggal Pengerjaan : 23 Mei 2022
// Nama : Daffa Sacofi Mutawakkil
// NIM : 10118401
// Kelas : IF-6

public class DailyModel {
    private int imgSrc;
    private String nama;

    public DailyModel(int imgSrc, String nama) {
        this.imgSrc = imgSrc;
        this.nama = nama;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
