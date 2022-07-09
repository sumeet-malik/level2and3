import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    // Case 3
    P obj = new C();

    System.out.println(obj.d);
    System.out.println(obj.d1);
    System.out.println(obj.d2); // compile-time error, will work only on typecasting
    obj.fun();
    obj.fun1();
    obj.fun2(); // compile-time error, will work only on typecasting

    syso(((C)obj).d2); // works , and 20
    ((C)obj).fun2(); // works, and calls C's fun2
  }

  static class P {
    int d = 1;
    int d1 = 10;

    void fun1(){
      System.out.println("P's fun1");
    }

    void fun(){
      System.out.println("P's fun");
    }
  }

  static class C extends P {
    int d = 2;
    int d2 = 20;

    void fun2(){
      System.out.println("C's fun2");
    }

    void fun(){
      System.out.println("C's fun");
    }    
  }



}