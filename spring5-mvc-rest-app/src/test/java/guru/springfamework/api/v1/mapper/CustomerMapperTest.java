package guru.springfamework.api.v1.mapper;


import guru.springfamework.domain.Customer;
import guru.springframework.model.CustomerDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rubatsirochiripa on 3/4/2018.
 */
public class CustomerMapperTest {

    CustomerMapper customerMapper = CustomerMapper.CUSTOMER_MAPPER;

    @Test
    public void customerToCustomerDTO() throws Exception {
        //given
        Customer customer = new Customer();
        customer.setId(1l);
        customer.setFirstName("Rubatsiro");
        customer.setLastName("Chiripa");

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(Long.valueOf(1L), customerDTO.getId());
        assertEquals("Rubatsiro", customerDTO.getFirstName());
        assertEquals("Chiripa", customerDTO.getLastName());


    }

}