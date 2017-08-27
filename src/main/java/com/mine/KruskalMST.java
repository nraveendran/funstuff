package com.mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


/**
 * Created by nidhish on 7/11/17. https://www.hackerrank.com/challenges/kruskalmstrsub
 */
public class KruskalMST {

   public static Scanner in = new Scanner(System.in);

   public static void main(String[] args) {

      findMST();


   }

   private static void findMST() {
      int[] tmp = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      int numNodes = tmp[0];
      int numEdges = tmp[1];

      Graph graph = new Graph(numNodes, numEdges);

      List<Edge> allEdges = new ArrayList<>();

      for (int i = 0; i < numEdges; i++) {

         tmp = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
         int startNode = tmp[0];
         int endNode = tmp[1];
         int weight = tmp[2];

         Edge edge = new Edge(new Vertex(startNode), new Vertex(endNode, weight), weight);

         allEdges.add(edge);
         Collections.sort(allEdges);

      }

      int numEdgesAdded = 0;
      for (Edge edge : allEdges) {
         if (!graph.findCycle(edge)) {
            graph.addEdge(edge);
            numEdgesAdded++;
         }

         if (numEdgesAdded == numNodes - 1) {
            System.out.println("numEdgesAdded = " + numEdgesAdded);
            break;
         }
      }

      int sum = 0;
      for (Map.Entry<Vertex, Set<Vertex>> entry : graph.vertexListMap.entrySet()) {
         Vertex vertex = entry.getKey();
         Set<Vertex> adjacencyList = entry.getValue();
         for (Vertex endVertex : adjacencyList) {
            Edge edge1 = new Edge(vertex, endVertex);
            Edge realEdge = allEdges.get(allEdges.indexOf(edge1));
            sum += realEdge.weight;
            System.out.println(realEdge.startVertex.nodeValue + " " + realEdge.endVertex.nodeValue + " " + realEdge
                .weight);
         }
      }

      System.out.println(sum);

      //graph.print();

   }


   private static class Graph {

      int numNodes;
      int numEdges;
      Map<Vertex, Set<Vertex>> vertexListMap;

      private Graph(int numNodes, int numEdges) {
         this.numNodes = numNodes;
         this.numEdges = numEdges;
         vertexListMap = new HashMap<>();


      }


      private void addEdge(Edge edge) {

         if (vertexListMap.containsKey(edge.startVertex)) {

            vertexListMap.get(edge.startVertex).add(edge.endVertex);

         } else {

            Set vertices1 = new LinkedHashSet<>();
            vertices1.add(edge.endVertex);
            vertexListMap.put(edge.startVertex, vertices1);

         }


      }

      private boolean findCycle(Edge edge) {

         if (vertexListMap.containsKey(edge.startVertex)) {
            return dfs(edge.startVertex, edge.endVertex);
         }
         return false;
      }

      private boolean dfs(Vertex startVertex, Vertex endVertex) {
         Set<Vertex> adjacencyList = vertexListMap.get(startVertex);

         if (adjacencyList == null) {
            return false;
         }

         for (Vertex adjacentVertex : adjacencyList) {
            if (adjacentVertex.equals(endVertex)) {
               return true;
            }
         }

         for (Vertex adjacentVertex : adjacencyList) {
            if (dfs(adjacentVertex, endVertex)) {
               return true;
            }
         }

         return false;
      }


   }


   private static class Edge implements Comparable {

      Vertex startVertex;
      Vertex endVertex;
      int weight;

      private Edge(Vertex startVertex, Vertex endVertex, int weight) {
         this.startVertex = startVertex;
         this.endVertex = endVertex;
         this.weight = weight;
      }

      public Edge(Vertex vertex, Vertex next) {
         this.startVertex = vertex;
         this.endVertex = next;
      }


      @Override
      public boolean equals(Object o) {
         if (this == o) {
            return true;
         }
         if (o == null || getClass() != o.getClass()) {
            return false;
         }

         Edge edge = (Edge) o;

         if (startVertex != null ? !startVertex.equals(edge.startVertex) : edge.startVertex != null) {
            return false;
         }
         return endVertex != null ? endVertex.equals(edge.endVertex) : edge.endVertex == null;

      }

      @Override
      public int hashCode() {
         int result = startVertex != null ? startVertex.hashCode() : 0;
         result = 31 * result + (endVertex != null ? endVertex.hashCode() : 0);
         return result;
      }


      @Override
      public int compareTo(Object o) {
         Edge other = (Edge) o;
         int i = Integer.compare(this.weight, other.weight);

         if (i==0){
            return  Integer.compare(this.startVertex.nodeValue+this.weight+this.endVertex.nodeValue,other.startVertex
                .nodeValue+other.weight+other.endVertex.nodeValue);
         }
         else return i;

      }
   }

   private static class Vertex {

      int nodeValue;
      int distance;
      boolean visited;

      private Vertex(int nodeValue) {
         this.nodeValue = nodeValue;
      }

      public Vertex(int endNode, int weight) {
         this.nodeValue = endNode;
         this.distance = weight;
      }


      @Override
      public boolean equals(Object o) {
         if (this == o) {
            return true;
         }
         if (o == null || getClass() != o.getClass()) {
            return false;
         }

         Vertex vertex = (Vertex) o;

         return nodeValue == vertex.nodeValue;

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