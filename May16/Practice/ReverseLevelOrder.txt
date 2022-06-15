void reverseLevelOrder(Node node) {
    ArrayDeque<Node> queue = new ArrayDeque<>();
    Stack<Node> stack = new Stack<>();

    queue.addLast(node);
    while(queue.size() > 0){
        // remove, add to stack, add children in reverseLevelOrder
        Node temp = queue.removeFirst();

        stack.push(temp);

        if(temp.right != null){
            queue.add(temp.right);
        }

        if(temp.left != null){
            queue.add(temp.left);
        }
    }

    while(stack.size() > 0){
        Node temp = stack.pop();
        System.out.println(temp.data);
    }
}