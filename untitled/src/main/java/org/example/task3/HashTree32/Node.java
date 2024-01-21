package org.example.task3.HashTree32;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    Node search(Node root, int key) {

        if (root == null || root.data == key) //если дерево пустое или корень содержит искомое значение
            return root;

        if (root.data > key)// Рекурсивный поиск в левом и правом поддеревьях
            return search(root.left, key);
        return search(root.right, key);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);

        Node result = tree.search(tree.root, 40);
        if (result != null)
            System.out.println("Элемент найден: " + result.data);
        else
            System.out.println("Элемент не найден");
    }
}
