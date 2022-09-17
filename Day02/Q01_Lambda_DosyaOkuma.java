package Lambda_Functional_Programing_Practice.Day02;

import java.io.IOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q01_Lambda_DosyaOkuma { // yolu src/lambda_practice/siirler.txt

    /*
    dosya eklemek icin 2 yol var
    1) Files.lines(Path.of("path")  buradan stream e eklemek icin
    Stream <String> satir=Files.lines(Path.of(".........."));
    bu bize tekrardan stream tanimlamadan kullanmayi saglar
    2) //Files.lines(Paths.get("..........")).  kullanilir
    ==========================================================
    intellj dosya eklemek icin src => new=>file=>text diyoruz ve istedigimiz metni buraya kopyaliyoruz
    bu dosyanin path almak icin dosyanin uzerine gelip sag tikliyoruz(burada dosya C7_TextFile)
    sonrasinda copy path seciyoruz bundan sonra iki secenek var
    1) absolute path seciyoruz yada
    2) path from content root seciyoruz
    her ikisinde de path kopyalamis oluyoruz
    cevirirken EXCEPTION OLUSMASIN DIYE => throws IOException <= EKLEMELIYIZ
    buda lines altinda kirmizi uyari veriyor uzerine tiklayinca kendiliginden oluyor
    */

    public static void main(String[] args) throws IOException { // src/Lambda_Functional_Programing_Practice/Day02/siirler.txt

        System.out.println("\nTASK 0 --> siirler.txt dosyasini okuyunuz -->  ");

        //1.yol:
        Path muti = Path.of("src/Lambda_Functional_Programing_Practice/Day02/siirler.txt");//siirler dosyasi muti obj sine atandi
        Stream<String> akis = Files.lines(muti);//muti obj si akis obj sine atanarak Stream classsinda akisa alindi

        //buyuk harfe cevrildi
        akis.map(String::toUpperCase).forEach(Utils::yazdır);
        //2.yol
        Files.lines(Path.of("src/Lambda_Functional_Programing_Practice/Day02/siirler.txt"))
                .forEach(Utils::yazdır);


        System.out.println("\nTASK 1  --> siirler.txt dosyasindaki ilk satiri kucuk harflerle yazdirin  -->  ");


        System.out.println("\nTASK 2 --> siirler.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        System.out.println(Files.lines(muti). // Dosya akısa alindi
                map(String::toLowerCase). // tamami kucuk harfe cevrildi.
                filter(t -> t.contains("hatir")). // her bir satirda hatır kelimesi var mi kontrol edildi.
                count()); // kac tane hatir varsa hepsinin sayisi yazdirildi.


        System.out.println("\nTASK 3  --> siirler.txt dosyasindaki ayni kelimeleri cikartarak yazdiriniz. -->  ");
        // 1. YOL
        System.out.println(Files.lines(muti).
                map(t -> t.split(" ")). // her bir kelime alindi.
                        flatMap(Arrays::stream). // duz bir yapiya yani tek bir array'e cevrildi.
                        distinct(). //
                        collect(Collectors.toList()));

        // 2. YOL
        System.out.println(Files.lines(muti).
                map(t -> t.split(" ")).
                flatMap(Arrays::stream).
                collect(Collectors.toSet()));


        System.out.println("\nTASK 4 --> siirler.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        Files.lines(muti).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                sorted().
                forEach(Utils::yazdir);


        System.out.println("\nTASK 5 --> siirler.txt dosyasinda gonlum kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        System.out.println(Files.lines(muti).
                map((t -> t.toLowerCase().split(" "))).
                flatMap(Arrays::stream).
                filter(t -> t.contains("gonlum")).
                count());


        System.out.println("\nTASK 6 --> siirler.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        System.out.println(Files.lines(muti).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).
                count());


        System.out.println("\nTASK 7 --> siirler.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        Files.lines(muti).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).
                forEach(Utils::yazdir);


        System.out.println("\nTASK 8 --> siirler.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        // 1. YOL
        System.out.println(Files.lines(muti).
                map(t -> t.toLowerCase().split("")).
                flatMap(Arrays::stream).
                distinct().
                count());

        // 2. YOL
        System.out.println(Files.lines(muti).
                map(t -> t.replaceAll("\\W", "").
                        replaceAll("\\d", "").
                        split("")).
                flatMap(Arrays::stream).
                distinct().
                count());

        System.out.println("\nTASK 9 --> siirler.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        System.out.println("\nTASK 10 --> siirler.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
    }


}
