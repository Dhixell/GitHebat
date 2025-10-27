import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Program Sistem Pemesanan Online Shop versi sederhana.
 * <p>
 * Fitur:
 * <ul>
 *   <li>Menampilkan nota pemesanan</li>
 *   <li>Menghitung diskon dan pajak otomatis</li>
 *   <li>Menyimpan nota ke file .txt</li>
 * </ul>
 *
 * @author
 * @version 1.0
 * @since 2025-10-27
 */
public class SistemPemesananOnlineShop {

    /**
     * Kelas untuk merepresentasikan barang yang dipesan.
     */
    static class Item {
        String nama;
        double harga;
        int jumlah;

        /** Persentase diskon */
        static final double DISKON = 0.1;

        /** Persentase pajak */
        static final double PAJAK = 0.11;

        /**
         * Konstruktor untuk membuat objek Item.
         *
         * @param nama   nama barang
         * @param harga  harga satuan barang
         * @param jumlah jumlah barang yang dibeli
         */
        Item(String nama, double harga, int jumlah) {
            this.nama = nama;
            this.harga = harga;
            this.jumlah = jumlah;
        }

        /**
         * Menghitung total harga sebelum diskon dan pajak.
         *
         * @return total harga
         */
        double total() {
            return harga * jumlah;
        }

        /**
         * Menghitung total harga setelah diskon 10%.
         *
         * @return total harga setelah diskon
         */
        double totalSetelahDiskon() {
            return total() - (total() * DISKON);
        }

        /**
         * Menghitung total harga akhir setelah diskon dan pajak.
         *
         * @return total harga akhir
         */
        double totalAkhir() {
            double setelahDiskon = totalSetelahDiskon();
            return setelahDiskon + (setelahDiskon * PAJAK);
        }
    }

    /**
     * Kelas untuk menyimpan data pelanggan.
     */
    static class Customer {
        String nama, alamat, telp;

        /**
         * Konstruktor Customer.
         *
         * @param nama   nama pelanggan
         * @param alamat alamat pelanggan
         * @param telp   nomor telepon pelanggan
         */
        Customer(String nama, String alamat, String telp) {
            this.nama = nama;
            this.alamat = alamat;
            this.telp = telp;
        }
    }

    /**
     * Menampilkan nota pemesanan ke layar.
     *
     * @param item barang yang dipesan
     * @param c    data pelanggan
     */
    static void tampilkanNota(Item item, Customer c) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String waktu = LocalDateTime.now().format(fmt);

        System.out.println("\n=== NOTA PEMESANAN ONLINE SHOP ===");
        System.out.println("Tanggal     : " + waktu);
        System.out.println("Nama        : " + c.nama);
        System.out.println("Alamat      : " + c.alamat);
        System.out.println("Telepon     : " + c.telp);
        System.out.println("------------------------------");
        System.out.println("Barang      : " + item.nama);
        System.out.println("Harga       : Rp " + item.harga);
        System.out.println("Jumlah      : " + item.jumlah);
        System.out.println("Subtotal    : Rp " + item.total());
        System.out.println("Diskon 10%  : Rp " + (item.total() * Item.DISKON));
        System.out.println("Pajak 11%   : Rp " + (item.totalSetelahDiskon() * Item.PAJAK));
        System.out.println("Total Bayar : Rp " + item.totalAkhir());
        System.out.println("==============================");
    }

    /**
     * Menyimpan nota pemesanan ke dalam file teks (.txt).
     *
     * @param item barang yang dipesan
     * @param c    data pelanggan
     */
    static void simpanNota(Item item, Customer c) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        String waktu = LocalDateTime.now().format(fmt);
        String fileName = "nota_" + c.nama.toLowerCase().replace(" ", "_") + ".txt";

        try (FileWriter w = new FileWriter(fileName)) {
            w.write("=== NOTA PEMESANAN ONLINE SHOP ===\n");
            w.write("Tanggal : " + waktu + "\n");
            w.write("Nama    : " + c.nama + "\n");
            w.write("Alamat  : " + c.alamat + "\n");
            w.write("Telepon : " + c.telp + "\n\n");
            w.write("Barang  : " + item.nama + "\n");
            w.write("Harga   : Rp " + item.harga + "\n");
            w.write("Jumlah  : " + item.jumlah + "\n");
            w.write("Total   : Rp " + item.totalAkhir() + "\n");
            w.write("==============================\n");
            w.write("Terima kasih telah berbelanja!\n");

            System.out.println("\n✅ Nota berhasil disimpan ke: " + fileName);
        } catch (IOException e) {
            System.out.println("❌ Gagal menyimpan nota: " + e.getMessage());
        }
    }

    /**
     * Method utama untuk menjalankan program pemesanan.
     *
     * @param args argumen dari command line (tidak digunakan)
     */
    public static void main(String[] args) {
        Item item = new Item("Kemeja Batik", 200000, 3);
        Customer c = new Customer("Andi", "Jl. Merdeka No. 5", "08123456789");

        tampilkanNota(item, c);
        simpanNota(item, c);
    }
}
