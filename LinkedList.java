public class LinkedList {
    private Node head;
    private Node tail;
    private int size;
    //O(1)
    public LinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    //O(1)
    public void setHead(Node head){
        this.head = head;
    }
    //O(1)
    public void setTail(Node tail){
        this.tail = tail;
    }
    //O(1)
    public Node getHead(){
        return head;
    }
    //O(1)
    public Node getTail(){
        return tail;
    }
    //O(1)
    public int size(){
        return size;
    }
    //کلاسی برای بررسی خالی بودن لیست
    //O(1)
    public boolean isEmpty(){return (size == 0);}
    //برگرداندن اولین عنصر لیست
    //O(1)
    public Car first(){
        if(isEmpty()) return null;
        else return head.getCar();
    }
    //اضافه کردن عنصر به اول لیست
    //O(1)
    public void addFirst(Car car) {
        head = new Node(car, head);
        if(size == 0)
            tail = head;
        size++;
    }
    //اضافه کردن عنصر به اخر لیست
    //O(1)
    public void addLast(Car car){
        Node node = new Node(car);
        if(isEmpty()){
            head = node;
            tail = node;
        }
        else{
            tail.setNext(node);
            tail = node;
        }
        size++;
    }
    //حذف اولین عنصر لیست
    //O(1)
    public Car removeFirst() throws IllegalStateException{
        if(isEmpty()) throw new IllegalStateException("list is empty");
        Car car = head.getCar();
        head = head.getNext();
        size--;
        if(size == 0) tail = null;
        return car;
    }
    //مرتب سازی لیست با merge sort
    //O(nlogn)
    public LinkedList mergeSort(LinkedList list) {
    
        if(list.size == 1){
            return list;
        }
        if(list.size == 2 && list.head.getCar().getCarId() > list.tail.getCar().getCarId()){
            Node temp;
            temp = list.head;
            temp.setNext(null);
            list.head = list.tail;
            list.head.setNext(temp);
            list.tail = temp;
        } 
    
        Node slow = list.getHead();
        Node fast = list.getHead();
        while(fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        Node mid = slow.getNext();
        slow.setNext(null);
    
        LinkedList left = new LinkedList();
        left.setHead(list.getHead());
        left.setTail(slow);
        int countL = 0;
        Node nodeL = left.getHead();
        while(nodeL != null){
            countL++;
            nodeL = nodeL.getNext();
        }
        left.size = countL;
    
        LinkedList right = new LinkedList();
        right.setHead(mid);
        right.setTail(list.getTail());
        int countR = 0;
        Node nodeR = right.getHead();
        while(nodeR != null){
            countR++;
            nodeR = nodeR.getNext();
        }
        right.size = countR;

        left = mergeSort(left);
        right = mergeSort(right);
    
        return merge(left, right);
    }
    //O(n)
    private LinkedList merge(LinkedList left, LinkedList right) {
        LinkedList result = new LinkedList();
        Node n1 = left.getHead();
        Node n2 = right.getHead();

        while(n1 != null && n2 != null) {
            if(n1.getCar().getCarId() <= n2.getCar().getCarId()) {
                result.addLast(n1.getCar());
                n1 = n1.getNext();
            } else {
                result.addLast(n2.getCar());
                n2 = n2.getNext();
            }
        }
        while(n1 != null) {
            result.addLast(n1.getCar());
            n1 = n1.getNext();
        }
        while(n2 != null) {
            result.addLast(n2.getCar());
            n2 = n2.getNext();
        }
        return result;
    }
}
