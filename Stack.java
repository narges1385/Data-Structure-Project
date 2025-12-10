public class Stack{
    private LinkedList list;
    private int m;//ظرفیت پشته
    //O(1)
    public Stack(int m) {
        list= new LinkedList();
        this.m = m;
    }
    //برگرداندن اندازه پشته(تعداد عناصر)
    //O(1)
    public int size() {return list.size();}
    //بررسی خالی بودن پشته
    //O(1)
    public boolean isEmpty() {return list.isEmpty();}
    //اضافه کردن عنصر به پشته
    //O(1)
    public void push(Car car) {
        if(size() >= m) throw new IllegalStateException("Stack is full");
        list.addFirst(car);
    }
    //برگرداندن اولین عنصر پشته
    //O(1)
    public Car top() {return list.first();}
    //خارج کردن اولین عنصر از پشته
    //O(1)
    public Car pop() {return list.removeFirst();}
    //O(1)
    public Node getHead(){ return list.getHead(); }
    //O(1)
    public LinkedList getList(){ return list;}
    //O(1)
    public void setList(LinkedList list){
        this.list = list;
    }
}
