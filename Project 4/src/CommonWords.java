/******************************************************************************
 *       Class: CommonWords
 * Super Class: (Inferred: Object)
 *  Implements: None
 *
 * Programmer: Henry Howes

 * Revision     Date                          Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     05/01/2014   Initial Release
 * 
 * Class Description
 * -----------------
 * This class implements methods to process two text files, identifying the number of
 * distinct words in each and then comparing the number of common words, and to print
 * a summary of that information in its toString.
 *
 * ----------------------------- Public Interface -----------------------------
 *           Method                               Description
 * --------------------------- ------------------------------------------------
 * CommonWords()		 		 Initializing constructor
 * determineCommonWords(String,  Uses strings to create two file objects which are
 * String)			 			 then processed into two treeMaps to catalog the
 *								 number of times each word appears. Then the two maps
 *								 are compared for overlap, using this overlap to populate
 *								 a set for common words.
 * toString() 					 Prints a detailed summary of the words in each file,
 * 								 the discarded and distinct words, as well as the
 * 								 number of common words and a list of each one with
 * 								 the number of appearances in each text.
 * ------------------------- Private Data Members -----------------------------
 *                  Data
 *    Type          Type         Name                    Description
 * ----------  --------------  ----------  ------------------------------------
 * non-static  Collection<String> commonWordSet	Set storing words common to both files
 * non-static  Map<String,Integer> file1CountMap Tree map storing each word and the # of times it occurs
 * non-static  Map<String,Integer> file2CountMap Tree map storing each word and the # of times it occurs
 * non-static  String 			file1Name    Name field for file 1
 * non-static  String			file2Name    Name field for file 2
 * non-static  String			summary 	 Stores the string description of the object  
 ******************************************************************************
 */

import java.util.*;
import java.io.*;

public class CommonWords {
	private Collection<String> commonWordSet;
	private Map<String, Integer> file1CountMap;
	private Map<String, Integer> file2CountMap;
	private String file1Name;
	private String file2Name;
	private String summary;
	
	//Constructor
	public CommonWords(){
		file1CountMap = new TreeMap<String,Integer>();
		file2CountMap = new TreeMap<String,Integer>();
		this.summary ="";
	}
	
	//Method taking two file names as strings and processing them to look for common words
	public void determineCommonWord(String file1, String file2)
	throws FileNotFoundException{
		this.file1Name=file1;
		this.file2Name=file2;
		this.file1CountMap=getCountMap(new File(file1));
		this.file2CountMap=getCountMap(new File(file2));
		this.commonWordSet = file1CountMap.keySet();
		commonWordSet.retainAll(file2CountMap.keySet());
		
		this.summary =this.summary+ "There are "+commonWordSet.size()+
				" common words in files "+file1Name+" and "+file2Name+"."+
				"\nThe common words are:\n"+
		String.format("%8s%17s%17s\n", "Word", file1Name, file2Name);
		for(int i=0; i<3; i++){
			for(int j=0; j<12; j++){
				this.summary=this.summary+"-";
			}
			this.summary=this.summary+"   ";
		}
		this.summary=this.summary+"\n";
		Iterator<String> itr = commonWordSet.iterator();
		while(itr.hasNext()){
			String currentWord=itr.next();
			this.summary=this.summary+String.format("%-13s%10s%12s\n", currentWord, file1CountMap.get(currentWord), file2CountMap.get(currentWord));
		}
		
		
		
	}
	
	//Method to print a string summary of the object
	public String toString(){
		return summary;
	}
	
	//Private method to build tree maps for the two file objects created in determineCommonWords,
	//also builds string summaries for the two files.
	private Map<String, Integer> getCountMap(File fileName)
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
			
			this.summary=summary+"Statistics for file: "+ fileName+
			"\n  There are a total of "+totalWordCount+" words in the file."+
			"\n  Of those, "+ignoredCount+" were ignored, leaving "+remainingWords+" words to process."+
			"\n  After processing, there are "+wordCountMap.size()+ " distinct words in the file.\n\n";
			
			
			return wordCountMap;
	}
}