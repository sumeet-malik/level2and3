import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);
    int q = Integer.parseInt(st[2]);

    int[][] pos = new int[q][2];
    for (int i = 0; i < q; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    System.out.println(numIslands2(m, n, pos));
  }


  public static List<Integer> numIslands2(int m, int n, int[][] positions) {
    int[][] grid = new int[m][n];
    parent = new int[m * n];
    rank = new int[m * n];
    
    for(int i = 0; i < m * n; i++){
        parent[i] = i;
        rank[i] = 0;
    }
    
    ArrayList<Integer> res = new ArrayList<>();
    count = 0;
    
    for(int[] pos: positions){
        int x = pos[0];
        int y = pos[1];
        grid[x][y] = 1;
        
        count++;
        
        handleNewCell(x, y, x - 1, y, m, n, grid);
        handleNewCell(x, y, x + 1, y, m, n, grid);
        handleNewCell(x, y, x, y - 1, m, n, grid);
        handleNewCell(x, y, x, y + 1, m, n, grid);
        
        res.add(count);
    }
    
    return res;
  }
  
  static void handleNewCell(int x, int y, int xx, int yy, int m, int n, int[][] grid){
      if(xx < 0 || yy < 0 || xx >= m || yy >= m || grid[xx][yy] == 0){
          return;
      }
      
      int xyCell = x * n + y;
      int xxyyCell = xx * n + yy;
      
      int xylead = find(xyCell);
      int xxyylead = find(xxyyCell);
      
      if(xylead != xxyylead){
          count--;
          union(xylead, xxyylead);
      }
  }
  
  static int count;
  static int[] parent;
  static int[] rank;
  
  
  static int find(int i){
      if(parent[i] == i){
          return i;
      } else {
          parent[i] = find(parent[i]);
          return parent[i];
      }
  }
  
  static void union(int i, int j){
      if(rank[i] < rank[j]){
          parent[i] = j;
      } else if(rank[j] < rank[i]){
          parent[j] = i;
      } else {
          parent[i] = j;
          rank[j]++;
      }
  }
}