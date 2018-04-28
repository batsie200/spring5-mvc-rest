package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import guru.springframework.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rubatsirochiripa on 3/4/2018.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long idNumber) {
//        return customerMapper.customerToCustomerDTO(customerRespository.findById(idNumber).get());
        return customerRepository.findById(idNumber)
                .map(customerMapper::customerToCustomerDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {

        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.customerToCustomerDTO(savedCustomer);
    }

    @Override
    public CustomerDTO saveCustomerById(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        customer.setId(id);

        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.customerToCustomerDTO(savedCustomer);
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {

            if (customerDTO.getFirstName() != null) {
                customer.setFirstName(customerDTO.getFirstName());
            }

            if (customerDTO.getLastName() != null) {
                customer.setLastName(customerDTO.getLastName());
            }

            return customerMapper.customerToCustomerDTO(customerRepository.save(customer));
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
