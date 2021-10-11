package com.store_keepers.stockmanagementsystem.integrationTest;

import com.store_keepers.stockmanagementsystem.domains.Customer;
import com.store_keepers.stockmanagementsystem.services.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
public class CustomerRepository_IT {

    @Autowired
    private CustomerService customerService;

    @Test
    public void shouldReturnValidCustomerInfo(){
        // Given
        Customer customer = Customer.builder()
                .firstName("Lakech")
                .middleName("Abera")
                .phoneNumber("0923211223")
                .itemName("1223/20")
                .date(LocalDate.now())
                .build();


        //When
        Customer customer1 = customerService.createCustomer(customer);

        //then
        assertEquals(customer.getFirstName(), customer1.getFirstName());
        assertThat(customer.getId().equals(customer1.getId()));
    }
}
