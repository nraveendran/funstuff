package com.mine;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by nidhish on 7/11/17. https://www.hackerrank.com/challenges/2d-array
 */
public class HourGlassSum {

   public static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {
      
      int[][] twoDArray = new int[6][6];

      for (int i = 0; i < 6 ; i++) {
         twoDArray[i] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      }

      int maxHourGlassSum = Integer.MIN_VALUE;

      for (int i = 0; i < 4; i++) {
         for (int j = 1; j < 5 ; j++) {
            int currentHourGlassSum = calculateHourGlassSum(twoDArray,i,j);
            if (currentHourGlassSum > maxHourGlassSum){
               maxHourGlassSum = currentHourGlassSum;
            }
         }


      }
      
      System.out.println(maxHourGlassSum);

   }

   private static int calculateHourGlassSum(int[][] twoDArray, int i, int j) {
      return twoDArray[i][j]+twoDArray[i][j-1]+twoDArray[i][j+1]+twoDArray[i+1][j]+twoDArray[i+2][j]+twoDArray[i+2][j-1
          ]+twoDArray[i+2][j+1];
   }


}

//7

//6 4 4 8 2 12
//4 3 4 2 16 3
//4 4 2 4 4 4
//8 2 4 -1 -1 -1
//2 16 4 -1 -1 -1
//12 3 4 -1 -1 1