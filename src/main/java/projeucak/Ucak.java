package projeucak;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ucak {
    /*
    A şehrinden uçmak isteyen bir yolcu B şehrine 500km C şehrine  700km  D şehrine  900 km mesafededir.
    Bilet tarifesi:
    km birim fiyati : 0.10$
    yolcu 12 yasindan kucukse toplam fiyat %50 indirim,
    12 ve 24 yas arasindaysa 10% indirim,
    65 yasindan buyukse 30% indirim,
    bilet gidis donus alinirrsa 20% indirim uygulayan bi app create ediniz
 */

    static Scanner scan = new Scanner(System.in);
    static Scanner input = new Scanner(System.in);
    static SehirlerinKmleri km = new SehirlerinKmleri();

    static double toplamFiyat;

    public static void main(String[] args) {
        gidilecekSehirUcreti();

    }

    public static void gidilecekSehirUcreti() {
        System.out.println("Ucmak istediginiz sehri yaziniz  B C D");
        String sehir = input.next().toUpperCase();

        switch (sehir) {
            case "B":
                toplamFiyat = km.getB() * km.getBirimFiyat();
                System.out.println("Tek yon bilet ucretiniz :" + toplamFiyat);

                gidisDonusMu();
                yas();
                break;
            case "C":
                toplamFiyat = km.getC() * km.getBirimFiyat();
                System.out.println("Tek yon bilet ucretiniz :" + toplamFiyat);
                gidisDonusMu();
                yas();
                break;
            case "D":
                toplamFiyat = km.getD() * km.getBirimFiyat();
                System.out.println("Tek yon bilet ucretiniz :" + toplamFiyat);
                gidisDonusMu();
                yas();
                break;
            default:
                System.out.println("Lutfen gecerli bir sehir giriniz.");
                gidilecekSehirUcreti();
        }
    }

    public static int yas;

    public static void yas() {

        while (true) {

            try {
                System.out.println("Yas indirimden yararlanabilmek icin yasinizi giriniz : ");
                yas = scan.nextInt();

                if (yas < 12) {
                    toplamFiyat = toplamFiyat * 0.5;
                    System.out.println("İndirimli bilet fiyatiniz " + toplamFiyat);
                } else if (yas < 25) {
                    toplamFiyat = toplamFiyat * 0.9;
                    System.out.println("İndirimli bilet fiyatiniz " + toplamFiyat);
                } else if (yas > 65) {
                    toplamFiyat = toplamFiyat * 0.7;
                    System.out.println("İndirimli bilet fiyatiniz " + toplamFiyat);
                } else {
                    System.out.println("Indirim kategorisinde degilsiniz.Biletiniz : " + toplamFiyat);
                }

            } catch (Exception e) {
                String str = scan.next();
                System.out.println("Lutfen yasinizi rakam olarak giriniz.");

            }

        }
    }

    public static void gidisDonusMu() {
        while (true) {

            try {
                System.out.println("Yolculugunuz tek yon mu gidis donus mu ? \n " +
                        "Gidis Donus icin:1 Tek yon icin:2 yi tuslayiniz.");
                int secim = scan.nextInt();
                if (secim == 1) {
                    System.out.println("Gidis donus biletlerinde %20 indirim uygulanmaktadir.");
                    toplamFiyat = toplamFiyat * 2 * 0.8;
                    System.out.println("Gisid donus indirimli fiyatiniz: " + toplamFiyat);
                } else if (secim == 2) {
                    System.out.println("Tek yon biletlerde indirim uygulanmamaktadir.Biletiniz: " + toplamFiyat);
                } else System.out.println("Lutfen gecerli bir giris yapiniz.");
            } catch (Exception e) {
                String str = scan.next();
                System.out.println("Lutfen dogru tuslama yapiniz.");


            }
        }
    }
}


