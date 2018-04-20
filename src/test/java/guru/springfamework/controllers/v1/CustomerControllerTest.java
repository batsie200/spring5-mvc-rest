package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.services.CustomerService;
import guru.springfamework.services.ResourceNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static guru.springfamework.controllers.v1.AbstractRestControllerTest.asJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by rubatsirochiripa on 4/4/2018.
 */
public class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController)
//                .setControllerAdvice(new RestResponseEntityExceptionHandler())
                .build();
    }

    @Test
    public void getAllCustomers() throws Exception {

        //given
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setId(1L);
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");

        CustomerDTO customer2 = new CustomerDTO();
        customer2.setId(2L);
        customer2.setFirstName("Sam");
        customer2.setLastName("Axe");

        when(customerService.getAllCustomers()).thenReturn(Arrays.asList(customer1, customer2));

        mockMvc.perform(get(CustomerController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.customerDTOS", hasSize(2)));
    }

    @Test
    public void getCustomerById() throws Exception {
        //given
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setId(1L);
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");

        when(customerService.getCustomerById(anyLong())).thenReturn(customer1);

        mockMvc.perform(get(CustomerController.BASE_URL + "/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", equalTo("Michale")));
    }

    @Test
    public void creatNewCustomer() throws Exception{
        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Barack");
        customerDTO.setLastName("Obama");

        CustomerDTO returnDto = new CustomerDTO();
        returnDto.setFirstName(customerDTO.getFirstName());
        returnDto.setLastName(customerDTO.getLastName());

        when(customerService.createNewCustomer(customerDTO)).thenReturn(returnDto);

        //when/then
        mockMvc.perform(post("/api/v1/customers/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customerDTO)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", equalTo("Barack")));

    }

    @Test
    public void saveCustomerByDTO() throws Exception {
        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Donald");
        customerDTO.setLastName("Trump");

        CustomerDTO returnDto = new CustomerDTO();
        returnDto.setFirstName(customerDTO.getFirstName());
        returnDto.setLastName(customerDTO.getLastName());

        when(customerService.saveCustomerByDTO(anyLong(), ArgumentMatchers.any(CustomerDTO.class))).thenReturn(returnDto);

        //when/then
        mockMvc.perform(put("/api/v1/customers/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(customerDTO)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", equalTo("Donald")));
    }

    @Test
    public void patchCustomer() throws Exception{
    //given
        CustomerDTO customer = new CustomerDTO();
        customer.setFirstName("Fred");

        CustomerDTO returnDTO = new CustomerDTO();
        returnDTO.setFirstName(customer.getFirstName());
        returnDTO.setLastName("Flintstone");

        when(customerService.patchCustomer(anyLong(), ArgumentMatchers.any(CustomerDTO.class))).thenReturn(returnDTO);

        mockMvc.perform(patch("/api/v1/customers/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(customer)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", equalTo("Fred")))
                .andExpect(jsonPath("$.lastName", equalTo("Flintstone")));
    }

    @Test
    public void deleteCustomer() throws Exception{

        mockMvc.perform(delete("/api/v1/customers/1")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(customerService).deleteCustomerById(anyLong());
    }

    @Test
    public void notFound()throws Exception{

        when(customerService.getCustomerById(anyLong())).thenThrow(ResourceNotFoundException.class);

        mockMvc.perform(get("/api/v1/customers/" + "55")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}