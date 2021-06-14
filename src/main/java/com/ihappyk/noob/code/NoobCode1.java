package com.ihappyk.noob.code;

class Node {
  public Integer key;
  public Node next;

    public Node (Integer key)
    {
        this.key = key;
        next = null;
    }
}

class CustomLinkedList {
    private Node header;
    private Node lastNode;
    private int size;

    CustomLinkedList(){
        header = new Node(null);
        lastNode = header;
    }


    public void prepand(Integer n) {
        Node node = new Node(n);
        if(size == 0) {
            header.next = node;
            lastNode = node;
            size = size+1;
        }
        else {
            Node next = header.next;
            header.next = node;


        }
    }
}


public class NoobCode1
{

}
