/**
 * 
 */
package com.ecoiyun.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecoiyun.entity.Dog;
import com.ecoiyun.service.DogService;

/**
 * @author Administrator
 *
 */
public class DogController {
	@Autowired
	private DogService dogService;

	@RequestMapping("/findById/{id}")
	@ResponseBody
	public Dog findDogById(@PathVariable("id") Integer id) {
		return dogService.findById(id);
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public List<Dog> findAll() {
		return dogService.findAll();
	}

	@RequestMapping("/saveDog/{name}/{age}")
	public String saveDog(@PathVariable("name") String name, @PathVariable("age") String age) {
		Dog dog = new Dog();
		dog.setName(name);
		dog.setAge(age);
		dogService.saveDog(dog);
		return "addSuccess";
	}

}
