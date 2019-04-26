import java.util.Scanner;

public class DoubleLinkedList {
    private static Node head;
    private static Node tempNode;
    private static final Scanner scanner = new Scanner(System.in);

    private static void insert(Node newNode) {
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    private static Node search(int key) {
        tempNode = head;
        while (tempNode != null && tempNode.key != key) {
            tempNode = tempNode.next;
        }

        return tempNode;
    }

    private static void delete(int key) {
        Node deleteNode = search(key);
        if (deleteNode != null) {
            if (deleteNode.prev != null) {
                deleteNode.prev.next = deleteNode.next;
            } else {
                head = deleteNode.next;
            }
            if (deleteNode.next != null) {
                deleteNode.next.prev = deleteNode.prev;
            }
        }
    }

    private static void reverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current, next, prev;
        current = head;
        next = head.next;
        prev = head.prev;

        while (next != null) {
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
            next = next.next;
        }

        head = current;
        head.next = prev;
        head.prev = null;
    }

    private static void printList() {
        tempNode = head;
        System.out.print("List : ");
        while (tempNode != null) {
            if(tempNode.next != null) {
                System.out.printf("%d -> ", tempNode.key);
            } else {
                System.out.printf("%d", tempNode.key);
            }

            tempNode = tempNode.next;
        }
    }

    private static void printMenu() {
        System.out.println("1. Insert");
        System.out.println("2. Search");
        System.out.println("3. Delete");
        System.out.println("4. Reverse");
        System.out.println("5. Print");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
        int key;
        while (true) {
            printMenu();
            System.out.print("Enter your input: ");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    System.out.print("Enter node key: ");
                    key = scanner.nextInt();

                    insert(new Node(key));
                    break;

                case 2:
                    System.out.print("Enter node key: ");
                    key = scanner.nextInt();
                    Node foundNode = search(key);
                    if (foundNode == null) {
                        System.out.println("Node not found in list: " + key);
                    }
                    break;

                case 3:
                    System.out.print("Enter node key: ");
                    key = scanner.nextInt();
                    delete(key);
                    break;

                case 4:
                    reverse();
                    printList();
                    break;

                case 5:
                    printList();
                    break;

                case 6:
                    System.exit(1);

                default:
                    System.out.println("Invalid selection");

            }
        }
    }

    static class Node {
        int key;
        Node next;
        Node prev;

        Node(int key) {
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }
}
