public class Pasien {
    public static final String STATUS_MENUNGGU = "Menunggu";
    public static final String STATUS_DIRAWAT = "Dirawat";
    public static final String STATUS_DIRUJUK = "Dirujuk";
    public static final String STATUS_SELESAI = "Selesai";

    private final String noRekamMedis;
    private String nama;
    private String keluhan;
    private int tingkatKeparahan;
    private String status;

    public Pasien(String noRekamMedis, String nama) {
        this(noRekamMedis, nama, "Belum diketahui", 1);
    }

    public Pasien(String noRekamMedis, String nama, String keluhan, int tingkatKeparahan) {
        this.noRekamMedis = noRekamMedis;
        this.nama = nama;
        this.keluhan = keluhan;
        this.tingkatKeparahan = tingkatKeparahan;
        this.status = STATUS_MENUNGGU;
    }

    public String getNoRekamMedis() {
        return noRekamMedis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public int getTingkatKeparahan() {
        return tingkatKeparahan;
    }

    public void setTingkatKeparahan(int tingkatKeparahan) {
        this.tingkatKeparahan = tingkatKeparahan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}