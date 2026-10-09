class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        return dfs(graph, source, destination, vis);
     }
     private boolean dfs(ArrayList<ArrayList<Integer>> graph, int source, int dest, boolean[] vis){
        if(source == dest){
            return true;
        }
        vis[source] = true;
        for(int neigh : graph.get(source)){
            if(!vis[neigh]){
                if(dfs(graph, neigh, dest, vis)){
                    return true;
                }
            }
        }
        return false;
     }
}