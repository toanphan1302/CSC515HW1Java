import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Iterator {
    public static void main(String[] args) {
        MySimpleSinglyLinkedList<Integer> myList = new MySimpleSinglyLinkedList();
        myList.Add(1);
        myList.Add(2);
        myList.Add(3);
        myList.Add(4);
        myList.Add(5);
        myList.Add(6);

        myList.PrintList();

        // Use iterator to do operattion
        MySimpleSinglyLinkedList<Integer> myList2 = new MySimpleSinglyLinkedList();
        MyIterator<Integer> iterator = new MyIterator(myList);
        while (iterator.HasNext()) {
            myList2.Add(iterator.Next() * 2);
        }
        myList2.PrintList();
    }
}

class MyIterator<T> {
    // data
    Node<T> CurrentNode;

    // Checks if the next element exists
    public boolean HasNext() {
        // When next is not null there is a "next" node
        return CurrentNode.Next != null;
    }

    // moves the cursor/iterator to next element
    public T Next() {
        if (HasNext()) {
            // Move current node to the next value
            CurrentNode = CurrentNode.Next;
            return CurrentNode.Value;
        } else {
            System.out.println("No more element in the list");
            return null;
        }
    }

    // ctors
    // When initialize CurrentNode point to a new reference that Next is point to
    // the head of the list
    public MyIterator(MySimpleSinglyLinkedList<T> commingList) {
        CurrentNode = new Node(null);
        CurrentNode.Next = commingList.Head;
    }

    public MyIterator(Node<T> headNode) {
        CurrentNode = new Node(null);
        CurrentNode.Next = headNode;
    }
}

class MySimpleSinglyLinkedList<T> {
    // Data
    Node<T> Head;

    // Methods
    public void Add(T someValue) {
        // Create new node
        Node<T> newNode = new Node<T>(someValue);

        if (Head == null) {
            Head = newNode;
        } else {
            // find the last node:
            Node<T> finger = Head;
            // as long as there is a node to the right of finger
            while (finger.Next != null) {
                // ... move there
                finger = finger.Next;
            }
            finger.Next = newNode;// link in the new node
        }
    }

    // Use iterator to print the list
    public void PrintList() {
        MyIterator<T> iterator = new MyIterator(Head);
        while (iterator.HasNext()) {
            System.out.print(iterator.Next() + ", ");
        }
        System.out.println();
    }

    // ctors
    public MySimpleSinglyLinkedList() {

    }
}

class Node<T> {
    public T Value;
    public Node<T> Next;

    // ctors
    public Node(T newValue) {
        Value = newValue;
    }
}