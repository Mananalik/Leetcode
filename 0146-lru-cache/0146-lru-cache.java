class Node{
    Node prev,next;
    int key;
    int val;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    int capacity;
    Map<Integer,Node> map = new HashMap<>();
    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
    private void insert(Node node){
        map.put(node.key,node);
        node.next=head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    private void remove(Node node){
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */