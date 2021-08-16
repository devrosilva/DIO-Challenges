import java.util.ArrayList;
import java.util.Scanner;

public class Challenge05 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int numberOfStudents = 0;
		int currentNumber = 0;
		int currentPosition = 0;
		int count = 0;
		int auxiliar = 0;

		ArrayList<Integer> listOfNumbers;
		ArrayList<String> listOfStudents;

		boolean luckyOne = false;
		numberOfStudents = Integer.parseInt(input.next());

		while(numberOfStudents != 0) {

			listOfNumbers = new ArrayList<Integer>();
			listOfStudents = new ArrayList<String>();
			
			for(int i = 0; i < numberOfStudents; i++) {
				listOfStudents.add(0,input.next());
				listOfNumbers.add(0,Integer.parseInt(input.next()));
			}

			if(listOfNumbers.size() >= 2) {
				currentNumber = listOfNumbers.get(listOfNumbers.size()-1);
				auxiliar = sign(currentNumber);
				if(auxiliar > 0) {
					currentPosition = 0;
				}
				else {
					currentPosition = listOfNumbers.size()-2;
				}
				count = 1;
			}
			
			while(listOfStudents.size() > 1) {
				
				while(!luckyOne) {

					if(currentNumber != 1) {
						currentPosition = currentPosition + auxiliar;
						count++;
					}
					
					if(currentPosition >= listOfNumbers.size()) {
						currentPosition = 0;
					}
					else if(currentPosition < 0) {
						currentPosition = listOfNumbers.size()-1;
					}
					
					if(count >= currentNumber) {

						currentNumber = listOfNumbers.get(currentPosition);
						listOfNumbers.remove(currentPosition);
						listOfStudents.remove(currentPosition);
						
						auxiliar = sign(currentNumber);
						if(auxiliar > 0 && (currentPosition >= 0 && currentPosition < listOfNumbers.size())) {
							count = 1;
						}
						else if(auxiliar > 0 && currentPosition == listOfNumbers.size()) {
							currentPosition = 0;
							count = 1;
						}
						
						else if(auxiliar < 0 && currentPosition == listOfNumbers.size()) {
							currentPosition = listOfNumbers.size()-1;
							count = 1;
						}
						else if(auxiliar < 0 && currentPosition == 0) {
							currentPosition = listOfNumbers.size()-1;
							count = 1;
						}
						else {
							count = 0;
						}
						luckyOne = true;
					}
				}
				luckyOne = false;
			}

			System.out.println("Vencedor(a): " + listOfStudents.get(0));
			numberOfStudents = Integer.parseInt(input.next());
		}
		System.out.println();
		input.close();
	}
	
	private static int sign(int currentNumber) {
		
		if(currentNumber % 2 == 0) {

			return 1;
		}
		return -1;
	}
}
