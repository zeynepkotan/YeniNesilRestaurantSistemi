package com.example.zeynep.bottombar.Model;

/**
 * Created by zeynep on 13.04.2018.
 */

public class SepetModel {
    int porsiyon;
    String isim;
    int fiyat;
    int urun_id;

    public SepetModel(int porsiyon, String isim, int fiyat, int urun_id) {
        this.porsiyon = porsiyon;
        this.isim = isim;
        this.fiyat = fiyat;
        this.urun_id = urun_id;
    }

    public int getPorsiyon() {
        return porsiyon;
    }

    public void setPorsiyon(int porsiyon) {
        this.porsiyon = porsiyon;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }
}
