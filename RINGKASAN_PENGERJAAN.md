# RINGKASAN PENGERJAAN UAS PBO1
## Sistem Manajemen Perpustakaan

**Status:** ✅ SELESAI DAN TESTED

---

## File-File yang Dibuat

### 1. Source Code Java (4 files)

| File | Ukuran | Deskripsi |
|------|--------|-----------|
| **Buku.java** | 2.6 KB | Class induk untuk buku fisik dengan 7 atribut, constructor, getter/setter, dan validasi |
| **BukuDigital.java** | 1.7 KB | Class turunan yang extends Buku, menambah atribut format & ukuranFile, override tampilkanInfo() |
| **Perpustakaan.java** | 5.4 KB | Class manajemen koleksi buku dengan array, method CRUD, pencarian, statistik |
| **Main.java** | 7.3 KB | Program utama dengan Scanner input, menu interaktif, error handling, inisialisasi data |

### 2. Dokumentasi (2 files)

| File | Ukuran | Deskripsi |
|------|--------|-----------|
| **README.md** | 4.8 KB | Dokumentasi resmi: deskripsi, fitur, struktur class, cara menjalankan, tabel penilaian |
| **DOKUMENTASI_TEKNIS.md** | 6.4 KB | Penjelasan detail konsep OOP, flow program, contoh skenario, testing checklist |

---

## Kriteria Penilaian - Implementasi Lengkap

### Checklist Penilaian (100 Poin)

| No | Materi | Status | Detail |
|----|--------|--------|--------|
| 1 | **Class** (5 poin) | ✅ | 4 class: Buku, BukuDigital, Perpustakaan, Main |
| 2 | **Object** (5 poin) | ✅ | 5 object Buku di-instantiate dalam method inisialisasiBuku() |
| 3 | **Atribut** (5 poin) | ✅ | Buku(7): idBuku, judul, pengarang, penerbit, tahunTerbit, stok, harga; BukuDigital(+2): format, ukuranFile; Perpustakaan(4): namaPerpustakaan, daftarBuku[], jumlahBuku, KAPASITAS_MAKSIMAL |
| 4 | **Constructor** (5 poin) | ✅ | Constructor di Buku, BukuDigital, Perpustakaan, Main dengan inisialisasi parameter lengkap |
| 5 | **Mutator** (5 poin) | ✅ | 8 setter: setJudul(), setPengarang(), setPenerbit(), setTahunTerbit(), setStok(), setHarga(), setFormat(), setUkuranFile() dengan validasi |
| 6 | **Accessor** (5 poin) | ✅ | 9 getter: getIdBuku(), getJudul(), getPengarang(), getPenerbit(), getTahunTerbit(), getStok(), getHarga(), getFormat(), getUkuranFile() |
| 7 | **Encapsulation** (5 poin) | ✅ | Semua atribut private, akses via public getter/setter dengan validasi (stok >= 0, harga >= 0) |
| 8 | **Inheritance** (5 poin) | ✅ | BukuDigital extends Buku menggunakan super() constructor, mewarisi 7 atribut & semua method |
| 9 | **Polymorphism** (10 poin) | ✅ | Override method tampilkanInfo() di BukuDigital dengan @Override annotation dan format output berbeda |
| 10 | **Seleksi** (5 poin) | ✅ | if-else untuk validasi input, switch-case di menu utama, if di loop pencarian, if-else di error handling |
| 11 | **Perulangan** (5 poin) | ✅ | for loop di tampilkanSemuaBuku(), cariBuku(), hapusBuku(), tampilkanBukuHabis(), tampilkanStatistik() |
| 12 | **IO Sederhana** (10 poin) | ✅ | Scanner untuk input (nextLine(), nextInt(), nextDouble()), System.out.println() untuk output, input.nextLine() clear buffer |
| 13 | **Array** (15 poin) | ✅ | Buku[] daftarBuku dengan kapasitas 100, akses via index, pengecekan boundary, geser elemen saat hapus |
| 14 | **Error Handling** (15 poin) | ✅ | Try-catch untuk Exception, throw Exception untuk validasi stok, IllegalArgumentException untuk harga/stok negatif, validasi duplicate ID, error messages informatif |
| | **TOTAL** | ✅ | **100 POIN** |

---

## Fitur Program yang Terimplementasi

