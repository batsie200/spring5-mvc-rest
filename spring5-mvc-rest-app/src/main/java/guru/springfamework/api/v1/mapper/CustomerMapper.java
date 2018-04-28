package guru.springfamework.api.v1.mapper;


import guru.springfamework.domain.Customer;
import guru.springframework.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by rubatsirochiripa on 3/4/2018.
 */
@Mapper
public interface CustomerMapper {

    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}
