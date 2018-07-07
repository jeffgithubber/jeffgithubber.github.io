/**
 *Description : This game class acts as a bluePrint for a game instance. It contains the
 * necessary methods for: 
 *      checking that the user has entered a number value between [1,100]
 *      setting a maximum number of guesses available to the user
 *      establishing how many guesses the user has had and checking that it is less than the maximum number of guesses available to the user
 *      setting, reseting and getting a random number
 *      testing whether or not the users guess was correct
 *Author: Jeff Williams
 *Version: Game1.0   
 */

import java.lang.Math; //Import the java.lang.Math class to provide common mathematical functions

public class Game{

    private double randomNumber;        // the game'srandom number  
    private int count;              // the number of guesses 
    private int maxCount;           // the total number of available guess
    private boolean correct = false;    // the state of the game (whether or not the user is allowed to enter another guess)

    
    /**
     *  Game() is a constructor method which
     *  initialises the instance variables (randomNumber, count and  maxCount)
    */   
    public Game(){
    double x =  Math.random();
        double y = Math.ceil(x*100); //yeilds an a random number of type double in the range of [1,100]                
        randomNumber = y;
    
        count = 0;
        maxCount = 5;
        correct = false;
    }   // Game()

    /**
     * testInputRange() is an accessor method which tests wether the users input
     * is between [1,100] and returns false if it is not and true if it is
     *
    */
    public boolean testInputRange(double userInput){    
    if ((userInput <=0) || (userInput >100))
        return false;
    else
        return true;
    }   // testInputRange()        

    /**
     * setCorrect() is a mutator method which takes a boolean paramater and assigns
     * it to answer. If answer is true then correct (the state of the game) is set to
     * true, else it is set to correct. This establishes whether or not the user can
     * play again.
    */
    public void setCorrect(boolean answer){
         if (answer == true) 
            correct = true;
         else
            correct = false;         
    }   //setCorrect()
    
    /**
     * setRandomNumber() is  a mutator method which creates and assigns a random number 
     * to the instance variable randomNumber
    */   
    public void setRandomNumber(){
        double x =  Math.random();
        double y = Math.ceil(x*100); //yeilds an a random number of type double in the range of [1,100]                
        randomNumber = y;
    }   // setRandomNumber()

    /**
     * is an accessor method which returns the games random number  
    */    
    public double getRandomNumber(){   
        return randomNumber;    
    } // getRandomNumber()
    
    /**
     * is an accessor/mutator method which tests the state of the game to see if they 
     * can play again or not. If they can play again, it tests the users guess to see 
     * if it is greater, equal to or less than the random number. It then returns the 
     * corresponding statement and either adds one to the number of guesses the user 
     * has had and sets the state of the game to false so the user can play again. Or 
     * its returns the corresponding statement and sets the state of the game to true
     * so the user cannot play again. 
    */    
    public String test(double guess, double randomnum){
    if ((correct == false)&& (count < maxCount)){ // if the user can play again and the number of guesses is less than the maximum number of guesses available
            if (guess < randomnum){ // if the guess is less than the random number, set the state of the game so they can play again and add 1 the number of guesses the user has had
            correct = false;
            count = ++count;
            return "the number is higher";
            }
            else if (guess > randomnum){ // if the guess is greater than the random number, set the state of the game so they can play again and add 1 the number of guesses the user has had 
            correct = false;
            count = ++count;
            return "the number is lower";        
            }
            else if (guess == randomnum){ // if the guess is equal to the random number, set the state of the game so they cannot play again 
        
            correct = true;
            return "Correct, you win";
            }
            else 
            return "error1"; // returns error1 so the tester can understand were the error has occured in the program
        }
    else if (count == maxCount){ // if the user has run out of guesses, set the state of the game to true so the user cannot play again. Also set count to one greater than the maximum count so it does not conflict with prior and subsequent game state conditional statements 
        correct = true;
        count = maxCount + 1;
        return "fail";
        }
        
    else if ((correct == true) ){ // if the gamestate is equal to true, the user cannot play again therefore return finished
        correct = true;
        return "finished";   
        }
    else
        return "error2"; // returns error2 so the tester can understand were the error has occured in the program
        
    } // test()
    
    
    
    
     /**
     * is a mutator method which resets the maximum number of guesses available to the user. (it is only used in the game class)
     */
    public void setMaxCount(int max)
    {
        maxCount = max;
    } //setMaxCount()
    
    /**
     * is an accessor method which returns the maximum number of guesses the user can have
    */ 
    public int getMaxCount()
    {
        return maxCount;
    }   // getMaxCount()
 
    /**
     * is an accessor method which returns the current number of guesses the user has had  
    */ 
    public int getCount()
    {
        return count;
    }   // getCount()
    
    /**
     * is a mutator method which set the current number of guesses to 0. It is used by the GameApplet when the user restarts. 
    */    
    public void resetCount()
    {
        count = 0;
    }   // resetCount()
    
}// end Game
    
