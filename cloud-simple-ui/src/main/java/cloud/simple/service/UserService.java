package cloud.simple.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cloud.simple.model.User;

@Service
public class UserService {
	
	 @Autowired	 
	 RestTemplate restTemplate;
	
//	 @Autowired
//	 FeignUserService feignUserService;
	 
	 final String SERVICE_NAME="cloud-simple-service";
	 
	 @HystrixCommand(fallbackMethod = "fallbackSearchAll")
	 public List<User> readUserInfo() {
	        return restTemplate.getForObject("http://"+SERVICE_NAME+"/user", List.class);
//		 return feignUserService.readUserInfo();
	 }	 
	 private List<User> fallbackSearchAll() {
		 System.out.println("HystrixCommand fallbackMethod handle!");
		 List<User> ls = new ArrayList<User>();
		 User user = new User();
		 user.setUsername("TestHystrixCommand");
		 ls.add(user);
		 return ls;
	 }
}
