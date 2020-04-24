/**
 * 
 */
package com.ecoiyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecoiyun.entity.Dog;
import com.ecoiyun.mapper.DogMapper;
import com.ecoiyun.service.DogService;

/**
 * @author Administrator
 *
 */
@Service
public class DogServiceImpl implements DogService {
	@Autowired
	private DogMapper dogMapper;

	public Dog findById(Integer id) {
		return dogMapper.findById(id);
	}

	public List<Dog> findAll() {
		return dogMapper.findAllDogs();
	}

	@Transactional
	public void saveDog(Dog dog) {
		dogMapper.saveDog(dog);
	}

}
