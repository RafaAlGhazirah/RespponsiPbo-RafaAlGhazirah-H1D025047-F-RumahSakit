public class Perawat extends TenagaMedis implements Diperiksa {
    private static final String SHIFT_DEFAULT = "Pagi";
    private static final int STAMINA_MINIMAL = 10;
    private static final int KEPARAHAN_RUJUK = 7;
    private static final int BIAYA_STAMINA_RUJUK = 20;
    private static final int BIAYA_STAMINA_DASAR = 10;

    private String shift;

    public Perawat(String idPegawai, String nama) {
        this(idPegawai, nama, SHIFT_DEFAULT);
    }

    public Perawat(String idPegawai, String nama, String shift) {
        super(idPegawai, nama);
        this.shift = shift;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public String tangani(Pasien pasien) {
        int keparahan = pasien.getTingkatKeparahan();

        if (getStamina() < STAMINA_MINIMAL) {
            return "Perawat " + getNama() + " kelelahan dan tidak bisa menangani " + pasien.getNama();
        } else if (keparahan >= KEPARAHAN_RUJUK) {
            catatPenanganan(BIAYA_STAMINA_RUJUK);
            pasien.setStatus(Pasien.STATUS_DIRUJUK);
            return "Perawat " + getNama() + " menstabilkan dan merujuk " + pasien.getNama() + " ke dokter";
        } else {
            catatPenanganan(BIAYA_STAMINA_DASAR);
            pasien.setStatus(Pasien.STATUS_DIRAWAT);
            return "Perawat " + getNama() + " memberi perawatan dasar pada " + pasien.getNama();
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Shift: " + shift;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  Peran: Perawat");
    }

    @Override
    public String periksa(Pasien pasien) {
        return "Perawat " + getNama() + " mengecek tensi dan suhu " + pasien.getNama();
    }
}