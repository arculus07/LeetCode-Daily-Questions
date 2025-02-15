// so the basic idea to solve it in constant time is perform the prefix sum kind operation --- 

// Basically rather than keeping the track of elements , we are keeping the track of prev(multiplied)*current -- this is basically creating a idea that if we want the product of last k numbers , then we needn't to iterate through the complete list again , we just have to get the index value(k) because we are storing multiplicated values . 

// And divide the current multiplied which will be the product of all the elements of list with the product value of kth index , this will simply give the result in O(1) complexity **[list.get(s-1)/list.get(s-1-k)]**

// Also we are eliminating unecessary multiplication by clearing the list , or better say returning 0 if we encountered any 0 
// **$$(0*(k) =0)$$**

// # Code
// ```java []
class ProductOfNumbers {
    ArrayList<Integer>list = new ArrayList<>();
    public ProductOfNumbers() {
        list.clear();
    }
    
    public void add(int num) {
        if(num == 0){
            list.clear();
            return;
        }
        int prev = (list.size() == 0?1:list.get(list.size()-1));
        list.add(prev*num);
    }
    public int getProduct(int k) {
        int s = list.size();
        if(s<k)return 0;
        else if(s == k)return list.get(s-1);
        return (list.get(s-1)/list.get(s-1-k));   
    }
}