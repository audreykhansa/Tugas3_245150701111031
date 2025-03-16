package TugasPraktikum3;

import java.util.Scanner;
import java.util.ArrayList;

class PengirimanBarang {
    private String namaPengirim;
    private String alamatTujuan;
    private double berat;
    private double biayaDasar;
    private ArrayList<String> jenisPenanganan;
    private double biayaTambahan;
    private boolean surchargeApplied;
    private double surcharge;
    private double diskon;

    public PengirimanBarang() {
        this.namaPengirim = "";
        this.alamatTujuan = "";
        this.berat = 0;
        this.biayaDasar = 0;
        this.jenisPenanganan = new ArrayList<>();
        this.biayaTambahan = 0;
        this.surchargeApplied = false;
        this.surcharge = 0;
        this.diskon = 0;
    }

    public PengirimanBarang(String namaPengirim, String alamatTujuan, double berat, ArrayList<Integer> pilihanPenanganan) {
        this();
        this.namaPengirim = namaPengirim;
        this.alamatTujuan = alamatTujuan;
        this.berat = berat;
        this.setBiayaDasar(berat);
        this.setPenangananKhusus(pilihanPenanganan);
    }

    public double getBiayaDasar() {
        return biayaDasar;
    }

    public double getBiayaTambahan() {
        return biayaTambahan;
    }

    public ArrayList<String> getJenisPenanganan() {
        return jenisPenanganan;
    }

    public boolean isSurchargeApplied() {
        return surchargeApplied;
    }

    public double getDiskon() {
        return diskon;
    }

    public double getSurcharge() {
        return surcharge;
    }

    public double hitungOngkir(int diskonPersen) {
        diskon = biayaDasar * (diskonPersen / 100);
        return biayaDasar - diskon;
    }

    public double hitungOngkir(double diskonPersen, double biayaTambahan) {
        diskon = biayaDasar * (diskonPersen / 100);
        return biayaDasar - diskon + biayaTambahan;
    }

    public double hitungOngkir(double jarak) {
        double biayaJarak = biayaDasar;
        if (jarak > 50.0) {
            surchargeApplied = true;
            surcharge = biayaDasar * 0.1;
            biayaJarak += surcharge;
        } else {
            surchargeApplied = false;
            diskon = biayaDasar * 0.05;
            biayaJarak -= diskon;
        }
        return biayaJarak;
    }

    public void setBiayaDasar(double berat) {
        if (berat > 0 && berat <= 1.0) biayaDasar = 10000;
        else if (berat > 1.0 && berat <= 2.0) biayaDasar = 20000;
        else if (berat > 2.0 && berat <= 3.0) biayaDasar = 30000;
        else if (berat > 3.0 && berat <= 4.0) biayaDasar = 40000;
        else if (berat > 4.0 && berat <= 5.0) biayaDasar = 50000;
        else if (berat > 5.0 && berat <= 6.0) biayaDasar = 60000;
        else if (berat > 6.0 && berat <= 7.0) biayaDasar = 70000;
        else if (berat > 7.0 && berat <= 8.0) biayaDasar = 80000;
        else if (berat > 8.0 && berat <= 9.0) biayaDasar = 90000;
        else if (berat > 9.0 && berat <= 10.0) biayaDasar = 100000;
        else biayaDasar = 110000;
    }

    public void setPenangananKhusus(ArrayList<Integer> pilihanPenanganan) {
        for (int pilihan : pilihanPenanganan) {
            switch (pilihan) {
                case 1 -> { jenisPenanganan.add("Asuransi"); biayaTambahan += 5000; }
                case 2 -> { jenisPenanganan.add("Penanganan Fragile"); biayaTambahan += 7000; }
                case 3 -> { jenisPenanganan.add("Pengiriman Ekspres"); biayaTambahan += 10000; }
            }
        }
    }
}
