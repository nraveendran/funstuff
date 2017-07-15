package com.mine;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nidhish on 7/8/17.
 */
public class SherlockAndValidString {

   static String isValid(String s) {
      char[] a = s.toCharArray();
      int[] counts = new int[26];

      Arrays.fill(counts, Integer.MAX_VALUE);

      int maxFrequency = Integer.MIN_VALUE;

      for (int i = 0; i < a.length; i++) {

         if (counts[a[i] - 'a'] == Integer.MAX_VALUE) {
            counts[a[i] - 'a'] = 1;
         } else {
            counts[a[i] - 'a']++;
         }

         maxFrequency = Math.max(maxFrequency,counts[a[i]-'a']);
      }

      boolean valid = true;
      boolean onechardiff = false;



      for (int i = 0; i < counts.length; i++) {
         if (counts[i] == Integer.MAX_VALUE){
            continue;
         }else if (maxFrequency - counts[i] == 0) {
            continue;
         } else if (maxFrequency+1 == counts[i] && !onechardiff) {
            onechardiff = true;
            continue;
         } else if (counts[i] == 1 && !onechardiff) {
            onechardiff = true;
            continue;
         } else {
            valid = false;
         }
      }

      if (valid) {
         return "YES";
      } else {
         return "NO";
      }
   }

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String s = in.next();
      String result = isValid(s);
      System.out.println(result);
   }

}
