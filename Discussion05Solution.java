class Book {
    String title;
    String author;
    double price;    

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    String toText() {
        return this.title + " by " + this.author + ", $" + this.price;
    }
}

class Discussion05 {
    public static void main(String[] args) {        
        Book[] books = {
            new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 7.99),
            new Book("The Two Towers",  "J.R.R. Tolkien", 7.99),
            new Book("The Return of the King", "J.R.R. Tolkien", 3.99),
            new Book("War and Peace", "Leo Tolstoy", 15.99)
        };

        if (args.length == 0) {
            // print all the books
            for (Book book: books) {
                System.out.println(book.toText());
            }
        } else if (args[0].equals("--author")) {
            // Print all books by author
            for (Book book: books) {
                if (book.author.equals(args[1])) {
                    System.out.println(book.toText());
                }
            }         
        } else if (args[0].equals("--buy")) {
            double total = 0;

            // For each requested book            
            for (int i = 1; i < args.length; i = i + 1) {
                // Search for the book
                for (Book book: books) {
                    if (book.title.contains(args[i])) {
                        // If you find it, add the price to total
                        total = total + book.price;
                    }
                }
            }

            System.out.println(total);
        }
    }
}