// Time Complexity : O(1)// 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes,  https://leetcode.com/problems/design-hashmap/
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

//The approach that was used is linear chaining. First, we initialize an array and then we use the hashing function to prevent the collision. 

class MyHashMap {
    
    class Node{
        int key;
        int val;
        int next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node[] storage;

    public MyHashMap() {
        this.storage = new Node(10000);
    }

    private int hash(int key){
         return key%10000;
    }

    private int search(Node head,int key ){
         Node prev = null;
         Node curr = head;
         while(curr!=null && curr.key!=key){
             prev = curr;
             curr = curr.next;
         }
         return prev;
    }
    
    public void put(int key, int value) {
        int idx = hash(key);
        if(storage[idx]==null){
            storage[idx] = new Node(-1,-1);
        }
        Node prev = search(storage[idx],key);
        if(prev.next==null){
            prev.next = new Node(key,value);
        }else{
            prev.next.val = value;
        }

    }
    
    public int get(int key) {
        int idx = hash(key);
        if(storage[idx]==null) return -1;
        Node prev = search(storage[idx],key);
        if(prev.next==null) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        int idx = hash(key);
        if(storage[idx]==null) return;
        Node prev = search(storage[idx],key);
        if(prev.next==null) return;
        Node temp = prev.next;
        prev.next = prev.next.next;
        temp.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
