
/**
 * Implements an Arraylist to modify, add, delete, and sort a collection of Objects.
 *
 * @author Dwayne Whyte
 * @version 0ct.26, 2020
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;

public class MyCollection
{  
    /** This method clears the display.**/
    private static void clearScreen() 
    { 
        System.out.println("\f");
    }
    
    /**This method pauses the program,
     * and asks the user for input to continue
     **/
    private static void pause() throws IOException
    {
        System.out.print("Press Enter key to continue:");
        char c = (char) System.in.read();
    }
    
    /** Main function responsible for */ 

    public static void main() 
    {  
        ArrayList<ActionFigure> Hero = new ArrayList<ActionFigure>(); 
        System.out.println("Starting Hero Collection Demo"); 
        System.out.println("Adding 5 Hero Objects!");
        Hero.add(new ActionFigure(123, "Superman", 50));
        Hero.add(new ActionFigure(654, "Green Lantern", 35));
        Hero.add(new ActionFigure(234, "Canary", 20));
        Hero.add(new ActionFigure(640, "Starfire",40));
        Hero.add(new ActionFigure(92, "Dr.Fate",60));
        
        for (int i = 0; i < Hero.size();i++)
        { 
            System.out.println(Hero.get(i));
        }
        
        boolean isFinished = false;
       
        while (!isFinished)
        {
            try 
            {
                Menu menu = new Menu();
                ActionFigure item;
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                input = input.toUpperCase();
                switch (input) 
                { 
                    case "A":
                    System.out.println("Enter an ID");
                    int id = in.nextInt();

                    for (int i = 0; i < Hero.size(); i++) 
                    {
                        item = Hero.get(i);
                        while ((i == Hero.size() - 1) && item.getId() == id)
                        {
            
                            System.out.println("Duplicate ID's are not allowed.");
                            pause();
                            System.out.println("Enter a unique ID.");
                            id = in.nextInt();
                            if (id <= 0)
                            {
                                System.out.println("ID can't be less than 1. Enter a new ID");
                                id = in.nextInt();
                            }
                        }
                    }
                    System.out.println("Enter a name");
                    String name = in.next();
                    System.out.println("Enter a price");
                    double price = in.nextDouble();
                    while (price <= 0.00)
                    {
                        System.out.println("Price must be greater than $0.00. Enter a new price");
                        price = in.nextDouble();
                    }
                    Hero.add(new ActionFigure(id,name,price));
                    clearScreen();
                    for (int i = 0; i < Hero.size();i++)
                    {
                        System.out.println(Hero.get(i));
                    }
                    break;
        
                    case "R":
                    System.out.println("Select the ID you want to remove.");
                    id = in.nextInt();
                    for (int i = 0; i < Hero.size(); i++) 
                    {
                        item = Hero.get(i);
                        if (item.getId() == id)
                        {
                            Hero.remove(i);
                            break;
                        }
                        else if (i == Hero.size()-1)
                        {
                            System.out.println ("ID not found"); 
                        }
                    }
                    pause();
                    clearScreen();
                    for (int i = 0; i < Hero.size();i++)
                    {
                        System.out.println(Hero.get(i));
                    }
                    break;
        
                    case "C":
                    System.out.println("ID of old Hero");
                    int heroID = in.nextInt();
                    System.out.println("Enter an new ID");
                    int newid = in.nextInt();
                    System.out.println("Enter a name");
                    name = in.next();
                    System.out.println("Enter a price");
                    price = in.nextInt();
                    ActionFigure item2;

                    for (int i = 0; i < Hero.size(); i++) 
                    {
                        item2 = Hero.get(i);
                        if (item2.getId() == heroID)
                        {
                            Hero.set(i,new ActionFigure (newid,name,price));
                        }
                        else
                        {
                            System.out.println("ID not found!");
                        }
                    }
                    clearScreen();
                    for (int i = 0; i < Hero.size();i++)
                    {
                        System.out.println(Hero.get(i));
                    }
                    break;
        
                    case "S":
                    Collections.sort(Hero);
                    pause();
                    clearScreen();
                    for (int i = 0; i < Hero.size();i++)
                    {
                        System.out.println(Hero.get(i));
                    }
                    break;
                        
                    case "Q":
                    isFinished = true;
                    clearScreen();
                    for (int i = 0; i < Hero.size();i++)
                    {
                        System.out.println(Hero.get(i));
                    }
                    break;
                        
                    default: 
                    System.out.println("Your input was invalid!");
                }
            }
            catch(Exception e)
            {
                System.out.println("Error Occured.");
            }
        }
    }
}
