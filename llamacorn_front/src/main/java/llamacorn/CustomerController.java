package llamacorn;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CustomerController {
	
	private static Customer getCustomerbyId(long id)
	{
	    final String uri = "http://localhost:8080/customers/"+id;
	     
	    RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	     
	    Customer result = restTemplate.getForObject(uri, Customer.class);
	    
	    System.out.println(result);
	    	    
	    return result;
	}
	
	private static ArrayList<Customer> getCustomers()
	{
	    final String uri = "http://localhost:8080/customers";
	     
	    RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	     
	    ArrayList<Customer> result = restTemplate.getForObject(uri, ArrayList.class);	    
	    
	    for (Customer custo : result) {
	        System.out.println(custo.toString());
	    }
	    	    
	    return result;
	}
	
    @RequestMapping("/customer/{id}")
    public String customer(@PathVariable long id, Model model){
    	Customer customer = CustomerController.getCustomerbyId(id);
    	
        model.addAttribute("customer", customer.toString());
        model.addAttribute("idcustomer", id);
        return "customer";
    }
    
    @RequestMapping("/customers")
    public String customers(Model model){
    	ArrayList<Customer> customers = CustomerController.getCustomers();
    	
        model.addAttribute("customers", customers);
        
        return "customers";
    }

}