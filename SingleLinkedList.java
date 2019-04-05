import java.util.Scanner;

public class SingleLinkedList {
    private static Node head;
    private static Node tempNode;
    private static int count;
    private static final Scanner scanner = new Scanner(System.in);

    private static void add(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }

            tempNode.next = newNode;
        }
    }

    private static void insertAt(Node node, int position) {
        if (position == 1) {
            node.next = head;
            head = node;
        } else {
            tempNode = head;
            count = 2;
            while (tempNode != null) {
                if (count == position) {
                    node.next = tempNode.next;
                    tempNode.next = node;
                    break;
                }
                tempNode = tempNode.next;
                count++;
            }
        }
    }

    private static void insertAfter(Node insertNode, int nodeData) {
        tempNode = head;
        while (tempNode != null) {
            if (tempNode.data == nodeData) {
                insertNode.next = tempNode.next;
                tempNode.next = insertNode;
                break;
            }
            tempNode = tempNode.next;
        }
    }

    private static void deleteAt(int position) {
        if (position == 1) {
            head = head.next;
        } else {
            count = 2;
            tempNode = head;
            while (tempNode.next != null) {
                if (count == position) {
                    tempNode.next = tempNode.next.next;
                    break;
                }
                tempNode = tempNode.next;
                count++;
            }
        }
    }

    private static void reverse() {
        if (head != null && head.next != null) {
            Node currentNode = head;
            Node currentNext = head.next;
            while (true) {
                tempNode = currentNext.next;
                currentNext.next = currentNode;
                currentNode = currentNext;
                currentNext = tempNode;

                if (currentNext == null) {
                    head.next = null;
                    head = currentNode;
                    break;
                }
            }
        }
    }

    private static void printList() {
        tempNode = head;
        System.out.print("List : ");
        while (tempNode != null) {
            if(tempNode.next != null) {
                System.out.printf("%d -> ", tempNode.data);
            } else {
                System.out.printf("%d", tempNode.data);
            }

            tempNode = tempNode.next;
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Add a new node");
        System.out.println("2. Insert a new Node at given position");
        System.out.println("3. Insert a new Node after given Node");
        System.out.println("4. Delete a node at given position");
        System.out.println("5. Reverse a list");
        System.out.println("6. Print list");
        System.out.println("7. Exit");
    }

    public static void main(String[] args) {
        int data;
        int position;
        while (true) {
            printMenu();
            System.out.print("Enter your input: ");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    System.out.print("Enter node data: ");
                    data = scanner.nextInt();

                    add(new Node(data));
                    break;

                case 2:
                    System.out.print("Enter node data: ");
                    data = scanner.nextInt();

                    System.out.print("Enter insert position: ");
                    position = scanner.nextInt();

                    insertAt(new Node(data), position);
                    break;

                case 3:
                    System.out.print("Enter node data: ");
                    data = scanner.nextInt();

                    System.out.print("Enter node data to insert after: ");
                    position = scanner.nextInt();
                    insertAfter(new Node(data), position);
                    break;

                case 4:
                    System.out.print("Enter node data: ");
                    position = scanner.nextInt();
                    deleteAt(position);
                    break;

                case 5:
                    reverse();
                    printList();
                    break;

                case 6:
                    printList();
                    break;

                case 7:
                    System.exit(1);

                default:
                    System.out.println("Invalid selection");

            }
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
