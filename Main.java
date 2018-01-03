package tic;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
   
//1.baştan başlasın +
    //kullanıcı x yerine f harfine basılınca çiksin +
    //kayıt etsin
//1.yarım kalan oyun devam etsin
//dosyalama işlemi başarili olmasdi ,kayitlidan başlama yi yap nesne içindeki geresiz çopleri temizle
// hamle dolu oldugunda sıan başkasına geçyor bu bir hatadır
public class Main {
    
  private static void dosyayiekle(int boyut, char[][] yarim_kalan, String adi, char oyuncu) 
{
    try{
      File dosya=new File("x.txt");
      FileWriter yazici = new FileWriter(dosya,true);
        try (BufferedWriter yaz = new BufferedWriter(yazici)) {
              yaz.write(oyuncu);
            yaz.newLine();
             yaz.write(adi);
             yaz.newLine();
             for(int i=0;i<boyut;i++){
                 for(int j=0;j<boyut;j++){
                     yaz.write(yarim_kalan[i][j]);   
                 }yaz.newLine();
             }
            
        }
        System.out.println("Ekleme başarılı");
    }
    catch(IOException hata){
        System.out.println("Hata");
    }
}
  //dene
 private static String vericek()
{
     String ad = new String();
     String bir=new String();
    try{
      FileReader fr=new FileReader("x.txt");
        try (BufferedReader br = new BufferedReader(fr)) {
           
            while((ad=br.readLine())!=null)
            {
                bir+=ad+" ";
               // System.out.println(ad);
            } 
          
           FileOutputStream yazici = new FileOutputStream("x.txt");
            yazici.close();
        }    }
    
    catch(IOException hata){
        
    }
  return bir;  
}

