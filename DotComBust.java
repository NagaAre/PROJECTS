package GridGame;
// These are the packages that are used usually in programs
import java.util.*; // -->Collections framework (List, Map, Set), date and time utilities, etc.
//import java.io.*; -->Input/output operations (files, streams).
//import java.net.*; -->  Networking operations (sockets, URLs).
//import java.lang.*; --> These are the basic packages that are given inbuilt for every java program
//import java.awt.*; --> This package is used for GUI's(Graphical User-Interfaces)
public class DotComBust
{
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;


    private void setUpGame()
   {
        DotCom one = new DotCom();
        one.setName("Pets.Com");
        DotCom two = new DotCom();
        two.setName("eToys.Com");
        DotCom three = new DotCom();
        three.setName("Go2.Com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Goal: Need To Sink Three .Coms");
        System.out.println("Pets.Com, eToys.Com, Go2.Com");
        System.out.println("Try To Sink Them All In Fewest Number Of Guesses");

        for(DotCom dotComToSet : dotComsList)
       {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation); 
           
        }
    }

    private void startPlaying()
    {
        while(!dotComsList.isEmpty())
        {
           String userGuess = helper.getUserInput("Enter the Guess: ");
           checkUserGuess(userGuess);
        }
        finishGame();
    }


    private void checkUserGuess(String userGuess)
    {
      numOfGuesses = numOfGuesses+1;
      String result = "Miss";

      for(DotCom dotComToTest : dotComsList)
       {
            result = dotComToTest.checkYourself(userGuess);
      

            if(result.equals("Hit"))
            {
                break;
            }

            if(result.equals("Kill"))
            {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println("Result is:" +result);
    }
     
    private void finishGame()
    {
     System.out.println("All .Com Classes Are Dead! Your Stock is WorthLess.");

       if(numOfGuesses <= 18)
       {
        System.out.println("It only took you" + numOfGuesses + "guesses");
        System.out.println("You Got Out Before Your Option Sank.");
       }
       else
       {
        System.out.println("Took Too Long" + numOfGuesses + "guesses");
        System.out.println("Fish Are Dancing With Your Options");
       }

    }


 
public static void main(String [] args)
{
    DotComBust game = new DotComBust();
    game.setUpGame();
    game.startPlaying();
}
}