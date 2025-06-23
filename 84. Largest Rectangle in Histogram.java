🌴Simple and Straightforward Solution #WITHOUTSTACK beating 96% solutions ✅🐱‍👤

Ayush Ranjan
365 Days Badge
0
a few seconds ago
Array
Two Pointers
Monotonic Stack
Java
This solution is about finding the largest rectangle in a histogram, where each bar has a certain height and the width of each bar is 1. Think of each bar like a building stacked side-by-side. We want to know the biggest possible rectangle we can make using one or more of these buildings, but the rectangle must be as high as the shortest building among them.

To figure this out, we calculate two things for every bar: how far it can extend to the left and to the right before it hits a shorter bar. The idea is that the width of the rectangle for any bar depends on how many consecutive bars are taller or equal to it, on both sides. So, for each bar, we find the index of the first smaller bar on the left (left[]) and the first smaller bar on the right (right[]). These arrays help us define the limits of how far a rectangle can stretch using that bar as the height.

Let’s take an example: say heights = [2, 1, 5, 6, 2, 3]. For bar 5 at index 2, it can stretch to index 2 itself on the left (since 1 at index 1 is smaller), and up to index 3 on the right (since 6 is taller and 2 after that is smaller). So the width is right - left - 1 = 4 - 1 - 1 = 2, and the area becomes 5 * 2 = 10. Similarly, it calculates area for each bar and keeps track of the maximum. That’s how it finds the biggest possible rectangle. Simple, logical, and neat.--

Code
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        left[0] = -1;
        right[n-1] = n;

        for(int i = 1;i<n;i++){
            int p = i-1;
            while(p>=0 && heights[p] >= heights[i]){
                p = left[p];
            }
            left[i] = p;
        }

        for(int i = n-1;i>=0;i--){
            int p = i+1;
            while(p<n && heights[p]>=heights[i]){
                p = right[p];
            }
            right[i] = p;
        }
        int max = 0;
        for(int i = 0;i<n;i++){
            int w = right[i]-left[i]-1;
            max = Math.max(max,heights[i]*w);
        }
        return max;

    }
}