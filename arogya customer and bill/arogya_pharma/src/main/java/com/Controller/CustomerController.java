package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Customer;
import com.service.customerService;
@RestController
@RequestMapping(value="customer")
public class CustomerController {
	
	
	@Autowired
	customerService cs;
	
	@GetMapping(value="display",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAllcustomer()
	{
		return cs.showCustomers();
	}
	
	@PostMapping(value="insert",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insertCust(@RequestBody Customer ct )
	{
		return cs.addCustomer(ct);
	}
	
	@PutMapping(value="update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateCust(@RequestBody Customer ct)
	{
		return cs.updateCustomer(ct);
	}
	
	@DeleteMapping(value="delete/{id}")
	public String deleteCust(@PathVariable("id") int cust_id)
	{
		return cs.deleteCustomer(cust_id);
	}
	

}
