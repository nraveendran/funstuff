package com.mine;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-contacts
 */
public class ContactsTrie {

   public static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {
      int numberWords = Integer.parseInt(in.nextLine());

      MyTrie mytrie = new MyTrie();

      for (int i = 0; i < numberWords; i++) {

         String[] commandAndWord = in.nextLine().split(" ");
         String command = commandAndWord[0];
         String word = commandAndWord[1];



         if (command.equals("add")) {

            mytrie.add(word);

         } else if (command.equals("find")) {
            System.out.println(mytrie.find(word));
         }

      }


   }

   private static class MyTrie {


      TrieNode node = new TrieNode();


      private void add(String word) {

         TrieNode currentNode = node;

         char[] wordChars = word.toCharArray();

         for (int i = 0; i < wordChars.length; i++) {

            TrieNode a = currentNode.mainArray[wordChars[i] - 'a'];

            if (a == null) {
               a = new TrieNode();
               currentNode.mainArray[wordChars[i] - 'a'] = a;
            }

            a.size++;
            currentNode = a;

         }

         currentNode.isEndNode = true;

      }

      int numOfWords =0;

      private int find(String word) {
         numOfWords=0;
         TrieNode currentNode = node;



         char[] wordChars = word.toCharArray();



         for (int i = 0; i < wordChars.length; i++) {

            TrieNode a = currentNode.mainArray[wordChars[i] - 'a'];

            if (a == null) return 0;

            currentNode = a;


         }



         return currentNode.size;


      }



      public int numberOfMatchingWords(TrieNode currentNode){



         if (currentNode.isEndNode) numOfWords++;

         TrieNode[] a = currentNode.mainArray;



         for (int i = 0; i < a.length; i++) {
            if (a[i]!=null){
               numOfWords=+numberOfMatchingWords(a[i]);
            }

         }

         return numOfWords;
      }


   }



      private static class TrieNode {

         TrieNode[] mainArray = new TrieNode[26];
         int size;
         boolean isEndNode;
      }

}
