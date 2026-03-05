class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        Node(int key, int val){
            this.key=key;
            this.val = val;
        }
    }
    Node[] bucket;
    int size = 1000;
    public MyHashMap() {
        bucket = new Node[size];
    }
    private int Hash(int key){
        return key%size;
    }
    public void put(int key, int value) {
        int index = Hash(key);
        Node head = bucket[index];
        Node curr = head;
        while(curr!=null){
            if(curr.key==key){
                curr.val = value;
                return;
            }
            curr = curr.next;
        }
        Node newNode = new Node(key,value);
        newNode.next = head;
        bucket[index] = newNode;
    }
    
    public int get(int key) {
        int index = Hash(key);
        Node curr = bucket[index];
        while(curr!=null){
            if(curr.key == key){
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = Hash(key);
        Node curr = bucket[index];
        Node prev = null;
        while(curr!=null){
            if(curr.key==key){
                if(prev==null){
                    bucket[index] = curr.next;
                }else{
                    prev.next = curr.next;
                }
            }
            prev = curr;
            curr = curr.next;

        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */