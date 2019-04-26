import java.util.Scanner;

public class StackWithLinkedList {
    private static Node head;
    private static final Scanner scanner = new Scanner(System.in);

    private static void push(Node newNode) {
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    private static int pop() {
        int key = 0;
        if (head != null) {
            key = head.key;
            head = head.next;
        }
        return key;
    }

    private static void printList() {
        Node tempNode = head;
        System.out.print("List : ");
        while (tempNode != null) {
            if(tempNode.next != null) {
                System.out.printf("%d -> ", tempNode.key);
            } else {
                System.out.printf("%d", tempNode.key);
            }

            tempNode = tempNode.next;
        }
        System.out.println();
    }

    private static void printMenu() {
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Print");
        System.out.println("4. Exit");
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

                    push(new Node(key));
                    break;

                case 2:
                    int foundNode = pop();
                    if (foundNode == 0) {
                        System.out.println("Stack is empty");
                        break;
                    }
                    System.out.println("Pop element : "+foundNode);
                    break;

                case 3:
                    printList();
                    break;

                case 4:
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
