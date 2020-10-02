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
    - Eliminasi Gauss
    - Eliminasi Gauss Jordan
6.  Keluar

## Cara Run Program
1.  Run Program 
    - Masuk ke dalam folder bin dan jalankan perintah "1"
    - Apabila ingin mengcompile ulang, masuk ke dalam folder src dan jalankan perintah "2"
    - Apabila akan di run menggunakan IDE atau aplikasi lainnya maka caranya mengikuti aplikasi tersebut
```
(1)
java App
(2)
javac App.java AdtMat.java
java App
```
2.  Masukkan menu dan submenu penyelesaian matriks yang diinginkan dengan mengetik angka 1-9
> :exclamation: Input menu yang diijinkan adalah integer sehingga apabila anda menginput string saat pilihan menu maka program akan error dan auto exit
3.  Masukkan cara pembacaan matriks , ada 3 cara untuk membaca matriks
    - Keyboard
    - File
    - Matriks Hilbert (Khusus SPL)
> :exclamation: File yang digunakan sebagai input matriks wajib berada di dalam folder test <br/>
> :exclamation: Dalam mengetikkan nama file, wajib sertakan extension file
4. Tergantung situasi dan kondisi maka matriks anda bisa saja diselesaikan ataupun ditolak karena penggunaan metode yang tidak cocok, input matriks yang tidak valid, dan beberapa alasan lainnnya
> :exclamation: Dalam menulis input/output ke layar kami membulatkan ke 2 angka dibelakang koma supaya tidak terlalu banyak angka, namun terkadang ada interpretasi angka yang ambigu (0.0004 menjadi 0.00) harap dimaklumi !
5. Apabila matriks anda berhasil diselesaikan, maka output yang bersesuaian akan muncul di layar , dan anda dapat memilih untuk save matriks di file atau tidak
> :exclamation: File yang digunakan sebagai ouput matriks akan berada di dalam folder output <br/>
> :exclamation: Apabila terdapat error dalam file handling (input onput) maka anda akan dilempar ke menu utama lagi 
> :exclamation: TC6 disarankan pake GAUSS/GAUSSJORDAN
6. Anda bisa mengulangi proses diatas sesuai kebutuhan
7. Jika dirasa sudah cukup, pilih menu keluar untuk keluar dari program


