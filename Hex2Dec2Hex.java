import java.util.Scanner;

public class Hex2Dec2Hex {
	private static final String error = "Error!";
	private static final char yes = 'y';
	private static final char no = 'n';
	private static final int H2D = 10;
	private static final int D2H = 16;
	
	private static Scanner input = new Scanner(System.in);
	
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);	
   	
      System.out.println("Hello! I am your friendly number converter.");

      char doContinue = 'y';
      do {
         int targetBase = getTargetBase();
         if(targetBase == H2D) {
            String Hex = getAndCheckHex();
            System.out.println("As decimal: " + Hex2Dec(Hex));
         }
         else {
            int Dec = getAndCheckDec();
            System.out.println("As hexadecimal: " + Dec2Hex(Dec));
         }
         doContinue = shallWeContinue();		
      } while(doContinue == yes);
   }

   public static char shallWeContinue() {
      char answer = 'k';
      String goodbye = "See you soon.";
      do {
         System.out.println("Countinue (y/n)?");
         answer = (input.nextLine()).charAt(0);
         if(answer != yes && answer != no)
            System.out.println(error);
         else if(answer == no)
            System.out.println(goodbye);
      } while(answer != yes && answer != no);

      return answer;
   }
	
   public static String Dec2Hex(int Dec) {
      String digits = "0123456789ABCDEF";

      if(Dec == 0)
         return "0";

      String Hex = "";
      while (Dec > 0) {
         int digit = Dec % 16;
         Hex = digits.charAt(digit) + Hex;
         Dec = Dec / 16;
      }

      return Hex;
   }

   public static int Hex2Dec(String Hex) {
      String digits = "0123456789ABCDEF";
      int result = 0;

      for(int i = 0; i < Hex.length(); i++) {
         int number = digits.indexOf(Hex.charAt(i));
         result = 16*result + number;
      }
      return result;
   }

  public static int getAndCheckDec() {
      int Dec = 0;
      do {
         System.out.println("Enter a decimal number:");
         Dec = input.nextInt();
         if (Dec < 0) {
            System.out.println(error);
         }
      }
      while (Dec < 0);

      return Dec;
   }

   public static String getAndCheckHex() {
      String Hex = " ";
      boolean isOk = false;
      do {
         isOk = false;
         System.out.println("Enter a hexadecimal number:");
         Hex = input.nextLine();
         for(int i = 0; i < Hex.length(); i++) {
            if (Hex.charAt(i) >= 'A' && Hex.charAt(i) <= 'F' || Hex.charAt(i) >= '0' && Hex.charAt(i) <= '9'){
            }
            else {
               System.out.println(error);
               isOk = true;
               i = i + Hex.length();
            }
         }
      }
      while (isOk);
		
      return Hex;
   }

   public static int getTargetBase() {
      int targetBase = 0;
      do {
         System.out.println("Enter the target base (16/10):");
         targetBase = In.readInt();
         // Tulostaa virheilmoituksen tarvittaessa.
         if (targetBase != D2H && targetBase != H2D)
            System.out.println(error);
      }
      while (targetBase != D2H && targetBase != H2D);

      return targetBase;
   }
}
