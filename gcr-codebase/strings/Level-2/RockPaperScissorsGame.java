//Created class Named RockPaperScissorsGame
import java.util.Scanner;
public class RockPaperScissorsGame{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for number of games
    int games=input.nextInt();

    String results[][]=new String[games][3];

    int playerWins=0;
    int computerWins=0;

    //play multiple games
    for(int i=0;i<games;i++){

        //take user choice
        String playerChoice=input.next();

        //get computer choice
        String computerChoice=getComputerChoice();

        //find winner
        String winner=findWinner(playerChoice,computerChoice);

        results[i][0]=playerChoice;
        results[i][1]=computerChoice;
        results[i][2]=winner;

        if(winner.equals("Player")){
            playerWins++;
        }
        else if(winner.equals("Computer")){
            computerWins++;
        }
    }

    //calculate statistics
    String stats[][]=calculateStats(games,playerWins,computerWins);

    //display results
    displayResults(results,stats);
   }

   //method to get computer choice
   public static String getComputerChoice(){
       int value=(int)(Math.random()*3);

       if(value==0){
           return "rock";
       }
       else if(value==1){
           return "paper";
       }
       else{
           return "scissors";
       }
   }

   //method to find winner
   public static String findWinner(String player,String computer){

       if(player.equals(computer)){
           return "Draw";
       }

       if(player.equals("rock") && computer.equals("scissors") ||
          player.equals("paper") && computer.equals("rock") ||
          player.equals("scissors") && computer.equals("paper")){
           return "Player";
       }

       return "Computer";
   }

   //method to calculate average and percentage
   public static String[][] calculateStats(int games,int playerWins,int computerWins){
       String stats[][]=new String[2][3];

       double playerPercent=(playerWins*100.0)/games;
       double computerPercent=(computerWins*100.0)/games;

       stats[0][0]="Player";
       stats[0][1]=String.valueOf(playerWins);
       stats[0][2]=String.format("%.2f",playerPercent);

       stats[1][0]="Computer";
       stats[1][1]=String.valueOf(computerWins);
       stats[1][2]=String.format("%.2f",computerPercent);

       return stats;
   }

   //method to display results
   public static void displayResults(String results[][],String stats[][]){

       System.out.println("Game\tPlayer\tComputer\tWinner");

       for(int i=0;i<results.length;i++){
           System.out.println((i+1) + "\t" +
                              results[i][0] + "\t" +
                              results[i][1] + "\t\t" +
                              results[i][2]);
       }

       System.out.println();
       System.out.println("Player\tWins\tWin %");

       for(int i=0;i<stats.length;i++){
           System.out.println(stats[i][0] + "\t" +
                              stats[i][1] + "\t" +
                              stats[i][2]);
       }
   }
}