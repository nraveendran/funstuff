package com.mine;

import java.util.Scanner;

/**
 * Created by nidhish on 7/9/17.
 */
public class CamelCase {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String s = in.next();

      char[] schars = s.toCharArray();

      int numofWords = 1;

      if (schars[0] > 'z') {
         System.out.println("0");
         return;
      }

      for (int i = 1; i < schars.length - 1; i++) {
         if (schars[i] < 'a') {
            if (schars[i + 1] >= 'a') {
               numofWords++;
            } else {
               System.out.printf("0");
               return;
            }
         }

      }
      System.out.println(numofWords);
   }

}
