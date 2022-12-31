import java.util.Scanner;

public class Siakad {

    // public static void main (String[] args) {
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];
    static int jumlahData = 0;
    //mahasiswa.setNim("21520241007");
    //System.out.println(mahasiswa.getNim());

    public static void tambahData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Silakan tambah data");
        System.out.print("Nama :");
        String nama = scan.nextLine();
        System.out.print("NIM :");
        int nim = scan.nextInt();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNama(nama);
        mahasiswa[jumlahData].setNim(nim);
        jumlahData++;
    }

    public static void lihatData() {
        System.out.println("Berikut data Anda");
        int i = 0;
        while (i < jumlahData) {
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
    }

    public static void urutData() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pilih algoritma pengurutan");
        System.out.println("1. EXCHANGE SORT");
        System.out.println("2. SELECTION SORT");
        System.out.println("3. BUBBLE SORT");
        System.out.println("4. QUICK SORT");
        System.out.println("5. SHELL SORT");
        System.out.print("Pilih algoritma = ");
        int algo = scan.nextInt();
        switch (algo) {
            case 1: {
                exchangeSort();
                break;
            }
            case 2: {
                selectionSort();
                break;
            }
            case 3: {
                bubbleSort();
            }
            case 4: {
                quickSort(mahasiswa, 0, jumlahData - 1);
            }
            case 5: {
                shellSort();
            }
        }

    }

    public static void exchangeSort() {
        for (int x = 0; x < jumlahData; x++) {
            for (int y = x + 1; y < jumlahData; y++) {
                if (mahasiswa[x].getNim() > (mahasiswa[y].getNim())) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    public static void selectionSort() {
        for (int x = 0; x < jumlahData; x++) {

            //mencari nilai minimum
            int minInd = x;
            for (int y = x + 1; y < jumlahData; y++) {
                if (mahasiswa[x].getNim() > (mahasiswa[y].getNim())) {
                    minInd = y;
                }
            }

            //exchange nilai terkecil dengan nilai pertama pada urutan
            Mahasiswa temp = mahasiswa[x];
            mahasiswa[x] = mahasiswa[minInd];
            mahasiswa[minInd] = temp;
        }
    }

    public static void bubbleSort() {
        for (int x = 0; x < jumlahData; x++) {
            for (int y = 0; y < jumlahData - x - 1; y++) {
                if (mahasiswa[x].getNim() > (mahasiswa[y + 1].getNim())) {
                    Mahasiswa temp = mahasiswa[y];
                    mahasiswa[y] = mahasiswa[y + 1];
                    mahasiswa[y + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Mahasiswa[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(Mahasiswa[] arr, int low, int high) {
        int p = low, j;
        for (j = low + 1; j <= high; j++)
            if (arr[j].getNim() < (arr[low].getNim()))
                swap(arr, ++p, j);

        swap(arr, low, p);
        return p;
    }

    static void swap(Mahasiswa[] arr, int low, int pivot) {
        Mahasiswa tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    public static void shellSort() {
        //jarak antar elemen yang dibandingkan
        int d = jumlahData / 2;
        while (d > 0) {
            for (int x = d; x < jumlahData; x++) {
                Mahasiswa current = mahasiswa[x];
                int y = x - d;

                //possition
                while (y >= 0 && mahasiswa[y].getNim() > (current.getNim())) {
                    mahasiswa[y + d] = mahasiswa[y];
                    y -= d;

                }
                mahasiswa[y + d] = current;
            }
            d /= 2;
        }
    }

    public static void cariData() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Pilh data yang akan dicari!");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Pilih pencarian = ");
        int cari = scan.nextInt();
        switch (cari) {
            case 1: {
                linearSearch();
                break;
            }
            case 2: {
                System.out.print("Masukan Nim = ");
                int filterValue = scan.nextInt();
                Integer indexFound = binarySearch(mahasiswa, filterValue, 0, jumlahData - 1);
                if (indexFound != null) {
                    System.out.println("Data yang anda cari :");
                    System.out.println(mahasiswa[indexFound].getNama() + " " + mahasiswa[indexFound].getNim());
                } else {
                    System.out.println("Data tidak ditemukan");
                }
                binarySearch(mahasiswa, filterValue, 0, jumlahData - 1);
                break;
            }
        }
    }

    public static void linearSearch() {
        Scanner scan = new Scanner(System.in);
        String cari = null;
        System.out.println("Masukkan nama mahasiswa yang ingin Anda cari");
        System.out.print("=> ");
        cari = scan.nextLine();

        // perulangan untuk elemen pada array
        for (int x = 0; x < jumlahData; x++) {
            // mecocokkan elemen dengan data yang diinput
            if (mahasiswa[x].getNama().compareTo(cari) == 0) {
                System.out.println("Data ditemukan.");
                System.out.println("Nama: " + mahasiswa[x].getNama() + " NIM: " + mahasiswa[x].getNim());
            } else {
                System.out.println("Data tidak ditemukan.");
            }
        }
    }

    public static Integer binarySearch(Mahasiswa[] arr, int filterValue, int low, int high) {

        quickSort(mahasiswa, 0, jumlahData - 1);
        if (low > high) {
            return null;
        } else {
            int mid = (low + high) / 2;
            int temp2 = Integer.parseInt(String.valueOf(arr[mid].getNim()));
            if (Integer.valueOf(filterValue) == temp2) {

                return mid;
            } else if (Integer.valueOf(filterValue) > temp2) {
                return binarySearch(mahasiswa, filterValue, mid + 1, high);

            } else {
                return binarySearch(mahasiswa, filterValue, low, mid - 1);
            }
        }
    }

    public static void editData() {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        while (i < jumlahData) {
            System.out.print(i + 1 + ". ");
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
        System.out.print("Pilih Nomor Data Yang Ingin Diubah = ");
        int xdata = scan.nextInt() - 1;
        System.out.print("Masukan Nama Baru = ");
        String nama = scan.next();
        System.out.print("Masukan NIM Baru = ");
        int nim = scan.nextInt();

        mahasiswa[xdata].setNama(nama);
        mahasiswa[xdata].setNim(nim);
    }

    public static void hapusData() {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int j;
        while (i < jumlahData) {
            System.out.print(i + 1 + ". ");
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
        System.out.print("Pilih Nomor Data Yang Ingin Dihapus = ");
        int xdata = scan.nextInt() - 1;

        System.out.println("Nama : " + mahasiswa[xdata].getNama());
        System.out.println("Nim : " + mahasiswa[xdata].getNim());
        System.out.print("Hapus Data ini? (y/n) = ");
        String pil = scan.next();
        if (pil.equalsIgnoreCase("y")) {
            mahasiswa[xdata] = null;
            for (i = 0; i < jumlahData - 1; i++) {
                Mahasiswa temp;
                if (mahasiswa[i] == null) {
                    temp = mahasiswa[i + 1];
                    mahasiswa[i] = mahasiswa[i + 1];
                    mahasiswa[i + 1] = null;

                }
            }
            jumlahData = jumlahData - 1;
            System.out.println("Data Telah Dihapus!");
        } else {
        }
    }

    public static void UAS() {
        Scanner scan = new Scanner(System.in);
        if (jumlahData == 0) {
            System.out.println("Tidak ada data!");
        } else {
            int jarak = jumlahData - 1;
            int susut = 13;
            int urut = 0;
            while (urut == 0) {
                jarak = (jarak * 10) / susut;
                if (jarak <= 1) {
                    jarak = 1;
                    urut = 1;
                    for (int i = 0; i + jarak < jumlahData; i++) {
                        int temp2 = Integer.parseInt(String.valueOf(mahasiswa[i].getNim()));
                        int temp3 = Integer.parseInt(String.valueOf(mahasiswa[i + jarak].getNim()));
                        if (temp2 > (temp3)) {
                            Mahasiswa temp = mahasiswa[i];
                            mahasiswa[i] = mahasiswa[i + jarak];
                            mahasiswa[i + jarak] = temp;
                            urut = 0;
                        }
                    }
                }
            }
            System.out.println("Data telah diurutkan silahkan tampilkan data");
        }
    }

    public static void main(String [] args) {
        Scanner scan =  new Scanner(System.in);
        int menu;
        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampilkan Data");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Cari Data");
            System.out.println("5. Edit Data");
            System.out.println("6. Hapus Data");
            System.out.println("7. UAS");
            System.out.println("8. Keluar");
            System.out.print("Pilih Menu = ");
            menu = scan.nextInt();
            if (menu ==1) {
                tambahData();
            } else if (menu==2) {
                lihatData();
            } else if (menu==3){
                urutData();
            } else if (menu==4){
                cariData();
            }  else if (menu==5) {
                editData();
            }  else if (menu==6) {
                hapusData();
            } else if (menu==7) {
                UAS();
            }
        } while (menu!= 8);
    }
}
