class LFUCache {
    class Node{
        Node prev , next;
        int key , value , freq;
        public Node(int k , int v , int f){
            key = k;
            value = v;
            freq = f;
        }
    }
    class DoublyList{
        Node head, tail;
        int size;
        public DoublyList(){
            head = new Node(0,0,0);
            tail = new Node(0,0,0);
            size = 0;
            head.next = tail;
            tail.prev = head;
        }
        public void add(Node node){
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }
        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev =null;
            size--;
        }
        public Node removeFirst(){
            if(size==0) return null;
            Node node = head.next;
            remove(node);
            return node;
        }
    }
    HashMap<Integer,Node> mp;
    HashMap<Integer,DoublyList> freqMap;
    int capacity;
    int minFreq;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        mp = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
    }

    private void updateFreq(Node node){
        int freq = node.freq;
        DoublyList list = freqMap.get(freq);
        list.remove(node);
        if(freq==minFreq && list.size==0){
            minFreq++;
        }
        node.freq++;
        freqMap.putIfAbsent(node.freq,new DoublyList());
        freqMap.get(node.freq).add(node);
    }
    
    public int get(int key) {
        if(!mp.containsKey(key)) return -1;
        Node node = mp.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity==0) return;
        if(mp.containsKey(key)){
            Node node = mp.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }
        if(mp.size()==capacity){
            DoublyList list = freqMap.get(minFreq);
            Node lru = list.removeFirst();
            mp.remove(lru.key);
        }
        Node node = new Node(key,value,1);
        minFreq = 1;
        freqMap.putIfAbsent(1,new DoublyList());
        freqMap.get(1).add(node);
        mp.put(key,node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */