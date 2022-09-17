package Lambda_Functional_Programing_Practice.Day01;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q03_Lambda {

    static ArrayList<String> names = new ArrayList<>(Arrays.asList("Tulay", "zekeriya", "hasan", "ismail", "osman", "fatih", "ersin", "mevlit"));
    static List<Integer> numbers = new ArrayList<>(Arrays.asList(25, 65, -56, 55, 98, -89, 65, 55, 21, -54, 9, 35, 35, 34));
    static List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "adana", "trilice", "havucdilim", "buryan",
            "kokorec", "kuzutandir", "guvec"));

    /* TASK :

     * Input olarak verilen listteki isimlerden
     * icinde 'a' harfi bulunanlari silen bir code create ediniz.
     *
     * INPUT : list1={"Ali","Veli","Ayse","Fatma","Omer"}
     * OUTPUT : [Veli,Omer]

     */
    public static void aHarfleriSilenGerisiniYazdiran(ArrayList<String> isimler) {
        /*
        1. YOL
       System.out.println(isimler.stream() // akisa alindi.
                .map(t -> t.toLowerCase()) // hepsi kucuk harfe cevrildi.
                .filter(t -> !t.contains("a")) // a harfi olmayanlar filtrelendi.
                .collect(Collectors.toList())); // liste atildi.

    Listemizi degistiriyor. Biz bu sekilde olmasini istemiyoruz.
        List mutable oldugu icin elemanlari işlem sonrasi kalici degistiginden
        comment-out yapiyoruz
    */

        // 2. YOL
        System.out.println(isimler.stream() // akisa alindi.
                .filter(t -> !t.contains("a") && !t.contains("A")) // a harfi olmayanlar filtrelendi.
                .collect(Collectors.toList())); // liste atildi.
    }


    /*
    En buyuk elemani bulun.
     */
    public static void maxElemanBul(List<Integer> sayi) {
        Optional<Integer> maxSayi = sayi.stream().reduce(Math::max);
        System.out.println(maxSayi);


        /*
         reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde)
         cevirmek icin kullanilir. Kullanımı yaygındır pratiktir.


         ==> Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme
             sürecinde, bir önceki adımda elde edilen sonuç bir sonraki adıma girdi olarak
             sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.

         ==> Reduce metodu ilk parametrede identity değeri, ikinci parametrede ise
             BinaryOperator türünden bir obj kullanılır. Reduce işleminde bir önceki hesaplanmış
             değer ile sıradaki değer bir işleme tabi tutulmaktadır. Işleme başlarken bir
             önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
         */
    }


    /*
    Task : List'teki tum elemanlarin toplamini yazdiriniz.
           Lambda Expression...
     */
    public static void elemanlariTopla(List<Integer> sayilar) {
        System.out.println(sayilar.stream().reduce(0, (a, b) -> a + b));

        /*
        2.YOL
        System.out.println(sayilar.stream().reduce(Integer::max));
         */
    }


    /*
    TODO task tek sayilarin karesini buyukten kucuge
     */
    public static void teklerinKareBuyuktenKucuge(List<Integer> sayi) {
        sayi.stream(). // liste akisa alindi
                filter(t -> t % 2 == 1). // tek olan rakamlari filtreledim.
                map(t -> t * t). // her tek sayinin karesi alindi
                sorted(Comparator.reverseOrder()). // buyukten kucuge siralandi
                forEach(Utils::yazdir); // seed methodu kullanarak method ref ile yazdirildi.
    }


    /*
     Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
     */
    public static void alfabetikBuyukHarfTekrarsiz(List<String> yemek) {
    }


    /*
     Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
     */
    public static void strKarakterSayisiYazdir(List<String> yemek) {
    }


    /*
     Task :TODO list elemanlarinin son harfine gore ters sirali print ediniz.
     */
    public static void sonHarfeGoreTersSira(List<String> yemek) {
        yemek.stream().
                sorted(Comparator. // siralama aksiyonuna girildi.
                        comparing(t -> t.toString(). // her bir eleman stringe cevrildi.
                        charAt(t.toString().length() - 1)). // son karakter 1 charAt ile alindi.
                        reversed()). // son haref gore siralandi.
                forEach(Utils::yazdir); // yazdirdi.

    }


    /*
     Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve
      karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
     */
    public static void karakterCiftKareBuyuktenKucuge(List<String> yemek) {
    }


    /*
     TODO Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
     */
    public static void karakterSayiYedidenBuyuk(List<String> yemek) {

        // Ilkel yontem ile
        boolean kontol = yemek.stream().allMatch(t -> t.length() <= 7);
        if (kontol) {
            System.out.print("List elemanlari 7 ve daha az harften olusur."); //
        } else {
            System.out.println("Bazi elemanlar 7'den buyuk.");
        }

        // Modern yazim java8 'in faydalari
        System.out.println(yemek.stream() // akisa alindi
                .allMatch(t -> t.length() <= 7) ? // 7'den kucuk olma durumu kontrol edildi ternary ile sarta bakildi
                "List elemanlari 7 ve daha az harften olusur." : // true ise mesaj donderildi.
                "Bazi elemanlar 7'den buyuk."); // false ise mesaj donderildi.
    }


    /*
    ==> anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    ==> allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    ==> noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
     */
    public static void basHarfiWIleBaslayan(List<String> yemek) {
    }


    /*
     TODO Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
     */
    public static void xIleBitenEleman(List<String> yemek) {
    }


    /*
     TODO Task : Karakter sayisi en buyuk elemani yazdiriniz.
     */
    public static void karkterEnFazla(List<String> yemek) {
        /*
        limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu
                    maxSize'dan uzun olmayacak şekilde kesilmiş bir akış return eder.
                    Stream return eder.
         */

        Stream<String> sonIsim = // limit kullandigimiz icin bu sonucu sonIsim objesine atadik.
                yemek.stream(). // akisa alindi.
                sorted(Comparator. // sortladik
                        comparing(t -> t.toString().length()). // sortlamayi length'ine gore yaptik
                        reversed()). // tersine cevirdik yani karakter sayisi en cok olan en basa geldi
                limit(1); // limit ile ilk elemani aldik yani listeyi ilk eleman ile sinirlandirdik.

        System.out.print( // sonIsim objesini data turu nedir. --> Stream oldugu icin ben bunu arraya cevirmem gerekli
                Arrays.toString // arra olanlari Stringe donusturup yazdirmamizi soyler
                        (sonIsim.toArray())); // Stream tipi arraya cevrildi.


    }


    /*
   TRİCK : •    Stream'ler ekrana direk yazdırılamaz. Stream'i toArray() ile Array'e çeviririz.
   Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
   •  Ör; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray()));
   kullanılabilir.
   */
    /*
    TODO Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
     */
    public static void sonHarfeGoreSiralaIlkHaricElmanlariYaz(List<String> yemek) {
    }


}
