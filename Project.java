import java.util.Scanner;

public class Project{
    //نمایش منو برای انتخاب عملیات توسط کاربر
    //O(1)
    public void menu(){
 
        System.out.println("*** Menu ***");
        System.out.println("1. Entry car to parking");
        System.out.println("2. Exit car");
        System.out.println("3. Find car");
        System.out.println("4. Print parked cars");
        System.out.println("5. Sort a stack");
        System.out.println("6. Move cars between stacks");
        System.out.println("0. Exit program");
        System.out.print("Choose an option: ");
    }
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("enter the number of stacks: ");
        int n = input.nextInt();
        System.out.println("enter the capacity of stacks: ");
        int m = input.nextInt();
        Parking parking = new Parking(n, m);
        Project project = new Project();

        int choice;
        do {
            project.menu();
            choice = input.nextInt();

            switch(choice){
                case 1:
                    System.out.print("car id(number):");
                    int id = input.nextInt();
                    if(parking.find(id) != null){
                        System.out.println("this car id has already been entered!");
                        break;
                    }
                    System.out.println("1.first empty stack 2.specific stack");
                    int entry = input.nextInt();
                    if(entry == 1){
                        parking.entry(new Car(id));
                        break;
                    }
                    if(entry == 2){
                        System.out.print("stack number:");
                        int stackNum = input.nextInt();
                        if(stackNum > n){
                            System.out.println("more than capacity!");
                            break;
                        }
                        parking.entry(new Car(id), stackNum-1);
                        break;
                    }
                    else{
                        System.out.println("invalid option!");
                        break;
                    }
                    

                case 2:
                    System.out.print("car id for exit: ");
                    id = input.nextInt();
                    if(parking.find(id) == null){
                        System.out.println("this car id not exist!");
                        break;
                    }
                    parking.exit(id);
                    break;

                case 3:
                    System.out.print("car id for find:");
                    id = input.nextInt();
                    int result[] = parking.find(id);
                    if(result != null){
                        System.out.println("Car " + id + " found in Stack " + (result[0]+1) + " at position " + (result[1]+1));
                    }
                    else{
                        System.out.println("car not found!");
                    }
                    break;
                case 4:
                    parking.printStack();
                    break;

                case 5:
                    System.out.print("stack number for sorting:");
                    int stackNum = input.nextInt();
                    parking.sortStack(stackNum-1);
                    break;

                case 6:
                    System.out.print("from stack number...: ");
                    int i = input.nextInt();
                    if(i > n){
                            System.out.println("more than capacity!");
                            break;
                    }
                    System.out.print("to stack number...: ");
                    int j = input.nextInt();
                    if(j > n){
                            System.out.println("more than capacity!");
                            break;
                    }
                    parking.move(i, j);
                    break;

                case 0:
                    System.out.println("the program ended!");
                    break;

                default:
                    System.out.println("invalid option!");
            }
        } while(choice != 0);

        input.close();
    }
}
