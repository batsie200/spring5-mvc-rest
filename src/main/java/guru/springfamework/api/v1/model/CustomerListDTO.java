package guru.springfamework.api.v1.model;

import lombok.Data;

import java.util.List;

/**
 * Created by rubatsirochiripa on 3/4/2018.
 */
@Data
public class CustomerListDTO {

    List<CustomerDTO> customerDTOS;

    public CustomerListDTO(List<CustomerDTO> customerDTOS) {
        this.customerDTOS = customerDTOS;
    }
}
