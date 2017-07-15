package com.mine;

import java.util.Scanner;

//TODO not working
public class SeparateTheNumbers {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int q = in.nextInt();
      for (int a0 = 0; a0 < q; a0++) {
         String s = in.next();

         int startIndex = 0;
         int endIndex = 1;

         int recurrence = -1;

         int firststringInt = 0;
         int secondStringInt = 0;


         while (recurrence == -1 && endIndex + (endIndex - startIndex) < s.length()) {

            String firstString = s.substring(startIndex, endIndex);
            String secondString = s.substring(endIndex, endIndex + (endIndex - startIndex));

            firststringInt = Integer.parseInt(firstString);
            secondStringInt = Integer.parseInt(secondString);

            if ((secondStringInt - firststringInt) == 1) {
               recurrence = endIndex - startIndex;
            } else if (endIndex + (endIndex - startIndex) + 1 < s.length()) {

               secondString = s.substring(endIndex, endIndex + (endIndex - startIndex) + 1);
               secondStringInt = Integer.parseInt(secondString);
               if ((secondStringInt - firststringInt) == 1) {
                  recurrence = endIndex - startIndex + 1;
               }

            }

            endIndex = endIndex + 1;
         }



         while (recurrence!=-1 && endIndex+recurrence < s.length()) {

         }

         if (recurrence == -1) {
            System.out.println("NO");
         } else {
            System.out.println("YES " + s.substring(0, recurrence));
         }

         // your code goes here
      }
   }

}
