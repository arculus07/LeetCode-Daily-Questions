class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i:answers){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int total = 0;
        for(Map.Entry<Integer,Integer> i:map.entrySet()){
            int x = i.getKey();
            int count = i.getValue();
            int size = x+1;
            int g = (int)Math.ceil((double)count/size);
            total+= g*size;
        }
        return total;
    }
}