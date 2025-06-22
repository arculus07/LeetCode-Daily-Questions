🐱‍👤Beats 93.67% using basic approach , no extra algorithm just pure analytics😑✅😎

Ayush Ranjan
365 Days Badge
0
a few seconds ago
String
Simulation
Java
In this approach, I divided the string into equal parts of size k. I first picked only the full groups from the string, meaning the parts that can give exactly k characters. I skipped the last incomplete group on purpose. After that, I checked if there were any characters left. If yes, I added them to a new group and then filled the remaining space using the given fill character, so that this group also becomes of size k. Finally, I added this last group to the result.

For example, if the input is "abcdefg", k = 3, and fill = 'x', then the first two groups will be "abc" and "def" (each of length 3). Now only "g" is left, which is of length 1. So, I created a new group starting with "g" and added two 'x' characters to make it "gxx". In the end, the result becomes ["abc", "def", "gxx"], where all groups are of equal size.

Code
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int m = s.length();
        int n = m%k == 0?m/k:m/k+1;
        String[] arr = new String[n];
        int j = 0;
        for(int i =0;i<m-(m%k);i+=k){
            arr[j] = s.substring(i,i+k);
            j++; 
        }
        if(m%k != 0){
            StringBuilder sb = new StringBuilder();
        for(int i = m-(m%k);i<m;i++){
            sb.append(s.charAt(i)+"");
        }
        while(sb.length() < k){
            sb.append(fill);
        }
        arr[j] = sb.toString();
        }
        
        return arr;
    }
}