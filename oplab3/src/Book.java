// Abstract Product Interface
interface Book {
    void read();
}

// Concrete Products
class EBook implements Book {
    @Override
    public void read() {
        System.out.println("Reading an eBook.");
    }
}

class PaperBook implements Book {
    @Override
    public void read() {
        System.out.println("Reading a paper book.");
    }
}

// Abstract Factory Interface
interface BookFactory {
    Book createBook();
}

// Concrete Factories implementing the Abstract Factory Interface
class EBookFactory implements BookFactory {
    @Override
    public Book createBook() {
        return new EBook();
    }
}

class PaperBookFactory implements BookFactory {
    @Override
    public Book createBook() {
        return new PaperBook();
    }
}
