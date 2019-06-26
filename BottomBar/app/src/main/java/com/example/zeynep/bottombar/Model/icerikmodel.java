package com.example.zeynep.bottombar.Model;

/**
 * Created by zeynep on 13.03.2018.
 */

public class icerikmodel {
   String urun_id;
    String urun_adi;
    String kategori_adi;
   String fiyat;

    public icerikmodel(String urun_id, String urun_adi, String kategori_adi,String fiyat) {
        this.urun_id = urun_id;
        this.urun_adi = urun_adi;
        this.kategori_adi = kategori_adi;
        this.fiyat = fiyat;
    }

    public String getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(String urun_id) {
        this.urun_id = urun_id;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public String getKategori_adi() {
        return kategori_adi;
    }

    public void setKategori_adi(String kategori_adi) {
        this.kategori_adi = kategori_adi;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }
}
