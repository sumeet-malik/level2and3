ArrayList<ArrayList<Integer> src = ..;

ArrayList<Integer> res = new ArrayList<>();
for(int i = 0; i < src.size(); i++){
    res.addAll(src.get(i));
}