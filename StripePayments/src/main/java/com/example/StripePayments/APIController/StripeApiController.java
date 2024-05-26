package com.example.StripePayments.APIController;

import com.example.StripePayments.Model.Customer;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StripeApiController {

    @GetMapping("/createCustomer")
    public Customer createCustomer(@RequestBody Customer customerData) throws StripeException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", customerData.getName());
        params.put("email", customerData.getEmail());
        Customer customer = Customer.create(params);
    }
}
