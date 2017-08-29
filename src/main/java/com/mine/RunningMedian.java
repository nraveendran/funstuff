package com.mine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median
 */
public class RunningMedian {

   public static Scanner in = new Scanner(System.in);


   public static void main(String[] args) {

      PriorityQueue<Double> minHeap = new PriorityQueue<>();
      PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

      int numProblems = Integer.parseInt(in.nextLine());

      for (int i = 0; i < numProblems; i++) {
         Integer nextInt = Integer.parseInt(in.nextLine());

         if (maxHeap.size()==0){
            maxHeap.add(Double.valueOf(nextInt));
            System.out.println(Double.valueOf(nextInt));
            continue;
         }

         if (nextInt < maxHeap.peek()) {
            maxHeap.add(Double.valueOf(nextInt));
         } else {
            minHeap.add(Double.valueOf(nextInt));
         }

         if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
         } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
         }

         if (maxHeap.size() == minHeap.size()) {
            System.out.println((maxHeap.peek() + minHeap.peek()) / 2);
         } else if (maxHeap.size() - minHeap.size() == 1) {
            System.out.println(maxHeap.peek());
         } else if (minHeap.size() - maxHeap.size() == 1) {
            System.out.println(minHeap.peek());
         }


      }


   }


}

