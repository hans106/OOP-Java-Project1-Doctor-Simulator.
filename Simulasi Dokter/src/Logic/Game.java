package Logic;

import java.util.*;
import Model.*;

public class Game {

    Random r = new Random();
    Scanner s = new Scanner(System.in);
    public int hari;

    String[] namaPasien = {
            "Budi", "Denis", "Adit", "Michael", "Gemini",
            "Claude", "Tarno", "Ralph", "Tim", "Seth",
    };

    String[] keluhanUmum = {
            "Demam",
            "Batuk",
            "Flu",
            "Sakit Kepala",
            "Sakit Perut",
    };

    String[] keluhanAnak = {
            "Demam",
            "Batuk",
            "Diare",
            "Ruam",
    };

    String[] keluhanPsikolog = {
            "Depresi",
            "Kecemasan",
            "Trauma",
            "Gangguan Makan",
    };

    ArrayList<Obat> list = new ArrayList<>();
    ArrayList<Pasien> pasienList = new ArrayList<>();
    ArrayList<Bahan> bahanList = new ArrayList<>();
    Resep resep = new Resep();

    public void start() {

        Dokter dokter = new DokterUmum("Hans", "Dokter Umum");
        hari = 1;

        list.add(new Obat("Panadol", 10));
        list.add(new Obat("Procold Flu", 10));
        list.add(new Obat("Grathazon", 10));
        list.add(new Obat("Mylanta", 10));
        list.add(new Obat("Bodrex", 10));

        list.add(new Obat("Panadol Anak", 10));
        list.add(new Obat("OBH Anak", 10));
        list.add(new Obat("Oralit", 10));
        list.add(new Obat("Cetirizine Syrup", 10));

        bahanList.add(new Bahan("Paracetamol"));
        bahanList.add(new Bahan("Antiistamin"));
        bahanList.add(new Bahan("Dextromethorphan"));
        bahanList.add(new Bahan("Anti-Inflamasi"));
        bahanList.add(new Bahan("Antasida"));
        bahanList.add(new Bahan("Simetikon"));
        bahanList.add(new Bahan("Kafein"));

        bahanList.add(new Bahan("Gula"));
        bahanList.add(new Bahan("Madu"));
        bahanList.add(new Bahan("Cetirizine Hydrochloride"));
        bahanList.add(new Bahan("Laktosa"));
        bahanList.add(new Bahan("Elektrolit"));

        menu(dokter);
        s.close();
    }

    public void menu(Dokter dokter) {
        System.out.println("Day " + hari);
        System.out.println("Selamat datang " + dokter.getNama() + "!");
        System.out.println("Spesialisasi: " + dokter.getSpesialisasi());
        System.out.println("Menu:");
        System.out.println("1. Tangani Pasien");
        System.out.println("2. Craft Obat");
        System.out.println("3. Pilih Spesialisasi Dokter");
        System.out.println("4. Keluar");
        System.out.print("> ");

        if (pasienList.size() == 0) {
            for (int i = 0; i < hari; i++) {
                pasienList.add(new Pasien(
                        namaPasien[r.nextInt(namaPasien.length)],
                        null));
            }
        }

        int pilihan = 0;
        try {
            pilihan = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka. Silakan coba lagi.");
            s.nextLine();
            menu(dokter);
            return;
        }

        switch (pilihan) {
            case 1:
                tanganiPasien(dokter);
                break;
            case 2:
                craftObat(dokter);
                break;
            case 3:
                if (hari < 5) {
                    System.out.println("Anda belum dapat memilih spesialisasi dokter.");
                    menu(dokter);
                } else {
                    dokter = offerSpecialization(dokter);
                    menu(dokter);
                }
                break;
            case 4:
                System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                menu(dokter);
                break;
        }
    }

