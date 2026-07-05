# Dokumentasi Teknis - Sistem Manajemen Perpustakaan

## Penjelasan Konsep OOP

### 1. Class (Konsep Abstraksi)
Class adalah blueprint/template untuk membuat object. Dalam program ini:
- **Buku**: Class untuk merepresentasikan buku fisik
- **BukuDigital**: Class untuk merepresentasikan buku digital
- **Perpustakaan**: Class untuk mengelola koleksi buku
- **Main**: Class untuk program utama

```java
public class Buku {
    // Atribut
    // Method
}
```

### 2. Object (Instansiasi)
Object adalah instance dari sebuah class. Contoh:
```java
Buku buku1 = new Buku("B001", "Java Programming", "Bambang Hariyanto", "Informatika", 2020, 5, 150000);
```

### 3. Atribut (Data Member)
Atribut adalah variabel yang menyimpan data dalam class:
```java
private String idBuku;
private String judul;
private int tahunTerbit;
private int stok;
```

### 4. Constructor (Konstruktor)
Method khusus untuk inisialisasi object saat dibuat:
```java
public Buku(String idBuku, String judul, String pengarang, ...) {
    this.idBuku = idBuku;
    this.judul = judul;
    // ... inisialisasi atribut lainnya
}
```

### 5. Mutator (Setter)
Method untuk mengubah nilai atribut:
```java
public void setStok(int stok) {
    if (stok >= 0) {  // Validasi
        this.stok = stok;
    } else {
        throw new IllegalArgumentException("Stok tidak boleh negatif!");
    }
}
```

### 6. Accessor (Getter)
Method untuk mendapatkan nilai atribut:
```java
public int getStok() {
    return stok;
}
```

### 7. Encapsulation (Enkapsulasi)
Menyembunyikan detail internal dan memberikan akses terkontrol:
- Semua atribut deklarasikan `private`
- Akses hanya melalui `public` getter/setter
- Validasi data di setter

```java
private int stok;  // Tidak bisa diakses langsung dari luar

public void setStok(int stok) {  // Akses terkontrol dengan validasi
    if (stok >= 0) {
        this.stok = stok;
    }
}
```

### 8. Inheritance (Pewarisan)
Class turunan mewarisi atribut dan method dari class induk:
```java
public class BukuDigital extends Buku {
    // Mewarisi semua atribut dan method dari Buku
    // Menambah atribut baru: format, ukuranFile
}
```

**Keuntungan Inheritance:**
- Code reusability (tidak perlu menulis ulang atribut Buku)
- Polymorphism support
- Hierarchi yang jelas

### 9. Polymorphism (Polimorfisme)
Method dengan nama sama tapi implementasi berbeda. Contoh: Override method `tampilkanInfo()`

**Class Buku:**
```java
public void tampilkanInfo() {
    System.out.println("ID: " + idBuku + " | Judul: " + judul);
    // Format buku fisik
}
```

**Class BukuDigital (Override):**
```java
@Override
public void tampilkanInfo() {
    System.out.println("=== BUKU DIGITAL ===");
    System.out.println("ID: " + getIdBuku() + " | Judul: " + getJudul());
    System.out.println("Format: " + format + " | Ukuran: " + ukuranFile + " MB");
    // Format buku digital berbeda
}
```

### 10. Seleksi (if-else, switch-case)
**if-else untuk validasi:**
```java
if (jumlah > stok) {
    throw new Exception("Stok tidak cukup!");
}
```

**switch-case untuk menu:**
```java
switch (pilihan) {
    case 1:
        tambahBukuBaru();
        break;
    case 2:
        lihatSemuaBuku();
        break;
    // ... case lainnya
}
```

### 11. Perulangan (for loop)
**For loop untuk iterasi array:**
```java
for (int i = 0; i < jumlahBuku; i++) {
    daftarBuku[i].tampilkanInfo();
}
```

