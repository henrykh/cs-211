/******************************************************************************
 * Bellevue Class: CS-211
 *           Term: Spring 2014
 *     Instructor: Robert Main
 *     
 * Textbook: Building Java Programs, A Back to Basics Approach
 *  Edition: 3rd
 *  Authors: Stuart Reges and Marty Stepp
 *  
 * Assigned Project: 4
 *
 *Class Name: project4
 *File Name: project4.java
 *
 * Programmer: Henry Howes
 *
 * Revision     Date                        Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     05/01/2014  Initial Release
 *
 * File Description
 * ----------------
 * This file defines the the class project4, which includes all methods,
 * variables, and constant values. Specifically, this class contains the Console
 * application entry method, main(), which is a static method, since no object
 * of the class type is ever instantiated.
 * 
 * Class Methods
 * -------------
 *    Name                                    Description
 * ----------  ----------------------------------------------------------------
 * main        The OS transfers control to this method upon program execution
 *
 ******************************************************************************
 */

import java.io.*;
import java.util.*;

public class project4{	

	/**************************************************************************
	 * Method: main(String[])
	 * 
	 * Program Description
	 * -------------------
	 * This client program test prints a brief introduction, then processes two
	 * files to determine the number of words, discarded "non-words", and distinct
	 * words in each (using the getCountMap method). Then it determines the number
	 * of common words, those found in both files, prints the total number and then
	 * a detailed of list of each word and the number of times it appears in each file.
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * void
	 *
	 * ------------------------------- Arguments ------------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ------------------------------------------------
	 * String[]  args          Array of "string" argument(s) passed to main()
	 *                         when the Console program is invoked by the User.
	 * 
	 * Invoked Methods
	 * ---------------
	 * getCountMap(File filename)
	 *
	 **************************************************************************
	 */
	
	public static void main(String[] args)
		throws FileNotFoundException {
		
		System.out.println("	     Chapter 11, Assigned Project #4");
		System.out.println("This program determines the distinct words in two different books");
		System.out.println("(from disk files) and the number of times each word occurs in the");
		System.out.println("file, determines the common words in both files, and finally, displays");
		System.out.println("the results.");
		System.out.println();
		
		File file1 = new File("Hamlet.txt");
		File file2 = new File("KingLear.txt");
		
		Map<String, Integer> file1Count = getCountMap(file1);
		Map<String, Integer> file2Count = getCountMap(file2);
	
		Collection<String> commonWords = file1Count.keySet();
		commonWords.retainAll(file2Count.keySet());
		System.out.println("There are "+commonWords.size()+" common words in files "+file1+" and "+file2+".");
		System.out.println("The common words are:");
		System.out.printf("%8s%17s%17s\n", "Word", "Hamlet.txt", "KingLear.txt");
		for(int i=0; i<3; i++){
			for(int j=0; j<12; j++){
				System.out.print("-");
			}
			System.out.print("   ");
		}
		System.out.println();
		Iterator<String> itr = commonWords.iterator();
		while(itr.hasNext()){
			String currentWord=itr.next();
			System.out.printf("%-13s%10s%12s\n", currentWord, file1Count.get(currentWord), file2Count.get(currentWord));
		}
		
	
	}
	//Method to process a file object and determine the total word count and the number of distinct words,
	//and then print a short summary.
	public static Map<String, Integer> getCountMap(File fileName)
	    throws FileNotFoundException {
		Map<String, Integer> wordCountMap = new TreeMap<String, Integer>();
		Scanner in = new Scanner(fileName);
		in.useDelimiter("[^a-zA-Z']+");
		int totalWordCount = 0;
		int ignoredCount = 0;
		while(in.hasNext()){
			String word = in.next().toLowerCase();
			
			if(word.length()==1 && word.charAt(0)=='\''){
				totalWordCount++;
				ignoredCount++;
				
			}
			else{
				totalWordCount++;
				if(word.startsWith("\'")){
					word = word.substring(1);
				}		
				if(wordCountMap.containsKey(word)){
					int count = wordCountMap.get(word);
					wordCountMap.put(word, count+1);
				} else {
					wordCountMap.put(word, 1);
				}
			}	
		}
		
		int remainingWords=totalWordCount-ignoredCount;
		
		System.out.println("Statistics for file: "+ fileName);
		System.out.println(" There are a total of "+totalWordCount+" words in the file.");
		System.out.println(" Of those, "+ignoredCount+" were ignored, leaving "+remainingWords+" words to process.");
		System.out.println(" After processing, there are "+wordCountMap.size()+ " distinct words in the file");
		System.out.println();
		
		return wordCountMap;
	}
}