import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class CRUDApplication {

    static List<Item> itemList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void createItem() {
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        itemList.add(new Item(name, price));
        System.out.println("Item created successfully!");
    }

    public static void readItems() {
        System.out.println("Items:");
        for (Item item : itemList) {
            System.out.println("Name: " + item.getName() + ", Price: " + item.getPrice());
        }
    }

    public static void updateItem() {
        System.out.print("Enter item name to update: ");
        String name = scanner.nextLine();
        for (Item item : itemList) {
            if (item.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new item price: ");
                double price = scanner.nextDouble();
                item.setPrice(price);
                System.out.println("Item updated successfully!");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public static void deleteItem() {
        System.out.print("Enter item name to delete: ");
        String name = scanner.nextLine();
        for (Item item : itemList) {
            if (item.getName().equalsIgnoreCase(name)) {
                itemList.remove(item);
                System.out.println("Item deleted successfully!");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("CRUD Application");
            System.out.println("1. Create Item");
            System.out.println("2. Read Items");
            System.out.println("3. Update Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createItem();
                    break;
                case 2:
                    readItems();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
