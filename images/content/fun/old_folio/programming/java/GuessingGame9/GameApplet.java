import java.applet.*;       
import java.awt.*;
import java.awt.event.*;

/**
 *Game applet serves as the user interface to the game 
 * 
 *Author : Jeff Williams 
 *Version : GameApplet1.0
*/
public class GameApplet extends Applet implements ActionListener
{
    
    private Game game1 = new Game(); // creates an instance of the game class using the constructor method Game();
    
    // GUI components
    private TextField guess = new TextField(10); //creates a textfield that the user can input their guess into         
    private TextField guessResponse = new TextField(38); //creates a textfield that that acts as an textual interface between the user and the applet. (38 characters in length)
    private TextField countField = new TextField(15); //creates a textfield that will display the number of guesses the user has had
    private Label promptTitle = new Label("Guess my number between 1 and 100 in " + game1.getMaxCount() + " guesses"); //creates a title for the applet, exclaiming the instructions of the game
    private Label promptGuess = new Label("Enter your guess"); //creates a label for the guess textfield so the user knows where to input their guess 
    private Label promptCount = new Label("Guesses so far"); //creates a label for the countField so the user knows where how many guesses they have had will appear 
    private Button testGuess = new Button("Test Guess"); //creates a button that will be used to submit the users inputed guess
    private Button restart = new Button("restart"); //creates a button that will allow the user to restart the game with a new random number and a guess count of 0
   
   
    public void init(){     //initalise the GameApplet class
        add(promptTitle);   // Set up the user interface, bu adding GUI components       
        add(promptGuess); 
        add(guess);                       
        add(promptCount);        
        add(countField);
        countField.setText("0");
        countField.setEditable(false);
        add(testGuess);
        testGuess.addActionListener(this); 
        restart.addActionListener(this);
        add(guessResponse); 
        guessResponse.setEditable(false);
        add(restart);
                            // Set up the user interface by restricting its size so buttons are arranged correctly according to the flow layout. Plus setting background as lightGray
        setSize(303,200);        
        setBackground(Color.lightGray); 
    } // init()
   
        
    public void actionPerformed(ActionEvent e) {   
        double randomNumber = game1.getRandomNumber(); // instantiate method variables 
        String response = "";
        boolean inputValid = false;
        
        String inputStr = guess.getText();             // Get user's input
        double userInput = Double.parseDouble(inputStr); // Convert it to double
          
        
        {
        if (e.getSource() == restart){ // if the restart button is pressed, clear guessResponse field, reset the randomNumber,  reset the number of guesses (count) to 0, set respective fields to editable, give respective fields neccesary text   
            guessResponse.setText("");
            game1.setRandomNumber();
            randomNumber = game1.getRandomNumber();
            game1.resetCount();
            countField.setText("" + game1.getCount());
            guess.setEditable(true);
            game1.setCorrect(false);
            countField.setText("" + game1.getCount());
            } // restart
            
        else if (e.getSource() == testGuess){ // if the test guess button is pressed       
                inputValid = game1.testInputRange(userInput); // call testInputRange() from Game class to see if the users input is valid  
                if (inputValid == false)
                    guessResponse.setText ("please enter a number between the given range");    
                else { //if the user input is valid process the guess by calling the test() from the Game class                      
                    response = game1.test(userInput, randomNumber);

                    if ((response == "the number is higher") || (response =="the number is lower") || (response =="Correct, you win") ){ // regular returns
                        guessResponse.setText(response);
                        countField.setText ("" + game1.getCount());
                        if (response == "Correct, you win") {
                            guess.setEditable(false);               // the guess is correct for the first time, so the user may no longer longer guess
                            countField.setText ("");
                            }
                       else 
                            guess.setEditable(true);
                        }
                    else if (response == "fail"){    // the user has run out of guesses, so they may no longer input another guess
                        guessResponse.setText("GAME OVER, guesses used, the number was " + randomNumber);
                        guess.setEditable(false);
                        }
                    else if (response == "finished" ){  //if the user is correct alreay (the gamestate is finished), set game response to play again by pressing restart
                        guessResponse.setText("Play again by pressing RESTART");
                        guess.setEditable(false);
                        game1.setCorrect(false);
                        }
                    else 
                        game1.setCorrect(false);    //if there is an error default correct (game state) to false 
                    }     
                } // testGuess 
        }
    } // Action Performed
     
} // GameApplet
