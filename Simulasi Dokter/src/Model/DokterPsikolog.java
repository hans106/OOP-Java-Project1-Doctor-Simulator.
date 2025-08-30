package Model;

import java.util.Random;

public class DokterPsikolog extends Dokter {
    private Random random = new Random();

    public DokterPsikolog(String nama, String spesialisasi) {
        super(nama, spesialisasi);
    }

    @Override
    public String berikanResep(String keluhan) {
        String[] terapiOptions = getTerapiOptions(keluhan.toLowerCase());

        System.out.println("Diagnosis: " + keluhan + "\n");
        System.out.println("Rekomendasi Terapi: ");
        for (int i = 0; i < terapiOptions.length; i++) {
            System.out.println((i + 1) + ". " + terapiOptions[i]);
        }

        return null;
    }

    private String[] getTerapiOptions(String keluhan) {
        return switch (keluhan) {
            case "depresi" -> new String[] {
                    "Terapi Kognitif-Perilaku (CBT)",
                    "Terapi Interpersonal",
                    "Terapi Psikodinamik"
            };
            case "kecemasan" -> new String[] {
                    "Terapi Eksposur",
                    "Terapi Relaksasi",
                    "Mindfulness-Based Therapy"
            };
            case "trauma" -> new String[] {
                    "EMDR (Eye Movement Desensitization and Reprocessing)",
                    "Terapi Naratif",
                    "Terapi Pemrosesan Kognitif"
            };
            case "gangguan makan" -> new String[] {
                    "Terapi Perilaku Dialektis (DBT)",
                    "Terapi Keluarga",
                    "Terapi Kognitif-Perilaku khusus ED"
            };
            default -> new String[] {
                    "Konseling Supportif",
                    "Terapi Psikodinamik Brief",
                    "Terapi Berpusat pada Klien"
            };
        };
    }
    public String getRandomNote() {
        String[] notes = {
                "Pasien menunjukkan peningkatan dalam mengidentifikasi pola pikir negatif",
                "Perlu lebih banyak latihan relaksasi di rumah",
                "Pasien mulai membuka diri tentang trauma masa kecil",
        };
        return notes[random.nextInt(notes.length)];
    }
}