
package tic;
import java.util.Scanner;
import java.util.Random;
public class Oyuncu {
    char harf;
   boolean insanmiKontrolu;
    String kullanici_adi;
    int boyut;
    public Oyuncu(){
        this.harf='x';
        this.insanmiKontrolu=true;
    }
    public Oyuncu(boolean insanmiKontrolu){
        this.insanmiKontrolu=insanmiKontrolu;
        if(this.insanmiKontrolu==true){
            this.harf='o';
        }
        else{
            this.harf='x';
        }
         }
    public Oyuncu(char hrf){
        this.harf=hrf;
    }
    

    String insanOyuncuHamlesiniKotrol(){
    String hamle;
        System.out.println("Sira sizde! Bir hamle giriniz:");
        Scanner giris=new Scanner(System.in);
        hamle=giris.nextLine();
       return hamle;  
    }
    String bilgisayarHamlesiUret(){
        Random rand = new Random(System.nanoTime()); 
        Random rand1=new Random(System.nanoTime());
        int sayi= rand.nextInt(boyut);
        int sayi2=rand1.nextInt(boyut);
        //System.out.println("sayi:"+sayi);
       String indis5=String.valueOf(sayi);
      String indis6=String.valueOf(sayi2);
      indis5=indis5.concat(indis6);
        return indis5;
    }

    
}
