import java.util.*;

class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}

class LL
{
    Node head = null;
    void append(int d)
    {
        Node newn = new Node(d);
        if(head == null)
        {
            head = newn;
        }
        else
        {
            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = newn;
        }
    }

    void insertbegin(int d)
    {
        Node newn = new Node(d);
        if(head == null)
        {
            head = newn;
        }
        else
        {
            newn.next = head;
            head = newn;
        }
    }

    void delete (int d)
    {
        if(head == null) System.out.println("List is Empty\n");
        else
        {
            Node temp = head;
            while(temp != null)
            {
                if (temp.next.data == d)
                {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
        }        
    }

    void deletebegin()
    {
        head = head.next;
    }

    void display(Node head)
    {
        if(head == null) System.out.println("List is Empty\n");
        else
        {
            Node temp = head;
            while(temp != null)
            {
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    int count(Node head)
    {
        int count = 0;
        if(head == null) return 0;
        else
        {
            Node temp = head;
            while(temp != null)
            {
                //System.out.print(temp.data + " -> ");
                temp = temp.next;
                count++;
            }
            System.out.println();
        }
        return count;
    }
}

public class LinkedList
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        LL ll = new LL();
        while(true)
        {
            System.out.println("\n[1] Insert Element at Begining\n[2] Append Element\n[3] Delete Element\n[4] Delete Element at Begining\n[5] Count\n[6] Display");
            System.out.print("\nDecision: ");
            int dec = sc.nextInt();
            if (dec == 1)
            {
                System.out.print("\nEnter Element: ");
                ll.insertbegin(sc.nextInt());
            }
            else if (dec == 2)
            {
                while(true)
                {
                    System.out.print("\nEnter data (-1 to end): ");
                    int data = sc.nextInt();
                    if(data == -1) break;
                    ll.append(data);
                }
            }
            else if (dec == 3)
            {
                System.out.print("\nEnter Element: ");
                ll.delete(sc.nextInt());
            }
            else if (dec == 4)
            {
                ll.deletebegin();
            }
            else if (dec == 5)
            {
                System.out.println("Count: " + ll.count(ll.head) + "\n");
            }
            else if (dec == 6)
            {
                ll.display(ll.head);
            }
            else break;
            
        }
        sc.close();
    }
}