    public static void main(String[] args){
        int boyut;
        Scanner giris = new Scanner(System.in);
        int dongu = 0;
         boolean kayit_et;
        Oyun_tahtasi tahta = new Oyun_tahtasi(); 
        System.out.println("Yeni oyun acmak icin(true)yazin ");
        System.out.println("Kayitli oyundan devam etmek icin (false) yazin");
        boolean yeni;
        yeni = giris.nextBoolean();
        while(dongu<1){
        if (yeni == true) {
            System.out.println("Kullanici adi :");
            String isim = giris.next();      
            System.out.println("TERCİH YAPMAK ISTERMİSİN");
            System.out.println("'o'/(true)         'x'/(false)");
            boolean insan =giris.nextBoolean();
            while(dongu<1){
                if(insan==false){
                    while (dongu < 1) {
                        System.out.println("Oyun tahtasinin boyutunu 3 ,5 veya 7 olacak :");
                        System.out.println("Oyun tahtasinin boyutunu giriniz");
                        boyut = giris.nextInt();
                        Oyuncu oyun = new Oyuncu();
                        oyun.kullanici_adi = isim;
                        oyun.boyut=boyut;
                        tahta.boyut=boyut;
                        oyun.kullanici_adi=isim;
                        char oyuncu='x';
                        char pc='o';
                        if (boyut == 5 || boyut == 3 || boyut == 7) {
                            char matris[][] = new char[boyut][boyut];
                            for (int i = 0; i < boyut; i++) {
                                for (int j = 0; j < boyut; j++) {
                                    matris[i][j] = '.';
                                    System.out.print(matris[i][j]);
                                }
                                System.out.println();
                            }
                            tahta.matris=matris;
                            while(dongu<1){
                                String hamle_oyuncu=oyun.insanOyuncuHamlesiniKotrol();
                                    if("f".equals(hamle_oyuncu)){
                                        System.out.println("OYUNU KAYIT ETMEK ISTERMISINIZ?");
                                        System.out.println("EVET/(true)       HAYIR/(False)");
                                        boolean kayit1=giris.nextBoolean();
                                        if(kayit1==true){
                                        dosyayiekle(boyut,matris,isim,oyuncu);
                                         System.exit(0);
                                        }else{
                                         System.exit(0);    
                                        }
                                }
                        boolean kontrol_oyuncu=tahta.hamleyiYaz(hamle_oyuncu,oyuncu);
                        String hamle_pc=oyun.bilgisayarHamlesiUret();
                        boolean kontrol_pc=tahta.hamleyiYaz(hamle_pc, pc);
                        int kontrol=0;
                        int van = 0;
                       if(kontrol_oyuncu==true){
                           if(tahta.beraberlikKontrol()==true){
                               System.out.println("OYUN BERABERE BİTTİ");
                               van++;
                               break;
                           }if(van!=0){
                            break;
                        }
                        tahta.oyunTahtasiniYazdir();
                        if(tahta.kazanan(oyuncu)==true){
                           System.out.println(oyun.kullanici_adi+"TEBRİKLER OYUNU KAZANDINIZ");
                           break;
                    }
                    }else{
                       if(tahta.kazanan(oyuncu)==true){
                           System.out.println(oyun.kullanici_adi+"TEBRİKLER OYUNU KAZANDINIZ");
                           break;
                       }
                       else{
                           while(dongu<1){
                               System.out.println("OYUNCU :girdiginiz hamle dolu!");
                                    hamle_oyuncu=oyun.insanOyuncuHamlesiniKotrol();
                                    if("f".equals(hamle_oyuncu)){
                                    System.out.println("OYUNU KAYIT ETMEK ISTERMISINIZ?");
                                    System.out.println("EVET/(true)       HAYIR/(false)  ");
                                    boolean kayit2=giris.nextBoolean();
                                        if(kayit2==true){
                                        dosyayiekle(boyut,matris,isim,oyuncu);
                                         System.exit(0);
                                        }else{
                                         System.exit(0);    
                                        }
                                 }
                                kontrol_oyuncu=tahta.hamleyiYaz(hamle_oyuncu,oyuncu);
                                if(kontrol_oyuncu==true){
                                    if(tahta.beraberlikKontrol()==true){
                                        System.out.println("OYUN BERABERE BİTTİ");
                                        van++;
                                        break;
                                    }
                                    tahta.oyunTahtasiniYazdir();
                                    if(tahta.kazanan(oyuncu)==true){
                                        System.out.println(oyun.kullanici_adi+"TEBRİKLER OYUNU KAZANDINIZ");
                                        break;
                                    }
                    
                                    break;
                                }else
                                    continue;
                                }  
                      }
                       if(van!=0){
                           break;
                       }
                   }
                    System.out.println("Sira bilgisayarda ");
                    if(kontrol_pc==true){
                        if(tahta.beraberlikKontrol()==true){
                            System.out.println("OYUN BERABERE BİTTİ");
                            van++;
                            break;
                       }if(van!=0){
                        break;
                    }
                    tahta.oyunTahtasiniYazdir();
                    if(tahta.kazanan(pc)==true){
                        System.out.println(oyun.kullanici_adi+" OYUNU KAYBETTİNİZ");
                        kontrol++;
                        break;
                    }
                    }else{
                       if(tahta.kazanan(pc)==true){
                           System.out.println(oyun.kullanici_adi+" OYUNU KAYBiTTİNİZ");
                           kontrol++;
                           break;
                       }
                       else{
                           while(dongu<1){
                                System.out.println("PC girdiginiz hamle dolu!");
                                hamle_oyuncu=oyun.bilgisayarHamlesiUret();
                                kontrol_pc=tahta.hamleyiYaz(hamle_oyuncu,pc);
                                if(kontrol_pc==true){
                                    if(tahta.beraberlikKontrol()==true){
                                        System.out.println("OYUN BERABERE BITTI");
                                        van++;
                                        break;
                       }
                        tahta.oyunTahtasiniYazdir();
                        if(tahta.kazanan(pc)==true){
                           System.out.println(oyun.kullanici_adi+" OYUNU KAYBETTİNİZ");
                           kontrol++;
                           break;
                    }
                    break;
                   }else
                        continue;
                           }
                      
                       }
                       if(van!=0){
                           break;
                       }
                   }
                    if(kontrol!=0){
                          break;
                    }
                }while(dongu<1){
                    System.out.println("CIKMAK İÇİN 0 DEVAM ETMEK İCİN 1 TIKLAYIN ");
                    int cik;
                    cik=giris.nextInt();
                    if(cik==0){
                       System.out.println("GULE GULE!");
                       System.exit(0);
                   }
                   else if(cik==1){
                       break;
                   }
                   else if(cik<1||cik>1){
                       System.out.println("yanlis sayi girdiniz");
                       continue;
                   }
                }
            }
            }}
        else if(insan==true){
                while (dongu < 1) {
                System.out.println("Oyun tahtasinin boyutunu 3 ,5 veya 7 olacak :");
                System.out.println("Oyun tahtasinin boyutunu giriniz");
                boyut = giris.nextInt();
                Oyuncu oyun1 = new Oyuncu(insan);
                oyun1.kullanici_adi = isim;
                oyun1.boyut=boyut;
                tahta.boyut=boyut;
                oyun1.kullanici_adi=isim;
                char oyuncu='o';
                char pc='x';
                if (boyut == 5 || boyut == 3 || boyut == 7) {
                    char matris[][] = new char[boyut][boyut];
                    for (int i = 0; i < boyut; i++) {
                        for (int j = 0; j < boyut; j++) {
                            matris[i][j] = '.';
                            System.out.print(matris[i][j]);
                        }
                        System.out.println();
                    }
                tahta.matris=matris;
                    while(dongu<1){
                        String hamle_oyuncu=oyun1.insanOyuncuHamlesiniKotrol();
                        if("f".equals(hamle_oyuncu)){
                             System.out.println("OYUNU KAYIT ETMEK ISTERMISINIZ?");
                                     System.out.println("EVET/(true)       HAYIR/(false)  ");
                                    boolean kayit3=giris.nextBoolean();
                                        if(kayit3==true){
                                        dosyayiekle(boyut,matris,isim,oyuncu);
                                         System.exit(0);
                                        }else{
                                         System.exit(0);    
                                        }
                        }
                    boolean kontrol_oyuncu=tahta.hamleyiYaz(hamle_oyuncu,oyuncu);
                    String hamle_pc=oyun1.bilgisayarHamlesiUret();
                    boolean kontrol_pc=tahta.hamleyiYaz(hamle_pc, pc);
                    int van1 = 0;
                   if(kontrol_oyuncu==true){
                        if(tahta.beraberlikKontrol()==true){
                           System.out.println("OYUN BERABERE BİTTİ");
                           van1++;
                           break;
                       }
                        if(van1!=0){
                            break;
                        }
                      tahta.oyunTahtasiniYazdir();
                    if(tahta.kazanan(oyuncu)==true){
                           System.out.println(oyun1.kullanici_adi+"TEBRİKLER OYUNU KAZANDINIZ");
                           break;
                    }
                   }else{
                       if(tahta.kazanan(oyuncu)==true){
                           System.out.println(oyun1.kullanici_adi+"TEBRİKLER OYUNU KAZANDINIZ");
                           break;
                       }
                       
                       else{
                           while(dongu<1){
                               System.out.println("OYUNCU girdiginiz hamle dolu!");
                                 hamle_oyuncu=oyun1.insanOyuncuHamlesiniKotrol();
                                 if("f".equals(hamle_oyuncu)){
                                     System.out.println("OYUNU KAYIT ETMEK ISTERMISINIZ?");
                                     System.out.println("EVET/(true)       HAYIR/(false)  ");
                                     boolean kayit4=giris.nextBoolean();
                                        if(kayit4==true){
                                        dosyayiekle(boyut,matris,isim,oyuncu);
                                         System.exit(0);
                                        }else{
                                         System.exit(0);    
                                        }
                                 }
                    kontrol_oyuncu=tahta.hamleyiYaz(hamle_oyuncu,oyuncu);
                    if(kontrol_oyuncu==true){
                        if(tahta.beraberlikKontrol()==true){
                           System.out.println("OYUN BERABERE BİTTİ");
                           van1++;
                           break;
                       }
                      tahta.oyunTahtasiniYazdir();
                      if(tahta.kazanan(oyuncu)==true){
                           System.out.println(oyun1.kullanici_adi+"TEBRİKLER OYUNU KAZANDINIZ");
                           break;
                    }break;
                   }else
                        continue;
                           }
                    }
                    if(van1!=0){
                           break;
                       }
                   }
                   System.out.println("Sira bilgisayarda ");
                       if(kontrol_pc==true){
                            if(tahta.beraberlikKontrol()==true){
                                System.out.println("OYUN BERABERE BİTTİ");
                                van1++;
                                break;
                            }
                            if(van1!=0){
                                break;
                            }
                        tahta.oyunTahtasiniYazdir();
                        if(tahta.kazanan(pc)==true){
                        System.out.println(oyun1.kullanici_adi+"OYUNU KAYBETTİNİZ!");
                        break;
                       }}
                      else{
                      if(tahta.kazanan(pc)==true){
                           System.out.println(oyun1.kullanici_adi+"OYUNU KAYBETTİNİZ!");
                           break;
                       }
                    else{
                          while(dongu<1){ 
                           System.out.println("PC girdiginiz hamle dolu!");   
                           hamle_pc=oyun1.bilgisayarHamlesiUret();
                           kontrol_pc=tahta.hamleyiYaz(hamle_pc, pc);
                       if(kontrol_pc==true){
                            if(tahta.beraberlikKontrol()==true){
                           System.out.println("OYUN BERABERE BİTTİ");
                           van1++;
                           break;
                       }
                      tahta.oyunTahtasiniYazdir();
                      if(tahta.kazanan(pc)==true){
                           System.out.println(oyun1.kullanici_adi+"OYUNU KAYBETTİNİZ!");
                           break;
                       }break;
                       }else
                       continue;
                          }
                      }
                      if(van1!=0){
                          break;
                      }
                   }
                }
            }else
                    continue;
                while(dongu<1){
                    System.out.println("CIKMAK İÇİN 0 DEVAM ETMEK İCİN 1 TIKLAYIN ");
                    int cik;
                    cik=giris.nextInt();
                    if(cik==0){
                       System.out.println("GULE GULE!");
                       System.exit(0);
                   }
                   else if(cik==1){
                       break;
                   }
                   else if(cik<1||cik>1){
                       System.out.println("yanlis sayi girdiniz");
                       continue;
                   }
                }
            }
        }
      }}
   else if(yeni==false){
        int dogru=0;
        String metin =vericek();
        int ad_boyut=metin.length();
        char harf;
        String ad = new String();
        int sayac=0;
        String dizi[]= metin.split(" ");
        harf=dizi[0].charAt(0);
        ad=dizi[1];
        String dizi1=new String();
            char pc2 = 0;
        if(harf=='x'){
            pc2='o';
        }else if(harf=='o'){
        pc2='x';
        }
        int mat_boyut = dizi[2].length();
        for(int j=2;j<mat_boyut+2;j++){
            dizi1+= dizi[j];
                }
        char[][]mat_kayit;
       mat_kayit = new char[mat_boyut][mat_boyut];
        dizi1=dizi1.trim();
        char[] kayit = dizi1.toCharArray();
        
         for(int j=0;j<mat_boyut;j++){
            for(int k=0;k<mat_boyut;k++){
                mat_kayit[j][k] = kayit[sayac];
                System.out.print(kayit[sayac]);
                sayac++;
                }System.out.println();
            }
          Oyun_tahtasi tahta_kayit=new Oyun_tahtasi(mat_boyut,mat_kayit);
          Oyuncu oyun_kayit=new Oyuncu(harf);
         oyun_kayit.boyut=mat_boyut;
        oyun_kayit.kullanici_adi=ad;
         while(dogru<1){
        String hamle_oyuncu2=oyun_kayit.insanOyuncuHamlesiniKotrol();
                        if("f".equals(hamle_oyuncu2)){
                             System.out.println("OYUNU KAYIT ETMEK ISTERMISINIZ?");
                                     System.out.println("EVET/(true)       HAYIR/(true)");
                                     boolean kayit5=giris.nextBoolean();
                                        if(kayit5==true){
                                        dosyayiekle(mat_boyut,mat_kayit,ad,harf);
                                         System.exit(0);
                                        }else{
                                         System.exit(0);    
                                        }
                        }
                    boolean kontrol_oyuncu2=tahta_kayit.hamleyiYaz(hamle_oyuncu2,harf);
                    String hamle_pck = oyun_kayit.bilgisayarHamlesiUret();
                    boolean kontrol_pc2=tahta_kayit.hamleyiYaz(hamle_pck, pc2);
                    int kontrol2=0;
                    int van2 = 0;
                   if(kontrol_oyuncu2==true){
                       if(tahta_kayit.beraberlikKontrol()==true){
                           System.out.println("oyun berabere bitti");
                           van2++;
                          break;
                       }if(van2!=0){
                        break;
                    }
                      tahta_kayit.oyunTahtasiniYazdir();
                    if(tahta_kayit.kazanan(harf)==true){
                           System.out.println(oyun_kayit.kullanici_adi+"TEBRİKLER OYUNU KAZANDINIZ");
                           break;
                    }
                     
                   }else{
                       if(tahta_kayit.kazanan(harf)==true){
                           System.out.println(oyun_kayit.kullanici_adi+":TEBRİKLER OYUNU KAZANDINIZ");
                           break;
                       }
                       
                       else{
                           while(dogru<2){
                               System.out.println("OYUNCU girdiginiz hamle dolu!");
                                 hamle_oyuncu2=oyun_kayit.insanOyuncuHamlesiniKotrol();
                                 if("f".equals(hamle_oyuncu2)){
                                     System.out.println("OYUNU KAYIT ETMEK ISTERMISINIZ?");
                                     System.out.println("EVET/(true)       HAYIR/(false)  ");
                                    boolean kayit5=giris.nextBoolean();
                                        if(kayit5==true){
                                        dosyayiekle(mat_boyut,mat_kayit,ad,harf);
                                         System.exit(0);
                                        }else{
                                         System.exit(0);    
                                        }
                                    
                                 }
                    kontrol_oyuncu2=tahta_kayit.hamleyiYaz(hamle_oyuncu2,harf);
                    if(kontrol_oyuncu2==true){
                        if(tahta_kayit.beraberlikKontrol()==true){
                           System.out.println("OYUN BERABERE BİTTİ");
                           van2++;
                           break;
                       }
                      tahta_kayit.oyunTahtasiniYazdir();
                    if(tahta_kayit.kazanan(harf)==true){
                           System.out.println(oyun_kayit.kullanici_adi+"TEBRİKLER OYUNU KAZANDINIZ");
                           break;
                    }
                    
                    break;
                   }else
             continue;
                           }
                      
                       }
                       if(van2!=0){
                          break;
                       }
                   }
                   
                   
                        System.out.println("Sira bilgisayarda ");
                       if(kontrol_pc2==true){
                           if(tahta_kayit.beraberlikKontrol()==true){
                           System.out.println("OYUN BERABERE BİTTİ");
                           van2++;
                           break;
                       }if(van2!=0){
                        break;
                    }
                      tahta_kayit.oyunTahtasiniYazdir();
                    if(tahta_kayit.kazanan(pc2)==true){
                           System.out.println(oyun_kayit.kullanici_adi+" OYUNU KAYBETTİNİZ");
                           kontrol2++;
                           break;
                    }
                    
                    
                   }else{
                       if(tahta_kayit.kazanan(pc2)==true){
                           System.out.println(oyun_kayit.kullanici_adi+" OYUNU KAYBiTTİNİZ");
                           kontrol2++;
                           break;
                       }
                       else{
                           while(dogru<3){
                               System.out.println("PC girdiginiz hamle dolu!");
                                 hamle_oyuncu2=oyun_kayit.bilgisayarHamlesiUret();
                    kontrol_pc2=tahta_kayit.hamleyiYaz(hamle_oyuncu2,pc2);
                    if(kontrol_pc2==true){
                        if(tahta_kayit.beraberlikKontrol()==true){
                           System.out.println("OYUN BERABERE BİTTİ");
                           van2++;
                           break;
                       
                       }
                      tahta_kayit.oyunTahtasiniYazdir();
                    if(tahta_kayit.kazanan(pc2)==true){
                           System.out.println(oyun_kayit.kullanici_adi+" OYUNU KAYBETTİNİZ");
                           kontrol2++;
                           break;
                    }
                    
                    break;
                   }else
             continue;
                           }
                      
                       }
                       if(van2!=0){
                           break;
                       }
                   }
                      if(kontrol2!=0){
                          break;
                      }
                }while(dongu<4){
                    System.out.println("CIKMAK İÇİN 0 DEVAM ETMEK İCİN 1 TIKLAYIN ");
                    int cik1;
                   cik1=giris.nextInt();
                   if(cik1==0){
                       System.out.println("GULE GULE!");
                       System.exit(0);
                   }
                   else if(cik1==1){
                       break;
                   }
                   else if(cik1<1||cik1>1){
                       System.out.println("yanlis sayi girdiniz");
                       continue;
                   }
                }
            }
        }      
    }
    private static void dosya(int boyut, char[][] matris, String im) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}   

    
            
        
           