package com.dio.ordenacao_e_filtros;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Receives many numbers, separate even from odd and present them in order.
//Even numbers are presented in crescent order and odd in descending order.
public class Challenge01 {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        int currentNumber = 0;
    
        int lines = Integer.parseInt(input.nextLine());
        while(lines > 0){
          currentNumber = Integer.parseInt(input.nextLine());
          if(currentNumber % 2 == 0){
            even.add(currentNumber);
          }
          else{
            odd.add(currentNumber);
          }
          lines--;
        }
        Collections.sort(even);
        Collections.sort(odd, Collections.reverseOrder());
        for(int n : even){
          System.out.println(n);
        }
        for(int n : odd){
          System.out.println(n);
        }
        input.close();
    }
}
