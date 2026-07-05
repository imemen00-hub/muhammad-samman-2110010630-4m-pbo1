/**
 * Class BukuDigital (Inheritance dari Buku)
 * Mewakili buku dalam format digital
 */
public class BukuDigital extends Buku {
    // Atribut tambahan
    private String format; // PDF, EPUB, MOBI
    private long ukuranFile; // dalam MB

    // Constructor
    public BukuDigital(String idBuku, String judul, String pengarang, String penerbit, int tahunTerbit, int stok, double harga, String format, long ukuranFile) {
        super(idBuku, judul, pengarang, penerbit, tahunTerbit, stok, harga);
        this.format = format;
        this.ukuranFile = ukuranFile;
    }

    // Accessor
    public String getFormat() {
        return format;
    }

    public long getUkuranFile() {
        return ukuranFile;
    }

    // Mutator
    public void setFormat(String format) {
        this.format = format;
    }

    public void setUkuranFile(long ukuranFile) {
        if (ukuranFile > 0) {
            this.ukuranFile = ukuranFile;
        }
    }

    // Override method tampilkanInfo (Polymorphism)
    @Override
    public void tampilkanInfo() {
        System.out.println("=== BUKU DIGITAL ===");
        System.out.println("ID: " + getIdBuku() + " | Judul: " + getJudul() + " | Pengarang: " + getPengarang());
        System.out.println("Penerbit: " + getPenerbit() + " | Tahun: " + getTahunTerbit() + " | Stok: " + getStok());
        System.out.println("Harga: Rp" + getHarga() + " | Format: " + format + " | Ukuran: " + ukuranFile + " MB");
        System.out.println("---");
    }

    public void downloadBuku(String namaUser) {
        System.out.println("Download buku '" + getJudul() + "' untuk user: " + namaUser);
        System.out.println("Format: " + format + " | Ukuran: " + ukuranFile + " MB");
    }
}
