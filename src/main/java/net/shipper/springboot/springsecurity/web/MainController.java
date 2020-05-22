package net.shipper.springboot.springsecurity.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import net.shipper.springboot.springsecurity.config.Common;
import net.shipper.springboot.springsecurity.model.BillingMethod;
import net.shipper.springboot.springsecurity.model.Customer;
import net.shipper.springboot.springsecurity.model.CustomerAccount;
import net.shipper.springboot.springsecurity.model.Manifest;
import net.shipper.springboot.springsecurity.model.ShipmentStatus;
import net.shipper.springboot.springsecurity.model.Shipping;
import net.shipper.springboot.springsecurity.model.Status;
import net.shipper.springboot.springsecurity.service.CustomerAccountService;
import net.shipper.springboot.springsecurity.service.CustomerService;
import net.shipper.springboot.springsecurity.service.ManifestService;
import net.shipper.springboot.springsecurity.service.ShipmentStatusService;
import net.shipper.springboot.springsecurity.service.ShippingService;
import net.shipper.springboot.springsecurity.web.dto.CustomerAccountDto;
import net.shipper.springboot.springsecurity.web.dto.ShippingDto;

@Controller
public class MainController {

	@Autowired
    CustomerService customerService;
	
	@Autowired
    ShippingService shippingService;
	

	@Autowired
    CustomerAccountService customerAccountService;
	
	@Autowired
	ManifestService manifestService;
	
	@Autowired
	ShipmentStatusService shipmentStatusService;
	
	private Customer loggedCustomer = null;
	
	@GetMapping("/bdz")
    public String mainPage() {
        return "main";
    }
	
	
    @GetMapping("/")
    public ModelAndView root() {
    	ModelAndView modelAndView = new ModelAndView();
        List<Shipping> shippingList = shippingService.findAll();
        for (int i = 0; i < shippingList.size(); i ++) {
        	String trackNumber = shippingList.get(i).getTrackingNumber();
        	List<ShipmentStatus> statusList = shipmentStatusService.findAllByShippingId(trackNumber);
        	shippingList.get(i).setShipmentStatus(statusList.get(statusList.size() - 1).getStatus().toString());
        }
        modelAndView.addObject("shippingLists",shippingList);
        List<Manifest> manifestList = manifestService.findAll();
        List<ShipmentStatus> shipmentStatusList = shipmentStatusService.findAll();
        Manifest manifest = new Manifest();
        modelAndView.addObject("manifest",manifest);
        modelAndView.addObject("manifestList",manifestList);
        modelAndView.addObject("shipmentStatusList", shipmentStatusList);
        modelAndView.setViewName("adminPage");
        return modelAndView;
    }
    
    @GetMapping("/customerPage")
    public ModelAndView customerPage(Model model) { 
    	if (loggedCustomer == null) {
    		return new ModelAndView("redirect:/login-customer");
    	} else { 
    		ModelAndView modelAndView = new ModelAndView();
    		Shipping shipping = new Shipping();
            modelAndView.addObject("shipping",shipping);
            CustomerAccount customerAccount= new CustomerAccount();
            customerAccount.setCustomerid( Common.customerId);
            modelAndView.addObject("customerAccount",customerAccount); 
            
            List<Shipping> myShippingList = shippingService.findAllByCustomerId((int)Common.customerId);
            for (int i = 0; i < myShippingList.size(); i ++) {
            	String trackNumber = myShippingList.get(i).getTrackingNumber();
            	List<ShipmentStatus> statusList = shipmentStatusService.findAllByShippingId(trackNumber);
            	myShippingList.get(i).setShipmentStatus(statusList.get(statusList.size() - 1).getStatus().toString());
            }
            modelAndView.addObject("shippingMyLists",myShippingList);  
            List<CustomerAccount> customerAccountList = customerAccountService.findAllByCustomerid((long)Common.customerId); 
            Double totalAccountBalance=Double.valueOf(0);
            for (CustomerAccount customerAccountDetails : customerAccountList) {
            	BillingMethod billingMethod=customerAccountDetails.getBillingMethod();
            	int customerId=(int) customerAccountDetails.getCustomerid();
            	Double accountBalance=Double.valueOf(0);
            	accountBalance=shippingService.sumByBillingMethodAndCustomerId(billingMethod.ordinal(), customerId);
            	totalAccountBalance=(!StringUtils.isEmpty(accountBalance)?totalAccountBalance+accountBalance:totalAccountBalance);
            	customerAccountDetails.setAccountBalance(!StringUtils.isEmpty(accountBalance)?accountBalance:0);
            }
            modelAndView.addObject("totalAccountBalance",totalAccountBalance);
            modelAndView.addObject("customerAccountList",customerAccountList); 
            
            modelAndView.setViewName("customerPage");
            return modelAndView;
    	}    
    }
    
