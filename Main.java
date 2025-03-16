package TugasPraktikum3;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void displayInfoLogistik() {
        System.out.println("FastExpress Logistics");
        System.out.println("Layanan Pengiriman Barang Terpercaya ke Seluruh Indonesia");
        System.out.println("Hubungi: 0800-1234-FAST");
        System.out.println();
    }

    public static void main(String[] args) {
        displayInfoLogistik();
        Scanner owd = new Scanner(System.in);

        System.out.print("Nama Pengirim: ");
        String namaPengirim = owd.nextLine();

        System.out.println("\nArea Pengiriman:");
        System.out.println("1. Dalam Area Malang");
        System.out.println("2. Luar Area Malang");
        System.out.print("Masukkan pilihan (1 atau 2): ");
        int pilihanArea = owd.nextInt();
        owd.nextLine();

        String alamatTujuan;
        double diskonArea = 0;

        if (pilihanArea == 1) {
            diskonArea = 0.05;
            System.out.print("\nDaerah di Malang: ");
            alamatTujuan = owd.nextLine();
        } else {
            diskonArea = 0.10;
            System.out.print("\nAlamat Tujuan: ");
            alamatTujuan = owd.nextLine();
        }

        System.out.print("\nBerat Barang (kg): ");
        double berat = Double.parseDouble(owd.nextLine().replace(',', '.'));

        System.out.print("\nJarak Pengiriman (km): ");
        double jarak = Double.parseDouble(owd.nextLine().replace(',', '.'));

        System.out.println("\nJenis Penanganan Khusus (Contoh: '1' atau '1, 2, 3'):");
        System.out.println("1. Asuransi (Rp5.000)");
        System.out.println("2. Penanganan Fragile (Rp7.000)");
        System.out.println("3. Pengiriman Ekspres (Rp10.000)");
        System.out.println("4. Tidak ada");
        System.out.print("Masukkan pilihan: ");

        String input = owd.nextLine();
        String[] pilihanStr = input.split(",");
        ArrayList<Integer> pilihanPenanganan = new ArrayList<>();
        for (String p : pilihanStr) {
            pilihanPenanganan.add(Integer.parseInt(p.trim()));
        }

        PengirimanBarang pengiriman = new PengirimanBarang(namaPengirim, alamatTujuan, berat, pilihanPenanganan);

        double biayaDasar = pengiriman.getBiayaDasar();
        double biayaSetelahJarak = pengiriman.hitungOngkir(jarak);
        double biayaDiskonArea = biayaDasar * diskonArea;
        double biayaTotal = biayaSetelahJarak - biayaDiskonArea + pengiriman.getBiayaTambahan();

        System.out.println("\n=== FastExpress Logistics: Ongkos Pengiriman Barang ===");
        System.out.printf("Nama Pengirim               : %s\n", namaPengirim);
        System.out.printf("Alamat Tujuan               : %s\n", alamatTujuan);
        System.out.printf("Berat Barang                : %.1f kg\n", berat);
        System.out.printf("Jarak Tempuh Pengiriman     : %.1f km\n", jarak);
        System.out.println("Jenis Penanganan Khusus     : " + pengiriman.getJenisPenanganan());
        System.out.printf("Biaya Dasar                 : Rp%,.0f\n", biayaDasar);

        if (pengiriman.isSurchargeApplied()) {
            System.out.printf("Biaya Surcharge (10%%)       : Rp%,.0f\n", pengiriman.getSurcharge());
        } else {
            System.out.printf("Biaya Diskon (5%%)           : Rp%,.0f\n", pengiriman.getDiskon());
        }

        System.out.printf("Biaya Setelah Jarak         : Rp%,.0f\n", biayaSetelahJarak);
        System.out.printf("Biaya Diskon Area           : Rp%,.0f (%.1f%%)\n", biayaDiskonArea, diskonArea * 100);
        System.out.printf("Biaya Penanganan Khusus     : Rp%,.0f\n", pengiriman.getBiayaTambahan());
        System.out.printf("Biaya Total                 : Rp%,.0f\n", biayaTotal);

        owd.close();
    }
}
