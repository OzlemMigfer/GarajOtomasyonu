import java.util.Scanner;


public class Calistir {
    public static void main(String[] args){
        Scanner giris = new Scanner(System.in);
        System.out.println("GARAJ SİSTEMİMİZE HOŞGELDİNİZ...");
        
        Garaj park=new Garaj();
        String İşlemler = "İŞLEMLER \n"
                        +"1.Park et \n"
                        +"2.Parktan al \n"
                        +"3.Çıkış";
        while(true){
            System.out.println("\n \n**********");
            System.out.println(İşlemler);
            System.out.println("**********");
            System.out.print("Hangi işlemi gerçekleştirmek istiyorsunuz?: ");
            int işlem = giris.nextInt();
            if(işlem == 1){
                park.parkEt();
            }
            else if(işlem == 2){
                park.parktanAl();
            }
            else if(işlem == 3){
                System.out.println("Çıkış yapılıyor");
                break;
            }
            else{
                System.out.println("Yanlış işlem girdiniz");
            }     
        }
    } 
}
class Garaj {
    int şifre;
    boolean dolu_mu;  
    private int aracSayisi=0;
    private int aracID=0;
 
    public void parkEt(){
        Scanner scanner = new Scanner(System.in);
        String aracturleri="\n \n1.Kamyon\n"
                          +"2.Otomobil\n"
                          +"3.Bisiklet";
        System.out.println(aracturleri);
            
        if(dolu_mu==true){
            System.out.println("\n \n Garajımız Dolu!");
        }
        else{
            System.out.print("Hangi araç türünü park edeceksiniz?: ");
            String aracturu=scanner.nextLine();
            scanner.nextLine();
            aracSayisi++;
            aracID++;
            
            if(aracturu.equals("1")){
               Kamyon kamyon=new Kamyon("Kamyon",10);
               kamyon.aracBilgileri();
               kamyon.hizlanma(20);
               kamyon.ferenleme(10);
               System.out.println(aracID+" nolu aracınız park edilmiştir...");
               şifre = (int)(Math.random()*999+1);
               System.out.println("Garaj şifreniz = "+şifre);
               
               dolu_mu = true;
            }
                
            else if(aracturu.equals("2")){
               Otomobil otomobil=new Otomobil("Otomobil",4);
               otomobil.aracBilgileri();
               otomobil.hizlanma(40);
               otomobil.ferenleme(30);
               System.out.println(aracID+" nolu aracınız park edilmiştir...");
               şifre = (int)(Math.random()*999+1);
               System.out.println("Garaj şifreniz = "+şifre);
               
               dolu_mu = true;
            }
                
            else if(aracturu.equals("3")){
               Bisiklet bisiklet=new Bisiklet("Bisiklet",2);
               bisiklet.aracBilgileri();
               bisiklet.hizlanma(8);
               bisiklet.ferenleme(5);
               System.out.println(aracID+" nolu aracınız park edilmiştir...");
               şifre = (int)(Math.random()*999+1);
               System.out.println("Garaj şifreniz = "+şifre);
               
               dolu_mu = true;
            }
            else{
               System.out.println("Başka tür araç girdiğinizden,araç park etme işleminizi gerçekleştiremiyoruz...");
            }
            System.out.println("Araç Sayısı:"+aracSayisi);
            System.out.println("AracID:"+aracID);
        }
    }
    
   public void parktanAl(){
        
        Scanner scanner=new Scanner(System.in);
        System.out.print("Aracınızı parktan mı almak istiyorsunuz?:\n1.Evet\n2.Hayır\n");
        System.out.print("Cevabınız: ");
        String parktanAlmak=scanner.nextLine();
        scanner.nextLine();
        
        if(parktanAlmak.equals("1")){
            
            System.out.print("Aracınızı parktan almak istemektesiziniz.\n");
            System.out.print("Bizim tarafımızdan verilen şifreyi giriniz,lütfen: ");
            int sifren=scanner.nextInt();
        
            if(sifren == şifre ){
               System.out.println(aracSayisi+" nolu arac parktan alınmıştır...");
               System.out.println("Garaj Boşaltılmıştır.Yeni Araç Kabulü Yapılabiilir.");
               dolu_mu = false;
            }
            else{
               System.out.println("Girdiğiniz şifre yanlış!!!");
            } 
        }
    }
}
 class Araclar {//Superclass
    
    private String aracIsim;
    

    public Araclar(String aracIsim) {//Constructor çağırdık
        this.aracIsim = aracIsim;
    }
    public void hizlanma(int hiz){
        System.out.println("Bu Araç "+hiz+" ile Hızlanmaktadır...");
    }
    public void ferenleme(int fren){
        System.out.println("Bu Araç "+fren+" ile Frenlemektedir...");
    }
    public void aracBilgileri(){
        System.out.println("Araç Türü: "+aracIsim);
    }
    public String getAracIsim() {
        return aracIsim;
    }
    public void setAracIsim(String aracIsim) {
        this.aracIsim = aracIsim;
    }

}  
class Kamyon extends Araclar{
    
        private final int tekerlekSayisi;
    
        public Kamyon(String aracIsim, int tekerlekSayisi){
        
        super(aracIsim);
        
        this.tekerlekSayisi=tekerlekSayisi;
       
    }
    
    @Override
    public void hizlanma(int hiz){
        System.out.println("Kamyon harekete geçmekte...");
       
    }
    
    @Override
    public void ferenleme(int fren){
        System.out.println("Kamyon stop olmaya hazırlanıyor...");
    }
    
    @Override
    public void aracBilgileri(){
        super.aracBilgileri();
        System.out.println("Tekerlek Sayisi: "+tekerlekSayisi);
    }
}
class Otomobil extends Araclar{
    
    private final int tekerlekSayisi;
    
    public Otomobil(String aracIsim,int tekerlekSayisi){
        
        super(aracIsim);
        
        this.tekerlekSayisi=tekerlekSayisi;
       
    }
    
    @Override
    public void hizlanma(int hiz){
        System.out.println("Otomobil harekete geçmekte...");
        
     
    }
    
    @Override
    public void ferenleme(int fren){
        System.out.println("Otomobil stop olmaya hazırlanıyor...");
        
    }
    
    @Override
    public void aracBilgileri(){
        super.aracBilgileri();
        System.out.println("Tekerlek Sayisi: "+tekerlekSayisi);
    }
}
class Bisiklet extends Araclar{
    
    private final int tekerlekSayisi;
    
    public Bisiklet(String aracIsim, int tekerlekSayisi){
        
        super(aracIsim);
        
        this.tekerlekSayisi=tekerlekSayisi;
       
    }
    
    @Override
    public void hizlanma(int hiz){
        System.out.println("Bisiklet harekete geçmekte...");
      
    }
    
    @Override
    public void ferenleme (int fren){
        System.out.println("Bisiklet stop olmaya hazırlanıyor...");
        
    }
    
    @Override
    public void aracBilgileri(){
        super.aracBilgileri();
        System.out.println("Tekerlek Sayisi: "+tekerlekSayisi);
    }
}
