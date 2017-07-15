package com.mine;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nidhish on 7/11/17.
 */
public class MissingNumbers {


   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int firstListSize = Integer.parseInt(in.nextLine());

      int[] firstList = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int secondListSize = Integer.parseInt(in.nextLine());

      String[] secondList = in.nextLine().split(" ");

      int[] secondListInt = new int[secondListSize];

      int minValue = Integer.MAX_VALUE;
      for (int i = 0; i < secondListSize; i++) {
         secondListInt[i] = Integer.parseInt(secondList[i]);
         minValue = Math.min(minValue, secondListInt[i]);
      }

      int[] countingArray = new int[100];
      Arrays.fill(countingArray, 0);

      for (int i = 0; i < secondListSize; i++) {
         countingArray[secondListInt[i] - minValue]++;
      }

      for (int i = 0; i < firstListSize; i++) {
         countingArray[firstList[i] - minValue]--;
      }

      for (int i = 0; i < 100; i++) {

         if (countingArray[i] > 0) {
            System.out.print(minValue + i + " ");
         }

      }

   }


}
