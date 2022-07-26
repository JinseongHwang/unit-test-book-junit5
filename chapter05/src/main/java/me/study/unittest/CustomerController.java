package me.study.unittest;

public class CustomerController {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private Store mainStore;
    private IEmailGateway emailGateway;

    public CustomerController(IEmailGateway emailGateway) {
        this.emailGateway = emailGateway;
    }

    public boolean purchase(int customerId, int productId, int quantity) {
        final Customer customer = customerRepository.getById(customerId);
        final Product product = productRepository.getById(productId);

        final boolean isSuccess = customer.purchase(mainStore, product, quantity);

        if (isSuccess) {
            emailGateway.sendReceipt(customer.getEmail(), product.name(), quantity);
        }
        return isSuccess;
    }
}
