package coms309.demo20.controller;

import coms309.demo20.model.CustomerContact;
import coms309.demo20.model.MailAddress;
import coms309.demo20.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;


    @GetMapping("customer/info")
    List<CustomerContact> GetAllCustomer(){
        return customerRepository.findAll();
    }


    @PostMapping("customer/post/info/{n}/{p}/{num}/{str}/{city}/{stat}/{zip}")
    CustomerContact PostContactByPath(@PathVariable String n, @PathVariable String p, @PathVariable int num, @PathVariable String str, @PathVariable String city, @PathVariable String stat, @PathVariable int zip){
        CustomerContact csc = new CustomerContact();
        csc.setName(n);
        csc.setPhone(p);
        csc.setShopDate(num);
        MailAddress mas = new MailAddress();
        mas.setStreet(str);
        mas.setCity(city);
        mas.setState(stat);
        mas.setZipCode(zip);
        csc.setAddress(mas);
        customerRepository.save(csc);
        return csc;
    }

    @PostMapping("customer/info/post/{str}/{city}/{stat}/{zip}")
    CustomerContact PostContactByPath(@RequestBody CustomerContact newCont, @PathVariable String str, @PathVariable String city, @PathVariable String stat, @PathVariable int zip){
        MailAddress mas = new MailAddress();
        mas.setStreet(str);
        mas.setCity(city);
        mas.setState(stat);
        mas.setZipCode(zip);
        newCont.setAddress(mas);
        customerRepository.save(newCont);
        return newCont;
    }

}
