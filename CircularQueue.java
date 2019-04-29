import java.util.Scanner;

public class CircularQueue {
    private static Node head, end;
    private static Node tempNode;
    private static final Scanner scanner = new Scanner(System.in);

    private static void insert(Node newNode) {
        if (head == null) {
            head = newNode;
            end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
        end.next = head;
    }

    private static int delete() {
        int deletedNodeKey = 0;
        if (head != null) {
            deletedNodeKey = head.key;
            if (head.next == head) {
                head = null;
                end = null;
            } else {
                head = head.next;
                end.next = head;
            }
        }

        return deletedNodeKey;
    }

    private static void printList() {
        if (head == null) {
            System.out.println("Queue is empty");
            return;
        }

        tempNode = head;
        System.out.print("Queue elements : ");
        while (tempNode.next != head) {
            System.out.printf("%d -> ", tempNode.key);
            tempNode = tempNode.next;
        }
        System.out.printf("%d -> %d \n", tempNode.key, tempNode.next.key);
    }

    private static void printMenu() {
        System.out.println("1. Insert");
        System.out.println("2. Delete");
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

                    insert(new Node(key));
                    break;

                case 2:
                    int foundNode = delete();
                    if (foundNode == 0) {
                        System.out.println("Queue is empty");
                        break;
                    }
                    System.out.println("Deleted element : "+foundNode);
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

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }
}
