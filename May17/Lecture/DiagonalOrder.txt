class Tree
{
    static int md = 0;
    static void traversal(Node root, int diag, HashMap<Integer, ArrayList<Integer>> map){
        if(root == null){
            return;
        }

        if(diag > md){
            md = diag;
        }

        if(map.containsKey(diag) == false){
            map.put(diag, new ArrayList<>());
            map.get(diag).add(root.data);
        } else {
            map.get(diag).add(root.data);
        }

        traversal(root.left, diag + 1, map);
        traversal(root.right, diag, map);
    }
     
     public ArrayList<Integer> diagonal(Node root)
      {
           HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
           traversal(root, 0, map);

            ArrayList<Integer> total = new ArrayList<>();
            for(int d = 0; d <= md; d++){
                ArrayList<Integer> list = map.get(d);
                for(int item: list){
                    total.addd(item);
                }
            }

            return total;
      }
}
