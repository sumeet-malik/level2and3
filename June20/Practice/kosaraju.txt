// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis1 = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int v = 0; v < V; v++){
            if(!vis1[v]){
                dfs1(v, adj, vis1, st);
            }
        }
        
        // transpose
        ArrayList<ArrayList<Integer>> tsp = new ArrayList<>();
        for(int v = 0; v < V; v++){
            tsp.add(new ArrayList<>());
        }
        
        for(int v = 0; v < V; v++){
            for(int nbr: adj.get(v)){
                tsp.get(nbr).add(v);
            }
        }
        
        // dfs2
        int count = 0;
        boolean[] vis2 = new boolean[V];
        while(st.size() > 0){
            int v = st.pop();
            if(!vis2[v]){
                dfs2(v, tsp, vis2);
                count++;
            }
        }
        
        return count;
    }
    
    public void dfs2(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[v] = true;
        for(int nbr: adj.get(v)){
            if(!visited[nbr]){
                dfs2(nbr, adj, visited);
            }
        }
    }
    
    public void dfs1(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st){
        
        visited[v] = true;
        for(int nbr: adj.get(v)){
            if(!visited[nbr]){
                dfs1(nbr, adj, visited, st);
            }
        }
        
        st.push(v);
    }
}
