import java.util.*;

public class DoublyLinkedList 
{
    public static void main(String[] args) 
    {
        DLL dll = new DLL();
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            int d = sc.nextInt();
            if (d == -1) break;
            else
            {
                dll.append(d);
            }
        }

        dll.delete(100);
        dll.count(dll.head);
        dll.display(dll.head);
        sc.close();;
    }
}

class Node
{
    int data;
    Node previous;
    Node next;

    Node(int d)
    {
        data = d;
        previous = null;
        next = null;
    }
}

class DLL
{
    Node head = null;

    void append(int d) {
        // Create a new node with the given data
        Node newn = new Node(d);
    
        // If the list is empty, make the new node the head
        if (head == null) {
            head = newn;
        } else {
            // Otherwise, traverse to the last node
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            // Link the new node at the end
            temp.next = newn;
            newn.previous = temp;
        }
    }
    
    void delete(int d) {
        if (head == null) {
            System.out.println("List is Empty !");
            return;
        }
    
        Node temp = head;
        while (temp != null) {
            // Ensure temp.next is not null before accessing temp.next.data
            if (temp.next != null && temp.next.data == d) {
                // If temp.next is the last node
                if (temp.next.next != null) {
                    temp.next = temp.next.next;
                    temp.next.previous = temp;
                } else {
                    temp.next = null; // Last node deletion, set temp.next to null
                }
                return; // Exit after deletion
            }
            temp = temp.next;
        }
        System.out.println("Node not found!");
    }

    void display(Node head) {
        if (head == null) {
            System.out.println("List is Empty !");
            return;
        }
    
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next; // Move to the next node
        }
        System.out.println(); // Print a new line after the list
    }

    int count(Node head) {
        if (head == null) {
            return 0; // Return 0 if the list is empty
        }
    
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next; // Move to the next node
        }
        return count;
    }
    
        
}