    // Update Shipping Request
    @GetMapping("/updateShipping/{trackingNumber}")
    public ModelAndView updateShipping(@PathVariable("trackingNumber") String trackingNumber){
    	ModelAndView modelAndView = new ModelAndView();
    	Shipping shipping  = shippingService.findByTrackingNumber(trackingNumber);
    	ShippingDto dto = new ShippingDto();
    	dto.setTrackingNumber(shipping.getTrackingNumber());
    	dto.setDescription(shipping.getDescription());
    	dto.setDimensions(shipping.getDimensions());
    	dto.setOrigin(shipping.getOrigin().toString());
    	dto.setDestination(shipping.getDestination().toString());
    	dto.setCustomerId(shipping.getCustomerId());
        modelAndView.addObject("shipping",dto);
        List<Shipping> myShippingList = shippingService.findAllByCustomerId((int)Common.customerId);
        modelAndView.addObject("shippingMyLists",myShippingList);
        modelAndView.setViewName("customerPage");
        return modelAndView;
    }
    
    // Search Shipping Request
    @GetMapping("/searchShipping/{trackingNumber}")
    public ModelAndView searchShipping(@PathVariable("trackingNumber") String trackingNumber){
    	ModelAndView modelAndView = new ModelAndView();
    	Shipping shipping  = shippingService.findByTrackingNumber(trackingNumber);
    	if (shipping != null) {
    		ShippingDto dto = new ShippingDto();
	    	dto.setTrackingNumber(shipping.getTrackingNumber());
	    	dto.setDescription(shipping.getDescription());
	    	dto.setDimensions(shipping.getDimensions());
	    	dto.setOrigin(shipping.getOrigin().toString());
	    	dto.setDestination(shipping.getDestination().toString());
	    	dto.setCustomerId(shipping.getCustomerId());
	    	String dtStr = new SimpleDateFormat("yyyy-MM-dd").format(shipping.getShipmentDate());
	    	dto.setShipmentDate(dtStr);
	    	
	        modelAndView.addObject("shipping",dto);
    	}
    	
    	modelAndView.setViewName("main");
    	
        return modelAndView;
    }
    
