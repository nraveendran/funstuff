package com.mine;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nidhish on 7/23/17.
 */
public class ReverseLinkedList {

   public static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {
      int numProblems = Integer.parseInt(in.nextLine());

      for (int i = 0; i < numProblems; i++) {
         reversetLinkedList();
      }
   }

   private static void reversetLinkedList() {
      Node head = createLinkedlistt();
      Node reversedHead = Reverse(head);

      while (reversedHead!=null){
         System.out.print(reversedHead.data + " " );
         reversedHead = reversedHead.next;
      }

      System.out.println();

   }

   private static Node Reverse(Node head) {

      Node currentNode = head;
      Node next = currentNode.next;
      currentNode.next = null;

      while(next!=null){
         Node tmp = next.next;
         next.next = currentNode;
         currentNode= next;
         next = tmp;
      }

      return currentNode;

   }

   private static Node createLinkedlistt() {
      int numberOfNodes  = Integer.parseInt(in.nextLine());
      int[] tmp = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      Node prevNode = null;
      Node head= null;
      for (int i = 0; i < tmp.length; i++) {
         Node node = new Node(tmp[i]);
         if (prevNode!=null){
            prevNode.next = node;
         }

         if (head==null){
            head= node;
         }

         prevNode=node;
      }

      return head;
   }

   private static class Node {

      int data;
      Node next;
      public Node(int i) {
         this.data = i;
      }
   }
}

//2
//   4
//   1 2 3 4
//   5
//   2 3 4 5 6