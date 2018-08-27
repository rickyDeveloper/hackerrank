package algo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by vikasnaiyar on 06/08/18.
 */
public class LinkedListRotation {


    public static class LinkedListNode {
        int data;
        LinkedListNode next;

        LinkedListNode(int value) {
           this.data = value;
        }

    }


    public static class LinkedList {
        LinkedListNode head = null;
        LinkedListNode tail = null;
    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        Scanner sn = new Scanner(System.in);
        int cases = sn.nextInt();

        while (cases > 0) {

            int n = sn.nextInt();

            if(linkedList.head == null) {

                linkedList.head = new LinkedListNode(n);
                linkedList.tail = linkedList.head;

            } else {
                LinkedListNode temp = linkedList.tail;
                linkedList.tail = new LinkedListNode(n);
                temp.next = linkedList.tail;
            }

            --cases;
        }

        int count = sn.nextInt();

        while (count-- > 0){
            LinkedListNode temp = linkedList.head;

            if(linkedList.head.next != null) {
                linkedList.tail.next =  linkedList.head;
                linkedList.head = linkedList.head.next;
                linkedList.tail = linkedList.tail.next;
                linkedList.tail.next = null;
            }
        }


        LinkedListNode head = linkedList.head;

        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }


}
