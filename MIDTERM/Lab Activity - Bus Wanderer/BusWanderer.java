import java.util.Scanner;
public class BusWanderer {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Welcome to Cebu South Bus Terminal");
      
      calculateEstimatedTimeArrival("Cebu City to Mingla",14.2, 60);
      calculateEstimatedTimeArrival("Cebu City to San Fernando",20.2, 60);
      calculateEstimatedTimeArrival("Cebu City to CarCar",39.1, 60);
      
      System.out.println("Which route would you like to go?");
      System.out.print("Enter your route choice ( Barili | Sibonga ): ");
      String carcarChoice = scan.nextLine();
      
      if (carcarChoice.equalsIgnoreCase("Barili")) {
         calculateEstimatedTimeArrival("Cebu City to Barili",55.4, 60);
         calculateEstimatedTimeArrival("Cebu City to Dumanjug",78.4, 60);
         calculateEstimatedTimeArrival("Cebu City to Alcantara",84.5, 60);
         calculateEstimatedTimeArrival("Cebu City to Moalboal",85.7, 60);
      } else if (carcarChoice.equalsIgnoreCase("Sibonga")) {
         System.out.print("Enter your route choice ( Dumanjug | Argao ): " );
         String sibongaChoice = scan.nextLine();
         
         if (sibongaChoice.equalsIgnoreCase("Dumanjug")) {
            calculateEstimatedTimeArrival("Cebu City to Dumanjug",83.2, 60);
            calculateEstimatedTimeArrival("Cebu City to Alcantara",110.4, 60);
            calculateEstimatedTimeArrival("Cebu City to Moalboal",124.1, 60);
         } else if (sibongaChoice.equalsIgnoreCase("Argao")) {
            calculateEstimatedTimeArrival("Cebu City to Argao",70.5, 60);
            calculateEstimatedTimeArrival("Cebu City to Ronda",96.5, 60);
            calculateEstimatedTimeArrival("Cebu City to Alcantara",116.5, 60);
            calculateEstimatedTimeArrival("Cebu City to Moalboal",130.2, 60);
            
         } else {
            System.out.println("Invalid choice. PLease enter ( Dumanjug | Argao )");
         }
      } else {
         System.out.println("Invalid Choice. Please enter( Barili | Sibonga ) ");
      }
   }
   public static void calculateEstimatedTimeArrival(String route, double distance, double speed) {
   double time = distance / speed;
   int seconds = (int)(time * 100);
   int hours = seconds / 100;
   int minutes = seconds % 100;
   if(minutes >= 60) {
      hours++;
      minutes = minutes - 60;
   }
   System.out.println("|---------------------------------------------");
   System.out.println("|Route = " + route);
   System.out.println("|Distance = "+ distance + " km ");
   System.out.println("|Speed = " + speed + " km/h ");
   System.out.println("|ETA = " + hours + " hr " + minutes + " min ");
   System.out.println("|---------------------------------------------");
   }
}