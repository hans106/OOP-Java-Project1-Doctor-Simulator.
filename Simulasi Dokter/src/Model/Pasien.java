package Model;

public class Pasien {
    private String nama;
    private String keluhan;

    public Pasien(String nama, String keluhan) {
        this.nama = nama;
        this.keluhan = keluhan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

}