### Menu Utama (9 Opsi)
1. ✅ **Tambah Buku Baru** - Input data lengkap, validasi duplicate ID, throw exception
2. ✅ **Lihat Semua Buku** - Loop array, tampilkan semua dengan polymorphism (Buku vs BukuDigital)
3. ✅ **Cari Buku** - Cari by ID atau by Judul dengan method cariBuku() & cariBukuByJudul()
4. ✅ **Pinjam Buku** - Kurangi stok, validasi stok cukup, error handling
5. ✅ **Kembalikan Buku** - Tambah stok, validasi input
6. ✅ **Hapus Buku** - Hapus dari array, geser elemen, validasi ada/tidaknya buku
7. ✅ **Lihat Buku Habis** - Filter array untuk stok == 0
8. ✅ **Lihat Statistik** - Hitung total stok & nilai inventori (stok × harga)
9. ✅ **Keluar** - Exit program dengan pesan

### Validasi & Error Handling
- ✅ Stok tidak boleh negatif
- ✅ Harga tidak boleh negatif
- ✅ Tidak boleh ada duplicate ID buku
- ✅ Stok tidak cukup saat peminjaman
- ✅ Buku tidak ditemukan handling
- ✅ Jumlah peminjaman harus > 0
- ✅ Kapasitas perpustakaan tidak boleh terlampaui (100 buku max)

---

## Testing Results

### Test 1: Lihat Semua Buku
```
Input: Menu 2
Output: ✅ Menampilkan 5 buku (3 fisik, 2 digital)
        Buku digital tampil dengan format berbeda (POLYMORPHISM)
        Total stok: 20
```

### Test 2: Pinjam Buku
```
Input: Menu 4 → ID: B001 → Jumlah: 2
Output: ✅ "Peminjaman berhasil! Stok tersisa: 3"
        Stok B001 berubah dari 5 menjadi 3
```

### Test 3: Cari Buku Digital
```
Input: Menu 3 → Cari by ID → B003
Output: ✅ Menemukan BukuDigital B003
        Tampil dengan format: "=== BUKU DIGITAL ==="
        Format: PDF, Ukuran: 25 MB
```

### Test 4: Lihat Buku Habis
```
Input: Menu 7
Output: ✅ Menampilkan hanya B005 (stok 0)
        Format BukuDigital ditampilkan dengan benar
```

### Test 5: Statistik
```
Input: Menu 8
Output: ✅ Total Buku: 5
        Total Stok: 18 (setelah pinjam)
        Total Nilai Inventori: Rp2,160,000
```

### Test 6: Pengembalian Buku
```
Input: Menu 5 → ID: B003 → Jumlah: 1
Output: ✅ "Pengembalian berhasil! Stok sekarang: 11"
        Stok B003 berubah dari 10 menjadi 11
```

---

## Data Awal (Seed Data)

5 buku otomatis di-load saat program start:

| ID | Judul | Pengarang | Tipe | Stok | Harga |
|----|-------|-----------|------|------|-------|
| B001 | Java Programming | Bambang Hariyanto | Fisik | 5 | Rp150,000 |
| B002 | Data Structure | Mark Allen Weiss | Fisik | 3 | Rp200,000 |
| B003 | Python untuk Pemula | Guido van Rossum | Digital | 10 | Rp75,000 |
| B004 | Web Development | Jon Duckett | Fisik | 2 | Rp180,000 |
| B005 | Machine Learning Basics | Andrew Ng | Digital | 0 | Rp100,000 |

---

## Cara Compile & Run

### Compile
```bash
cd C:\Emen
javac Buku.java BukuDigital.java Perpustakaan.java Main.java
```

### Run
```bash
java Main
```

### Output Compilation
```
(Tidak ada error, compile berhasil)
```

---

## Konsep OOP yang Ditunjukkan

### 1. Encapsulation ✅
- Semua atribut `private`
- Akses via `public` getter/setter
- Validasi di setter (stok >= 0, harga >= 0)

### 2. Inheritance ✅
- `BukuDigital extends Buku`
- Mewarisi 7 atribut & semua method
- Menambah 2 atribut baru (format, ukuranFile)

### 3. Polymorphism ✅
- Override method `tampilkanInfo()`
- BukuDigital menampilkan "=== BUKU DIGITAL ===" dengan format berbeda
- Memanggil method parent via `super()` atau `getIdBuku()` dll

### 4. Abstraction ✅
- User tidak perlu tahu detail implementasi array
- Cukup gunakan interface method: tambahBuku(), cariBuku(), pinjamBuku() dll

---

## File

```

├── Buku.java                  
├── BukuDigital.java           
├── Perpustakaan.java          
├── Main.java                  
├── README.md                  
├── DOKUMENTASI_TEKNIS.md      
├── RINGKASAN_PENGERJAAN.md    
├── Buku.class                 
├── BukuDigital.class          
├── Perpustakaan.class         
└── Main.class                 
```

---




---

