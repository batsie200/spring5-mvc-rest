package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import guru.springfamework.repositories.VendorRepository;
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
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        loadCustomers();

        loadCategories();

        loadVendors();

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

    private void loadCustomers() {
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

    private void loadVendors() {
        Vendor vendor1 = new Vendor();
        vendor1.setName("FirstVendor");

        Vendor vendor2 = new Vendor();
        vendor2.setName("SecondVendor");

        Vendor vendor3 = new Vendor();
        vendor3.setName("ThirdVendor");

        Vendor vendor4 = new Vendor();
        vendor4.setName("FourthVendor");

        Vendor vendor5 = new Vendor();
        vendor5.setName("FifthVendor");

        vendorRepository.save(vendor1);
        vendorRepository.save(vendor2);
        vendorRepository.save(vendor3);
        vendorRepository.save(vendor4);
        vendorRepository.save(vendor5);

        System.out.println("############# Vendor Data loaded: " + vendorRepository.count() + " ##############");
    }
}
