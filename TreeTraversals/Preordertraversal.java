/*
Pre Order Traversal

ROOT*LEFT*RIGHT

 */

package com.company;

import java.util.Stack;

class Node
{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
    }
}

//main class
public class Main {

    //Recursive
    public void preorderRecursive(Node root)
    {
        if(root != null){
            System.out.print(root.data + "->");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    //stack
    public void preorderStack(Node root)
    {
        Stack <Node> s =new Stack<Node>();
        while(true){

            // Print the root first and and then add the left node
            while(root != null){
                System.out.print(root.data + "->");
                s.push(root);
                root = root.left;
            }
            // check if Stack is empty, if yes, exit from everywhere
            if (s.isEmpty()) {
                return;
            }
            // pop the element from the stack and go to the right tree
            root =s.pop();

            root = root.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Main obj = new Main();
        obj.preorderRecursive(root);
        System.out.println();
        obj.preorderStack(root);
    }
}
