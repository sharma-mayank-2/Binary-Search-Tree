package com.app;

/**
 * Created by s.mayank on 21/10/16.
 * class to implement BST.
 */
public class BinarySearchTree {
    Node root;
    BinarySearchTree(){
        this.root = null;
    }

    public void insert(int data){
        Node n = new Node(data);
        if(root == null){
            root = n;
            return;
        }
        Node currentNode = root;
        Node parent = null;
        while (true){
            parent = currentNode;
            if(data < currentNode.data){
                currentNode = currentNode.left;
                if(currentNode == null){
                    parent.left = n;
                    return;
                }
            }
            else{
                currentNode = currentNode.right;
                if(currentNode == null){
                    parent.right = n;
                    return;
                }
            }
        }
    }

    // inorder display
    public void display(Node root){
        if(root != null){
            display(root.left);
            System.out.print(root.data+" ");
            display(root.right);
        }
    }

    public boolean find(int data){
        Node currentNode = root;
        while (currentNode != null){
            if(data == currentNode.data){
                return true;
            }else if(data < currentNode.data){
                currentNode = currentNode.left;
            }else{
                currentNode = currentNode.right;
            }
        }
        return false;
    }

    public void findMin(Node root){
        while(root.left != null){
            root = root.left;
        }
        System.out.println("min is "+root.data);
    }

    public boolean isBalanced(Node root, Height height){
        boolean l, r;
        l = false;
        r = false;
        if(root == null){
            height.height = 0;
            return true;
        }

        Height l_h = new Height();
        Height r_h = new Height();

        l = isBalanced(root.left, l_h);
        r = isBalanced(root.right, r_h);

        height.lh = l_h.height;
        height.rh = r_h.height;
        height.height = Math.max(height.rh, height.lh)+1;

        if(height.lh - height.rh >=2 || height.rh - height.lh >= 2){
            return false;
        }else {
            return r && l;
        }
    }

    public Node delete(Node root, int data){
        Node currentNode = root;
        if(currentNode == null){
            return null;
        }
        if(data < currentNode.data){
            currentNode.left = delete(currentNode.left, data);
        }else if(data > currentNode.data){
            currentNode.right = delete(currentNode.right, data);
        }else {
            if(currentNode.left == null && currentNode.right == null){
                currentNode = null;
            }else if(currentNode.left == null){
                currentNode= currentNode.right;
            }else if(currentNode.right == null){
                currentNode = currentNode.left;
            }else{
                Node minFromRight = findMinFromRight(currentNode.right);
                currentNode.data = minFromRight.data;
                currentNode.right = delete(currentNode.right, minFromRight.data);
            }
        }
        return currentNode;
    }

    public Node findMinFromRight(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class Height{
    int height;
    int lh;
    int rh;
    Height(){
        this.height = 0;
        this.lh = 0;
        this.rh = 0;
    }
}
