import java.util.Scanner;
public class penjumlahan {
    public static void main (String [] args) {
        int x = 0;
        int y = 0;
        Scanner inp = new Scanner(System.in);

        System.out.print("Masukkan nilai x = ");
        x = inp.nextInt();
        System.out.print("Masukkan nilai y = ");
        y = inp.nextInt();
        int hasil = x + y;

        System.out.println("Total = " + hasil);

    }
}