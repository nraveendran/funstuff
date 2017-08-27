package com.mine;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by nidhish on 7/11/17. https://www.hackerrank.com/challenges/crush
 */
public class AlgorthmicCrush {

   public static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {
      int[] listSizeNumOperations = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int listSize = listSizeNumOperations[0];
      int numOperations = listSizeNumOperations[1];

      int maxArray[] = new int[listSize];
      Arrays.fill(maxArray,0);

      int maxValue = Integer.MIN_VALUE;
      for (int i = 0; i < numOperations; i++) {

         int[] operation = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
         int startRange = operation[0];
         int endRange = operation[1];
         int value = operation[2];

         for (int j = startRange-1; j <endRange ; j++) {
            maxArray[j]+=value;
            if (maxArray[j]>maxValue){
               maxValue = maxArray[j];
            }
         }

      }

      System.out.println(maxValue);


   }



}

//7

//6 4 4 8 2 12
//4 3 4 2 16 3
//4 4 2 4 4 4
//8 2 4 -1 -1 -1
//2 16 4 -1 -1 -1
//12 3 4 -1 -1 1m