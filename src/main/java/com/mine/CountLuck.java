package com.mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Created by nidhish on 7/11/17.
 */
public class CountLuck {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int numRows = Integer.parseInt(in.nextLine());

      int[][] grid = new int[numRows][numRows];

      for (int[] row : grid) {
         Arrays.fill(row, Integer.MIN_VALUE);
      }

      for (int a = 1; a < numRows; a++) {
         for (int b = 1; b < numRows; b++) {

            ChessNode[][] chessboard = new ChessNode[numRows][numRows];
            Queue<ChessNode> queue = new LinkedBlockingQueue<>();

            for (int i = 0; i < numRows; i++) {
               for (int j = 0; j < numRows; j++) {
                  chessboard[i][j] = new ChessNode(i, j, Integer.MAX_VALUE);
               }
            }

            ChessNode sourceNode = chessboard[0][0];
            sourceNode.distance = 0;
            ChessNode destinationNode = chessboard[numRows - 1][numRows - 1];

            queue.add(sourceNode);
            dfs(destinationNode, queue, chessboard, a, b);

            grid[a][b] = -1;
            if (destinationNode.distance != Integer.MAX_VALUE) {
               grid[a][b] = destinationNode.distance;
            }
         }
      }

      for (int i = 1; i < numRows; i++) {
         for (int j = 1; j < numRows; j++) {
            int i1 = grid[i][j];

            System.out.print(i1 + " ");
         }
         System.out.println();
      }
   }

   private static void dfs(ChessNode destinationNode, Queue<ChessNode> queue, ChessNode[][] chessboard, int a, int b) {
      ChessNode sourceNode = queue.poll();

      if (destinationNode.distance != Integer.MAX_VALUE || sourceNode.equals(destinationNode)) {
         return;
      }

      Collection<? extends ChessNode> neighbors = sourceNode.findNeighbors(chessboard, a, b);
      if (neighbors != null && neighbors.size() != 0) {
         queue.addAll(neighbors);
      }

      while (!queue.isEmpty()) {
         dfs(destinationNode, queue, chessboard, a, b);
      }

   }


   private static class ChessNode {

      private final int rowNum;
      private final int colNum;
      private int distance;

      public ChessNode(int rowNum, int colNum, int distance) {
         this.rowNum = rowNum;
         this.colNum = colNum;
         this.distance = distance;
      }


      @Override
      public boolean equals(Object o) {
         if (this == o) {
            return true;
         }
         if (o == null || getClass() != o.getClass()) {
            return false;
         }

         ChessNode chessNode = (ChessNode) o;

         if (rowNum != chessNode.rowNum) {
            return false;
         }
         return colNum == chessNode.colNum;

      }

      @Override
      public int hashCode() {
         int result = rowNum;
         result = 31 * result + colNum;
         return result;
      }

      private Collection<? extends ChessNode> findNeighbors(ChessNode[][] chessboard, int a, int b) {

         //int a2 = findOptimalPath(x + a, y - b, a, b, grid, optimalPaths, processingPaths);
         //int a3 = findOptimalPath(x - a, y + b, a, b, grid, optimalPaths, processingPaths);
         //int a1 = findOptimalPath(x + a, y + b, a, b, grid, optimalPaths, processingPaths);
         //int a4 = findOptimalPath(x - a, y - b, a, b, grid, optimalPaths, processingPaths);
         //
         //int b1 = findOptimalPath(x + b, y + a, a, b, grid, optimalPaths, processingPaths);
         //int b2 = findOptimalPath(x + b, y - a, a, b, grid, optimalPaths, processingPaths);
         //int b3 = findOptimalPath(x - b, y + a, a, b, grid, optimalPaths, processingPaths);
         //int b4 = findOptimalPath(x - b, y - a, a, b, grid, optimalPaths, processingPaths);

         List<ChessNode> neighbors = new ArrayList<>();

         ChessNode a1 = findNeighbor(chessboard, this.rowNum + a, this.colNum - b);
         ChessNode a2 = findNeighbor(chessboard, this.rowNum - a, this.colNum + b);
         ChessNode a3 = findNeighbor(chessboard, this.rowNum + a, this.colNum + b);
         ChessNode a4 = findNeighbor(chessboard, this.rowNum - a, this.colNum - b);
         ChessNode a5 = findNeighbor(chessboard, this.rowNum + b, this.colNum + a);
         ChessNode a6 = findNeighbor(chessboard, this.rowNum + b, this.colNum - a);
         ChessNode a7 = findNeighbor(chessboard, this.rowNum - b, this.colNum + a);
         ChessNode a8 = findNeighbor(chessboard, this.rowNum - b, this.colNum - a);

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

         if (a5 != null) {
            neighbors.add(a5);
         }

         if (a6 != null) {
            neighbors.add(a6);
         }

         if (a7 != null) {
            neighbors.add(a7);
         }

         if (a8 != null) {
            neighbors.add(a8);
         }

         return neighbors;

      }

      private ChessNode findNeighbor(ChessNode[][] chessboard, int i, int i1) {
         if (i < chessboard.length && i1 < chessboard.length && i >= 0 && i1 >= 0) {
            if (chessboard[i][i1].distance == Integer.MAX_VALUE) {
               chessboard[i][i1].distance = 1 + this.distance;
               return chessboard[i][i1];
            }

         }
         return null;
      }
   }

}

//7

//6 4 4 8 2 12
//4 3 4 2 16 3
//4 4 2 4 4 4
//8 2 4 -1 -1 -1
//2 16 4 -1 -1 -1
//12 3 4 -1 -1 1