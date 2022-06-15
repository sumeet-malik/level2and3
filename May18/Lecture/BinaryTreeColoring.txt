    class Solution {

        int xkaleft;
        int xkaright;

        public int size(TreeNode node, int x){
            if(node == null){
                return 0;
            }

            int ls = size(node.left, x);
            int rs = size(node.right, x);

            if(node.val == x){
                xkaleft = ls;
                xkaright = rs;
            }

            int ts = ls + rs + 1;
            return ts;
        }

        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            size(root, x);

            int theOtherSide = n - (xkaleft + xkaright + 1);
            int maxOfThree = Math.max(theOtherSide, Math.max(xkaleft, xkaright));

            int rest = n - maxOfThree;
            if(maxOfThree > rest){
                return true;
            } else {
                return false;
            }
        }
    }