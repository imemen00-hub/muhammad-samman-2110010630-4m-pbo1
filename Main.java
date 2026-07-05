import java.util.Scanner;

/**
 * Class Main - Program Utama Sistem Manajemen Perpustakaan
 * IO Sederhana, Seleksi, Perulangan, Error Handling
 */
public class Main {
    static Scanner input = new Scanner(System.in);
    static Perpustakaan perpustakaan;

    public static void main(String[] args) {
        perpustakaan = new Perpustakaan("Perpustakaan Kota");
        
        // Inisialisasi data buku
        inisialisasiBuku();
        
        boolean running = true;
        while (running) {
            tampilkanMenu();
            System.out.print("Pilih menu (1-9): ");
            
            try {
                int pilihan = input.nextInt();
                input.nextLine(); // Consume newline
                
                switch (pilihan) {
                    case 1:
                        tambahBukuBaru();
                        break;
                    case 2:
                        lihatSemuaBuku();
                        break;
                    case 3:
                        cariBukuMenu();
                        break;
                    case 4:
                        pinjamBukuMenu();
                        break;
                    case 5:
                        kembalikanBukuMenu();
                        break;
                    case 6:
                        hapusBukuMenu();
                        break;
                    case 7:
                        lihatBukuHabis();
                        break;
                    case 8:
                        lihatStatistik();
                        break;
                    case 9:
                        running = false;
                        System.out.println("Terima kasih telah menggunakan sistem perpustakaan. Sampai jumpa!");
                        break;
                    default:
                        System.out.println("Menu tidak valid! Silakan pilih 1-9.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                input.nextLine(); // Clear invalid input
            }
        }
        input.close();
    }

    private static void tampilkanMenu() {
        System.out.println("\n========== MENU PERPUSTAKAAN ==========");
        System.out.println("1. Tambah Buku Baru");
        System.out.println("2. Lihat Semua Buku");
        System.out.println("3. Cari Buku");
        System.out.println("4. Pinjam Buku");
        System.out.println("5. Kembalikan Buku");
        System.out.println("6. Hapus Buku");
        System.out.println("7. Lihat Buku Habis");
        System.out.println("8. Lihat Statistik");
        System.out.println("9. Keluar");
        System.out.println("======================================");
    }

    private static void inisialisasiBuku() {
        try {
            perpustakaan.tambahBuku(new Buku("B001", "Java Programming", "Bambang Hariyanto", "Informatika", 2020, 5, 150000));
            perpustakaan.tambahBuku(new Buku("B002", "Data Structure", "Mark Allen Weiss", "Pearson", 2019, 3, 200000));
            perpustakaan.tambahBuku(new BukuDigital("B003", "Python untuk Pemula", "Guido van Rossum", "Penerbit IT", 2021, 10, 75000, "PDF", 25));
            perpustakaan.tambahBuku(new Buku("B004", "Web Development", "Jon Duckett", "Wiley", 2018, 2, 180000));
            perpustakaan.tambahBuku(new BukuDigital("B005", "Machine Learning Basics", "Andrew Ng", "Coursera Press", 2022, 0, 100000, "EPUB", 50));
        } catch (Exception e) {
            System.out.println("Error inisialisasi: " + e.getMessage());
        }
    }

    private static void tambahBukuBaru() {
        try {
            System.out.print("ID Buku: ");
            String id = input.nextLine();
            System.out.print("Judul: ");
            String judul = input.nextLine();
            System.out.print("Pengarang: ");
            String pengarang = input.nextLine();
            System.out.print("Penerbit: ");
            String penerbit = input.nextLine();
            System.out.print("Tahun Terbit: ");
            int tahun = input.nextInt();
            System.out.print("Stok: ");
            int stok = input.nextInt();
            System.out.print("Harga: ");
            double harga = input.nextDouble();
            input.nextLine();

            Buku bukuBaru = new Buku(id, judul, pengarang, penerbit, tahun, stok, harga);
            perpustakaan.tambahBuku(bukuBaru);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void lihatSemuaBuku() {
        perpustakaan.tampilkanSemuaBuku();
    }

    private static void cariBukuMenu() {
        System.out.print("Cari berdasarkan (1=ID, 2=Judul): ");
        int pilihan = input.nextInt();
        input.nextLine();

        try {
            if (pilihan == 1) {
                System.out.print("Masukkan ID Buku: ");
                String id = input.nextLine();
                Buku buku = perpustakaan.cariBuku(id);
                
                if (buku != null) {
                    System.out.println("\n========== HASIL PENCARIAN ==========");
                    buku.tampilkanInfo();
                } else {
                    System.out.println("Buku tidak ditemukan!");
                }
            } else if (pilihan == 2) {
                System.out.print("Masukkan Judul Buku: ");
                String judul = input.nextLine();
                Buku buku = perpustakaan.cariBukuByJudul(judul);
                
                if (buku != null) {
                    System.out.println("\n========== HASIL PENCARIAN ==========");
                    buku.tampilkanInfo();
                } else {
                    System.out.println("Buku tidak ditemukan!");
                }
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void pinjamBukuMenu() {
        try {
            System.out.print("Masukkan ID Buku: ");
            String id = input.nextLine();
            System.out.print("Jumlah Peminjaman: ");
            int jumlah = input.nextInt();
            input.nextLine();

            perpustakaan.pinjamBuku(id, jumlah);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void kembalikanBukuMenu() {
        try {
            System.out.print("Masukkan ID Buku: ");
            String id = input.nextLine();
            System.out.print("Jumlah Pengembalian: ");
            int jumlah = input.nextInt();
            input.nextLine();

            perpustakaan.kembalikanBuku(id, jumlah);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void hapusBukuMenu() {
        try {
            System.out.print("Masukkan ID Buku yang akan dihapus: ");
            String id = input.nextLine();
            perpustakaan.hapusBuku(id);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void lihatBukuHabis() {
        perpustakaan.tampilkanBukuHabis();
    }

    private static void lihatStatistik() {
        perpustakaan.tampilkanStatistik();
    }
}
