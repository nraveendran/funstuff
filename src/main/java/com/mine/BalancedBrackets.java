package com.mine;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;


/**
 * https://www.hackerrank.com/challenges/ctci-balanced-brackets
 */
public class BalancedBrackets {

   public static Scanner in = new Scanner(System.in);


   public static void main(String[] args) {
      int numProblems = Integer.parseInt(in.nextLine());

      for (int i = 0; i < numProblems; i++) {

         findBalancedBrackets();
      }


   }

   private static boolean isOpeningBracker(String s) {
      return s.equals("{") || s.equals("(") || s.equals("[");
   }

   private static boolean isEndingBracker(String s) {
      return s.equals("}") || s.equals(")") || s.equals("]");
   }

   private static void findBalancedBrackets() {
      char[] brackets = in.next().toCharArray();

      Stack<String> bracketsStack = new Stack<>();

      for (int i = 0; i < brackets.length; i++) {

         String s = brackets[i] + "";
         if (isOpeningBracker(s)) {
            bracketsStack.push(s);
         } else {
            if (bracketsStack.isEmpty()) {
               System.out.println("NO");
               return;
            } else {
               String top = bracketsStack.peek();
               if ((s.equals("]") && top.equals("[")) || (s.equals("}") && top.equals("{")) || (s.equals(")") && top
                   .equals("("))) {
                  bracketsStack.pop();
               } else {
                  System.out.println("NO");
                  return;
               }
            }
         }
      }

      if (bracketsStack.isEmpty()) {
         System.out.println("YES");
      } else {
         System.out.println("NO");
      }


   }


}

//7

//6 4 4 8 2 12
//4 3 4 2 16 3
//4 4 2 4 4 4
//8 2 4 -1 -1 -1
//2 16 4 -1 -1 -1
//12 3 4 -1 -1 1