    public void tanganiPasien(Dokter dokter) {
        if (dokter instanceof DokterUmum) {
            System.out.println("Menangani pasien: " + pasienList.get(0).getNama() + "\n");

            System.out.println("Dokter telah menangani pasien dan membuat resep obat.");
            pasienList.set(0, new Pasien(
                    pasienList.get(0).getNama(),
                    keluhanUmum[r.nextInt(keluhanUmum.length)]));
            System.out.println(
                    "Pasien " + pasienList.get(0).getNama() + " memiliki gejala " + pasienList.get(0).getKeluhan());
            String resep = dokter.berikanResep(pasienList.get(0).getKeluhan());
            System.out.println(resep);

            int lanjut = 0;
            do {
                System.out.println("Ketik 1 untuk melanjutkan ke apotek.");
                System.out.print("> ");
                try {
                    lanjut = s.nextInt();
                    if (lanjut != 1) {
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input harus berupa angka. Silakan coba lagi.");
                    s.nextLine();
                }
            } while (lanjut != 1);
            ambilObat(dokter);
        }

        if (dokter instanceof DokterAnak) {
            System.out.println("Menangani pasien: " + pasienList.get(0).getNama() + "\n");
            System.out.println("Dokter Anak telah menangani pasien dan membuat resep obat.");
            pasienList.set(0, new Pasien(
                    pasienList.get(0).getNama(),
                    keluhanAnak[r.nextInt(keluhanAnak.length)]));
            System.out.println(
                    "Pasien " + pasienList.get(0).getNama() + " memiliki gejala " + pasienList.get(0).getKeluhan());
            String resep = dokter.berikanResep(pasienList.get(0).getKeluhan());
            System.out.println(resep);

            int lanjut = 0;
            do {
                System.out.println("Ketik 1 untuk melanjutkan ke apotek.");
                System.out.print("> ");
                try {
                    lanjut = s.nextInt();
                    if (lanjut != 1) {
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input harus berupa angka. Silakan coba lagi.");
                    s.nextLine();
                }
            } while (lanjut != 1);
            ambilObat(dokter);
        }

        if (dokter instanceof DokterPsikolog) {
            System.out.println("Konseling dengan: " + pasienList.get(0).getNama());
            pasienList.set(0, new Pasien(
                    pasienList.get(0).getNama(),
                    keluhanPsikolog[r.nextInt(keluhanPsikolog.length)]));

            dokter.berikanResep(pasienList.get(0).getKeluhan());
            int choice = 0;
            do {
                System.out.print("Pilih terapi yang akan dilakukan: ");
                try {
                    choice = s.nextInt();
                    if (choice < 1 || choice > 3) {
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input harus berupa angka. Silakan coba lagi.");
                    s.nextLine();
                    choice = 0;
                }
            } while (choice < 1 || choice > 3);

            System.out.println("Terapi telah dilakukan, pasien merasa lebih baik.");
            System.out.println("\n" + ((DokterPsikolog) dokter).getRandomNote());

            pasienList.remove(0);
            cekAntrian(pasienList, dokter);
        }
    }

    public void ambilObat(Dokter dokter) {
        displayObatList();

        int pilihanObat = 0;
        while (true) {
            System.out.print("Masukkan obat yang ingin diberikan (masukkan nomor): ");
            try {
                pilihanObat = s.nextInt();
                if (pilihanObat < 1 || pilihanObat > list.size()) {
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                s.nextLine();
            }
        }

        if (list.get(pilihanObat - 1).getStok() <= 0) {
            System.out.println("Stok obat " + list.get(pilihanObat - 1).getNamaObat()
                    + " habis. Silakan buat obat terlebih dahulu.");
            craftObat(dokter);
            return;
        }

        if (dokter instanceof DokterUmum) {
            switch (pasienList.get(0).getKeluhan()) {
                case "Demam":
                    terimaObat(dokter, pilihanObat, "Panadol");
                    break;
                case "Batuk":
                    terimaObat(dokter, pilihanObat, "Grathazon");
                    break;
                case "Flu":
                    terimaObat(dokter, pilihanObat, "Procold Flu");
                    break;
                case "Sakit Kepala":
                    terimaObat(dokter, pilihanObat, "Bodrex");
                    break;
                case "Sakit Perut":
                    terimaObat(dokter, pilihanObat, "Mylanta");
                    break;
                default:
                    System.out.println("Keluhan tidak dikenali");
                    menu(dokter);
            }
        }

        if (dokter instanceof DokterAnak) {
            switch (pasienList.get(0).getKeluhan()) {
                case "Demam":
                    terimaObat(dokter, pilihanObat, "Panadol Anak");
                    break;
                case "Batuk":
                    terimaObat(dokter, pilihanObat, "OBH Anak");
                    break;
                case "Diare":
                    terimaObat(dokter, pilihanObat, "Oralit");
                    break;
                case "Ruam":
                    terimaObat(dokter, pilihanObat, "Cetirizine Syrup");
                    break;
                default:
                    System.out.println("Keluhan anak tidak dikenali.");
                    menu(dokter);
            }
        }

        cekAntrian(pasienList, dokter);
    }

    public void cekAntrian(ArrayList<Pasien> pasienList, Dokter dokter) {
        if (pasienList.size() == 0) {
            hari++;
            menu(dokter);
        } else {
            System.out.println("\nMenangani pasien berikutnya (" + pasienList.size() + " pasien tersisa hari ini)\n");
            tanganiPasien(dokter);
        }
    }

    public void craftObat(Dokter dokter) {
        displayObatList();

        int pilihanObat = 0;
        while (true) {
            System.out.print("Masukkan nomor obat yang ingin dibuat: ");
            try {
                pilihanObat = s.nextInt();
                if (pilihanObat < 1 || pilihanObat > list.size()) {
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                s.nextLine();
            }
        }

        Obat obatDipilih = list.get(pilihanObat - 1);

        System.out.println("\nCrafting " + obatDipilih.getNamaObat() + "...");

        resep.tampilkanResep();

        int indexBahan = 1;
        for (Bahan bahan : bahanList) {
            System.out.println(indexBahan + ". " + bahan.getNamaBahan());
            indexBahan++;
        }

        int pilihanBahan = 0;
        Bahan bahanDipilih = null;
        while (true) {
            System.out.print("Masukkan nomor bahan yang ingin digunakan: ");
            try {
                pilihanBahan = s.nextInt();
                if (pilihanBahan < 1 || pilihanBahan > bahanList.size()) {
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    continue;
                }
                bahanDipilih = bahanList.get(pilihanBahan - 1);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                s.nextLine();
            }
        }
        System.out.println("Bahan pertama yang digunakan: " + bahanDipilih.getNamaBahan());

        Bahan bahanDipilih2 = null;
        while (true) {
            System.out.print("Masukkan nomor bahan kedua yang ingin digunakan: ");
            try {
                pilihanBahan = s.nextInt();
                if (pilihanBahan < 1 || pilihanBahan > bahanList.size()) {
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    continue;
                }
                bahanDipilih2 = bahanList.get(pilihanBahan - 1);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                s.nextLine();
            }
        }
        System.out.println("Bahan kedua yang digunakan: " + bahanDipilih2.getNamaBahan());

        Obat craftedObat = obatDipilih.craft(bahanDipilih, bahanDipilih2);

        if (craftedObat != null) {
            obatDipilih.setStok(obatDipilih.getStok() + 1);
            System.out.println(
                    "Obat " + craftedObat.getNamaObat() + " telah dibuat. Stok sekarang: " + obatDipilih.getStok());
        } else {
            System.out.println("Bahan tidak valid untuk crafting obat.");
            craftObat(dokter);
        }

        menu(dokter);
    }

    public void terimaObat(Dokter dokter, int pilihanObat, String match) {
        if (list.get(pilihanObat - 1).getNamaObat().equals(match)) {
            System.out.println("Obat " + list.get(pilihanObat - 1).getNamaObat() + " telah dibuat.");
            list.get(pilihanObat - 1).setStok(list.get(pilihanObat - 1).getStok() - 1);
            pasienList.remove(0);
        } else {
            System.out.println("\nObat yang dipilih tidak sesuai dengan keluhan pasien.\n");
            ambilObat(dokter);
        }
    }

    private void displayObatList() {
        System.out.println("Daftar obat yang tersedia:");
        int index = 1;
        for (Obat obat : list) {
            System.out.println(index + ". " + obat.getNamaObat() + " (Stok: " + obat.getStok() + ")");
            index++;
        }
    }

    public Dokter offerSpecialization(Dokter dokter) {
        System.out.println("\nPilih spesialisasi dokter:");
        System.out.println("1. Dokter Anak");
        System.out.println("2. Dokter Psikolog");
        System.out.println("3. Dokter Umum");
        System.out.print("> ");

        int choice = 0;
        try {
            choice = s.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka. Silakan coba lagi.");
            s.nextLine();
            return offerSpecialization(dokter);
        }

        switch (choice) {
            case 1:
                dokter = new DokterAnak(dokter.getNama(), "Dokter Anak");
                System.out.println("Anda sekarang menjadi Dokter Anak!");
                break;
            case 2:
                dokter = new DokterPsikolog(dokter.getNama(), "Dokter Psikolog");
                System.out.println("Anda sekarang menjadi Dokter Psikolog!");
                break;
            case 3:
                dokter = new DokterUmum(dokter.getNama(), "Dokter Umum");
                System.out.println("Anda memilih tetap sebagai Dokter Umum.");
                break;
            default:
                System.out.println("Pilihan tidak valid, silakan coba lagi.");
                offerSpecialization(dokter);
                break;
        }
        System.out.println("");

        return dokter;
    }
}