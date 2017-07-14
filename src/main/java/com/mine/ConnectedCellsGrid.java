package com.mine;

import java.util.Scanner;

/**
 * Created by nidhish on 7/9/17.
 */
public class ConnectedCellsGrid {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      int numProblems = Integer.parseInt(in.nextLine());

      for (int i = 0; i < numProblems; i++) {
         int totalMoney = Integer.parseInt(in.nextLine());
         int numOfIcecreams = Integer.parseInt(in.nextLine());
         String[] icecreamCosts = in.nextLine().split(" ");
         int[] iceCreamCostsInt = new int[icecreamCosts.length];
         for (int j = 0; j < icecreamCosts.length; j++) {
            iceCreamCostsInt[j] = Integer.parseInt(icecreamCosts[j]);
         }
         int firstIndex = -1;
         int index = -1;

         for (int j = 0; j < iceCreamCostsInt.length - 1; j++) {
            firstIndex = j+1;
            int currentCost = iceCreamCostsInt[j];
            int remainingCost = totalMoney - currentCost;
            for (int k = j + 1; k < iceCreamCostsInt.length; k++) {
               if (iceCreamCostsInt[k] == remainingCost) {
                  index = k+1;
                  break;
               }
            }
            if (index != -1) {
               break;
            }
         }

         System.out.println(firstIndex + " " + index );

      }


   }

}
