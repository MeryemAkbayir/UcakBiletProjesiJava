package projekimlik;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KimlikMap {
    /*
           1) Kullanicidan kimlik numarasini(4 haneli), tam ismini, adresini, telefonunu, alin
           2) Kimlik numarasini key olarak, diger bilgileri value olarak bir map'e depolayin

            saveInfo() method olusturun:
            3)Kullanicidan bircok kimlik numarasi(4 haneli), isim, adres ve telefon alin.
            4)Kimlik numarasini key olarak, diger bilgileri value olarak bir map'e depolayin.
            5)Ayni kimlik numarasi ile bilgi girilmesine engel olun.

            getInfo() method olusturun:
            1)Kimlik numarasini girerek kullanicinin bilgilerine ulasin.
            2)Olmayan kimlik numarasi girilirse kullaniciya hata mesaji verin.

           removeInfo() method olusturun:
           1)Kimlik numarasini girerek data silin.
           2)Girilen kimlik numarasi yoksa kullaniciya hata mesaji verin.
           3)Collection bos ise kullaniciya hata mesaji verin.

           selectOption() method olusturun:
           1)Yukaridaki 3 methodu programi sonlandirana kadar secme hakki verin
   */

    static Scanner input = new Scanner(System.in);
    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        selectOption();
    }

    private static void saveInfo() {
        System.out.println("Lutfen 4 haneli kimlik numaranizi giriniz: ");
        String tc = input.next();
        input.nextLine();

        if (tc.length() == 4) {
            if (map.containsKey(tc)) {
                System.out.println("Bu tc numarasi sistemde kayitli");
                saveInfo();
            } else {
                System.out.println("Adinizi giriniz");
                String ad = input.next();

                System.out.println("Soyadinizi giriniz");
                String soyad = input.next();

                System.out.println("Adresinizi giriniz:");
                String adres = input.next();

                System.out.println("Telefon numaranizi giriniz :");
                String telNo = input.next();

                String values = ad + " " + soyad + " " + adres + " " + telNo;

                map.put(tc, values);
                System.out.println("Tebrikler... :)" + map);
                selectOption();
            }
        } else {
            System.out.println("Tc kimlik numaraniz 4 haneli olmalidir");
            saveInfo();
        }
    }

    private static void getInfo() {
        System.out.println("Lutfen 4 haneli kimli numaranizi giriniz:");
        String kimlik = input.next();
        if (map.containsKey(kimlik)) {
            System.out.println(map.get(kimlik));
        } else {
            System.out.println("Bu kimlik kayitli degil. Tekrar deneyin!");
            getInfo();
        }
        selectOption();
    }

    private static void removeInfo() {
        System.out.println("Silmek istediginiz 4 haneli kimlik numaranizi yaziniz");
        String silinecekKimlik = input.next();
        if (map.containsKey(silinecekKimlik)) {
            map.remove(silinecekKimlik);
            System.out.println("Silme islemi basariyla gerceklesti" + map);
        } else {
            System.out.println("bu tc kayitli degildir.");
            removeInfo();
        }
    }

    private static void cikis() {
        System.out.println("Cikis yapiliyor");
    }

    private static void selectOption() {
        System.out.println("Yapmak istediginiz islemi giriniz: " +
                "\n 1: Kullanici ekle \n 2: Kullanici bilgisi alma \n 3: Kullanici silme \n 4 : cikis");
        int secim = input.nextInt();

        switch (secim) {
            case 1:
                saveInfo();
                break;
            case 2:
                getInfo();
                break;
            case 3:
                removeInfo();
                break;
            case 4:
                cikis();
                break;
            default:
                System.out.println("Yanlis secim yaptiniz lutfen tekrar deneyin");
                selectOption();
                break;
        }

    }


}
