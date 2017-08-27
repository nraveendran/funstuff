package com.mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * https://www.hackerrank.com/challenges/sherlock-and-array/problem
 */
public class SherlockAndArray {

   public static Scanner in = new Scanner(System.in);
   public static int wandWaves = 0;

   public static void main(String[] args) {

      int numProblems = Integer.parseInt(in.nextLine());

      for (int i = 0; i < numProblems; i++) {

         int arrSize = Integer.parseInt(in.nextLine());
         int[] arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
         int[] leftSum = new int[arrSize];
         int[] rightSum = new int[arrSize];

         int total = 0;

         for (int j = 0; j < arrSize; j++) {
            total += arr[j];
         }

         leftSum[0] = 0;

         rightSum[0] = total - arr[0];

         boolean hit = false;

         if (arrSize == 1) {
            hit = true;
         } else {

            for (int j = 1; j < arrSize; j++) {
               leftSum[j] = leftSum[j - 1] + arr[j - 1];
               rightSum[j] = rightSum[j - 1] - arr[j];

               if (leftSum[j] == rightSum[j]) {
                  hit = true;
               }
            }
         }

         if (hit) {
            System.out.println("YES");
         } else {
            System.out.println("NO");
         }


      }


   }


}

