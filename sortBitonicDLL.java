static Node sortBitonicDLL(Node head) {
    if (head == null || head.next == null) return head;

    Node last = head;
    while (last.next != null) {
        last = last.next;
    }

    Node front = head;
    Node result = null;
    Node tail = null;

    while (front != null && last != null && front != last && last.next != front) {
        Node newNode;
        if (front.data < last.data) {
            newNode = new Node(front.data);
            front = front.next;
        } else {
            newNode = new Node(last.data);
            last = last.prev;
        }

        if (result == null) {
            result = newNode;
            tail = result;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
    }

    while (front != null && front != last.next) {
        Node newNode = new Node(front.data);
        front = front.next;
        tail.next = newNode;
        newNode.prev = tail;
        tail = tail.next;
    }

    while (last != null && last.next != front) {
        Node newNode = new Node(last.data);
        last = last.prev;
        tail.next = newNode;
        newNode.prev = tail;
        tail = tail.next;
    }

    return result;
}
