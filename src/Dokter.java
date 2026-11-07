public class Dokter extends TenagaMedis implements Diperiksa, Ditagih {
    public static final double TARIF_DEFAULT = 150000;

    private static final int STAMINA_MINIMAL = 20;
    private static final int KEPARAHAN_OPERASI = 8;
    private static final int KEPARAHAN_KONSULTASI = 4;
    private static final int BIAYA_STAMINA_OPERASI = 30;
    private static final int BIAYA_STAMINA_KONSULTASI = 15;
    private static final int BIAYA_STAMINA_RINGAN = 5;

    private String spesialis;
    private double tarif;

    public Dokter(String idPegawai, String nama, String spesialis) {
        this(idPegawai, nama, spesialis, TARIF_DEFAULT);
    }

    public Dokter(String idPegawai, String nama, String spesialis, double tarif) {
        super(idPegawai, nama);
        this.spesialis = spesialis;
        this.tarif = tarif;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    @Override
    public String tangani(Pasien pasien) {
        int keparahan = pasien.getTingkatKeparahan();

        if (getStamina() < STAMINA_MINIMAL) {
            return "dr. " + getNama() + " kelelahan dan tidak bisa menangani " + pasien.getNama();
        } else if (keparahan >= KEPARAHAN_OPERASI) {
            catatPenanganan(BIAYA_STAMINA_OPERASI);
            pasien.setStatus(Pasien.STATUS_DIRAWAT);
            return "dr. " + getNama() + " mengoperasi " + pasien.getNama();
        } else if (keparahan >= KEPARAHAN_KONSULTASI) {
            catatPenanganan(BIAYA_STAMINA_KONSULTASI);
            pasien.setStatus(Pasien.STATUS_SELESAI);
            return "dr. " + getNama() + " memberi konsultasi dan resep untuk " + pasien.getNama();
        } else {
            catatPenanganan(BIAYA_STAMINA_RINGAN);
            pasien.setStatus(Pasien.STATUS_SELESAI);
            return "dr. " + getNama() + " memeriksa ringan " + pasien.getNama();
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Spesialis: " + spesialis;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  Peran: Dokter | Tarif per pasien: Rp" + (long) tarif);
    }

    @Override
    public String periksa(Pasien pasien) {
        return "Dokter " + spesialis + " memeriksa keluhan '" + pasien.getKeluhan()
                + "' milik " + pasien.getNama();
    }

    @Override
    public double hitungBiaya() {
        return tarif * getJumlahPasien();
    }
}