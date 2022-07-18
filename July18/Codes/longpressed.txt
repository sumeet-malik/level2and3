class Solution {
    public boolean isLongPressedName(String n, String t) {
        int i = 0;
        int j = 0;
        while(i < t.length()){
            if(j < n.length() && t.charAt(i) == n.charAt(j)){
                i++;
                j++;
            } else if(i > 0 && t.charAt(i) == t.charAt(i - 1)){
                i++;
            } else {
                return false; // ssaaedd saeed
            }
        }
        
        return j == n.length(); // aalexx alexa
    }
}