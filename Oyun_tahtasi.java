
package tic;
public class Oyun_tahtasi {
     int boyut;
 char [][]matris= new char [boyut][boyut];
public Oyun_tahtasi(){
   //System.out.println("parametresiz:"+this.boyut);
         
  }
  
public Oyun_tahtasi(int boyut,char[][]Oyun_t){
    // System.out.println("parametreli:"+this.boyut);
    this.boyut=boyut;
      this.matris=Oyun_t;
  }
  
  
      void oyunTahtasiniYazdir(){
          char[][]matris2=new char[this.boyut][this.boyut];
   
          //System.out.println("yazdir:"+this.boyut);
          for (int i=0;i<this.boyut;i++) {
              for(int j=0;j<this.boyut;j++){
                  
                  System.out.print(this.matris[i][j]);
               
                  
              }System.out.println();
          }
  }
      boolean hamleyiYaz(String koordinat, char oyuncu){
          int sayi,sayac= 0;
        sayi = Integer.parseInt(koordinat);
        int oyun_satir, oyun_sutun;
        
        oyun_sutun = sayi % 10;
        sayi = sayi / 10;
        oyun_satir = sayi % 10;
       // System.out.println("oyuncu sayisi"+oyun_satir+oyun_sutun ); 
       if(this.matris[oyun_satir][oyun_sutun ]=='.'){
           this.matris[oyun_satir][oyun_sutun ]=oyuncu;
       }
       else if(oyun_satir>0||oyun_sutun>0||oyun_satir<this.boyut||oyun_sutun<this.boyut){
           return false;
       }
       else{
           return false;
       }
      for(int i=0;i<this.boyut;i++){
               for(int j=0;j<this.boyut;j++){
                   if(this.matris[i][j]=='.'){
                       sayac++;
                   }
               }
           }
      
         return sayac != this.boyut;
   }
      boolean kazanan(char oyuncu){
          //oyuncu=
          switch(this.boyut){
              case 3:{
        if(this.matris[0][0]==oyuncu && this.matris[0][1]==oyuncu && this.matris[0][2]==oyuncu){
              return true;
          }
        else if(this.matris[0][0]==oyuncu && this.matris[1][0]==oyuncu && this.matris[2][0]==oyuncu){
            return true;  
          }
        else if(this.matris[0][2]==oyuncu && this.matris[1][2]==oyuncu && this.matris[2][2]==oyuncu){
            return true;  
          }
        else if(this.matris[2][0]==oyuncu && this.matris[2][1]==oyuncu && this.matris[2][2]==oyuncu){
              return true;
          }
        else if(this.matris[0][0]==oyuncu && this.matris[1][1]==oyuncu && this.matris[2][2]==oyuncu){
              return true;
          }
        else if(this.matris[0][2]==oyuncu && this.matris[1][1]==oyuncu && this.matris[2][0]==oyuncu){
              return true;
          }
        else if(this.matris[1][0]==oyuncu && this.matris[1][1]==oyuncu && this.matris[1][2]==oyuncu){
              return true;
          }
        else if(this.matris[0][1]==oyuncu && this.matris[1][1]==oyuncu && this.matris[2][1]==oyuncu){
              return true;
          }
        break;
      }
              case 5:{
              if(this.matris[0][0]==oyuncu && this.matris[0][1]==oyuncu && this.matris[0][2]==oyuncu && this.matris[0][3]==oyuncu && this.matris[0][4]==oyuncu){
              return true;
          }
        else if(this.matris[0][0]==oyuncu && this.matris[1][0]==oyuncu && this.matris[2][0]==oyuncu && this.matris[3][0]==oyuncu && this.matris[4][0]==oyuncu){
            return true;  
          }
        else if(this.matris[0][4]==oyuncu && this.matris[1][4]==oyuncu && this.matris[2][4]==oyuncu && this.matris[3][4]==oyuncu && this.matris[4][4]==oyuncu){
            return true;  
          }
        else if(this.matris[4][0]==oyuncu && this.matris[4][1]==oyuncu && this.matris[4][2]==oyuncu && this.matris[4][3]==oyuncu && this.matris[4][4]==oyuncu){
              return true;
          }
        else if(this.matris[0][0]==oyuncu && this.matris[1][1]==oyuncu && this.matris[2][2]==oyuncu && this.matris[3][3]==oyuncu && this.matris[4][4]==oyuncu){
              return true;
          }
        else if(this.matris[0][4]==oyuncu && this.matris[1][3]==oyuncu && this.matris[2][2]==oyuncu && this.matris[3][1]==oyuncu && this.matris[4][0]==oyuncu){
              return true;
          }
        else if(this.matris[1][0]==oyuncu && this.matris[1][1]==oyuncu && this.matris[1][2]==oyuncu && this.matris[1][3]==oyuncu && this.matris[1][4]==oyuncu){
              return true;
          }
        else if(this.matris[2][0]==oyuncu && this.matris[2][1]==oyuncu && this.matris[2][2]==oyuncu && this.matris[2][3]==oyuncu && this.matris[2][4]==oyuncu){
              return true;
          }
        else if(this.matris[3][0]==oyuncu && this.matris[3][1]==oyuncu && this.matris[3][2]==oyuncu && this.matris[3][3]==oyuncu && this.matris[3][4]==oyuncu){
              return true;
          }
        else if(this.matris[0][1]==oyuncu && this.matris[1][1]==oyuncu && this.matris[2][1]==oyuncu && this.matris[3][1]==oyuncu && this.matris[4][1]==oyuncu){
            return true;  
          }
        else if(this.matris[0][2]==oyuncu && this.matris[1][2]==oyuncu && this.matris[2][2]==oyuncu && this.matris[3][2]==oyuncu && this.matris[4][2]==oyuncu){
            return true;  
          }
        else if(this.matris[0][3]==oyuncu && this.matris[1][3]==oyuncu && this.matris[2][3]==oyuncu && this.matris[3][3]==oyuncu && this.matris[4][3]==oyuncu){
            return true;  
          }
       break; 
          } 
              case 7:{
              if(this.matris[0][0]==oyuncu && this.matris[0][1]==oyuncu && this.matris[0][2]==oyuncu && this.matris[0][3]==oyuncu && this.matris[0][4]==oyuncu && this.matris[0][5]==oyuncu && this.matris[0][6]==oyuncu){
              return true;
          }
        else if(this.matris[0][0]==oyuncu && this.matris[1][0]==oyuncu && this.matris[2][0]==oyuncu && this.matris[3][0]==oyuncu && this.matris[4][0]==oyuncu && this.matris[5][0]==oyuncu && this.matris[6][0]==oyuncu){
            return true;  
          }
        else if(this.matris[0][6]==oyuncu && this.matris[1][6]==oyuncu && this.matris[2][6]==oyuncu && this.matris[3][6]==oyuncu && this.matris[4][6]==oyuncu && this.matris[5][6]==oyuncu && this.matris[6][6]==oyuncu){
            return true;  
          }
        else if(this.matris[6][0]==oyuncu && this.matris[6][1]==oyuncu && this.matris[6][2]==oyuncu && this.matris[6][3]==oyuncu && this.matris[6][4]==oyuncu && this.matris[6][5]==oyuncu && this.matris[6][6]==oyuncu){
              return true;
          }
        else if(this.matris[0][0]==oyuncu && this.matris[1][1]==oyuncu && this.matris[2][2]==oyuncu && this.matris[3][3]==oyuncu && this.matris[4][4]==oyuncu && this.matris[5][5]==oyuncu && this.matris[6][6]==oyuncu){
              return true;
          }
        else if(this.matris[6][0]==oyuncu && this.matris[5][1]==oyuncu && this.matris[4][2]==oyuncu && this.matris[3][3]==oyuncu && this.matris[2][4]==oyuncu && this.matris[1][5]==oyuncu && this.matris[0][6]==oyuncu){
              return true;
          }
        else if(this.matris[1][0]==oyuncu && this.matris[1][1]==oyuncu && this.matris[1][2]==oyuncu && this.matris[1][3]==oyuncu && this.matris[1][4]==oyuncu && this.matris[1][5]==oyuncu && this.matris[1][6]==oyuncu){
              return true;
          }
        else if(this.matris[2][0]==oyuncu && this.matris[2][1]==oyuncu && this.matris[2][2]==oyuncu && this.matris[2][3]==oyuncu && this.matris[2][4]==oyuncu && this.matris[2][5]==oyuncu && this.matris[2][6]==oyuncu){
              return true;
          }
        else if(this.matris[3][0]==oyuncu && this.matris[3][1]==oyuncu && this.matris[3][2]==oyuncu && this.matris[3][3]==oyuncu && this.matris[3][4]==oyuncu && this.matris[3][5]==oyuncu && this.matris[3][6]==oyuncu){
              return true;
          }
        else if(this.matris[4][0]==oyuncu && this.matris[4][1]==oyuncu && this.matris[4][2]==oyuncu && this.matris[4][3]==oyuncu && this.matris[4][4]==oyuncu && this.matris[4][5]==oyuncu && this.matris[4][6]==oyuncu){
              return true;
          }
        else if(this.matris[5][0]==oyuncu && this.matris[5][1]==oyuncu && this.matris[5][2]==oyuncu && this.matris[5][3]==oyuncu && this.matris[5][4]==oyuncu && this.matris[5][5]==oyuncu && this.matris[5][6]==oyuncu){
              return true;
          }
        else if(this.matris[0][1]==oyuncu && this.matris[1][1]==oyuncu && this.matris[2][1]==oyuncu && this.matris[3][1]==oyuncu && this.matris[4][1]==oyuncu && this.matris[5][1]==oyuncu && this.matris[6][1]==oyuncu){
            return true;  
          }
        else if(this.matris[0][2]==oyuncu && this.matris[1][2]==oyuncu && this.matris[2][2]==oyuncu && this.matris[3][2]==oyuncu && this.matris[4][2]==oyuncu && this.matris[5][2]==oyuncu && this.matris[6][2]==oyuncu){
            return true;  
          }
        else if(this.matris[0][3]==oyuncu && this.matris[1][3]==oyuncu && this.matris[2][3]==oyuncu && this.matris[3][3]==oyuncu && this.matris[4][3]==oyuncu && this.matris[5][3]==oyuncu && this.matris[6][3]==oyuncu){
            return true;  
          }
        else if(this.matris[0][4]==oyuncu && this.matris[1][4]==oyuncu && this.matris[2][4]==oyuncu && this.matris[3][4]==oyuncu && this.matris[4][4]==oyuncu && this.matris[5][4]==oyuncu && this.matris[6][4]==oyuncu){
            return true;  
          }
        else if(this.matris[0][5]==oyuncu && this.matris[1][5]==oyuncu && this.matris[2][5]==oyuncu && this.matris[3][5]==oyuncu && this.matris[4][5]==oyuncu && this.matris[5][5]==oyuncu && this.matris[6][5]==oyuncu){
            return true;  
          }      
              }
          }return false;
      }  
      boolean beraberlikKontrol(){
          int sayac = 0;
          for(int i=0;i<this.boyut;i++){
          for(int j=0;j<this.boyut;j++){
            if (this.matris[i][j]!='.'){
            sayac++;
            }
          }
      }//System.out.println("sayac:"+sayac);
         return sayac==this.boyut*this.boyut;
          
 }
}    
    
       


      



