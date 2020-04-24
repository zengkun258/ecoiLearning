/**
 * 
 */
package com.ecoiyun.service;

import java.util.List;

import com.ecoiyun.entity.Dog;

/**
 * @author Administrator
 *
 */
public interface DogService {
	public Dog findById(Integer id);

	public List<Dog> findAll();

	public void saveDog(Dog dog);
}
