package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by rubatsirochiripa on 2/4/2018.
 */
@Component
@Profile("dev")
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        loadCustomers();

        loadCategories();

    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("############# Category Data loaded: " + categoryRepository.count() + " ##############");
    }

    private void loadCustomers(){
        Customer customer1 = new Customer();
        customer1.setFirstName("FirstOne");
        customer1.setLastName("LastOne");

        Customer customer2 = new Customer();
        customer2.setFirstName("FirstTwo");
        customer2.setLastName("LastTwo");

        Customer customer3 = new Customer();
        customer3.setFirstName("FirstThree");
        customer3.setLastName("LastThree");

        Customer customer4 = new Customer();
        customer4.setFirstName("FirstFour");
        customer4.setLastName("LastFour");

        Customer customer5 = new Customer();
        customer5.setFirstName("FirstFive");
        customer5.setLastName("LastFive");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);

        System.out.println("############# Customer Data loaded: " + customerRepository.count() + " ##############");

    }
}
