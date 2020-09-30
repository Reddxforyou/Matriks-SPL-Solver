# Aljabar Linear dan Geometri - Tubes 1

## SPESIFIKASI TUGAS
Buatlah program dalam Bahasa Java untuk :
1. Menghitung solusi SPL dengan metode eliminasi Gauss, metode Eliminasi Gauss-Jordan, metode matriks balikan, dan kaidah Cramer (kaidah Cramer khusus untuk SPL dengan n peubah dan n persamaan).
2. Menyelesaikan persoalan interpolasi dan regresi linier.
3. Menghitung matriks balikan
4. Menghitung determinan matriks dengan berbagai metode (reduksi baris dan ekspansi kofaktor).

## Nama Anggota Kelompok
1. 13519043 - Reihan Andhika Putra
2. 13519057 - Kadek Dwi Bagus Ananta Udayana
3. 13519193 - Ryo Richardo

## Menu
Menu dalam program :
1.  Determinan
    - Ekspansi Kofaktor
    - Segitiga Atas (OBE)
    - Segitiga Bawah (OBE)
2.  Invers
    - Adjoint
    - Eliminasi Gauss Jordan
3.  Sistem Persamaan Linear
    - Eliminasi Gauss
    - Eliminasi Gauss Jordan
    - Metode Cramer
    - Metode Invers
4.  Interpolasi Polinom
    - Sama seperti SPL
5.  Regresi Linear Berganda
    - Sama seperti SPL
6.  Keluar

## Cara Run Program
1.  Run Program 
    - Masuk ke dalam folder bin dan jalankan perintah "1"
    - Apabila ingin mengcompile ulang, masuk ke dalam folder src dan jalankan perintah "2"
    - Apabila akan di run menggunakan IDE atau aplikasi lainnya maka caranya mengikuti aplikasi tersebut
```
(1)
java app
(2)
javac app.java AdtMat,java
java app
```
2.  Masukkan menu dan submenu penyelesaian matriks yang diinginkan dengan mengetik angka 1-9
3.  Masukkan cara pembacaan matriks , ada 3cara untuk membaca matriks
    - Keyboard
    - File
    - Matriks Hilbert ( Khusus SPL)
4. Tergantung situasi dan kondisi maka matriks anda bisa saja diselesaikan ataupun ditolak karena penggunaan metode yang tidak cocok, input matriks yang tidak valid, dan beberapa alasan lainnnya
5. Apabila matriks anda berhasil diselesaikan, maka output yang bersesuaian akan muncul di layar , dan anda dapat memilih untuk save matriks di file atau tidak
# WARNING
1. > :exclamation: Input menu yang diijinkan adalah integer sehingga apabila anda menginput string saat pilihan menu maka program akan error dan auto exit
2. > :exclamation: File yang digunakan sebagai input matriks wajib berada di dalam folder test
3. > :exclamation: File yang digunakan sebagai ouput matriks akan berada di dalam folder output
4. > :exclamation: Dalam mengetikkan nama file, wajib sertakan extension file

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies


