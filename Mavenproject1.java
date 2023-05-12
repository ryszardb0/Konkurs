

import java.io.*;
import java.util.*;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


public class Mavenproject1 {

      static int[] klany = new int[100004];
   static int[] klanyPunkty = new int [100004];
   static short[] klanyIlosc = new short [20004];    
    static boolean[] klanyWybor = new boolean [20004];  
    static short liczebnosc;
          static int licznik;
      static int pozycja;
      static int pozycja2;
      static StringBuilder[] konta = new StringBuilder[200005];
      
       // static int[] bankomaty = new int[ileZmiennych];   //ILE BANKOMATOW TYLE POL (jedno z dwoch pol)  zastapiaone przez klany
   // static int[] roboczy3 = new int[ileZmiennych];  //ILE BANKOMATOW TYLE POL (jedno z dwoch pol) zastapiaone przez klanyPunkty
     
    public static void main(String[] args)
        throws IOException {
           
    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
    server.createContext("/", new Handler());
    server.start();
    System.out.println("Serwer Wystartowany");
            //double czas =System.nanoTime();
             //  System.out.println(System.nanoTime()-czas ); 
           
            
    }
   
    
}




class Handler implements HttpHandler {
    
 
  @Override
  public void handle(HttpExchange xchg) throws IOException {
      StringBuilder bu0;

      try (InputStreamReader isr = new InputStreamReader(xchg.getRequestBody()); BufferedReader br = new BufferedReader(isr)) {
          bu0 = new StringBuilder();
          Mavenproject1.licznik = 0;
          Mavenproject1.pozycja = 0;
          Mavenproject1.pozycja2 = 0;
           Mavenproject1.licznik=0;
          String roboczy = null;
          // int[] bankomaty = new int[100001];   //ILE BANKOMATOW TYLE POL
          // int[] bankomaty = new int[100001];   //ILE BANKOMATOW TYLE POL
          
          //System.out.println(Mavenproject1.klany[2]); 
          
          //System.out.println("str");
          while ((roboczy=(br.readLine())) != null) {
              
              //if (roboczy==null){
              //break;
              //}close
              bu0.append(roboczy);
          }
          //System.out.println(bu0); 
//roboczy=(br.lines());
//bu0.append(roboczy);
      }
 //double czas =System.nanoTime();
 // while((System.nanoTime()-czas)<1000000000.0f){  
  //}
 //System.out.println("kon");
if (((bu0.indexOf("b",Mavenproject1.pozycja2)==(-1)))&&( (bu0.indexOf("q",Mavenproject1.pozycja2)==(-1)))&&( (bu0.indexOf("m",Mavenproject1.pozycja2)==(-1)))){
     StringBuilder response2 = new StringBuilder();
       response2.append("{INVALID DATA}");
      
     xchg.getResponseHeaders().set("Content-type", "application/json");
    xchg.sendResponseHeaders(200, response2.length());
    try (OutputStream os = xchg.getResponseBody()) {
        os.write(response2.toString().getBytes());
    }
}
else {
    

  
 if ("/transactions/report".equals(xchg.getRequestURI().toString())){
     
      //StringBuilder[] konta = new StringBuilder[ileZmiennych];
     
     while(Mavenproject1.pozycja2>=0){
         Mavenproject1.konta[Mavenproject1.licznik] = new StringBuilder(36);
         Mavenproject1.konta[(Mavenproject1.licznik+1)] = new StringBuilder(36);
       Mavenproject1.pozycja = (bu0.indexOf("b",Mavenproject1.pozycja2))+11; 
       Mavenproject1.pozycja = bu0.indexOf("\"",Mavenproject1.pozycja);    
       Mavenproject1.konta[Mavenproject1.licznik].append((bu0.substring((Mavenproject1.pozycja+1), (Mavenproject1.pozycja+27))));
        Mavenproject1.pozycja = (bu0.indexOf("r",(Mavenproject1.pozycja+29)))+13; 
        Mavenproject1.pozycja = bu0.indexOf("\"",Mavenproject1.pozycja); 
        Mavenproject1.konta[(Mavenproject1.licznik+1)].append((bu0.substring((Mavenproject1.pozycja+1), Mavenproject1.pozycja+27))); 
          Mavenproject1.pozycja = (bu0.indexOf("m",(Mavenproject1.pozycja+29)))+6; 
         Mavenproject1.pozycja = bu0.indexOf(":",Mavenproject1.pozycja); 
        
        Mavenproject1.konta[Mavenproject1.licznik].append("1");
        Mavenproject1.konta[(Mavenproject1.licznik+1)].append("0");
        ///////////////////////////////////////////Wariant szybszy, kwota musi być podana z dwoma miejscami po przecinku(kropce),(i minimum jedna cyfra przed przecinkiem, choćby 0)
        Mavenproject1.pozycja2= bu0.indexOf(".",(Mavenproject1.pozycja+2)); 
        Mavenproject1.konta[Mavenproject1.licznik].append(((bu0.substring((Mavenproject1.pozycja+1), Mavenproject1.pozycja2)).trim()));
        Mavenproject1.konta[(Mavenproject1.licznik+1)].append(((bu0.substring((Mavenproject1.pozycja+1), Mavenproject1.pozycja2)).trim()));
        Mavenproject1.konta[Mavenproject1.licznik].append((bu0.substring((Mavenproject1.pozycja2+1), Mavenproject1.pozycja2+3)));
        Mavenproject1.konta[(Mavenproject1.licznik+1)].append((bu0.substring((Mavenproject1.pozycja2+1), Mavenproject1.pozycja2+3)));
        //////////////////////////////////////////KONIEC WARIANTU
        
        //////////////////////////////////////////Wariant przyjmujący kwotę FLOAT, może być przecinek w dowolnym miejscu, ale i tak ignoruje mniej niz setne czesci
        //pozycja2= bu0.indexOf("}",(Mavenproject1.pozycja+1)); 
        //pozycja=(int)((Double.parseDouble(((bu0.substring((Mavenproject1.pozycja+1), Mavenproject1.pozycja2)).trim())))*100);
        //konta[Mavenproject1.licznik].append(Mavenproject1.pozycja);
        //konta[(Mavenproject1.licznik+1)].append(Mavenproject1.pozycja);
        //////////////////////////////////////////KONIEC WARIANTU
        
        Mavenproject1.licznik=Mavenproject1.licznik+2;
        Mavenproject1.pozycja2 = bu0.indexOf("{",Mavenproject1.pozycja2);
     }


     //if (Mavenproject1.licznik>50000){  //zalezy od konfiguracji sprzetu
     //    Arrays.parallelSort(Mavenproject1.konta, 0, Mavenproject1.licznik);
     //}
     //else{
         Arrays.sort(Mavenproject1.konta, 0, Mavenproject1.licznik); //mogloby sortowac bez kwot, tylko pierwsze 26 znakow, ale customowy comaprator nawet prosty jest wolniejszy
     //}
    

      Mavenproject1.pozycja2 = 0;


String bk = "a";
int licznikd = 0;
int liczniku = 0;
int kwota = 0;
   StringBuilder response = new StringBuilder((87*Mavenproject1.licznik)); //,mozna uzaleznic od zmiennej licznik, ale niewiele 
     Mavenproject1.pozycja = 0;
     response.append("[");
    while (true){
      if (!bk.equals(Mavenproject1.konta[Mavenproject1.pozycja].substring((0), (26)))){
                  if (Mavenproject1.pozycja>0){

         
         response.append("{\"account\":\"");
      response.append(bk);  
    response.append("\",\"debitCount\":");   
    response.append(liczniku);
    response.append(",\"creditCount\":");   
    response.append(licznikd);
      response.append(",\"balance\":");   
      if (kwota<100){
          if (kwota>(-100)){
          if (kwota<0){
              kwota = kwota * (-1);
              response.append("-");
          }
          response.append("0");
           if (kwota<10){
          response.append("0");
      }
      }
      }
    response.append(kwota);
    response.insert((response.length()-2), ".");
    response.append("},");  
     }
          licznikd = 0;
         liczniku=0;
         kwota = 0;
    bk =  Mavenproject1.konta[Mavenproject1.pozycja].substring((0), (26));
      }
          
          
          if ("0".equals(Mavenproject1.konta[Mavenproject1.pozycja].substring((26), (27)))){
             licznikd = licznikd + 1;
             kwota = kwota + Integer.parseInt((Mavenproject1.konta[Mavenproject1.pozycja].substring((27), (Mavenproject1.konta[Mavenproject1.pozycja].length()))));
          }
          else{
               liczniku = liczniku + 1;
             kwota = kwota - Integer.parseInt((Mavenproject1.konta[Mavenproject1.pozycja].substring((27), (Mavenproject1.konta[Mavenproject1.pozycja].length()))));
          }
           Mavenproject1.pozycja = Mavenproject1.pozycja +1;
      
   
 

        
      
    if (Mavenproject1.pozycja>=Mavenproject1.licznik){
         response.append("{\"account\":\"");
      response.append(bk);  
    response.append("\",\"debitCount\":");   
    response.append(liczniku);
    response.append(",\"creditCount\":");   
    response.append(licznikd);
      response.append(",\"balance\":");   
        if (kwota<100){
          if (kwota>(-100)){
          if (kwota<0){
              kwota = kwota * (-1);
              response.append("-");
          }
          response.append("0");
           if (kwota<10){
          response.append("0");
      }
      }
      }
    response.append(kwota);
    response.insert((response.length()-2), ".");
    response.append("}");  
        break;
    }
   
    }

      response.append("]");   
    
     xchg.getResponseHeaders().set("Content-type", "application/json");
    xchg.sendResponseHeaders(200, response.length());
     try (OutputStream os = xchg.getResponseBody()) {
         os.write(response.toString().getBytes());
     }

 }
 if ("/atms/calculateOrder".equals(xchg.getRequestURI().toString())){
  
  
      while(Mavenproject1.pozycja2>=0){
       Mavenproject1.pozycja = (bu0.indexOf("g",Mavenproject1.pozycja2))+6;       
        Mavenproject1.pozycja2= bu0.indexOf(",",(Mavenproject1.pozycja)); 
        Mavenproject1.klany[Mavenproject1.licznik] = ((Integer.parseInt(((bu0.substring((Mavenproject1.pozycja), Mavenproject1.pozycja2)).trim())))<<16);    //((Integer.parseInt(((bu0.substring((Mavenproject1.pozycja), Mavenproject1.pozycja2)).trim())))*65536);       
         Mavenproject1.pozycja = (bu0.indexOf("q",Mavenproject1.pozycja2))+11; 
        Mavenproject1.pozycja = (bu0.indexOf("\"",Mavenproject1.pozycja))+2;
                if ((bu0.substring((Mavenproject1.pozycja), (Mavenproject1.pozycja+1))).equals("R")){
                    Mavenproject1.klany[Mavenproject1.licznik] =Mavenproject1.klany[Mavenproject1.licznik] +(16384);
                }
                else{
                if ((bu0.substring((Mavenproject1.pozycja), (Mavenproject1.pozycja+1))).equals("I")){
                    Mavenproject1.klany[Mavenproject1.licznik] =Mavenproject1.klany[Mavenproject1.licznik] +(2*16384);
                }
                if ((bu0.substring((Mavenproject1.pozycja), (Mavenproject1.pozycja+1))).equals("T")){
                    Mavenproject1.klany[Mavenproject1.licznik] =Mavenproject1.klany[Mavenproject1.licznik] +(3*16384);
                }
                }
           Mavenproject1.pozycja = Mavenproject1.pozycja +9;     
           Mavenproject1.pozycja = (bu0.indexOf("m",Mavenproject1.pozycja))+5; 
                 Mavenproject1.pozycja2= bu0.indexOf("}",(Mavenproject1.pozycja+1));  

                Mavenproject1.klany[Mavenproject1.licznik] = Mavenproject1.klany[Mavenproject1.licznik] + ((Integer.parseInt(((bu0.substring((Mavenproject1.pozycja), (Mavenproject1.pozycja2))).trim())))); 

        Mavenproject1.licznik=Mavenproject1.licznik+1;
        Mavenproject1.pozycja2 = bu0.indexOf("{",Mavenproject1.pozycja2);
     }


     Arrays.sort(Mavenproject1.klany, 0, Mavenproject1.licznik); //mogloby sortowac bez nr bankomatu, tylko pierwsze iles MSB

     
      int roboczy1;
      int roboczy2;
      
      boolean pominiecie;
   StringBuilder response = new StringBuilder(120000);
     Mavenproject1.pozycja = 0;
     response.append("[");
    while (true){
        //roboczy1 = (Mavenproject1.klany[Mavenproject1.pozycja]%65536);
        //roboczy2 = ((Mavenproject1.klany[Mavenproject1.pozycja]-roboczy1));
        //roboczy1=(roboczy1%16384);
        //roboczy3[Mavenproject1.pozycja] = roboczy1+roboczy2;
        //roboczy2 = roboczy2/65536;
        
        roboczy1 = Mavenproject1.klany[Mavenproject1.pozycja]&16383;
        roboczy2 = Mavenproject1.klany[Mavenproject1.pozycja]&1073676288;       
        Mavenproject1.klanyPunkty[Mavenproject1.pozycja] = roboczy1+roboczy2;
        roboczy2=roboczy2>>16;
        
        Mavenproject1.pozycja2=Mavenproject1.pozycja-1;
        pominiecie = false;

        
        while(true){
              if(Mavenproject1.pozycja2<0){
               break;
            }
            if(Mavenproject1.klanyPunkty[Mavenproject1.pozycja]==Mavenproject1.klanyPunkty[Mavenproject1.pozycja2]){
               pominiecie = true; 
               break;
            }
             if((Mavenproject1.klanyPunkty[Mavenproject1.pozycja]-Mavenproject1.klanyPunkty[Mavenproject1.pozycja2])>=60000){
               break;
            }
           Mavenproject1.pozycja2 = Mavenproject1.pozycja2 -1 ;
         
        }
        if(pominiecie == false){
    response.append("{\"region\":");
      response.append(roboczy2);      
    response.append(",\"atmId\":");   
    response.append(roboczy1);
    response.append("},");  
     }
    Mavenproject1.pozycja = Mavenproject1.pozycja +1;
    if (Mavenproject1.pozycja>=Mavenproject1.licznik){
        break;
    }
   
    }
    response.deleteCharAt(response.length() - 1);
      response.append("]");   
      
     xchg.getResponseHeaders().set("Content-type", "application/json");
    xchg.sendResponseHeaders(200, response.length());
     try (OutputStream os = xchg.getResponseBody()) {
         os.write(response.toString().getBytes());
     }
      

 }
   if ("/onlinegame/calculate".equals(xchg.getRequestURI().toString())){
      // int ileZmiennych = (bu0.length()/32)+2;
      //  if (ileZmiennych>20001){
       //   ileZmiennych=20001;
      //}
     
       Mavenproject1.pozycja = bu0.indexOf("g",0); 
       Mavenproject1.pozycja = Mavenproject1.pozycja + 12;
       Mavenproject1.pozycja2 = bu0.indexOf(",",Mavenproject1.pozycja); 
       Mavenproject1.liczebnosc=Short.parseShort((bu0.substring((Mavenproject1.pozycja), (Mavenproject1.pozycja2))).trim());
        Mavenproject1.pozycja =1;
        Mavenproject1.pozycja2=1;
     while(Mavenproject1.pozycja2>=0){
       Mavenproject1.pozycja = (bu0.indexOf("m",Mavenproject1.pozycja2))+15; 
        Mavenproject1.pozycja2 = bu0.indexOf(",",Mavenproject1.pozycja);
        Mavenproject1.klany[Mavenproject1.licznik]=(1000-(Integer.parseInt((bu0.substring((Mavenproject1.pozycja), (Mavenproject1.pozycja2))).trim())));
        Mavenproject1.pozycja = (bu0.indexOf("i",Mavenproject1.pozycja2))+6;
        Mavenproject1.pozycja2 = bu0.indexOf("}",Mavenproject1.pozycja); 
        Mavenproject1.klany[Mavenproject1.licznik]=Mavenproject1.klany[Mavenproject1.licznik]+((Integer.parseInt((bu0.substring((Mavenproject1.pozycja), (Mavenproject1.pozycja2))).trim()))<<10); //*1024
        Mavenproject1.pozycja2 = bu0.indexOf("{",Mavenproject1.pozycja);
        Mavenproject1.licznik=Mavenproject1.licznik+1;
     }

      
//if (Mavenproject1.licznik>6000){
//    Arrays.parallelSort(klany, 0, Mavenproject1.licznik);
//}
//else{
    Arrays.sort(Mavenproject1.klany, 0, Mavenproject1.licznik);
//}
    
         
          
         



      Mavenproject1.pozycja2=Mavenproject1.licznik;

       while (Mavenproject1.pozycja2>0){
           Mavenproject1.pozycja2=Mavenproject1.pozycja2-1;
           
           
       //roboczy1 = (klany[Mavenproject1.pozycja2]%1000);
       // klanyPunkty[Mavenproject1.pozycja2]=((klany[Mavenproject1.pozycja2]-roboczy1)/1000);
       //klanyIlosc[Mavenproject1.pozycja2]=(short)(1000-roboczy1); 
       //klanyWybor[Mavenproject1.pozycja2]= false;

       Mavenproject1.klanyPunkty[Mavenproject1.pozycja2]=  Mavenproject1.klany[Mavenproject1.pozycja2] & 1073740800;
       Mavenproject1.klanyPunkty[Mavenproject1.pozycja2]= Mavenproject1.klanyPunkty[Mavenproject1.pozycja2] >>10;
       Mavenproject1.klanyIlosc[Mavenproject1.pozycja2]=(short)(1000-(Mavenproject1.klany[Mavenproject1.pozycja2] & 1023)); 
       Mavenproject1.klanyWybor[Mavenproject1.pozycja2]= false;
       
       }
        
        short bL = 0;
        int przeskok = 0;
        Mavenproject1.pozycja2=Mavenproject1.licznik-1;//
        StringBuilder response = new StringBuilder(120000);
         response.append("[[");
         while (true){
             if ((Mavenproject1.klanyWybor[Mavenproject1.pozycja2]== true)&&(przeskok==0)){
             Mavenproject1.pozycja2=Mavenproject1.pozycja2-1;
             if (Mavenproject1.pozycja2<0) {
                 break;
             }
         }
            if (((bL+Mavenproject1.klanyIlosc[(Mavenproject1.pozycja2-przeskok)])<=Mavenproject1.liczebnosc)&&(Mavenproject1.klanyWybor[Mavenproject1.pozycja2-przeskok]== false)){
                //wyrzut osobnika
                response.append("{\"numberOfPlayers\":");
                response.append((Mavenproject1.klanyIlosc[Mavenproject1.pozycja2-przeskok]));
                response.append(",\"points\":");
                response.append((Mavenproject1.klanyPunkty[Mavenproject1.pozycja2-przeskok]));
                response.append("},");

                
                Mavenproject1.klanyWybor[Mavenproject1.pozycja2-przeskok]= true;
                bL = (short)(bL + (Mavenproject1.klanyIlosc[(Mavenproject1.pozycja2-przeskok)]));
               
                
            }
                przeskok=przeskok+1;

            if ((bL==Mavenproject1.liczebnosc) || (Mavenproject1.pozycja2-przeskok)<0){
                
                if (bL>0){
                    response.deleteCharAt(response.length() - 1);
                    response.append("],[");

                }
                przeskok = 0;
                bL=0;
              
            }
       }
         response.deleteCharAt(response.length() - 1);
         response.deleteCharAt(response.length() - 1);
         response.append("]");
         
       
         
       xchg.getResponseHeaders().set("Content-type", "application/json");
    xchg.sendResponseHeaders(200, response.length());
     try (OutputStream os = xchg.getResponseBody()) {
         os.write(response.toString().getBytes());
     }

 }
  //System.out.println(System.nanoTime()-czas ); 

   
 
  }  
    
  }

}

