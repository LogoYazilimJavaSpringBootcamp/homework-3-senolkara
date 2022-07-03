package com.karakurt.homework3.RestAPI;

import com.karakurt.homework3.Business.Customer.ICustomerService;
import com.karakurt.homework3.Entities.Customer.ICustomer;
import com.karakurt.homework3.Entities.Order.IOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/customer-api")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService iCustomerService;

    @GetMapping
    public List<ICustomer> getCustomerList(){
        return this.iCustomerService.getCustomerList();
    }

    @PostMapping
    public ICustomer createCustomer(String firstName, String lastName, String email, String address, IOrder order, LocalDate createdDT){
        return this.iCustomerService.createCustomer(firstName, lastName, email, address, order, createdDT);
    }

    @PatchMapping("/{id}")
    public ICustomer updateCustomer(@PathVariable Integer id,
                                    String firstName,
                                    String lastName,
                                    String email,
                                    String address,
                                    IOrder order,
                                    LocalDate createdDT){
        return this.iCustomerService.updateCustomer(id, firstName, lastName, email, address, order, createdDT);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        this.iCustomerService.deleteCustomer(id);
    }
}
