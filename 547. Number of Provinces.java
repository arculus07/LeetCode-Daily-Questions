// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

// A province is a group of directly or indirectly connected cities and no other cities outside of the group.

// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

// Return the total number of provinces.

 

// Example 1:


// Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 2
// Example 2:


// Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
// Output: 3
 

// Constraints:

// 1 <= n <= 200
// n == isConnected.length
// n == isConnected[i].length
// isConnected[i][j] is 1 or 0.
// isConnected[i][i] == 1
// isConnected[i][j] == isConnected[j][i]

🐱‍👤2 Big brothers [ BFS | DFS ] to beat 88.62% with the simple explanation ✅

Ayush Ranjan
200 Days Badge 2024
0
a few seconds ago
Depth-First Search
Breadth-First Search
Graph
Java
BFS
This approach uses Breadth-First Search (BFS) to find the number of provinces (connected components) in a graph represented by an adjacency matrix. Each city is a node, and a direct connection (adj[i][j] = 1) represents an edge. We maintain a boolean array to track visited cities. For each unvisited city, we start a BFS traversal, marking all reachable cities as visited. Every time we start a new BFS, it means we found a new province, so we increment the count.

For example, consider a graph with adj = [[1,1,0],[1,1,0],[0,0,1]]. Here, City 0 and City 1 are directly connected (1-2 forms one province), while City 2 is isolated (3 forms another province). We start BFS from City 0, marking City 1 as visited. Since no other cities are connected to them, we move to the next unvisited city (City 2) and start a new BFS. The final count is 2 provinces.

DFS
This approach uses Depth-First Search (DFS) to count the number of provinces (connected components) in an adjacency matrix. We maintain a boolean array to track visited cities. If a city is unvisited and has a direct connection (adj[i][j] = 1), we start a DFS from that city, marking all reachable cities as visited. Each time a new DFS starts, it signifies a new province, so we increment the count.

For example, given adj = [[1,1,0],[1,1,0],[0,0,1]], City 0 and City 1 are connected (1-2 forms one province), while City 2 is isolated (3 forms another province). DFS starts at City 0, marking City 1 as visited. Since no other connections exist, DFS moves to the next unvisited city (City 2) and starts a new DFS. The final count is 2 provinces.

Code
class Solution {
    public int findCircleNum(int[][] adj) {
        boolean[] bool = new boolean[adj.length];
        int count= 0;
        for(int i = 0;i<adj.length;i++){
                if(!bool[i]){
                    bfs(adj,bool,i);
                    count++;
                }
        }
        return count;
    }
    public void bfs(int[][] adj,boolean[] bool,int u){
        bool[u] = true;
        Queue<Integer>que = new LinkedList<>();
        que.offer(u);
        while(!que.isEmpty()){
            int v = que.poll();
            for(int i = 0;i<adj.length;i++){
                if(!bool[i] && adj[v][i] == 1){
                    bool[i] = true;
                    que.offer(i);
                }
            }
        }
    }
}

// class Solution {
//     public int findCircleNum(int[][] adj) {
//         boolean[] bool= new boolean[adj.length];
//         int count = 0;
//         for(int i = 0;i<adj.length;i++){
//            for(int j = 0;j<adj.length;j++){
//                 if(!bool[j] && adj[i][j] == 1){
//                 dfs(adj,bool,i);
//                 count++;
//            }
//         }
//         }   
//         return count;
//     }
//     public void dfs(int[][] adj,boolean[] bool,int u){
//         bool[u] = true;


//         for(int i = 0;i<adj.length;i++){
//             if(!bool[i] && adj[u][i] == 1){
//                 dfs(adj,bool,i);
//             }
//         }
//     }
// }