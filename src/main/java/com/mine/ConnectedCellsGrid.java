package com.mine;

import java.util.Scanner;

/**
 * Created by nidhish on 7/9/17.
 */
//TODO DIDN'T GET ALL TESTS
public class ConnectedCellsGrid {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int numRows = Integer.parseInt(in.nextLine());
      int numColumns = Integer.parseInt(in.nextLine());

      int[][] grid = new int[numRows][numColumns];
      boolean[][] gridflags = new boolean[numRows][numColumns];

      for (int i = 0; i < numRows; i++) {
         String[] allColumsArray = in.nextLine().split(" ");
         for (int j = 0; j < allColumsArray.length; j++) {
            grid[i][j] = Integer.parseInt(allColumsArray[j]);
         }

      }

      int connectionCount = 0;

      for (int i = 0; i < numRows; i++) {
         for (int j = 0; j < numColumns; j++) {
            if (!gridflags[i][j] && grid[i][j] == 1) {

               int tmp = findConnectionCount(grid, i, j, numRows-1, numColumns-1, gridflags);

               connectionCount = Math.max(connectionCount, tmp);


            }
         }
      }

      System.out.println(connectionCount);

   }

   private static int findConnectionCount(int[][] grid, int i, int j, int numRows, int numColumns,
       boolean[][] gridflags) {

      if (gridflags[i][j]) {
         return 0;
      }
      gridflags[i][j] = true;
      int connectionCount = 1;

      if (i - 1 >= 0) {
         if (j - 1 >= 0) {
            if (grid[i - 1][j - 1] == 1) {
               connectionCount += findConnectionCount(grid, i - 1, j - 1, numRows, numColumns, gridflags);
            }
            if (grid[i][j - 1] == 1) {
               connectionCount += findConnectionCount(grid, i, j - 1, numRows, numColumns, gridflags);
            }
         }

         if (grid[i - 1][j] == 1) {
            connectionCount += findConnectionCount(grid, i - 1, j, numRows, numColumns, gridflags);
         }

         if (j + 1 <= numColumns) {

            if (grid[i - 1][j + 1] == 1) {
               connectionCount += findConnectionCount(grid, i - 1, j + 1, numRows, numColumns, gridflags);
            }

            if (grid[i][j + 1] == 1) {
               connectionCount += findConnectionCount(grid, i, j + 1, numRows, numColumns, gridflags);
            }
         }
      }

      if (i + 1 <= numRows) {

         if (j - 1 >= 0) {
            if (grid[i + 1][j - 1] == 1) {
               connectionCount += findConnectionCount(grid, i + 1, j - 1, numRows, numColumns, gridflags);
            }
            if (grid[i + 1][j] == 1) {
               connectionCount += findConnectionCount(grid, i + 1, j, numRows, numColumns, gridflags);
            }
         }

         if (j + 1 <= numColumns) {

            if (grid[i + 1][j + 1] == 1) {
               connectionCount += findConnectionCount(grid, i + 1, j + 1, numRows, numColumns, gridflags);
            }

         }

      }

      return connectionCount;
   }

}
