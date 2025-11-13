package KRSMAHASISWA;
import java.util.ArrayList;
import java.util.List;

class Mahasiswa {
    private String nim;
    private String nama;
    private List<MataKuliah> mkList;
    int totalSks;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.mkList = new ArrayList<>();
        this.totalSks = 0;
    }

    public boolean addMk(MataKuliah mk) {
        if (totalSks + mk.getSks() <= 24) {
            mkList.add(mk);
            totalSks += mk.getSks();
            return true;
        } else {
            return false;
        }
    }

    public String getKpsTtd() {
        // Logika sederhana: berdasarkan NIM (diasumsikan NIM adalah angka), assign KPS
        String[] kpsList = {"Dr. Ahmad Santoso", "Prof. Budi Prasetyo", "Dr. Citra Dewi"};
        try {
            int index = Integer.parseInt(nim) % 3;
            return kpsList[index];
        } catch (NumberFormatException e) {
            return "KPS Tidak Diketahui";  // Jika NIM bukan angka
        }
    }

    public void printKrs() {
        System.out.println("\n=== KARTU RENCANA STUDI (KRS) ===");
        System.out.println("NIM: " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("\nDaftar Mata Kuliah:");
        for (MataKuliah mk : mkList) {
            System.out.println("- Kode: " + mk.getKode() + ", Nama: " + mk.getNama() + ", SKS: " + mk.getSks());
        }
        System.out.println("\nTotal SKS: " + totalSks);
        System.out.println("Tanda Tangan KPS: " + getKpsTtd());
        System.out.println("=================================");
    }
}

