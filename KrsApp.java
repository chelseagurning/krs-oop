package KRSMAHASISWA;
import java.util.Scanner;

public class KrsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selamat datang di Aplikasi Pengisian KRS");
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();
        
        Mahasiswa mahasiswa = new Mahasiswa(nim, nama);
        
        while (true) {
            System.out.println("\nTotal SKS saat ini: " + mahasiswa.totalSks + "/24");
            System.out.print("Masukkan kode mata kuliah (atau ketik 'stop' untuk berhenti): ");
            String kode = scanner.nextLine();
            if (kode.equalsIgnoreCase("stop")) {
                break;
            }
            System.out.print("Masukkan nama mata kuliah: ");
            String namaMk = scanner.nextLine();
            System.out.print("Masukkan SKS mata kuliah: ");
            try {
                int sks = Integer.parseInt(scanner.nextLine());
                MataKuliah mk = new MataKuliah(kode, namaMk, sks);
                if (mahasiswa.addMk(mk)) {
                    System.out.println("Mata kuliah berhasil ditambahkan.");
                } else {
                    System.out.println("Gagal menambahkan mata kuliah. Total SKS akan melebihi 24.");
                }
            } catch (NumberFormatException e) {
                System.out.println("SKS harus berupa angka. Coba lagi.");
            }
        }
        
        mahasiswa.printKrs();
        scanner.close();
    }
}
