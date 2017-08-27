package com.mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;


/**
 *
 * https://www.hackerrank.com/challenges/count-luck
 */
public class CountLuck {

   public static Scanner in = new Scanner(System.in);
   public static int wandWaves = 0;

   public static void main(String[] args) {

      int numProblems = Integer.parseInt(in.nextLine());

      for (int i = 0; i < numProblems; i++) {
         wandWaves = 0;
         findPortKey();
      }


   }

   private static void findPortKey() {
      String[] numRowsCols = in.nextLine().split(" ");

      int numRows = Integer.parseInt(numRowsCols[0]);
      int numCols = Integer.parseInt(numRowsCols[1]);

      ForestNode[][] forest = new ForestNode[numRows][numCols];
      Queue<ForestNode> queue = new LinkedBlockingQueue<>();

      ForestNode sourceNode = null;

      for (int a = 0; a < numRows; a++) {

         String cols = in.nextLine();
         for (int b = 0; b < numCols; b++) {

            ForestNode forestNode = new ForestNode(cols.charAt(b) + "", a, b);

            if (forestNode.value.equals("M")) {
               sourceNode = forestNode;
               sourceNode.visited = true;
            }
            forest[a][b] = forestNode;
         }
      }

      int guess = Integer.parseInt(in.nextLine());

      List<ForestNode> sourceList = new ArrayList<>();
      sourceList.add(sourceNode);

      dfs(sourceList, forest);

      //if (guess == wandWaves) {
      //   System.out.println("Impressed " + wandWaves + " " + guess);
      //} else {
      //
      //   System.out.println("Oops " + wandWaves + " " + guess);
      //}

      if (guess == wandWaves) {
         System.out.println("Impressed");
      } else {

         System.out.println("Oops!");
      }

   }

   private static boolean dfs(List<ForestNode> sourceList, ForestNode[][] chessboard) {

      boolean portKeyFound = false;

      for (ForestNode sourceNode : sourceList) {


         if (sourceNode.isPortKey() || portKeyFound) {
            portKeyFound = true;
            return portKeyFound;
         }

         List<ForestNode> neighbors = sourceNode.findNeighbors(chessboard);
         if (neighbors != null && neighbors.size() != 0) {
            portKeyFound = dfs(neighbors, chessboard);

            if (neighbors.size() > 1 && portKeyFound) {
               wandWaves++;
            }
         }

      }

      return portKeyFound;

   }


   private static class ForestNode {

      int rowNum;
      int colNum;
      String value;
      private int distance;
      private boolean visited;

      public ForestNode(String value, int a, int b) {
         this.value = value;
         this.rowNum = a;
         this.colNum = b;
      }

      public boolean isBlockingCell() {
         return value.equals("X");
      }

      public boolean isEmptyCell() {
         return value.equals(".");
      }

      public boolean isPortKey() {
         return value.equals("*");
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) {
            return true;
         }
         if (o == null || getClass() != o.getClass()) {
            return false;
         }

         ForestNode that = (ForestNode) o;

         if (rowNum != that.rowNum) {
            return false;
         }
         return colNum == that.colNum;

      }

      @Override
      public int hashCode() {
         int result = rowNum;
         result = 31 * result + colNum;
         return result;
      }

      private List<ForestNode> findNeighbors(ForestNode[][] forest) {

         List<ForestNode> neighbors = new ArrayList<>();

         ForestNode a1 = findNeighbor(forest, this.rowNum + 1, this.colNum);
         ForestNode a2 = findNeighbor(forest, this.rowNum - 1, this.colNum);
         ForestNode a3 = findNeighbor(forest, this.rowNum, this.colNum + 1);
         ForestNode a4 = findNeighbor(forest, this.rowNum, this.colNum - 1);

         if (a1 != null) {
            neighbors.add(a1);
         }
         if (a2 != null) {
            neighbors.add(a2);
         }

         if (a3 != null) {
            neighbors.add(a3);
         }

         if (a4 != null) {
            neighbors.add(a4);
         }

         return neighbors;

      }

      private ForestNode findNeighbor(ForestNode[][] forest, int rowNum, int colNum) {
         int nosCols = forest[0].length;  // 4
         int nosRows = forest.length;     // 3

         if (rowNum < nosRows && colNum < nosCols && rowNum >= 0 && colNum >= 0) {
            if ((forest[rowNum][colNum].isEmptyCell() ||forest[rowNum][colNum].isPortKey()) && !forest[rowNum][colNum]
                .visited) {
               forest[rowNum][colNum].visited = true;
               return forest[rowNum][colNum];
            }

         }
         return null;
      }
   }

}

//Oops!
//Oops!
//    Impressed
//    Impressed
//    Oops!
//    Impressed
//    Oops!