import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    Student s = new Student(); // error, no default ctor is provided by java if a Parametrized ctor is made available

    Student s1 = new Main.Student(10, "A");

    Main obj = new Main();
    Person p1 = obj.new Person();
}
// usual
  static class Student {
    int age;
    String name;

    Student(int age, Student name){
      this.age = age;
      this.name = name;
    }

  // after a Parametrized ctor is added, if default ctor is required it will have to be written
    Student(){

    }
  }

// very unusual (a nested non-static class)
  class Person {

  }

}