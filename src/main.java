class Main {
    public static void main(String[] args) {
        Dokter dokterBedah = new Dokter("D-001", "And", "Bedah", 300000);
        Dokter dokterUmum = new Dokter("D-002", "Sari", "Umum");
        Perawat perawatMalam = new Perawat("P-001", "Rina", "Malam");
        Apoteker apoteker = new Apoteker("A-001", "Bima");

        Diperiksa pemeriksaAwal = new Perawat("P-002", "Dewi");
        Diperiksa pemeriksaLanjut = dokterUmum;

        Pasien joko = new Pasien("RM-01", "Joko", "Flu ringan", 2);
        Pasien mira = new Pasien("RM-02", "Mira", "Demam tinggi", 5);
        Pasien tono = new Pasien("RM-03", "Tono", "Usus buntu", 9);
        Pasien lina = new Pasien("RM-04", "Lina");
        lina.setKeluhan("Batuk pilek");
        lina.setTingkatKeparahan(3);
        Pasien[] antrean = {joko, mira, tono, lina};

        System.out.println(TenagaMedis.NAMA_RS + " menerima " + antrean.length + " pasien");

        judul("Pemeriksaan");
        for (Pasien pasien : antrean) {
            System.out.println("- " + pemeriksaAwal.periksa(pasien));
        }
        System.out.println("- " + pemeriksaLanjut.periksa(tono));

        judul("Penanganan");
        tangani(perawatMalam, mira, tono);
        tangani(dokterUmum, joko, lina);
        tangani(dokterBedah, antrean);
        tangani(dokterBedah, antrean);
        dokterBedah.tampilkanInfo();
        dokterBedah.istirahat();
        tangani(dokterBedah, tono);
        tangani(apoteker, joko, mira, tono);

        judul("Pembayaran");
        Ditagih[] layanan = {dokterBedah, dokterUmum, apoteker};
        double total = 0;
        for (Ditagih item : layanan) {
            total += item.hitungBiaya();
        }
        cetakTagihan("Dokter " + dokterBedah.getNama(), dokterBedah);
        cetakTagihan("Dokter " + dokterUmum.getNama(), dokterUmum);
        cetakTagihan("Apoteker " + apoteker.getNama(), apoteker);
        System.out.println("Total: " + format(total));
    }

    private static void judul(String teks) {
        System.out.println("\n=== " + teks + " ===");
    }

    private static void tangani(TenagaMedis petugas, Pasien... daftarPasien) {
        for (Pasien pasien : daftarPasien) {
            System.out.println("- " + petugas.tangani(pasien));
        }
    }

    private static void cetakTagihan(String label, Ditagih tagihan) {
        System.out.println("- " + label + ": " + format(tagihan.hitungBiaya()));
    }

    private static String format(double nominal) {
        return String.format("Rp%,.0f", nominal);
    }
}