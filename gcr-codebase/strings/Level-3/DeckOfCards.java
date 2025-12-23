//Created class Named DeckOfCards
import java.util.Scanner;
public class DeckOfCards{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for number of cards to distribute
    int n=input.nextInt();

    //take input for number of players
    int players=input.nextInt();
    String deck[]=initializeDeck();
    shuffleDeck(deck);
    String playerCards[][]=distributeCards(deck,n,players);

    //print players and their cards
    printPlayers(playerCards);
   }

   //method to initialize deck of cards
   public static String[] initializeDeck(){

       String suits[]={"Hearts","Diamonds","Clubs","Spades"};
       String ranks[]={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};

       int numOfCards=suits.length*ranks.length;
       String deck[]=new String[numOfCards];

       int index=0;

       for(int i=0;i<suits.length;i++){
           for(int j=0;j<ranks.length;j++){
               deck[index]=ranks[j] + " of " + suits[i];
               index++;
           }
       }

       return deck;
   }

   //method to shuffle the deck
   public static void shuffleDeck(String deck[]){

       int n=deck.length;

       for(int i=0;i<n;i++){
           int randomCardNumber=i + (int)(Math.random()*(n-i));
           String temp=deck[i];
           deck[i]=deck[randomCardNumber];
           deck[randomCardNumber]=temp;
       }
   }

   //method to distribute cards to players
   public static String[][] distributeCards(String deck[],int n,int players){

       if(n%players!=0){
           System.out.println("Cards cannot be distributed equally");
           return new String[0][0];
       }

       int cardsPerPlayer=n/players;
       String playerCards[][]=new String[players][cardsPerPlayer];

       int index=0;

       for(int i=0;i<players;i++){
           for(int j=0;j<cardsPerPlayer;j++){
               playerCards[i][j]=deck[index];
               index++;
           }
       }

       return playerCards;
   }

   //method to print players and their cards
   public static void printPlayers(String playerCards[][]){

       for(int i=0;i<playerCards.length;i++){
           System.out.println("Player " + (i+1) + " cards:");

           for(int j=0;j<playerCards[i].length;j++){
               System.out.println(playerCards[i][j]);
           }

           System.out.println();
       }
   }
}
