import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Sistem Pemesanan Online Shop
 * Program ini menampilkan simulasi sederhana dari sistem pemesanan online
 * dengan fitur perhitungan harga, diskon, dan pajak.
 *
 * @author Axell
 * @version 2.0
 */
public class SistemPemesananOnlineShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> daftarPesanan = new ArrayList<>();

        System.out.println("=== Sistem Pemesanan Online Shop ===");
        System.out.print("Masukkan jumlah item yang ingin dipesan: ");
        int jumlahItem = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        for (int i = 1; i <= jumlahItem; i++) {
            System.out.println("\nItem ke-" + i);
            System.out.print("Nama Barang: ");
            String nama = scanner.nextLine();

            System.out.print("Harga Barang: ");
            double harga = scanner.nextDouble();

            System.out.print("Jumlah Barang: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();

            daftarPesanan.add(new Item(nama, harga, jumlah));
        }

        double totalBayar = 0;
        System.out.println("\n=== Daftar Pesanan ===");
        for (Item item : daftarPesanan) {
            System.out.println(item);
            totalBayar += item.calculateTotalWithTax(); // Live Template digunakan di sini
        }

        System.out.printf("\nTotal yang harus dibayar (termasuk pajak & diskon): Rp %.2f\n", totalBayar);
        System.out.println("\nTerima kasih telah berbelanja!");
        scanner.close();
    }
}

/**
 * Kelas Item merepresentasikan satu barang dalam pesanan.
 */
record Item(String nama, double harga, int jumlah) {
    public static final double DISCOUNT_RATE = 0.10; // 10%
    public static final double TAX_RATE = 0.11;      // 11%

    /**
     * Menghitung total harga sebelum diskon dan pajak.
     * Template: calcTotal
     */
    public double calculateTotal() {
        // [LIVE TEMPLATE - calcTotal]
        return harga * jumlah;
    }

    /**
     * Menghitung total harga setelah diskon diterapkan.
     * Template: calcDiscount
     */
    public double calculateDiscountedTotal() {
        // [LIVE TEMPLATE - calcDiscount]
        return calculateTotal() - (calculateTotal() * DISCOUNT_RATE);
    }

    /**
     * Menghitung total harga setelah diskon dan pajak diterapkan.
     * Template: calcTotalWithTax
     */
    public double calculateTotalWithTax() {
        // [LIVE TEMPLATE - calcTotalWithTax]
        double discounted = calculateDiscountedTotal();
        return discounted + (discounted * TAX_RATE);
    }

    @Override
    public String toString() {
        return String.format("%s x%d | Harga: Rp%.2f | Total (Diskon+Pajak): Rp%.2f",
                nama, jumlah, harga, calculateTotalWithTax());
    }
}
