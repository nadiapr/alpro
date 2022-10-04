import java.util.Scanner;

public class Siakad {

   // public static void main (String[] args) {
        static Mahasiswa [] mahasiswa = new Mahasiswa[1000];
        static int jumlahData = 0;
        //mahasiswa.setNim("21520241007");
        //System.out.println(mahasiswa.getNim());

    public static void tambahData(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Silakan tambah data");
        System.out.print("Nama :");
        String nama = scan.nextLine();
        System.out.print("NIM :");
        String nim = scan.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNama(nama);
        mahasiswa[jumlahData].setNim(nim);
        jumlahData++;
    }

    public static void lihatData(){
        System.out.println("Berikut data Anda");
        int i = 0;
        while (i<jumlahData) {
            System.out.println(mahasiswa[i].getNama() + "" + mahasiswa[i].getNim());
            i++;
        }
    }

    public static void main(String [] args) {
        Scanner scan =  new Scanner(System.in);
        int menu;
        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu = ");
            menu = scan.nextInt();
            if (menu ==1){
                tambahData();
                //System.out.println("Silakan tambah data");
            } else if (menu==2) {
                lihatData();
                //System.out.println("Berikut data Anda");
            }
        } while (menu!= 3);
    }
}
