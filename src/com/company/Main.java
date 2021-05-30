package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BinarySearchTree b = new BinarySearchTree();
        b.insert(1);
        b.insert(2);
        b.insert(3);
        b.insert(4);
        b.insert(5);
        b.insert(6);
        b.insert(7);
        b.insert(8);
        b.insert(9);
        b.insert(10);
        b.insert(11);
        b.insert(12);
        System.out.println("Original Tree : ");
        b.display(b.root);
        System.out.println("");
        System.out.println("Check whether Node with value 4 exists : " + b.find(4));
        System.out.println("Delete Node with no children (2) : " + b.delete(2));
        b.display(b.root);
        System.out.println("\n Delete Node with one child (4) : " + b.delete(4));
        b.display(b.root);
        System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));
        b.display(b.root);



        Hashtbl<String, Integer> tbl = new Hashtbl<String, Integer>(5);

        tbl.insert("one", 1);
        tbl.insert("three", 3);
        tbl.insert("nineteen", 19);
        tbl.insert("fifteen", 15);
        tbl.insert("six", 6);

        System.out.println();

        System.out.println("get 6: " + tbl.get("six") + " remove 6: " + tbl.remove("six") + " show six: "+ tbl.get("six"));

    }
}
