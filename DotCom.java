package GridGame;
import java.util.*;
public class DotCom 
{
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc)
    {
          locationCells = loc;
    }
    public void setName(String n)
    {
     name = n;
    }
   public String checkYourself(String userInput)
   {
        String result = "Miss";
        int index = locationCells.indexOf(userInput);

        if (index > 0) 
        {
            locationCells.remove(index);
           if (locationCells.isEmpty()) 
           {
            result = "Kill";
            System.out.println("OUCH! You Sunk" + name + " : ( ");
           }
            else
            { 
                result = "Hit";

            }

        }
        return result;
   }




}
