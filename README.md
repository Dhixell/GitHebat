🛍️ Sistem Pemesanan Online Shop
📖 Deskripsi Program

Program ini merupakan simulasi sistem pemesanan sederhana di sebuah toko online.
Dibuat menggunakan bahasa Java, program ini menampilkan nota pemesanan pelanggan lengkap dengan perhitungan diskon 10%, pajak 11%, serta fitur untuk menyimpan nota ke dalam file .txt secara otomatis.

Program ini juga sudah dilengkapi dengan JavaDoc, yang digunakan untuk menghasilkan dokumentasi kode agar mudah dibaca oleh pengembang lain.

⚙️ Fitur Utama

🧾 Menampilkan nota pemesanan di terminal.

💸 Perhitungan otomatis subtotal, diskon, pajak, dan total akhir.

🕓 Menampilkan tanggal & waktu transaksi.

💾 Menyimpan nota pemesanan ke file .txt.

🧠 Struktur program OOP sederhana (class dan method terpisah).

| Kelas                           | Deskripsi                                                                                                                              |
| :------------------------------ | :------------------------------------------------------------------------------------------------------------------------------------- |
| **`Item`**                      | Menyimpan data barang seperti nama, harga, dan jumlah pembelian. Juga memiliki method untuk menghitung total harga, diskon, dan pajak. |
| **`Customer`**                  | Menyimpan informasi pelanggan seperti nama, alamat, dan nomor telepon.                                                                 |
| **`SistemPemesananOnlineShop`** | Kelas utama yang menjalankan program, menampilkan dan menyimpan nota pesanan.                                                          |

💻 Cara Kerja Program

Program membuat objek Item berisi data barang: nama, harga, dan jumlah.

Membuat objek Customer dengan data pelanggan.

Program menampilkan nota pemesanan di layar melalui method tampilkanNota().

Setelah itu, nota disimpan ke dalam file teks .txt melalui method simpanNota().

| Komponen    | Rumus                         | Keterangan                           |
| :---------- | :---------------------------- | :----------------------------------- |
| Subtotal    | `harga × jumlah`              | Total harga sebelum diskon dan pajak |
| Diskon      | `subtotal × 0.1`              | Diskon sebesar 10%                   |
| Pajak       | `(subtotal - diskon) × 0.11`  | Pajak sebesar 11% setelah diskon     |
| Total Akhir | `(subtotal - diskon) + pajak` | Total keseluruhan yang harus dibayar |

selesai
tets