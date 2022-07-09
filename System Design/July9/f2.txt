import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    Student s = new Student(); // default ctor is always available even if not provided
  }

  static class Student {
    int age;
    String name;
  }

}