import java.util.*;
public class p6 {
  public static  double dbmToW( double dbm )
    {
        return Math.pow( 10.0, dbm/10 )/1000;
    }
    
   public static double dbWToW( double dbW )
    {
        return Math.pow( 10.0, dbW/10 );
    }
    
  public static  double WTodbm( double W)
    {
        return 10.0 * Math.log10(1000 * W);
    }
    
   public static double WTodbW( double W)
    {
        return 10.0 * Math.log10(W);
    }
    public static void main(String[] args) {
        do
        {
            int givenunit;
            System.out.print("\n Please Select any one of the input. \n Enter 1 for Watt. (W)\n Enter 2 for decibel watts (dBW). \n Enter 3 for decibel milliwatts (dBm)\n");
            Scanner sc = new Scanner(System.in);
            givenunit= sc.nextInt();
             
            
            if(!(givenunit==1 || givenunit==2 || givenunit==3))
            System.out.print("either 1, 2 or 3 \n");
            else
            {
                double pwer; 
                 
               String unit_1 = (givenunit==1) ? "Watt (W)" : ((givenunit==2) ? "Decibel Watts (dBW)" : "Decibel Milliwatts (dBm)");
               System.out.println("enter transmit pwer "+ unit_1 + "..... ");
               
               pwer = sc.nextInt();

               
    
                if(givenunit==1)
                {
                    System.out.println( " " + unit_1 + " = " + WTodbW(pwer) + " Decibel Watts (dBW)" );                    
                    System.out.println(" " + unit_1 + " = " + WTodbm(pwer) + " Decibel Milliwatts (dBm)"  );   
                    
                }
                else if(givenunit==2)
                System.out.print (pwer+ " "+ unit_1+ " = "+ dbWToW(pwer)+ " Watt (W)");   
                 
                else if(givenunit==3)
                System.out.print (pwer+ " "+ unit_1+ " = "+ dbmToW(pwer)+ " Watt (W)");       
               
            }
        }while(false);
}    
}
