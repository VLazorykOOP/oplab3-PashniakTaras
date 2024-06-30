// Mediator Interface
interface BookStoreMediator {
    void notify(Component sender, String event);
}

// Concrete Mediator implementing the Mediator Interface
class ConcreteBookStoreMediator implements BookStoreMediator {
    private Inventory inventory;
    private Payment payment;
    private Shipping shipping;

    public ConcreteBookStoreMediator(Inventory inventory, Payment payment, Shipping shipping) {
        this.inventory = inventory;
        this.inventory.setMediator(this);
        this.payment = payment;
        this.payment.setMediator(this);
        this.shipping = shipping;
        this.shipping.setMediator(this);
    }

    @Override
    public void notify(Component sender, String event) {
        if (event.equals("orderPlaced")) {
            boolean isAvailable = inventory.checkAvailability();
            if (isAvailable) {
                payment.processPayment();
            }
        } else if (event.equals("paymentProcessed")) {
            shipping.arrangeShipping();
        }
    }
}


// Abstract Component class
abstract class Component {
    protected BookStoreMediator mediator;

    public void setMediator(BookStoreMediator mediator) {
        this.mediator = mediator;
    }
}

// Inventory class extending Component
class Inventory extends Component {
    public boolean checkAvailability() {
        System.out.println("Checking book availability...");
        return true;
    }
}

// Payment class extending Component
class Payment extends Component {
    public void processPayment() {
        System.out.println("Processing payment...");
        mediator.notify(this, "paymentProcessed");
    }
}

// Shipping class extending Component
class Shipping extends Component {
    public void arrangeShipping() {
        System.out.println("Arranging shipping...");
    }
}
