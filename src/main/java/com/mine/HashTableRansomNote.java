package com.mine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note
 */
public class HashTableRansomNote {

   public static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {
      int numberWords[] = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      int numWordsinMagazine = numberWords[0];
      int numWordsinNote = numberWords[1];

      String[] wordsInMagazine = in.nextLine().split(" ");
      String[] wordsInNote = in.nextLine().split(" ");

      Map<String, Integer> wordsMapping = new HashMap<>();

      for (String wordInMagazine : wordsInMagazine) {

         Integer numOccurences = wordsMapping.get(wordInMagazine);
         if (numOccurences == null) {
            wordsMapping.put(wordInMagazine, new Integer(1));
         } else {
            wordsMapping.put(wordInMagazine, ++numOccurences);
         }
      }

      if (numWordsinNote > numWordsinMagazine) {
         System.out.println("No");
         return;
      }

      for (String wordInNote : wordsInNote) {
         if (wordsMapping.get(wordInNote) == null || wordsMapping.get(wordInNote) == 0) {
            System.out.println("No");
            return;
         } else {
            Integer currentCount = wordsMapping.get(wordInNote);
            wordsMapping.put(wordInNote, --currentCount);
         }
      }

      System.out.println("Yes");


   }

}
