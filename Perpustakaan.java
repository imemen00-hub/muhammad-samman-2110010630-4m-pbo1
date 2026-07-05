/**
 * Class Perpustakaan
 * Mengelola koleksi buku dalam perpustakaan
 */
public class Perpustakaan {
    // Atribut
    private String namaPerpustakaan;
    private Buku[] daftarBuku;
    private int jumlahBuku;
    private final int KAPASITAS_MAKSIMAL = 100;

    // Constructor
    public Perpustakaan(String namaPerpustakaan) {
        this.namaPerpustakaan = namaPerpustakaan;
        this.daftarBuku = new Buku[KAPASITAS_MAKSIMAL];
        this.jumlahBuku = 0;
    }

    // Accessor
    public String getNamaPerpustakaan() {
        return namaPerpustakaan;
    }

    public int getJumlahBuku() {
        return jumlahBuku;
    }

    public Buku[] getDaftarBuku() {
        return daftarBuku;
    }

    // Mutator
    public void setNamaPerpustakaan(String namaPerpustakaan) {
        this.namaPerpustakaan = namaPerpustakaan;
    }

    // Method untuk menambah buku
    public void tambahBuku(Buku buku) throws Exception {
        if (jumlahBuku >= KAPASITAS_MAKSIMAL) {
            throw new Exception("Kapasitas perpustakaan penuh!");
        }
        
        // Cek apakah buku sudah ada
        if (cariBuku(buku.getIdBuku()) != null) {
            throw new Exception("Buku dengan ID " + buku.getIdBuku() + " sudah ada!");
        }
        
        daftarBuku[jumlahBuku] = buku;
        jumlahBuku++;
        System.out.println("Buku '" + buku.getJudul() + "' berhasil ditambahkan.");
    }

    // Method untuk mencari buku berdasarkan ID
    public Buku cariBuku(String idBuku) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getIdBuku().equals(idBuku)) {
                return daftarBuku[i];
            }
        }
        return null;
    }

    // Method untuk mencari buku berdasarkan judul
    public Buku cariBukuByJudul(String judul) {
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getJudul().equalsIgnoreCase(judul)) {
                return daftarBuku[i];
            }
        }
        return null;
    }

    // Method untuk menghapus buku
    public void hapusBuku(String idBuku) throws Exception {
        int index = -1;
        
        // Perulangan untuk mencari posisi buku
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getIdBuku().equals(idBuku)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new Exception("Buku dengan ID " + idBuku + " tidak ditemukan!");
        }

        // Geser elemen array
        for (int i = index; i < jumlahBuku - 1; i++) {
            daftarBuku[i] = daftarBuku[i + 1];
        }
        jumlahBuku--;
        System.out.println("Buku berhasil dihapus.");
    }

    // Method untuk meminjam buku
    public void pinjamBuku(String idBuku, int jumlah) throws Exception {
        Buku buku = cariBuku(idBuku);
        
        if (buku == null) {
            throw new Exception("Buku tidak ditemukan!");
        }

        if (jumlah <= 0) {
            throw new Exception("Jumlah peminjaman harus lebih dari 0!");
        }

        buku.kurangiStok(jumlah);
        System.out.println("Peminjaman berhasil! Stok tersisa: " + buku.getStok());
    }

    // Method untuk mengembalikan buku
    public void kembalikanBuku(String idBuku, int jumlah) throws Exception {
        Buku buku = cariBuku(idBuku);
        
        if (buku == null) {
            throw new Exception("Buku tidak ditemukan!");
        }

        if (jumlah <= 0) {
            throw new Exception("Jumlah pengembalian harus lebih dari 0!");
        }

        buku.tambahStok(jumlah);
        System.out.println("Pengembalian berhasil! Stok sekarang: " + buku.getStok());
    }

    // Method untuk menampilkan semua buku
    public void tampilkanSemuaBuku() {
        if (jumlahBuku == 0) {
            System.out.println("Tidak ada buku dalam perpustakaan.");
            return;
        }

        System.out.println("\n========== DAFTAR BUKU " + namaPerpustakaan + " ==========");
        for (int i = 0; i < jumlahBuku; i++) {
            System.out.println("[" + (i + 1) + "]");
            daftarBuku[i].tampilkanInfo();
        }
        System.out.println("Total buku: " + jumlahBuku);
    }

    // Method untuk menampilkan buku dengan stok habis
    public void tampilkanBukuHabis() {
        System.out.println("\n========== BUKU DENGAN STOK HABIS ==========");
        int count = 0;
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getStok() == 0) {
                daftarBuku[i].tampilkanInfo();
                count++;
            }
        }
        
        if (count == 0) {
            System.out.println("Semua buku masih tersedia.");
        }
    }

    // Method untuk menampilkan statistik
    public void tampilkanStatistik() {
        System.out.println("\n========== STATISTIK PERPUSTAKAAN ==========");
        System.out.println("Nama Perpustakaan: " + namaPerpustakaan);
        System.out.println("Total Buku: " + jumlahBuku);
        System.out.println("Kapasitas Maksimal: " + KAPASITAS_MAKSIMAL);
        
        int totalStok = 0;
        double totalNilai = 0;
        
        for (int i = 0; i < jumlahBuku; i++) {
            totalStok += daftarBuku[i].getStok();
            totalNilai += daftarBuku[i].getStok() * daftarBuku[i].getHarga();
        }
        
        System.out.println("Total Stok: " + totalStok);
        System.out.println("Total Nilai Inventori: Rp" + totalNilai);
    }
}
