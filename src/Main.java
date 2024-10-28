import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {

    String name;
    double price;
    int quantity;

    MenuItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return price * quantity;
    }
}

public class Tugas1 {
    private static final ArrayList<MenuItem> orderList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Selamat datang di Restoran Firman!");
        System.out.println();
        boolean ordering = true;
        while (ordering) {
            System.out.print("Masukkan nama makanan: ");
            String name = scanner.nextLine();

            System.out.print("Masukkan harga makanan: ");
            double price = scanner.nextDouble();

            System.out.print("Masukkan jumlah yang dipesan: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();  // Mengonsumsi newline

            orderList.add(new MenuItem(name, price, quantity));

            System.out.print("Apakah Anda ingin menambah pesanan? (y/n): ");
            String choice = scanner.nextLine();
            ordering = choice.equalsIgnoreCase("y");
        }

        printReceipt();
    }

    private static void printReceipt() {
        System.out.println("\n=== Nota Pemesanan ===");
        double totalCost = 0;

        for (MenuItem item : orderList) {
            double itemTotal = item.getTotalPrice();
            System.out.printf("%s (x%d) - Rp%.2f\n", item.name, item.quantity, itemTotal);
            totalCost += itemTotal;
        }

        System.out.printf("\nTotal Pembayaran: Rp%.2f\n", totalCost);
        System.out.println("Terima kasih telah memesan di Restoran Kami!");
    }
}

