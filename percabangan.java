import java.util.Scanner;

public class percabangan {
    public static void main(String[]args) {
        String nama, keterangan;
        int nilai;
        Scanner inp = new Scanner(System.in);

        //Input Data
        System.out.print("Masukkan nama = ");
        nama = inp.nextLine();

        System.out.print("Masukkan nilai = ");
        nilai = inp.nextInt();

        //Condition
        if(nilai >= 60) {
            keterangan = "Lulus";
        } else {
            keterangan = "Tidak Lulus";
        }
        System.out.println(nama + " " + keterangan);
    }
}