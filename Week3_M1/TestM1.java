public class TestM1 {

    public static void main(String[] args) {

        BookInventory[] books = {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        for (int i = 0; i < books.length; i++) {
            books[i].printEntry();
        }
    }
}