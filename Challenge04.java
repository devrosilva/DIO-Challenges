import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Challenge04 {
    public static void main(String[] args) throws IOException {
    	
    	Scanner input = new Scanner(System.in);
    	int testCases = 0;
    	int numberOfClients = 0;
    	
    	ArrayList<Integer> numbers = new ArrayList<Integer>();
    	ArrayList<Integer> auxiliar = new ArrayList<Integer>();
    	
    	int unchanged = 0;
    	
    	testCases = Integer.parseInt(input.next());
    	while(testCases > 0) {
    		
    		numberOfClients = Integer.parseInt(input.next());
    		
    		for(int i = 0; i < numberOfClients; i++) {
    			numbers.add(Integer.parseInt(input.next()));
    		}
    		auxiliar.addAll(numbers);
    		
    		Collections.sort(numbers, new Comparator<Integer>(){
				@Override
				public int compare(Integer o1, Integer o2) {
					
					int diff = o2.compareTo(o1);
					if(diff != 0) {
						return diff;
					}
					return 0;
				}
    			
    		});
    		
    		for(int i = 0; i < numberOfClients; i++) {
    			if(numbers.get(i).equals(auxiliar.get(i))) {
    				unchanged++;
    			}
    		}
        	System.out.println(unchanged);
        	
    		testCases--;
    		numbers = new ArrayList<Integer>();
    		auxiliar = new ArrayList<Integer>();
    		unchanged = 0;

    	}
    	input.close();
    }
}
