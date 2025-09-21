public class MainMahasiswa {
    public static void main(String[] args) {
        DLL<Mahasiswa> daftarMahasiswa = new DLL<>();

        System.out.println("== Menambahkan Mahasiswa Secara Urut Berdasarkan IPK ==");

        Mahasiswa m1 = new Mahasiswa("25001", "Budi", 3.85);
        Mahasiswa m2 = new Mahasiswa("25002", "Vincent", 4.0);
        Mahasiswa m3 = new Mahasiswa("25003", "Sven", 3.5);
        Mahasiswa m4 = new Mahasiswa("25004", "Elsa", 3.9);
        Mahasiswa m5 = new Mahasiswa("25005", "Casey", 3.2);

        System.out.println("\nMenambahkan " + m1 + "...");
        daftarMahasiswa.addSorted(m1);
        daftarMahasiswa.printList();

        System.out.println("\nMenambahkan " + m2 + "...");
        daftarMahasiswa.addSorted(m2);
        daftarMahasiswa.printList();

        System.out.println("\nMenambahkan " + m3 + "...");
        daftarMahasiswa.addSorted(m3);
        daftarMahasiswa.printList();

        System.out.println("\nMenambahkan " + m4 + "...");
        daftarMahasiswa.addSorted(m4);
        daftarMahasiswa.printList();

        System.out.println("\nMenambahkan " + m5 + "...");
        daftarMahasiswa.addSorted(m5);
        daftarMahasiswa.printList();

        System.out.println("\nHasil Akhir List Mahasiswa Terurut:");
        daftarMahasiswa.printList();

        System.out.println("\nMenampilkan mahasiswa dalam ASC dan DESC:");
        daftarMahasiswa.displayASC();
        daftarMahasiswa.displayDESC();
    }
}