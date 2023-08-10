public class WinnerRobot {
   private String winner;

   public WinnerRobot (BaseRobot[] robots){
   int indexWinner=0;
       for (int i = 1; i < robots.length ; i++) {
           if(robots[i].score > robots[indexWinner].score )
               indexWinner = i;
       }
       winner = robots[indexWinner].getName();
   }

   public String getWinner(){
       return winner;
   }


}