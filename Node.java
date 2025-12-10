public class Node {
    private Car car; //عنصر کلاس شی ای از کلاس ماشین است
    private Node next;
    public Node(Car car){
        this.car = car;
        this.next = null;
    }
    //O(1)
    public Node(Car car, Node next){
        this.car = car;
        this.next = next;
    }
    //O(1)
    public Car getCar() {return car;}
    //O(1)
    public Node getNext() {return next;}
    //O(1)
    public void setNext(Node n){next = n;}
}
