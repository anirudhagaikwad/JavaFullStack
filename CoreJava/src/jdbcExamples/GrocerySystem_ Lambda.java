package corejava;

public class GrocerySystem_Lambda {

    public interface InventoryManager {
        void addItem(GroceryItem item);
        GroceryItem[] getAllItems();
    }

    @FunctionalInterface
    public interface ItemFilter {
        GroceryItem[] filterItems(GroceryItem[] items);
    }

    @FunctionalInterface
    public interface ItemSorter {
        GroceryItem[] sortItems(GroceryItem[] items);
    }

    @FunctionalInterface
    public interface ValueCalculator {
        double calculateTotalValue(GroceryItem[] items);
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addItem(new GroceryItem("Apple", 2.5, 10, "Fruit"));
        inventory.addItem(new GroceryItem("Milk", 1.2, 5, "Dairy"));
        inventory.addItem(new GroceryItem("Bread", 1.5, 8, "Bakery"));
        inventory.addItem(new GroceryItem("Cheese", 3.0, 3, "Dairy"));
        inventory.addItem(new GroceryItem("Banana", 1.0, 12, "Fruit"));

        GroceryItem[] allItems = inventory.getAllItems();

        // Filter using lambda 
        ItemFilter fruitFilter = (items) -> {
            int count = 0;
            for (GroceryItem item : items) {
                if (item != null && item.getCategory().equalsIgnoreCase("Fruit")) {
                    count++;
                }
            }
            GroceryItem[] result = new GroceryItem[count];
            int index = 0;
            for (GroceryItem item : items) {
                if (item != null && item.getCategory().equalsIgnoreCase("Fruit")) {
                    result[index++] = item;
                }
            }
            return result;
        };

        System.out.println("=== Filtered Items (Fruits) ===");
        for (GroceryItem item : fruitFilter.filterItems(allItems)) {
            System.out.println(item);
        }

        // Sort using lambda (by price ascending)
        ItemSorter priceSorter = (items) -> {
            GroceryItem[] sorted = new GroceryItem[items.length];
            for (int i = 0; i < items.length; i++) {
                sorted[i] = items[i];
            }

            for (int i = 0; i < sorted.length - 1; i++) {
                for (int j = i + 1; j < sorted.length; j++) {
                    if (sorted[i].getPrice() > sorted[j].getPrice()) {
                        GroceryItem temp = sorted[i];
                        sorted[i] = sorted[j];
                        sorted[j] = temp;
                    }
                }
            }
            return sorted;
        };

        System.out.println("\n=== Sorted Items (By Price Ascending) ===");
        for (GroceryItem item : priceSorter.sortItems(allItems)) {
            System.out.println(item);
        }

        // Total value using lambda
        ValueCalculator totalValue = (items) -> {
            double total = 0;
            for (GroceryItem item : items) {
                if (item != null) {
                    total += item.getPrice() * item.getQuantity();
                }
            }
            return total;
        };

        System.out.println("\nTotal Inventory Value: $" + totalValue.calculateTotalValue(allItems));
    }
}

class GroceryItem {
    private String name;
    private double price;
    private int quantity;
    private String category;

    public GroceryItem(String name, double price, int quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "GroceryItem [name=" + name + ", price=" + price + ", quantity=" + quantity + ", category=" + category + "]";
    }
}

class Inventory implements GrocerySystem.InventoryManager {
    private GroceryItem[] items = new GroceryItem[100];
    private int count = 0;

    @Override
    public void addItem(GroceryItem item) {
        if (count < items.length) {
            items[count++] = item;
        }
    }

    @Override
    public GroceryItem[] getAllItems() {
        GroceryItem[] result = new GroceryItem[count];
        for (int i = 0; i < count; i++) {
            result[i] = items[i];
        }
        return result;
    }
}

/*

### ✅ 1. What is the main structure of the program?

The program is a Grocery Inventory Management System that:

* Stores grocery items using arrays
* Allows adding items
* Filters items (e.g., by category)
* Sorts items (e.g., by price)
* Calculates total value
* Uses lambda expressions for operations

---

### ✅ 2. What are functional interfaces, and why are they used here?

A functional interface is an interface with only one abstract method, ideal for use with lambda expressions.

--- 

| Sr | Question                                                     | Expected Answer                                          |
| -- | ------------------------------------------------------------ | -------------------------------------------------------- |
| 1  | What is a functional interface in Java?                      | Interface with one abstract method                       |
| 2  | Why do we need lambda expressions?                           | For writing clean, short behavior implementations        |
| 3  | Can we filter items without `Predicate` or streams?          | Yes, by creating a custom interface                      |
| 4  | How are items stored in this program?                        | Using arrays                                             |
| 5  | Why is `List` or `ArrayList` not used here?                  | To demonstrate array-only logic                          |
| 6  | What is the return type of `ItemFilter`?                     | `GroceryItem[]`                                          |
| 7  | How does sorting work here?                                  | Custom logic using nested loops (like bubble sort)       |
| 8  | How is memory managed when filtering items into a new array? | First count matching items, then create that sized array |
| 9  | Why is `toString()` overridden in `GroceryItem`?             | For easy printing                                        |
| 10 | How would you filter only `"Dairy"` items?                   | Change the category check in lambda                      |
| 11 | How can you sort by name instead of price?                   | Modify comparison logic in `sortItems()`                 |

---


*/