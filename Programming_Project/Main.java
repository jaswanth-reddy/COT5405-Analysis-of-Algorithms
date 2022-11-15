import java.util.*;
import java.text.*;
public class Main {
    public static void main(String[] args) {
        String ch=args[0];
        switch(ch){
            case "1":
                Task1.enterTask1();
                break;
            case "2":
                Task2 test2 = new Task2();
                test2.enterTask2();
                break;
            case "3a":
                Task3A test3a = new Task3A();
                test3a.enterTask3a();
                break;
            case "3A":
                Task3A test3A = new Task3A();
                Task3A.enterTask3a();
                break;
            case "3b":
                Task3b test3b = new Task3b();
                test3b.enterTask3b();
                break;
            case "3B":
                Task3b test3B = new Task3b();
                Task3b.enterTask3b();
                break;
            case "4":
                Task4 test4 = new Task4();
                test4.enterTask4();
                break;
            case "5":
                Task5 test5 = new Task5();
                test5.enterTask5();
                break;
            case "6":
                Task6 test6 = new Task6();
                test6.enterTask6();
                break;
            default:
                System.out.println("Invalid Input Recognized");
        }
    }
}