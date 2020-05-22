package net.shipper.springboot.springsecurity.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.shipper.springboot.springsecurity.model.Customer;
import net.shipper.springboot.springsecurity.service.CustomerService;
import net.shipper.springboot.springsecurity.web.dto.CustomerRegistrationDto;


@Controller
@RequestMapping("/registration-customer")
public class CustomerRegistrationController {

    @Autowired
    private CustomerService customerService;
    
    @ModelAttribute("customer")
    public CustomerRegistrationDto customerRegistrationDto() {
        return new CustomerRegistrationDto();
    }

    // Customer register page

    @GetMapping
    public String showRegCustomerForm(Model model) {
        return "registration-customer";
    }
    
    @PostMapping
    public String registerCustomerAccount(@ModelAttribute("customer") @Valid CustomerRegistrationDto customerDto,
                                      BindingResult result){

    	Customer existing = customerService.findByEmailAddress(customerDto.getEmailAddress());
        if (existing != null){
            result.rejectValue("emailAddress", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "registration-customer";
        }
        
        customerService.save(customerDto);
        return "redirect:/registration-customer?success";
    }

}
