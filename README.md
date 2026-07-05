# Sistem Manajemen Perpustakaan

## Deskripsi Studi Kasus

Sistem Manajemen Perpustakaan adalah aplikasi berbasis konsol yang dirancang untuk mengelola koleksi buku dalam perpustakaan. Program ini mengimplementasikan konsep-konsep Object-Oriented Programming (OOP) seperti Class, Object, Encapsulation, Inheritance, dan Polymorphism.

## Fitur Utama

1. **Tambah Buku Baru** - Menambahkan buku ke dalam perpustakaan
2. **Lihat Semua Buku** - Menampilkan daftar lengkap buku yang tersedia
3. **Cari Buku** - Mencari buku berdasarkan ID atau Judul
4. **Pinjam Buku** - Mengurangi stok buku saat dipinjam
5. **Kembalikan Buku** - Menambah stok buku saat dikembalikan
6. **Hapus Buku** - Menghapus buku dari perpustakaan
7. **Lihat Buku Habis** - Menampilkan buku dengan stok 0
8. **Lihat Statistik** - Menampilkan statistik perpustakaan

## Struktur Class

### 1. Class Buku
- **Atribut**: idBuku, judul, pengarang, penerbit, tahunTerbit, stok, harga
- **Method**: Constructor, Getter/Setter, kurangiStok(), tambahStok(), tampilkanInfo()

### 2. Class BukuDigital (Inheritance dari Buku)
- **Atribut tambahan**: format, ukuranFile
- **Method**: Constructor, Getter/Setter, downloadBuku()
- **Polymorphism**: Override method tampilkanInfo()

### 3. Class Perpustakaan
- **Atribut**: namaPerpustakaan, daftarBuku (Array), jumlahBuku, KAPASITAS_MAKSIMAL
- **Method**: tambahBuku(), cariBuku(), hapusBuku(), pinjamBuku(), kembalikanBuku(), tampilkanSemuaBuku(), tampilkanBukuHabis(), tampilkanStatistik()

### 4. Class Main
- **IO Sederhana**: Input/Output menggunakan Scanner dan System.out
- **Menu**: Loop interaktif dengan pilihan menu
- **Error Handling**: Try-catch untuk menangani exception

## Cara Menjalankan

```bash
# Compile
javac Buku.java BukuDigital.java Perpustakaan.java Main.java

# Run
java Main
```

## Contoh Penggunaan

```
========== MENU PERPUSTAKAAN ==========
1. Tambah Buku Baru
2. Lihat Semua Buku
3. Cari Buku
4. Pinjam Buku
5. Kembalikan Buku
6. Hapus Buku
7. Lihat Buku Habis
8. Lihat Statistik
9. Keluar
======================================

Pilih menu (1-9): 2
```

## Tabel Penilaian

| No | Materi | Implementasi | Nilai |
|----|--------|--------------|-------|
| 1 | Class | 4 class (Buku, BukuDigital, Perpustakaan, Main) | 5 |
| 2 | Object | 5 object buku di-instantiate saat inisialisasi | 5 |
| 3 | Atribut | 7 atribut di Buku + 2 di BukuDigital + 4 di Perpustakaan | 5 |
| 4 | Constructor | Constructor di semua class dengan parameter lengkap | 5 |
| 5 | Mutator | setJudul(), setPengarang(), setPenerbit(), setTahunTerbit(), setStok(), setHarga(), setFormat(), setUkuranFile() | 5 |
| 6 | Accessor | getIdBuku(), getJudul(), getPengarang(), getPenerbit(), getTahunTerbit(), getStok(), getHarga(), getFormat(), getUkuranFile() | 5 |
| 7 | Encapsulation | Semua atribut private, akses melalui getter/setter dengan validasi | 5 |
| 8 | Inheritance | BukuDigital extends Buku, mewarisi atribut dan method | 5 |
| 9 | Polymorphism | Override method tampilkanInfo() di BukuDigital | 10 |
| 10 | Seleksi | if-else pada validasi input, switch-case di menu, if di perulangan pencarian | 5 |
| 11 | Perulangan | for loop di tampilkanSemuaBuku(), cariBuku(), kurangiStok(), kembalikanBuku() | 5 |
| 12 | IO Sederhana | Scanner untuk input, System.out.println() untuk output | 10 |
| 13 | Array | Array daftarBuku[100] di class Perpustakaan untuk menyimpan buku | 15 |
| 14 | Error Handling | Try-catch untuk Exception, validasi input, throw Exception untuk stok tidak cukup | 15 |
| **TOTAL** | | | **100** |

## Konsep OOP yang Diimplementasikan

- ✅ **Encapsulation**: Atribut private dengan getter/setter
- ✅ **Inheritance**: BukuDigital mewarisi dari Buku
- ✅ **Polymorphism**: Override method tampilkanInfo()
- ✅ **Abstraction**: Interface operasi perpustakaan yang jelas

## File-file

1. **Buku.java** - Class induk untuk buku fisik
2. **BukuDigital.java** - Class turunan untuk buku digital
3. **Perpustakaan.java** - Class untuk mengelola koleksi buku
4. **Main.java** - Program utama dengan menu interaktif
5. **README.md** - Dokumentasi ini

## Data Awal (Seed Data)

Program sudah dilengkapi dengan 5 buku awal:

| ID | Judul | Pengarang | Stok |
|----|-------|-----------|------|
| B001 | Java Programming | Bambang Hariyanto | 5 |
| B002 | Data Structure | Mark Allen Weiss | 3 |
| B003 | Python untuk Pemula | Guido van Rossum | 10 |
| B004 | Web Development | Jon Duckett | 2 |
| B005 | Machine Learning Basics | Andrew Ng | 0 |

## Catatan

- Kapasitas maksimal perpustakaan: 100 buku
- Validasi stok untuk memastikan tidak ada stok negatif
- Error handling untuk berbagai kondisi error
- Program berjalan dalam loop sampai user memilih keluar

---

**Dibuat untuk**: Ujian Akhir Semester Pemrograman Berbasis Objek 1  
**Program Studi**: Teknik Informatika  
**Universitas**: Universitas Islam Kalimantan Muhammad Arsyad Al Banjari
