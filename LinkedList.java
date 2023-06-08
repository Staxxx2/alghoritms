import java.io.*;

public class LinkedList {

	Node head; 

	static class Node {

		int data;
		Node next;

		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	public static LinkedList insert(LinkedList list,
									int data)
	{
		Node new_node = new Node(data);
		new_node.next = null;

		if (list.head == null) {
			list.head = new_node;
		}
		else {
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			last.next = new_node;
		}

		return list;
	}

	// Method to print the LinkedList.
	public static void printList(LinkedList list)
	{
		Node currNode = list.head;

		System.out.print("LinkedList: ");

		while (currNode != null) {
			System.out.print(currNode.data + " ");

			currNode = currNode.next;
		}
	}
    public static LinkedList reverse(LinkedList list)
    {
        Node currNode = list.head;
        Node prevNode = null, nextNode = null;
    
        while (currNode != null) {
            nextNode = currNode.next;
    
            currNode.next = prevNode;
    
            prevNode = currNode;
            currNode = nextNode;
        }
    
        list.head = prevNode;
    

        return list;
    }
	// **************MAIN METHOD**************


	public static void main(String[] args)
	{
		// Начало с пустого тела списка
		LinkedList list = new LinkedList();


		// Ввод данных
		list = insert(list, 1);
		list = insert(list, 2);
		list = insert(list, 3);
		list = insert(list, 4);
		list = insert(list, 5);
		list = insert(list, 6);
		list = insert(list, 7);
		list = insert(list, 8);

        System.out.print("Вывод односвязного списка ");
		printList(list);
        
        reverse(list);

        System.out.print("\nВывод развернутого списка ");  
        printList(list);


	}
}
