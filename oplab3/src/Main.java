public class Main {
    public static void main(String[] args) {
        // Використання шаблонів Abstract Factory та Facade
        BookStoreFacade bookstore = new BookStoreFacade();
        bookstore.orderEBook();
        bookstore.orderPaperBook();

        // Використання шаблону Mediator
        Inventory inventory = new Inventory();
        Payment payment = new Payment();
        Shipping shipping = new Shipping();
        ConcreteBookStoreMediator mediator = new ConcreteBookStoreMediator(inventory, payment, shipping);

        // Імітація процесу замовлення
        System.out.println("Placing an order...");
        mediator.notify(inventory, "orderPlaced");
    }
}
