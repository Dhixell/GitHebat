import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SistemPemesananOnlineShop {

    // ====== Data Barang dan Pelanggan ======
    static class Item {
        String nama;
        double harga;
        int jumlah;

        static final double DISKON = 0.1;
        static final double PAJAK = 0.11;

        Item(String nama, double harga, int jumlah) {
            this.nama = nama;
            this.harga = harga;
            this.jumlah = jumlah;
        }

        double total() { return harga * jumlah; }

        double totalSetelahDiskon() {
            return total() - (total() * DISKON);
        }

        double totalAkhir() {
            double setelahDiskon = totalSetelahDiskon();
            return setelahDiskon + (setelahDiskon * PAJAK);
        }
    }

    static class Customer {
        String nama, alamat, telp;

        Customer(String nama, String alamat, String telp) {
            this.nama = nama;
            this.alamat = alamat;
            this.telp = telp;
        }
    }

    // ====== Fitur Menampilkan dan Menyimpan Nota ======
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

    // ====== Program Utama ======
    public static void main(String[] args) {
        Item item = new Item("Kemeja Batik", 200000, 3);
        Customer c = new Customer("Andi", "Jl. Merdeka No. 5", "08123456789");

        tampilkanNota(item, c);
        simpanNota(item, c);
    }
}
