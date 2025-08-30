package Model;

import java.util.*;

public class Resep {
    private static final Map<Set<String>, String> resep = new HashMap<>();

    static {
        resep.put(Set.of("Paracetamol", "Dextromethorphan"), "Panadol");
        resep.put(Set.of("Paracetamol", "Antiistamin"), "Procold Flu");
        resep.put(Set.of("Dextromethorphan", "Anti-Inflamasi"), "Gratazon");
        resep.put(Set.of("Antasida", "Simetikon"), "Mylanta");
        resep.put(Set.of("Paracetamol", "Kafein"), "Bodrex");

        resep.put(Set.of("Paracetamol", "Gula"), "Panadol Anak");
        resep.put(Set.of("Dextromethorphan", "Madu"), "OBH Anak");
        resep.put(Set.of("Elektrolit", "Gula"), "Oralit");
        resep.put(Set.of("Cetirizine Hydrochloride", "Laktosa"), "Cetirizine Syrup");
    }

    public static String getCraftedItem(String bahan1, String bahan2) {
        Set<String> key = Set.of(bahan1, bahan2);
        return resep.get(key);
    }

    public void tampilkanResep() {
        System.out.println("\nDaftar Resep:");
        int i = 1;
        for (Map.Entry<Set<String>, String> entry : resep.entrySet()) {
            Set<String> bahan = entry.getKey();
            String obat = entry.getValue();
            System.out.printf("%2d. %-35s -> %s%n", i++, String.join(" + ", bahan), obat);
        }
        System.out.println();
    }
}