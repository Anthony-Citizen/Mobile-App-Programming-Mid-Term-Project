package com.example.anthonyrafael_00000038087_if570_al_uts;

import java.io.Serializable;

public class SoundSource implements Serializable {
    private String judul;
    private String kategori;
    private String soundURI;

    public SoundSource (String judul, String kategori, String soundURI) {
         this.judul = judul;
         this.kategori = kategori;
         this.soundURI = soundURI;
    }

    public String getJudul() {
        return this.judul;
    }

    public String getKategori() {
        return this.kategori;
    }

    public String getSoundURI() {
        return this.soundURI;
    }

    public void  setSoundURI(String soundURI) {
        this.soundURI = soundURI;
    }

    @Override
    public String toString() {
        return this.getJudul() + " => " + this.getKategori();
    }
}
