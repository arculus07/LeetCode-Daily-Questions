// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

 

// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.
// Example 2:

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

// Constraints:

// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= 5000
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// All the pairs prerequisites[i] are unique.

2 Approaches [DFS | Kahn's Algorithm] with the easiest and smooth explanation✅🐱‍👤

Ayush Ranjan
200 Days Badge 2024
0
a few seconds ago
Depth-First Search
Breadth-First Search
Graph

2+
Explanation of the DFS Approach (Cycle Detection)
The first approach uses Depth-First Search (DFS) to detect cycles in a directed graph, which determines if all courses can be finished. The idea is that if a cycle exists, it's impossible to complete all courses because there's a circular dependency. The algorithm marks nodes as visited and checks for back edges during the traversal. If a back edge is found (indicating a cycle), it returns false; otherwise, it returns true after checking all nodes.

For example, consider courses 0, 1, 2 with prerequisites [[1,0],[2,1]]. The graph is 0 → 1 → 2. DFS starts at 0, marks it as visited, then moves to 1, then 2. No back edges are found, so the courses can be finished. If we add [0,2], creating a cycle 0 → 1 → 2 → 0, DFS detects the back edge from 2 to 0 and returns false.

Explanation of the Kahn's Algorithm (Topological Sort)
The second approach uses Kahn's Algorithm for topological sorting, which also detects cycles by counting in-degrees and processing nodes with zero in-degree. If all nodes are processed (count equals N), the graph is acyclic, and courses can be finished. Nodes are added to a queue if their in-degree drops to zero, and their neighbors' in-degrees are decremented.

For the same example [[1,0],[2,1]], the in-degrees are [0,1,1]. The queue starts with 0, processes it, decrements in-degrees of 1 (now 0), adds 1 to the queue, then processes 1, decrements 2's in-degree (now 0), adds 2, and processes it. The count reaches 3, so it returns true. If [0,2] is added, 2's in-degree remains 1, and the count stops at 2, returning false. This method efficiently checks for cycles using in-degree tracking.

Code
// class Solution {
//     int count = 0;
//     public boolean canFinish(int N, int[][] list) {
//         ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
//         for(int i = 0;i<N;i++)adj.add(new ArrayList<>());
//         for(int[] i:list)adj.get(i[1]).add(i[0]); 

//         boolean[] bool = new boolean[N];
//         boolean[] recur = new boolean[N];

//         for(int i = 0;i<N;i++){
//             if(!bool[i] && dfs(adj,i,bool,recur)){
//                 return false;
//             }
//         }
//         return true;
//     }
//     public boolean dfs(ArrayList<ArrayList<Integer>>adj,int u,boolean[] bool,boolean[] recur){
//         bool[u] = true;
//         recur[u] = true;
//         for(int i :adj.get(u)){
//             if(!bool[i] && dfs(adj,i,bool,recur)){
//                 return true;
//             }else if(recur[i] == true){
//                 return true;
//             }
//         }
//         recur[u] = false;
//             return false;
//     }
// }

class Solution {
    public boolean canFinish(int N, int[][] list) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i = 0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i:list){
            adj.get(i[1]).add(i[0]);
        }


        int[] indegree = new int[N];
        for(int i = 0;i<N;i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0;i<N;i++){
            if(indegree[i] == 0)que.offer(i);
        }
        int count = 0;
        while(!que.isEmpty()){
            int u = que.poll();
            count++;
            for(int i : adj.get(u)){
                indegree[i]--;
                if(indegree[i] == 0)que.offer(i);
            }
        }
        return count==N;
    }
}