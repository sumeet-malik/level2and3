import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    P obj = null;

    obj = new C();

    obj.fun();
  }

  static class P {
    final int maxScore = 100;
    final void fun(){
      final int age = 10;
      //age++;
      System.out.println("Max score is = " + maxScore);
    }
  }

  static class C extends P {
    void fun(){
      System.out.println("C's fun");
    }
  }

  

}