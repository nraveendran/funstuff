package com.mine;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nidhish on 7/23/17.
 */
public class DeleteNodeLinkedList {

   public static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {
      int numProblems = Integer.parseInt(in.nextLine());

      for (int i = 0; i < numProblems; i++) {
         deleteNodeLinkedList();
      }
   }

   private static void deleteNodeLinkedList() {
      Node head = createLinkedlistt();
      int position = Integer.parseInt(in.nextLine());

      Node reversedHead = Delete(head,position);

      while (reversedHead!=null){
         System.out.print(reversedHead.data + " " );
         reversedHead = reversedHead.next;
      }

      System.out.println();

   }

   private static Node Delete(Node head, int position) {

      if (position==0){
         if (head.next ==null){
            return null;
         }else{
            return head.next;
         }
      }

      Node current = head.next;
      Node previous = head;



      for (int i=1;i<=position;i++){
         if (i==position){
            previous.next = current.next;
            return   head;
         }

         Node tmp = current;
         current = current.next;
         previous = tmp;

      }

      // Complete this method
      return head;

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