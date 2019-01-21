/*
 * Author Kristoffer Corbett
 * created 1/18/2019
 * This class is a simple example of a dictionary program
 * This class reads two default text files or two text file arguments provided at the command line
 * It reads words from said text files into array lists of strings and then compares words in the first file to the second
 * If a word in the first file cannot be found in the second file user will be notified
 */

import java.io.*;
import java.util.ArrayList;

public class SepllChecking {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		File inputFile; //stores first argument as type: file, inputed to array list and checked against dictionary
		File dictionaryFile; //stores second argument as type: file , used as dictionary to check existance of words
		ArrayList<String> words = new ArrayList<String>(); //array list for words to check
		ArrayList<String> dictionary = new ArrayList<String>(); //array list for dictionary
		String st; //stores individual words as they are read from file
		
		//initialize test and dictionary files to the samples provided
		String fileOne = "testStates.txt"; //unzips to root project directory 
		String fileTwo = "dictionary.txt"; //unzips to root project directory
		inputFile = new File(fileOne);
		dictionaryFile = new File(fileTwo);
		
		
		//attempt to replace default files with files provided during command line arguments
		try
		{
			fileOne = args[0]; //requirements specified arguments must be stored as string variables
			fileTwo = args[1]; //requirements specified arguments must be stored as string variables
			inputFile = new File(fileOne);
			dictionaryFile = new File(fileTwo);
		}
		catch(Exception e)
		{
			System.out.println("Missing or invalid file arguments. Using default files:");
		}
		
		
		//attempt to read from provided word list
		try
		{
		BufferedReader br = new BufferedReader(new FileReader(inputFile));
		//each word is its own line. store each line as a string while iterating through the file. If a text line is empty, exit the loop
		while ((st = br.readLine()) != null)
			words.add(st); //add each word to the words arraylist
		br.close(); //close reader
		}
		//if there is a problem reading from the file notify the user and exit
		catch(IOException e)
		{
			System.out.println("Cannot read from provided word list. Exiting Program.");
			System.exit(1);
		}
		
		//attempt to read from provided dictionary list
		try
		{
		BufferedReader br = new BufferedReader(new FileReader(dictionaryFile));
		//each word is its own line. store each line as a string while iterating through the file. If a text line is empty, exit the loop
		while ((st = br.readLine()) != null)
			dictionary.add(st); //add each word to the dictionary arraylist
		br.close();
		}
		//if there is a problem reading from the file notify the user and exit
		catch(IOException e)
		{
			System.out.println("Cannot read from provided dictionary. Exiting Program.");
			System.exit(1);
		}
		
		//iterate through the provided list of words to check		
		for(int i=0; i < words.size() ; i++)
		{
			boolean found = false; //for each word begin with the assumption that this is NOT a word
			for(int j=0; j < dictionary.size(); j++) //for each word to check iterate through the dictionary
			{
				if(words.get(i).equals(dictionary.get(j))) //compare current word to check with current dictionary word
				{
					//if there is a match found boolean records the match and the inner loop breaks for efficiency
					found = true;
					break;
				}
			}
			//at the end of each outer loop notify the user if a word to check was not found in the dictionary
			if(!found)
				System.out.println(words.get(i) + " is an unknown word.");
		}
	}
}
