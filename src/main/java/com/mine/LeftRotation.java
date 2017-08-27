package com.mine;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;


/**
 * Created by nidhish on 7/11/17. https://www.hackerrank.com/challenges/array-left-rotation
 */
public class LeftRotation {

   public static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {
      int[] numItemsNumRotations = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int numItems = numItemsNumRotations[0];
      int numRotations = numItemsNumRotations[1];

      int[] arrayToRotate = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      int arrayToRotateLength = arrayToRotate.length;
      int[] finalArray = new int[arrayToRotateLength];

      for (int i = 0; i < arrayToRotateLength; i++) {

         int newIndex = (arrayToRotateLength + (i-numRotations))% arrayToRotateLength;
         finalArray[newIndex] = arrayToRotate[i];
      }

      for (int i = 0; i < finalArray.length; i++) {
         System.out.print(finalArray[i] + " ");
      }

      //System.arraycopy(arrayToRotate,);

      System.out.println();

   }



}

//7

//6 4 4 8 2 12
//4 3 4 2 16 3
//4 4 2 4 4 4
//8 2 4 -1 -1 -1
//2 16 4 -1 -1 -1
//12 3 4 -1 -1 1