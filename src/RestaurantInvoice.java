import java.util.ArrayList;
import java.util.Scanner;

class Menu {
    String nama;
    double harga;

    Menu(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }
}

class Pesanan {
    Menu menu;
    int jumlah;

    Pesanan(Menu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }

    // Custom Live Template (contoh)
    // Abbreviation: hitungTotal
    // Template Text: return $MENU$.harga * $JUMLAH$;
    double hitungTotal() {
        return menu.harga * jumlah;
    }
}

public class RestaurantInvoice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Daftar menu restoran
        Menu[] daftarMenu = {
                new Menu("Sate Ayam", 25000),
                new Menu("Nasi Uduk", 15000),
                new Menu("Bakso", 18000),
                new Menu("Es Jeruk", 8000),
                new Menu("Teh Hangat", 6000)
        };

        ArrayList<Pesanan> daftarPesanan = new ArrayList<>();

        System.out.println("======= MENU RESTORAN MAKMUR =======");
        for (int i = 0; i < daftarMenu.length; i++) {
            System.out.printf("%d. %-15s Rp %,8.0f%n", (i + 1), daftarMenu[i].nama, daftarMenu[i].harga);
        }

        char lanjut;
        do {
            System.out.print("\nPilih nomor menu: ");
            int pilihan = input.nextInt();

            System.out.print("Masukkan jumlah pesanan: ");
            int jumlah = input.nextInt();

            daftarPesanan.add(new Pesanan(daftarMenu[pilihan - 1], jumlah));

            System.out.print("Tambah pesanan lain? (y/n): ");
            lanjut = input.next().toLowerCase().charAt(0);
        } while (lanjut == 'y');

        // Hitung total keseluruhan
        double total = 0;
        System.out.println("\n=========== NOTA PEMESANAN ===========");
        System.out.printf("%-20s %-10s %-10s%n", "Menu", "Jumlah", "Subtotal");

        for (Pesanan p : daftarPesanan) {
            double subtotal = p.hitungTotal();
            total += subtotal;
            System.out.printf("%-20s %-10d Rp %,10.0f%n", p.menu.nama, p.jumlah, subtotal);
        }

        // Pajak dan diskon
        double pajak = total * 0.10;
        double diskon = total > 100000 ? total * 0.05 : 0;
        double grandTotal = total + pajak - diskon;

        System.out.println("--------------------------------------");
        System.out.printf("%-25s Rp %,10.0f%n", "Total", total);
        System.out.printf("%-25s Rp %,10.0f%n", "Pajak (10%)", pajak);
        if (diskon > 0)
            System.out.printf("%-25s Rp %,10.0f%n", "Diskon (5%)", diskon);
        System.out.printf("%-25s Rp %,10.0f%n", "Total Bayar", grandTotal);
        System.out.println("======================================");
        System.out.println("Terima kasih telah makan di Restoran Makmur!");
        input.close();
    }
}
