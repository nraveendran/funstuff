package com.mine;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;


/**
 * https://www.hackerrank.com/challenges/ctci-balanced-brackets
 */
public class BalancedBrackets {

   public static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {
      int numProblems = Integer.parseInt(in.nextLine());

      for (int i = 0; i < numProblems; i++) {

         findShortestReach();
      }


   }

   private static void findShortestReach() {
      int[] tmp = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      int numNodes = tmp[0];
      int numEdges = tmp[1];

      Graph graph = new Graph(numNodes, numEdges);

      for (int i = 0; i < numEdges; i++) {

         tmp = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
         int startNode = tmp[0];
         int endNode = tmp[1];

         graph.addEdge(startNode, endNode);
         graph.addEdge(endNode, startNode);


      }

      int sourceNodeInt = Integer.parseInt(in.nextLine());

      GraphNode sourceNode = graph.findSourceNode(sourceNodeInt);
      sourceNode.distance = 0;
      sourceNode.visited = true;

      LinkedList<GraphNode> queue = new LinkedList<>();
      queue.add(sourceNode);

      bfs(queue);

      for (GraphNode node : graph.getAllVertex()) {
         if (!node.visited) {
            node.distance = -1;
         }

         if (!node.equals(sourceNode)) {
            System.out.print(node.distance + " ");
         }
      }
      System.out.println();

   }

   private static void bfs(LinkedList<GraphNode> queue) {

      while (!queue.isEmpty()) {
         GraphNode sourceNode = queue.poll();

         sourceNode.adjacencyList.stream().filter(adjacentNode -> !adjacentNode.visited).forEach(adjacentNode -> {
            adjacentNode.visited = true;
            adjacentNode.distance = sourceNode.distance + 6;
            queue.add(adjacentNode);
         });
      }


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


      private GraphNode findSourceNode(int startNode) {
         return nodes[startNode - 1];
      }

      private void addEdge(int sourceNodeInt, int endNodeInt) {
         GraphNode sourceNode = nodes[sourceNodeInt - 1];
         GraphNode endNode = nodes[endNodeInt - 1];
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