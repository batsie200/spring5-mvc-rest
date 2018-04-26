package guru.springfamework.services;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;

import java.util.List;

/**
 * Created by rubatsirochiripa on 3/4/2018.
 */
public interface CustomerService {


    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long idNumber);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);

    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomerById(Long id);
}
