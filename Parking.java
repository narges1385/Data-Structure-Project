public class Parking {
    private Queue entry = new Queue();//صف ورودی پارکینگ
    private Stack[] stacks;//پارکینگ شامل n تا stack است
    private int n;
    private int m;
    //O(n)
    public Parking(int n, int m){
        this.n = n;
        this.m = m;
        stacks = new Stack[n];
        for(int i = 0; i < n; i++){
            stacks[i] = new Stack(m);
        }
    }
    //O(1)
    public Stack[] getStacks(){
        return stacks;
    }
    //ورود ماشین از queue به اولین stack خالی
    //O(n)
    public void entry(Car car){
        entry.enqueue(car);
        for(int i = 0; i < n; i++){
            if(stacks[i].size() < m){
                stacks[i].push(entry.dequeue());
                return;
            }
        }
        System.out.println("parking is full");
    }
    //ورود ماشین از queue به stack مورد نظر
    //O(1)
    public void entry(Car car, int num){
        entry.enqueue(car);
        if(stacks[num].size() < m) stacks[num].push(entry.dequeue());
        else System.out.println("Stack " + num + " is full");
    }
    //پیدا کردن موقعیت ماشین
    //O(n*m)
    public int[] find(int carId){
        for(int i = 0; i < n;i++){
            int j = 0;
            Node node = stacks[i].getHead();
            while(node != null){
                if(node.getCar().getCarId() == carId){
                    return new int[] {i,j};
                }
                node = node.getNext();
                j++;
            }
        }
        return null;
    }
    //خروج ماشین از پارکینگ
    //O(n*m)
    public void exit(int carId){
        int[] locate = find(carId);
        if(locate == null ) return;
        if(locate[1] != 0)
           System.out.println("Exit is not allowed!");
        else{
            stacks[locate[0]].pop();
        }
    }
    //مرتب کردن پشته
    //O(mlogm)
    public void sortStack(int i){
    LinkedList sorted = stacks[i].getList().mergeSort(stacks[i].getList());
    stacks[i].setList(sorted);
    }
    //  جابه جایی میان دو stack
    //O(m*n)
    public void move(int i, int j){
    if(stacks[i].isEmpty()){
        System.out.println("Stack " + i + " is empty!");
        return;
    }
    while(!stacks[i].isEmpty()){
        Car car = stacks[i].pop();
        boolean placed = false;
        for(int k = j; k < n; k++){
            if(stacks[k].size() < m){
                stacks[k].push(car);
                placed = true;
                break;
            }
        }

        if(!placed){
            System.out.println("No space available for car " + car.getCarId());
            break;
        }
    }
    }
    //چاپ id ماشین های درون پشته ها(کل ماشین های پارک شده در پارکینگ)
    //O(m*n)
    public void printStack(){
        for(int i = 0; i < n; i++){
            Node node = stacks[i].getList().getHead();
            while(node != null){
               int result = node.getCar().getCarId();
               System.out.print(node.getCar().getCarId() + "_");
               node = node.getNext();
            }
            System.out.println("");
        }
    }
}
