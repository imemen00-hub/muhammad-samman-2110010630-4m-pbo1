/**
 * Class Buku
 * Mewakili sebuah buku dalam perpustakaan
 */
public class Buku {
    // Atribut
    private String idBuku;
    private String judul;
    private String pengarang;
    private String penerbit;
    private int tahunTerbit;
    private int stok;
    private double harga;

    // Constructor
    public Buku(String idBuku, String judul, String pengarang, String penerbit, int tahunTerbit, int stok, double harga) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.stok = stok;
        this.harga = harga;
    }

    // Accessor (Getter)
    public String getIdBuku() {
        return idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public int getStok() {
        return stok;
    }

    public double getHarga() {
        return harga;
    }

    // Mutator (Setter)
    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            throw new IllegalArgumentException("Stok tidak boleh negatif!");
        }
    }

    public void setHarga(double harga) {
        if (harga >= 0) {
            this.harga = harga;
        } else {
            throw new IllegalArgumentException("Harga tidak boleh negatif!");
        }
    }

    // Method tambahan
    public void kurangiStok(int jumlah) throws Exception {
        if (jumlah > stok) {
            throw new Exception("Stok tidak cukup! Stok tersedia: " + stok);
        }
        this.stok -= jumlah;
    }

    public void tambahStok(int jumlah) {
        if (jumlah > 0) {
            this.stok += jumlah;
        }
    }

    public void tampilkanInfo() {
        System.out.println("ID: " + idBuku + " | Judul: " + judul + " | Pengarang: " + pengarang);
        System.out.println("Penerbit: " + penerbit + " | Tahun: " + tahunTerbit + " | Stok: " + stok + " | Harga: Rp" + harga);
        System.out.println("---");
    }
}
