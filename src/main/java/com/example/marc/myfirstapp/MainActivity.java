package com.example.marc.myfirstapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.util.Scanner;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void search(View view) throws Exception{
//        ((TextView) findViewById(R.id.result)).setText(
//                HangingHelperStart(pickedLettersCreator(), currentBoardCreator())
//        );
        ((TextView) findViewById(R.id.result)).setText("Hello World!");
    }

    static String arraySizer(int[] array)
    {
        String winningChar;
        winningChar = "a";
        int winningIndex, currentIndex, winningNumber;
        winningIndex = 0;
        currentIndex = 0;
        while (currentIndex < 26)
        {
            if (array[currentIndex] > array[winningIndex])
            {
                winningIndex = currentIndex;
            }
            currentIndex++;
        }
        switch (winningIndex)
        {
            case 0: winningChar = "a";
                break;
            case 1: winningChar = "b";
                break;
            case 2: winningChar = "c";
                break;
            case 3: winningChar = "d";
                break;
            case 4: winningChar = "e";
                break;
            case 5: winningChar = "f";
                break;
            case 6: winningChar = "g";
                break;
            case 7: winningChar = "h";
                break;
            case 8: winningChar = "i";
                break;
            case 9: winningChar = "j";
                break;
            case 10: winningChar = "k";
                break;
            case 11: winningChar = "l";
                break;
            case 12: winningChar = "m";
                break;
            case 13: winningChar = "n";
                break;
            case 14: winningChar = "o";
                break;
            case 15: winningChar = "p";
                break;
            case 16: winningChar = "q";
                break;
            case 17: winningChar = "r";
                break;
            case 18: winningChar = "s";
                break;
            case 19: winningChar = "t";
                break;
            case 20: winningChar = "u";
                break;
            case 21: winningChar = "v";
                break;
            case 22: winningChar = "w";
                break;
            case 23: winningChar = "x";
                break;
            case 24: winningChar = "y";
                break;
            case 25: winningChar = "z";
                break;
            default: winningChar = "error";
                break;
        }
        return winningChar;
    }
    //This is the real main method. Takes two string values, the current board and the letters that
    //aren't in the word. Returns the best character to pick OR the correct word (if it's the only remaining
    //possible word).
    static String HangingHelperStart(String pickedLetters, String currentBoard) throws Exception
    {
        //Initiate variables
        String winningChar;
        int boardLength, index, lastIndex;
        index = 0;

        //Setup files
        boardLength = currentBoard.length();
        lastIndex = lastVowel(currentBoard, boardLength);
        possibleWordsCreator(currentBoard, pickedLetters, lastIndex);

        //Create string for the letters already in the word
        java.io.File extraFile = new java.io.File("C:\\Users\\marc\\workspace\\HangingHelper\\src\\extraFile.txt");
        java.io.PrintWriter output = new java.io.PrintWriter(extraFile);
        while (index < boardLength)
        {
            if (currentBoard.charAt(index) != '?')
            {
                output.print(currentBoard.charAt(index));
            }
            index++;
        }
        output.close();

        winningChar = statsCalculator(currentBoard, pickedLetters);
        return winningChar;
    }
    static String statsCalculator(String currentBoard, String pickedLetters) throws Exception
    {
        //Initiate Files
        java.io.File PossibleWords = new java.io.File("C:\\Users\\marc\\workspace\\HangingHelper\\src\\PossibleWords.txt");
        java.io.File extraFile = new java.io.File("C:\\Users\\marc\\workspace\\HangingHelper\\src\\extraFile.txt");
        Scanner input = new Scanner(PossibleWords);
        Scanner input2 = new Scanner(extraFile);

        //Initiate Variables
        int wordIndex, charIndex, wordLength, invalidLength;
        charIndex = 0;
        int[] alphabet = new int[26];
        while (charIndex < 26)
        {
            alphabet[charIndex] = 0;
            charIndex++;
        }
        String correctLetters, totalLetters, word1, winningChar;
        correctLetters = input2.next();
        totalLetters = correctLetters + pickedLetters;
        invalidLength = totalLetters.length();

        while (input.hasNext())
        {
            wordIndex = 0;
            word1 = input.next();
            wordLength = word1.length();
            while (wordIndex < wordLength)
            {
                if (currentBoard.charAt(wordIndex) == '?')
                {
                    switch (word1.charAt(wordIndex))
                    {
                        case 'a': alphabet[0]++;
                            break;
                        case 'b': alphabet[1]++;
                            break;
                        case 'c': alphabet[2]++;
                            break;
                        case 'd': alphabet[3]++;
                            break;
                        case 'e': alphabet[4]++;
                            break;
                        case 'f': alphabet[5]++;
                            break;
                        case 'g': alphabet[6]++;
                            break;
                        case 'h': alphabet[7]++;
                            break;
                        case 'i': alphabet[8]++;
                            break;
                        case 'j': alphabet[9]++;
                            break;
                        case 'k': alphabet[10]++;
                            break;
                        case 'l': alphabet[11]++;
                            break;
                        case 'm': alphabet[12]++;
                            break;
                        case 'n': alphabet[13]++;
                            break;
                        case 'o': alphabet[14]++;
                            break;
                        case 'p': alphabet[15]++;
                            break;
                        case 'q': alphabet[16]++;
                            break;
                        case 'r': alphabet[17]++;
                            break;
                        case 's': alphabet[18]++;
                            break;
                        case 't': alphabet[19]++;
                            break;
                        case 'u': alphabet[20]++;
                            break;
                        case 'v': alphabet[21]++;
                            break;
                        case 'w': alphabet[22]++;
                            break;
                        case 'x': alphabet[23]++;
                            break;
                        case 'y': alphabet[24]++;
                            break;
                        case 'z': alphabet[25]++;
                            break;
                    }
                }
                wordIndex++;
            }
        }
        charIndex = 0;
        //For testing the alphabet array
		/*while (charIndex < 26)
		{
			System.out.println(alphabet[charIndex]);
			charIndex++;
		}*/
        winningChar = arraySizer(alphabet);
        return winningChar;
    }
    //Takes a string that represents what is currently on the board and a string of letters that have already
    //been picked. Requires a document called "HangingDictionary.txt" that is the acceptable dictionary.
    //Creates a document called "PossibleWords.txt" that lists the words that are possible with the given information.
    static void possibleWordsCreator(String currentBoard, String pickedLetters, int lastIndex) throws Exception
    {
        //Initiate Files
        java.io.File PossibleWords = new java.io.File("C:\\Users\\marc\\workspace\\HangingHelper\\src\\PossibleWords.txt");
        java.io.File HHDictionary = new java.io.File("C:\\Users\\marc\\workspace\\HangingHelper\\src\\HangingDictionary.txt");
        java.io.PrintWriter output = new java.io.PrintWriter(PossibleWords);
        Scanner input = new Scanner(HHDictionary);
        //Initiate variables
        boolean possible = true;
        boolean qmark = false;
        boolean vowel = false;
        String word1;
        int wordLength, boardIndex, boardLength, pickedIndex, pickedLength;
        boardLength = currentBoard.length();
        pickedLength = pickedLetters.length();

        //Searching word by word
        while (input.hasNext())
        {
            possible = true;
            boardIndex = 0;
            word1 = input.next();
            wordLength = word1.length();
            //Check the wordlength
            if(boardLength != wordLength)
            {
                possible = false;
            }
            //Searching character by character
            while (boardIndex < boardLength && possible)
            {
                pickedIndex = 0;
                if (currentBoard.charAt(boardIndex) != '?')
                {
                    if (currentBoard.charAt(boardIndex) != word1.charAt(boardIndex))
                    {
                        possible = false;
                    }
                }
                else
                {
                    vowel = isVowel(word1.charAt(boardIndex));
                    if (vowel && boardIndex > lastIndex)
                    {
                        possible = false;
                    }
                    while (pickedIndex < pickedLength)
                    {
                        if (word1.charAt(boardIndex) == pickedLetters.charAt(pickedIndex))
                        {
                            possible = false;
                        }
                        pickedIndex++;
                    }
                }
                boardIndex++;
            }
            if (possible)
            {
                output.println(word1);
            }
        }
        output.close();
        input.close();
    }
    //Prompts the user to enter a string of letters that have already been entered and returns that string.
    static String pickedLettersCreator()
    {
        Scanner input = new Scanner(System.in);
        String pickedLetters = "";
        System.out.println("Which letters have already been eliminated?");
        pickedLetters = input.nextLine();
        return pickedLetters;
    }
    //Prompts the user to enter a string of letters that represents what is on the board and returns that string.
    static String currentBoardCreator()
    {
        Scanner input = new Scanner(System.in);
        String currentBoard = "";
        System.out.println("What does the current board look like?");
        currentBoard = input.nextLine();
        return currentBoard;
    }
    //Takes a char variable that is a letter. Returns 'True' if the letter is a vowel and 'False' if the letter
    //is a consonant.
    static boolean isVowel(char letter)
    {
        boolean vowel = false;
        switch (letter)
        {
            case 'a': vowel = true;
                break;
            case 'b': vowel = false;
                break;
            case 'c': vowel = false;
                break;
            case 'd': vowel = false;
                break;
            case 'e': vowel = true;
                break;
            case 'f': vowel = false;
                break;
            case 'g': vowel = false;
                break;
            case 'h': vowel = false;
                break;
            case 'i': vowel = true;
                break;
            case 'j': vowel = false;
                break;
            case 'k': vowel = false;
                break;
            case 'l': vowel = false;
                break;
            case 'm': vowel = false;
                break;
            case 'n': vowel = false;
                break;
            case 'o': vowel = true;
                break;
            case 'p': vowel = false;
                break;
            case 'q': vowel = false;
                break;
            case 'r': vowel = false;
                break;
            case 's': vowel = false;
                break;
            case 't': vowel = false;
                break;
            case 'u': vowel = true;
                break;
            case 'v': vowel = false;
                break;
            case 'w': vowel = false;
                break;
            case 'x': vowel = false;
                break;
            case 'y': vowel = false;
                break;
            case 'z': vowel = false;
                break;
            case '?': vowel = false;
        }
        return vowel;
    }
    //Takes a string
    static int lastVowel(String currentBoard, int boardLength)
    {
        //Initiate variables
        int lastIndex, index;
        char letter = '?';
        lastIndex = boardLength;
        index = 0;

        while (index < boardLength)
        {
            letter = currentBoard.charAt(index);
            if (isVowel(letter))
            {
                lastIndex = index;
            }
            index++;
        }

        return lastIndex;
    }
}
