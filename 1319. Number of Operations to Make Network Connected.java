class Solution {
    int[] parent;
    int[] rank;
    public int makeConnected(int n, int[][] graph) {
        parent = new int[n];
        for(int i = 0;i<n;i++)parent[i] = i;
        rank = new int[n];
        if(graph.length<n-1)return -1;
        int t = n;
        for(int i[]:graph){
            int x = find(i[0]);
            int y = find(i[1]);
            if(x!=y){
                union(i[0],i[1]);
                t--;
            }   
        }
        return t-1;
    }
    public int find(int x){
        if(x == parent[x])return x;

        return parent[x] = find(parent[x]);
    }
    public void union(int x,int y){
        int x_parent = find(x);
        int y_parent = find(y);
        if(x_parent == y_parent)return;
        if(rank[x_parent]>rank[y_parent])parent[y_parent] = x_parent;
        else if(rank[x_parent]<rank[y_parent])parent[x_parent] = y_parent;
        else{
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
        
    }
}