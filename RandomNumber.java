import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {
    
    protected static boolean easyHard()
    {
        try
        {
            System.out.println("Easy Game (E) or Hard Game (H):");
            BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));

            String choice = bfn.readLine();

            if (choice.equals("H") || choice.equals("h"))
            {
                System.out.println("Hard Game, Number is between 0 and 1000");
                return true;
            }
            else
            {
                System.out.println("Easy Game, Number is between 0 and 100");
                return false;
            }
        }
        catch (IOException e) {
            // IOException - thrown when input-output operation failed
            System.out.println("Not a valid choice, game default is easy");
            return false;
        }    
    }

    protected static int userInput()
    {
    try
    {
        System.out.println("Guess a number:");
        BufferedReader bfn = new BufferedReader(new InputStreamReader(System.in));

        int guess = Integer.parseInt(bfn.readLine());

        return guess;
    }
    catch (IOException e) {
        // IOException - thrown when input-output operation failed
        System.out.println("Not a Number, guess default is 0");
        return 0;
    }
    }

    protected static int randomInt(boolean level)
    {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        if (level == false){
            int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            return randomNum;
        }
        else{
            int randomNum = ThreadLocalRandom.current().nextInt(0, 1000 + 1);
            return randomNum;
        }
    }

    protected static boolean processInput(int guess, int number)
    {
        if (guess == number)
        {
            System.out.println("You guessed it!");
            return true;
        }
        else if (guess > number)
        {
            System.out.println("Too High");
            return false;
        }
            else
            System.out.println("Too Low");
            return false;
    }

    protected static void runGame(int number)
    {
        int guess = 0;
        boolean correct = false;
        for (int i=1; i<=20; i++)
        {
            guess = userInput();
            
            correct = processInput(guess, number);
            if (correct == true)
            {
                String guesses = "It took you " + i + " guesses";
                System.out.println(guesses);
                break;
            }
            if (i == 20){
                System.out.println("Better Luck Next Time!");
            }
        }  
    }
    
    public static void main(String[] args)
    {
        System.out.println("Guess The Number Game!");
        boolean level = easyHard();
        int number = randomInt(level);
        runGame(number);
    }
}
