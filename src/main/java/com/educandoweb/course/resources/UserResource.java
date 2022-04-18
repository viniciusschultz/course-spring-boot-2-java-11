package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		//User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		//A mockagem acima foi comentada pois foi criada a classe UserService
		//que faz a injeção da dependência com a classe de UserResource.
		//A classe UserService é a camada de serviço e é um intermediário entre 
		//Resource Layer (Rest Controller) a DataBase Layer (data repositories) que contém as regras de negócio
				
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);		
		return ResponseEntity.ok().body(obj);
	}

}
