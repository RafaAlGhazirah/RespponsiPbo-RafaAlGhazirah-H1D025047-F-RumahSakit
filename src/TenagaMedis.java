public abstract class TenagaMedis {
    public static final String NAMA_RS = "RS Sehat Sentosa";
    public static final int STAMINA_MAKSIMAL = 100;

    private final String idPegawai;
    private String nama;
    private int stamina;
    private int jumlahPasien;

    public TenagaMedis(String idPegawai, String nama) {
        this(idPegawai, nama, STAMINA_MAKSIMAL);
    }

    public TenagaMedis(String idPegawai, String nama, int stamina) {
        this.idPegawai = idPegawai;
        this.nama = nama;
        this.stamina = stamina;
        this.jumlahPasien = 0;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = Math.max(0, Math.min(stamina, STAMINA_MAKSIMAL));
    }

    public int getJumlahPasien() {
        return jumlahPasien;
    }

    public void setJumlahPasien(int jumlahPasien) {
        this.jumlahPasien = jumlahPasien;
    }

    public void istirahat() {
        setStamina(STAMINA_MAKSIMAL);
        System.out.println("- " + nama + " beristirahat, stamina pulih ke " + STAMINA_MAKSIMAL);
    }

    public String getInfo() {
        return "[" + idPegawai + "] " + nama
                + " | Stamina: " + stamina
                + " | Pasien ditangani: " + jumlahPasien;
    }

    public void tampilkanInfo() {
        System.out.println(getInfo());
    }

    public abstract String tangani(Pasien pasien);

    protected void catatPenanganan(int staminaTerpakai) {
        setStamina(stamina - staminaTerpakai);
        setJumlahPasien(jumlahPasien + 1);
    }
}