// Facade class providing a simplified interface for ordering books
class BookStoreFacade {
    private BookFactory eBookFactory;
    private BookFactory paperBookFactory;

    public BookStoreFacade() {
        eBookFactory = new EBookFactory();
        paperBookFactory = new PaperBookFactory();
    }

    public void orderEBook() {
        Book book = eBookFactory.createBook();
        book.read();
    }

    public void orderPaperBook() {
        Book book = paperBookFactory.createBook();
        book.read();
    }
}
