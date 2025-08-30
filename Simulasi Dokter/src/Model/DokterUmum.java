package Model;

public class DokterUmum extends Dokter {

    public DokterUmum(String nama, String spesialisasi) {
        super(nama, spesialisasi);
    }

    @Override
    public String berikanResep(String keluhan) {
        return switch (keluhan.toLowerCase()) {
            case "demam" -> "Resep: Panadol 500mg 3x sehari";
            case "batuk" -> "Resep: Grathazon 3x sehari";
            case "flu" -> "Resep: Procold Flu 3x sehari";
            case "sakit kepala" -> "Resep: Bodrex 3-4x sehari";
            case "sakit perut" -> "Resep: Mylanta 5-10ml 3-4x sehari";

            default -> "Istirahat dan observasi";
        };
    }
}
