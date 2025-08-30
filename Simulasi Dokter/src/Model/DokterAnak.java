package Model;

public class DokterAnak extends Dokter {

    public DokterAnak(String nama, String spesialisasi) {
        super(nama, spesialisasi);
    }

    @Override
    public String berikanResep(String keluhan) {
        return switch (keluhan.toLowerCase()) {
            case "demam" -> "Resep: Panadol 250 mg, 3x sehari";
            case "batuk" -> "Resep: OBH 3x sehari";
            case "diare" -> "Resep: Oralit 5ml, 3x sehari";
            case "ruam" -> "Resep: Cetirizine 5mg, 1x sehari";
            default -> "Istirahat dan observasi";
        };
    }
}