 // Search Manifest
    @GetMapping("/searchManifest/{manifestNumber}")
    public ModelAndView searchManifest(@PathVariable("manifestNumber") String manifestNumber){
    	ModelAndView modelAndView = new ModelAndView();
    	Manifest manifest  = manifestService.findByManifestNumber(manifestNumber);
    	if (manifest != null) {
    		modelAndView.addObject("manifest", manifest);
    		List<Shipping> shipments = shippingService.findAll();
    		shipments.clear();
    		String shipmentStr = manifest.getShipments();
    		String[] shipmentArr = shipmentStr.split(",");
    		for (int i = 0; i < shipmentArr.length; i ++) {
    			if (shipmentArr[i] != "") {
    				Shipping shipment = shippingService.findByTrackingNumber(shipmentArr[i]);
    				if (shipment != null) {
    					List<ShipmentStatus> statusList = shipmentStatusService.findAllByShippingId(shipment.getTrackingNumber());
                    	shipment.setShipmentStatus(statusList.get(statusList.size() - 1).getStatus().toString());
        				shipments.add(shipment);
    				} else {
    					return new ModelAndView("redirect:/");
    				}
    			}
    		}
	        modelAndView.addObject("shippingLists", shipments);
	        modelAndView.setViewName("manifest");
	        return modelAndView;
    	}
    	
    	return new ModelAndView("redirect:/");
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
    
    
    @GetMapping("/login-customer")
    public ModelAndView loginCustomer(Model model) {
  
    	if (loggedCustomer != null) {
    		return new ModelAndView("redirect:/customerPage");
    	}
    	return new ModelAndView();
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
    
    // Customer Login POST API
    @PostMapping("/login-customer")
    public ModelAndView loginCustomer(@ModelAttribute("customer") Customer customer){
    	Customer existing = customerService.findByEmailAddress(customer.getEmailAddress());
    	if (existing != null) {
    		loggedCustomer = customer;
    		Common.customerId = existing.getCustomerID();
    		return new ModelAndView("redirect:/customerPage");
    	}
    	return new ModelAndView();
    }
    
    // Add Shipping POST API
    @PostMapping("/customerPage")
    public ModelAndView addShipping(@ModelAttribute("shipping") ShippingDto shippingDto){
    	ShipmentStatus shipmentStatus = new ShipmentStatus();
    	shipmentStatus.setStatus(Status.Request_Made);
    	shipmentStatus.setShippingId(shippingDto.getTrackingNumber());
    	shipmentStatusService.saveShipmentStatus(shipmentStatus);
    	// shippingDto.setShipmentStatusId(shipmentStatus.getId());
    	shippingService.saveShipping(shippingDto);
    	
    	return new ModelAndView("redirect:/customerPage");
    }
    
    // Add Shipping POST API
    @PostMapping("/addCustomerAccount")
    public ModelAndView addCustomerAccount(@ModelAttribute("customerAccount") CustomerAccountDto customerAccountDto){
    	 System.out.println("************ addCustomerAccount* "+customerAccountDto);
    	 System.out.println("************ addCustomerAccount* "+customerAccountDto.getAccountBalance());
    	 System.out.println("************ addCustomerAccount* "+customerAccountDto.getAccountID()); 
    	 System.out.println("************ addCustomerAccount* "+customerAccountDto.getBillingMethod());
    	 
    	customerAccountService.saveCustomerAccount(customerAccountDto);
    	
    	return new ModelAndView("redirect:/customerPage");
    }
    
    
    
    @PostMapping("/logout-customer")
    public ModelAndView logoutCustomerPost() {
		loggedCustomer = null;
        return new ModelAndView("redirect:/bdz");
    }
    
    @PostMapping("/addmanifest")
    public ModelAndView addManifest(@ModelAttribute("manifest") Manifest manifest) {
    	
		manifestService.saveManifest(manifest);
		
		return new ModelAndView("redirect:/");
    }
    
    @PostMapping("/changeShipmentStatus")
    public ModelAndView changeShipmentStatus(@ModelAttribute("shipmentStatus") ShipmentStatus shipmentStatus) {
    	
    	shipmentStatusService.saveShipmentStatus(shipmentStatus);
    	
        return new ModelAndView("redirect:/");
    }
    
    @PostMapping("/changePrice")
    public ModelAndView changeShipmentStatus(@ModelAttribute("shipping") ShippingDto shippingDto) {
    	
    	shippingService.updateShippingPrice(shippingDto);
    	
        return new ModelAndView("redirect:/");
    }
    
 // View Detail Shipment
    @GetMapping("/detailShipment/{trackingNumber}")
    public ModelAndView detailShipment(@PathVariable("trackingNumber") String trackingNumber){
    	ModelAndView modelAndView = new ModelAndView();
    	Shipping shipping  = shippingService.findByTrackingNumber(trackingNumber);
    	if (shipping != null) {
    		List<ShipmentStatus> statusList = shipmentStatusService.findAllByShippingId(trackingNumber);
    		ShippingDto dto = new ShippingDto();
	    	dto.setTrackingNumber(shipping.getTrackingNumber());
	    	dto.setDescription(shipping.getDescription());
	    	dto.setDimensions(shipping.getDimensions());
	    	dto.setOrigin(shipping.getOrigin().toString());
	    	dto.setDestination(shipping.getDestination().toString());
	    	dto.setCustomerId(shipping.getCustomerId());
	    	dto.setPrice(shipping.getPrice());

	        modelAndView.addObject("shipping",dto);
	        modelAndView.addObject("statusList",statusList);
	        modelAndView.setViewName("detailShipment");
    	} else {
    		modelAndView.setViewName("adminPage");
    	}

        return modelAndView;
    }
    
    
    // View Detail Shipment
    @GetMapping("/invoice/{trackingNumber}")
    public ModelAndView invoice(@PathVariable("trackingNumber") String trackingNumber){
    	ModelAndView modelAndView = new ModelAndView();
    	Shipping shipping  = shippingService.findByTrackingNumber(trackingNumber);
    	if (shipping != null) {
    		List<ShipmentStatus> statusList = shipmentStatusService.findAllByShippingId(trackingNumber);
    		ShippingDto dto = new ShippingDto();
	    	dto.setTrackingNumber(shipping.getTrackingNumber());
	    	dto.setDescription(shipping.getDescription());
	    	dto.setDimensions(shipping.getDimensions());
	    	dto.setOrigin(shipping.getOrigin().toString());
	    	dto.setDestination(shipping.getDestination().toString());
	    	dto.setCustomerId(shipping.getCustomerId());
	    	dto.setPrice(shipping.getPrice());

	        Long numInLong = Long.valueOf(shipping.getCustomerId());
	    	Customer customer = customerService.findBycustomerID(numInLong);
            modelAndView.addObject("customer",customer); 
            
            
	        modelAndView.addObject("shipping",dto);
	        modelAndView.addObject("statusList",statusList);
	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	        String strDate= formatter.format(new Date()); 
	        modelAndView.addObject("date",strDate);
	        modelAndView.setViewName("invoice");
    	} else {
    		modelAndView.setViewName("adminPage");
    	}

        return modelAndView;
    }
}
