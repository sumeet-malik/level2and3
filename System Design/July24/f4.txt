import java.io.*;
import java.util.*;

// No probelm in this code
class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
   MyGenericTree gt = new MyGenericTree();
   gt.construct(new int[] {10, 20, 50, -1, 60, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1});
  
    for(int val: gt){
      System.out.println(val);
    }
  }

  static class MyGenericTree implements Iterable<Integer> {
    Node root;

    static class Node {
      int data;
      ArrayList<Node> children = new ArrayList<>();
    }

    public void construct(int[] arr) {
      root = null;

      Stack<Node> st = new Stack<>();
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == -1) {
          st.pop();
        } else {
          Node t = new Node();
          t.data = arr[i];

          if (st.size() > 0) {
            st.peek().children.add(t);
          } else {
            root = t;
          }

          st.push(t);
        }
      }
    }

    public Iterator<Integer> iterator(){
      return new GTIterator(root);
    }

    static class GTIterator implements Iterator<Integer> {
      static class Pair {
        Node node;
        int state = -1;

        Pair(Node node){
          this.node = node;
        }
      }

      Stack<Pair> st = new Stack<>();
      Integer curr = null;

      public GTIterator(Node root){
        st.push(new Pair(root));
        next();
      }

      public boolean hasNext(){
        return st.size() > 0;
      }

      public Integer next(){
        Integer rv = curr;

        curr = null;
        while(st.size() > 0){
          Pair top = st.peek();
          if(top.state == -1){
            curr = top.node.data;
            top.state++;
            break;
          } else if(top.state < top.node.children.size()){
            Pair cp = new Pair(top.node.children.get(top.state));
            st.push(cp);
            top.state++;
          } else {
            st.pop();
          }
        }

        return rv;
      }
    }
  }

}