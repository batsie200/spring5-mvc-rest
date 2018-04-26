package guru.springfamework.repositories;

import guru.springfamework.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rubatsirochiripa on 3/4/2018.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
