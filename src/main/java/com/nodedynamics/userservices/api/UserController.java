package com.nodedynamics.userservices.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.nodedynamics.userservices.model.users.EndUserModel;
import com.nodedynamics.userservices.service.userservice.EndUserService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/user")
public class UserController {
	

	private final Logger log = LoggerFactory.getLogger(this.getClass());

		
	@Autowired
	Gson gson;
	
	@Autowired
	EndUserService service;
	
	@CrossOrigin(origins = "*") //TODO: NEED TO REMOVE AND INIT PROPER CORS
	@PostMapping(value = "/adduser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> AddUser(@RequestBody String request){
    	return service.Store(gson.fromJson(request, EndUserModel.class));
    }
	
    //LIST ALL USERS
	@PostMapping(value = "/getallusers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> GetAllUser(@RequestBody String request){
		return service.GetAll();
    }
	
    //LIST ALL USERS
	@PostMapping(value = "/getuser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> GetUserById(@RequestBody String request){

		return service.Get(gson.fromJson(request, EndUserModel.class));
    }
	
	//UPDATE USERS
	@PostMapping(value = "/updateuser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> UpdateUser(@RequestBody String request){
		return service.Update(gson.fromJson(request, EndUserModel.class));
	}
	
	//UPDATE USERS
	@PostMapping(value = "/deleteuser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> DeleteUserById(@RequestBody String request){
		return service.Delete(gson.fromJson(request, EndUserModel.class));
	}
		



}
