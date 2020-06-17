/*

LEFT *ROOT* RIGHT
Since we are not using recursion, we will use the Stack to store the traversal, we need to remember that inorder traversal is, first traverse the left node then root followed by the right node.
Psuedo code:
* Create a Stack
* Push the Root onto Stack until set the root = root.left continue till it hits the NULL.
* If root is null and Stack is empty Then return, we are done.
* Else Pop the top Node from the Stack and set it as, root = popped_Node.
* print the root and go right, root = root.right.
* Go to step. End If

we have to keep track of the root that’s why we use stack! if we consider each subtree as separate ones it gets easier to understand the traversal and then move to stack
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
    public void inorderRecursive(Node root)
    {
        if(root != null){
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    //stack
    public void inorderStack(Node root)
    {
        Stack <Node> s =new Stack<Node>();
        while(true){

            // Go to the left extreme insert all the elements to stack
            while(root != null){
                s.push(root);
                root = root.left;
            }
            // check if Stack is empty, if yes, exit from everywhere
            if (s.isEmpty()) {
                return;
            }
            // pop the element from the stack , print it and add the nodes at
            // the right to the Stack
            root =s.pop();
            System.out.print(root.data + "->");
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
        obj.inorderRecursive(root);
        System.out.println();
        obj.inorderStack(root);
    }
}
