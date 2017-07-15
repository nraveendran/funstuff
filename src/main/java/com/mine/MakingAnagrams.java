package com.mine;

import java.util.Scanner;

/**
 * Created by nidhish on 7/8/17.
 */
public class MakingAnagrams {



   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String s1 = in.next();
      String s2 = in.next();
      int result = makingAnagrams(s1, s2);
      System.out.println(result);;
   }

   private static int makingAnagrams(String s1, String s2) {

      char[] s1chars = s1.toCharArray();
      char[] s2chars = s2.toCharArray();

      int[] s1counts = new int[26];
      int[] s2counts = new int[26];

      for (int i = 0; i < s1chars.length; i++) {
         s1counts[s1chars[i]-'a']++;
      }

      for (int i = 0; i < s2chars.length; i++) {
         s2counts[s2chars[i]-'a']++;
      }

      int numCharsDeleted =0;

      for (int i = 0; i < 26; i++) {
         numCharsDeleted += Math.abs(s1counts[i]-s2counts[i]);
      }


      return numCharsDeleted;
   }

}
