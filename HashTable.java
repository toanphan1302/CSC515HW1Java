import java.util.ArrayList;
import java.util.LinkedList;

public class HashTable {
    // Resolving collision by using chaining
    public static void main(String[] args) {
        // Initialize the table with 10 buckets
        var myHashTable = new ArrayList<LinkedList<MyKeyValuePair>>(10);
        for (int i = 0; i < 10; i++) {
            myHashTable.add(new LinkedList<MyKeyValuePair>());
        }

        // Insert values to the table
        Insert(myHashTable, new MyKeyValuePair(55, "Value of 55"));
        Insert(myHashTable, new MyKeyValuePair(12, "Value of 12"));
        Insert(myHashTable, new MyKeyValuePair(106, "Value of 106"));
        Insert(myHashTable, new MyKeyValuePair(217, "Value of 217"));
        Insert(myHashTable, new MyKeyValuePair(888, "Value of 888"));
        Insert(myHashTable, new MyKeyValuePair(27, "Value of 27"));
        Insert(myHashTable, new MyKeyValuePair(48, "Value of 48"));
        Insert(myHashTable, new MyKeyValuePair(351, "Value of 351"));
        Insert(myHashTable, new MyKeyValuePair(60, "Value of 60"));
        Insert(myHashTable, new MyKeyValuePair(254, "Value of 254"));
        // Colision between 217 with 27 and 888 with 48
        PrintHashTable(myHashTable);

        GetValue(myHashTable, 48);
        GetValue(myHashTable, 55);
        GetValue(myHashTable, 67);

        DeleteValue(myHashTable, 27);
        DeleteValue(myHashTable, 60);
        PrintHashTable(myHashTable);
    }

    static public int HashFunction(int key) {
        return key % 10;
    }

    static public void Insert(ArrayList<LinkedList<MyKeyValuePair>> hashTable, MyKeyValuePair keyValuePair) {
        var index = HashFunction(keyValuePair.Key);
        var selectedSpot = hashTable.get(index);
        selectedSpot.add(keyValuePair);
    }

    static public MyKeyValuePair GetValue(ArrayList<LinkedList<MyKeyValuePair>> hashTable, int key) {
        // Get the bucket index
        var index = HashFunction(key);
        var selectedSpot = hashTable.get(index);

        // Find the needed value
        for (MyKeyValuePair myKeyValuePair : selectedSpot) {
            if (myKeyValuePair.Key == key) {
                System.out.println("Found: [" + myKeyValuePair.Key + ", " + myKeyValuePair.Value + "]");
                return myKeyValuePair;
            }
        }

        System.out.println("Not Found value with key: " + key);
        return null;
    }

    static public void DeleteValue(ArrayList<LinkedList<MyKeyValuePair>> hashTable, int key) {
        var index = HashFunction(key);
        var selectedSpot = hashTable.get(index);

        // find the needed value
        var valueToDelete = GetValue(hashTable, key);
        if (valueToDelete != null) {
            System.out.println("Removing: [" + valueToDelete.Key + ", " + valueToDelete.Value + "]");
            selectedSpot.remove(valueToDelete);
        }
    }

    static public void PrintHashTable(ArrayList<LinkedList<MyKeyValuePair>> hashTable) {
        int index = 0;
        for (LinkedList<MyKeyValuePair> linkedList : hashTable) {
            System.out.print(index + "\t");
            index += 1;
            for (MyKeyValuePair keyValuePair : linkedList) {
                System.out.print(
                        "[" + keyValuePair.Key + ", " + keyValuePair.Value + "] \t");
            }
            System.out.println();
        }
    }

}

class MyKeyValuePair {
    // Key
    int Key;
    // Value can be any type - using string for this demo
    String Value;

    public MyKeyValuePair(int key, String value) {
        Key = key;
        Value = value;
    }
}