public class Apoteker extends TenagaMedis implements Ditagih {
    public static final double HARGA_OBAT_DEFAULT = 50000;

    private static final int STAMINA_MINIMAL = 10;
    private static final int KEPARAHAN_BUTUH_OBAT = 4;
    private static final int BIAYA_STAMINA_RACIK = 10;

    private double hargaObat;

    public Apoteker(String idPegawai, String nama) {
        this(idPegawai, nama, HARGA_OBAT_DEFAULT);
    }

    public Apoteker(String idPegawai, String nama, double hargaObat) {
        super(idPegawai, nama);
        this.hargaObat = hargaObat;
    }

    public double getHargaObat() {
        return hargaObat;
    }

    public void setHargaObat(double hargaObat) {
        this.hargaObat = hargaObat;
    }

    @Override
    public String tangani(Pasien pasien) {
        if (getStamina() < STAMINA_MINIMAL) {
            return "Apoteker " + getNama() + " kelelahan dan tidak bisa melayani " + pasien.getNama();
        } else if (pasien.getTingkatKeparahan() >= KEPARAHAN_BUTUH_OBAT) {
            catatPenanganan(BIAYA_STAMINA_RACIK);
            pasien.setStatus(Pasien.STATUS_SELESAI);
            return "Apoteker " + getNama() + " menyiapkan obat untuk " + pasien.getNama();
        } else {
            pasien.setStatus(Pasien.STATUS_SELESAI);
            return "Apoteker " + getNama() + " memastikan " + pasien.getNama() + " tidak perlu obat";
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Resep disiapkan: " + getJumlahPasien();
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  Peran: Apoteker | Harga obat per resep: Rp" + (long) hargaObat);
    }

    @Override
    public double hitungBiaya() {
        return hargaObat * getJumlahPasien();
    }
}
