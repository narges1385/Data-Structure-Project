public class Queue{
    private LinkedList list = new LinkedList();
    //O(1)
    public Queue(){}
    //برگرداندن اندازه صف
    //O(1)
    public int size(){return list.size();}
    //بررسی خالی بودن صف
    //O(1)
    public boolean isEmpty() {return list.isEmpty();}
    //اضافه کردن ماشین به صف
    //O(1)
    public void enqueue(Car car) {list.addLast(car);}
    //برگرداندن اولین عنصر صف
    //O(1)
    public Car first() {return list.first();}
    //خارج کردن اولین عنصر از صف
    //O(1)
    public Car dequeue() {return list.removeFirst();}
    //O(1)
    public LinkedList getList(){return list;}
}
