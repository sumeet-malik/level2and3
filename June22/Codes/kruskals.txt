import java.io.*;
import java.util.*;

public class Main {
   static class Edge implements Comparable<Edge> {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
      
      public int compareTo(Edge o){
          return this.wt - o.wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      kruskals(graph);
   }
   

   public static void kruskals(ArrayList<Edge>[] graph){
       PriorityQueue<Edge> pq = new PriorityQueue<>();
       for(int v = 0; v < graph.length; v++){
           for(Edge e: graph[v]){
               pq.add(e);
           }
       }
       
       parent = new int[graph.length];
       rank = new int[graph.length];
       for(int i = 0; i < graph.length; i++){
           parent[i] = i;
           rank[i] = 0;
       }
       
       while(pq.size() > 0){
           Edge e = pq.remove();
           
           int srcLead = find(e.src);
           int nbrLead = find(e.nbr);
           
           if(srcLead != nbrLead){
               System.out.println(e.src + "-" + e.nbr + "@" + e.wt);
               
               union(srcLead, nbrLead);
           }
       }
   }
   
   static int[] parent;
   static int[] rank;
   
   public static int find(int x){
       if(parent[x] == x){
           return x;
       } else {
           parent[x] = find(parent[x]);
           return parent[x];
       }
   }
   
   public static void union(int s1l, int s2l){
       if(rank[s1l] < rank[s2l]){
           parent[s1l] = s2l;
       } else if(rank[s2l] < rank[s1l]){
           parent[s2l] = s1l;
       } else {
           parent[s1l] = s2l;
           rank[s2l]++;
       }
   }
   
   
   
   
   
   
   

}