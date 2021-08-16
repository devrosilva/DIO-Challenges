package com.dio.ordenacao_e_filtros;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

//Puts many lists of words in order and exclude repeated words.
public class Challenge02 {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        TreeSet<String> orderedListOfWords;
        String[] listOfWords;
            
        int lines = Integer.parseInt(input.nextLine());
        while(lines > 0){
        	listOfWords = input.nextLine().split(" ");
        	orderedListOfWords = new TreeSet<String>();
        	
        	for(String word : listOfWords) {
        		orderedListOfWords.add(word);
        	}

        	for(String word : orderedListOfWords) {
        		System.out.print(word + " ");
        	}
        	System.out.println();
        	
        	lines--;
        }
        input.close();
    }
}

