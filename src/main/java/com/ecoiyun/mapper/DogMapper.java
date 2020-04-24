/**
 * 
 */
package com.ecoiyun.mapper;

import java.util.List;

import com.ecoiyun.entity.Dog;

/**
 * @author Administrator
 *
 */
public interface DogMapper {
	public List<Dog> findAllDogs();

	public Dog findById(Integer id);

	public void saveDog(Dog dog);

}
