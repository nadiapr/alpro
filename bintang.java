import java.util.Scanner;
public class bintang {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int n = 5;
        for (int a = 1; a <= n; a++) {
            for (int b =4; b >= a; b--) {
                System.out.print(" ");
            }
            for (int c =1; c <= a; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
