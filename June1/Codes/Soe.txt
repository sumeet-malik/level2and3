class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] nodes = new int[n];
        int[] res = new int[n];
        helper1(graph, nodes, res, 0, -1);
        helper2(graph, nodes, res, 0, -1);

        return res;   
    }

    public void helper1(ArrayList<Integer>[] graph, int[] nodes, int[] res, int src, int par){
        for(int nbr: graph[src]){
            if(nbr != par){
                helper1(graph, nodes, res, nbr, src);
                nodes[src] += nodes[nbr];
                res[src] += nodes[nbr] + res[nbr];
            }
        }

        nodes[src]++;
    }

    public void helper2(ArrayList<Integer>[] graph, int[] nodes, int[] res, int src, int par){
        for(int nbr: graph[src]){
            if(nbr != par){
                res[nbr] = res[src] + (nodes.length - nodes[nbr]) - (nodes[nbr]);
                helper2(graph, nodes, res, nbr, src);
            }
        }
    }

    
}