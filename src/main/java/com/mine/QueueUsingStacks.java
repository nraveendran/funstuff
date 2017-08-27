package com.mine;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks
 */
public class QueueUsingStacks {

   public static void main(String[] args) {
      MyQueue<Integer> queue = new MyQueue<Integer>();

      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();

      for (int i = 0; i < n; i++) {
         int operation = scan.nextInt();
         if (operation == 1) { // enqueue
            queue.enqueue(scan.nextInt());
         } else if (operation == 2) { // dequeue
            queue.dequeue();
         } else if (operation == 3) { // print/peek
            System.out.println(queue.peek());
         }
      }
      scan.close();
   }

   private static class MyQueue<T> {

      Stack firstStack = new Stack<T>();
      Stack secondStack = new Stack<T>();

      private void enqueue(T i) {
         firstStack.push(i);
      }

      private void dequeue() {

         if (secondStack.isEmpty()) {
            while(!firstStack.isEmpty()){
               secondStack.push(firstStack.pop());
            }
         }

         if (!secondStack.isEmpty()){
            secondStack.pop();
         }

      }

      private T peek() {
         if (secondStack.isEmpty()) {
            while(!firstStack.isEmpty()){
               secondStack.push(firstStack.pop());
            }
         }

         if (!secondStack.isEmpty()){
            return (T) secondStack.peek();
         }

         return null;
      }
   }
}
