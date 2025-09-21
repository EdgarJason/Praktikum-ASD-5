public class Main {
    public static void main(String[] args) {
        DLL<String> list = new DLL<>();

        System.out.println("== PENGUJIAN PADA LIST KOSONG ==");
        System.out.println("Apakah list kosong? " + list.isEmpty());
        System.out.println("Ukuran list: " + list.size());
        list.printList();
        System.out.println("----------------------------------------\n");

        System.out.println("== PENGUJIAN METHOD PENAMBAHAN DATA ==");
        System.out.println("Menambahkan 'A' di awal...");
        list.addFirst("A");
        list.printList();

        System.out.println("\nMenambahkan 'B' di akhir...");
        list.addLast("B");
        list.printList();

        System.out.println("\nMenambahkan 'C' di awal...");
        list.addFirst("C");
        list.printList();

        System.out.println("\nMenambahkan 'D' di akhir...");
        list.addLast("D");
        list.printList();
        System.out.println("----------------------------------------\n");

        System.out.println("== PENGUJIAN METHOD PENYISIPAN DATA DITENGAH (insertAt) ==");
        System.out.println("Menyisipkan 'EX' di indeks 2...");
        list.insertAt(2, "EX");
        list.printList();

        System.out.println("\nMenyisipkan 'FX' di akhir (indeks 5)...");
        list.insertAt(5, "FX");
        list.printList();

        System.out.println("\nMenyisipkan 'GX' di awal (indeks 0)...");
        list.insertAt(0, "GX");
        list.printList();
        System.out.println("----------------------------------------\n");

        System.out.println("== PENGUJIAN METHOD PENGAKSESAN & PENCARIAN ==");
        System.out.println("Data pada indeks 3 adalah: " + list.get(3));
        System.out.println("Data pada indeks 0 adalah: " + list.get(0));
        System.out.println("\nMencari data 'Z': " + list.find("Z"));
        System.out.println("Mencari data 'A': " + list.find("A"));
        System.out.println("----------------------------------------\n");

        System.out.println("== PENGUJIAN METHOD PENGHAPUSAN DATA ==");
        list.printList();

        System.out.println("\nMenghapus data pertama...");
        list.removeFirst();
        list.printList();

        System.out.println("\nMenghapus data terakhir...");
        list.removeLast();
        list.printList();

        System.out.println("\nMenghapus data pada indeks 2 ('EX')...");
        list.removeAt(2);
        list.printList();

        System.out.println("\nMenghapus data terakhir...");
        list.removeLast();
        list.printList();

        System.out.println("\nMenghapus semua sisa data...");
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.printList();
        System.out.println("Apakah list sekarang kosong? " + list.isEmpty());
        System.out.println("----------------------------------------\n");

        System.out.println("== PENGUJIAN INISIALISASI ==");
        list.addFirst("A");
        list.addLast("B");
        list.addFirst("C");

        System.out.println("Isi data sebelum");
        list.printList();

        list.inisialisasi();

        System.out.println("Isi data setelah diinisialisasi");
        list.printList();
        System.out.println("----------------------------------------\n");

        System.out.println("== PENGUJIAN PENANGANAN ERROR (EXCEPTION) ==");
        try {
            System.out.println("Mencoba mengakses indeks -1...");
            list.get(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error yang ditangkap: " + e.getMessage());
        }

        try {
            System.out.println("Mencoba menyisipkan data di indeks 10 (pada list kosong)...");
            list.insertAt(10, "Data Error");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error yang ditangkap: " + e.getMessage());
        }
        System.out.println("----------------------------------------\n");

        System.out.println("Semua pengujian selesai.");


    }
}