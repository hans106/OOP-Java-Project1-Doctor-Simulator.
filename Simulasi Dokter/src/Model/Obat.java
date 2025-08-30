package Model;

import Interface.Craftable;

public class Obat implements Craftable {

    private String namaObat;
    private int stok;

    public Obat(String namaObat, int stok) {
        this.namaObat = namaObat;
        this.stok = stok;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public Obat craft(Bahan bahan1, Bahan bahan2) {
        String craftedName = Resep.getCraftedItem(bahan1.getNamaBahan(), bahan2.getNamaBahan());
        return (craftedName != null) ? new Obat(craftedName, 1) : null;
    }
}
