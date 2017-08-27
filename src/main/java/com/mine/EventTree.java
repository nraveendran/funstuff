package com.mine;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;


/**
 * Created by nidhish on 7/11/17. https://www.hackerrank.com/challenges/even-tree/problem
 */
public class EventTree {

   public static Scanner in = new Scanner(System.in);

   private static int numEdgesToBeRemoved;

   public static void main(String[] args) {

      findEvenTree();


   }

   private static void findEvenTree() {
      int[] tmp = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      int numNodes = tmp[0];
      int numEdges = tmp[1];

      Graph graph = new Graph(numNodes, numEdges);

      for (int i = 0; i < numEdges; i++) {

         tmp = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
         int startNode = tmp[0];
         int endNode = tmp[1];

         graph.addEdge(startNode, endNode);
         //graph.addEdge(endNode, startNode);
      //
      }


      GraphNode sourceNode = graph.nodes[0];
      sourceNode.distance = 0;
      sourceNode.visited = true;

      int evenTreeDistance = graph.findEvenTreeDistance(sourceNode);

      if (evenTreeDistance!=0 && evenTreeDistance%2==0){
         numEdgesToBeRemoved++;
      }

      System.out.println(numEdgesToBeRemoved);


   }


   private static class Graph {

      int numNodes;
      int numEdges;
      GraphNode[] nodes;

      private Graph(int numNodes, int numEdges) {
         this.numNodes = numNodes;
         this.numEdges = numEdges;
         nodes = new GraphNode[numNodes];

         for (int i = 0; i < nodes.length; i++) {
            GraphNode node = new GraphNode(i);
            nodes[i] = node;
         }

      }


      private static int findEvenTreeDistance(GraphNode sourceNode) {
         if (sourceNode == null) {
            return 0;
         } else {

            int numberOfChildren = 0;

            for (GraphNode adjacentNode : sourceNode.adjacencyList) {

               if (adjacentNode.visited == false) {
                  numberOfChildren += findEvenTreeDistance(adjacentNode) + 1;
                  adjacentNode.visited = true;
               }
            }

            if (numberOfChildren!=0 && numberOfChildren % 2 != 0) {
               numEdgesToBeRemoved++;
               return 0;
            }

            return numberOfChildren;
         }
      }


      private void addEdge(int sourceNodeInt, int endNodeInt) {


         int lowNum = Math.min(sourceNodeInt,endNodeInt);
         int maxNUm = Math.max(sourceNodeInt,endNodeInt);

         GraphNode sourceNode = nodes[lowNum - 1];
         GraphNode endNode = nodes[maxNUm - 1];



         sourceNode.adjacencyList.add(endNode);

      }

      private GraphNode[] getAllVertex() {
         return nodes;
      }
   }


   private static class GraphNode {

      int nodeValue;
      int distance;
      boolean visited;

      private GraphNode(int nodeValue) {
         this.nodeValue = nodeValue;
      }

      Set<GraphNode> adjacencyList = new LinkedHashSet<>();

      @Override
      public boolean equals(Object o) {
         if (this == o) {
            return true;
         }
         if (o == null || getClass() != o.getClass()) {
            return false;
         }

         GraphNode graphNode = (GraphNode) o;

         return nodeValue == graphNode.nodeValue;

      }

      @Override
      public int hashCode() {
         return nodeValue;
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