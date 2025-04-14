// You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

// The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

// Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

 

// Example 1:


// Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
// Output: 20
// Explanation: 

// We can connect the points as shown above to get the minimum cost of 20.
// Notice that there is a unique path between every pair of points.
// Example 2:

// Input: points = [[3,12],[-2,5],[-4,1]]
// Output: 18
 

// Constraints:

// 1 <= points.length <= 1000
// -106 <= xi, yi <= 106
// All pairs (xi, yi) are distinct.

class Solution {
    class Pair{
        int node;
        int weight;
        Pair(int node,int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int dist = Math.abs(points[i][0] - points[j][0])+Math.abs(points[i][1]-points[j][1]);
                adj.get(i).add(new Pair(j,dist));
                adj.get(j).add(new Pair(i,dist));
            }
        }

        PriorityQueue<Pair>que = new PriorityQueue<>((a,b)->a.weight - b.weight);
        boolean[] bool = new boolean[n];
        que.offer(new Pair(0,0));
        int sum = 0;
        while(!que.isEmpty()){
            Pair temp = que.poll();
            int n1 = temp.node;
            int w1 = temp.weight;
            
            if(bool[n1])continue;
            bool[n1] = true;
            sum+=w1;
            for(var i:adj.get(n1)){
                int n_ = i.node;
                int w_ = i.weight;

                if(!bool[n_]){
                    que.offer(new Pair(n_,w_));
                }
            }
        }
        return sum;
    }
}