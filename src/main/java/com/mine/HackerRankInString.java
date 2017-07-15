package com.mine;

import java.util.Scanner;


public class HackerRankInString {


   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      char[] hackerrank = "hackerrank".toCharArray();
      int q = in.nextInt();
      for (int a0 = 0; a0 < q; a0++) {
         String s = in.next();

         char[] schars = s.toCharArray();

         int hackerrankIndex = 0;

         for (int i = 0; i < schars.length; i++) {

            if (hackerrank[hackerrankIndex] == schars[i]) {
               hackerrankIndex++;
            }

            if (hackerrankIndex == hackerrank.length) {
               break;
            }

         }

         if (hackerrankIndex == hackerrank.length) {
            System.out.println("YES");
         } else {
            System.out.println("NO");
         }

      }
   }

}
