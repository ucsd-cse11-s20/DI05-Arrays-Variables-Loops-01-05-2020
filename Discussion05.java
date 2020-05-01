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

public class Discussion05 {    
}