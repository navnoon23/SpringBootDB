package demo.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import demo.bean.Customer;
import demo.service.CustomerService;


@Controller
public class CustomerController {

	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy hh:mm:ss a");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy");
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value="home.do", method=RequestMethod.GET)
	public String home(Map<String, Object> model) {
		model.put("curtime", sdf.format(new Date()));
		model.put("list", customerService.findAll());
		
		return "customer";
	}
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
	public String add(@RequestParam String firstName, 
			@RequestParam String lastName, 
			@RequestParam String birthDate, 
			@RequestParam String gender){
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setGender(gender);
		try {
			customer.setBirthDate(sdf2.parse(birthDate));
		} catch( Exception ignore) {}
		
		customerService.save(customer);
		
		return "redirect:home.do";
	}
	
	@RequestMapping(value = "delete.do", method = RequestMethod.POST)
	public String delete(@RequestParam Long customerId) {
		customerService.deleteById(customerId);
		
		return "redirect:home.do";
	}
}