### 12. IO Sederhana
**Input dengan Scanner:**
```java
Scanner input = new Scanner(System.in);
String judul = input.nextLine();
int stok = input.nextInt();
```

**Output dengan System.out:**
```java
System.out.println("Buku berhasil ditambahkan!");
System.out.println("ID: " + buku.getIdBuku());
```

### 13. Array
Array untuk menyimpan koleksi buku:
```java
private Buku[] daftarBuku;  // Deklarasi array
daftarBuku = new Buku[100]; // Inisialisasi dengan kapasitas 100

// Akses elemen
daftarBuku[0] = bukuBaru;
```

### 14. Error Handling
**Try-catch untuk exception:**
```java
try {
    perpustakaan.tambahBuku(bukuBaru);
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}
```

**Throw exception:**
```java
if (jumlah > stok) {
    throw new Exception("Stok tidak cukup! Stok tersedia: " + stok);
}
```

## Flow Program

```
Start
  ↓
Inisialisasi Perpustakaan
  ↓
Load Data Buku (5 buku default)
  ↓
Loop Menu:
  ├─ 1. Tambah Buku → Input data → Validasi → Tambah ke array
  ├─ 2. Lihat Semua → Loop array → Tampilkan info setiap buku
  ├─ 3. Cari Buku → Loop array → Cari ID/Judul → Tampilkan
  ├─ 4. Pinjam → Input ID & jumlah → Validasi stok → Kurangi stok
  ├─ 5. Kembalikan → Input ID & jumlah → Tambah stok
  ├─ 6. Hapus Buku → Input ID → Geser array → Hapus
  ├─ 7. Lihat Stok Habis → Loop array → Filter stok == 0 → Tampilkan
  ├─ 8. Statistik → Hitung total stok & nilai → Tampilkan
  └─ 9. Keluar → Exit
  ↓
End
```

## Contoh Skenario Penggunaan

### Skenario 1: Pinjam Buku
```
Menu: 4 (Pinjam Buku)
Input ID: B001
Input Jumlah: 2
Output: "Peminjaman berhasil! Stok tersisa: 3"
```

### Skenario 2: Cari Buku Digital
```
Menu: 3 (Cari Buku)
Pilih: 1 (Cari ID)
Input ID: B003
Output: Tampilkan info BukuDigital dengan format berbeda
```

### Skenario 3: Error Handling - Stok Tidak Cukup
```
Menu: 4 (Pinjam Buku)
Input ID: B004 (Stok: 2)
Input Jumlah: 5
Output: "Error: Stok tidak cukup! Stok tersedia: 2"
```

## Testing Checklist

- ✅ Compile tanpa error
- ✅ Run program berjalan normal
- ✅ Menu tampil dengan benar
- ✅ Lihat semua buku menampilkan 5 data
- ✅ Polymorphism bekerja - BukuDigital tampil berbeda
- ✅ Pinjam buku mengurangi stok
- ✅ Kembalikan buku menambah stok
- ✅ Cari buku berhasil menemukan
- ✅ Lihat stok habis menampilkan B005 (stok 0)
- ✅ Statistik menghitung total dengan benar
- ✅ Error handling menangkap exception

## Kesimpulan

Program ini mengimplementasikan semua 14 kriteria penilaian:
1. ✅ Class - 4 class
2. ✅ Object - 5 object buku
3. ✅ Atribut - 13 atribut total
4. ✅ Constructor - Di semua class
5. ✅ Mutator - 8 setter method
6. ✅ Accessor - 9 getter method
7. ✅ Encapsulation - Private atribut + public getter/setter
8. ✅ Inheritance - BukuDigital extends Buku
9. ✅ Polymorphism - Override tampilkanInfo()
10. ✅ Seleksi - if-else dan switch-case
11. ✅ Perulangan - for loop di berbagai method
12. ✅ IO Sederhana - Scanner dan System.out
13. ✅ Array - Buku array dengan kapasitas 100
14. ✅ Error Handling - Try-catch dan validasi input
