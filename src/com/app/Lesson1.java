package com.app;

/**
 * Created by s.mayank on 21/10/16.
 */
public class Lesson1 {
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(30);
        bst.insert(20);
        bst.insert(10);
        bst.insert(15);
        bst.insert(40);
        bst.insert(35);
        bst.insert(45);
        bst.display(bst.root);
        System.out.println();
        bst.findMin(bst.root);
        System.out.println();
        if(bst.find(40)){
            System.out.println("present");
        }else{
            System.out.println("not present");
        }
        System.out.println();

        Height height = new Height();
        if(bst.isBalanced(bst.root, height)){
            System.out.println("balanced");
        }else{
            System.out.println("not balanced");
        }

        bst.delete(bst.root, 30);


        bst.display(bst.root);

    }
}
