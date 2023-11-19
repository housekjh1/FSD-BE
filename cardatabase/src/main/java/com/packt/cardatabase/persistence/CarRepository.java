package com.packt.cardatabase.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.packt.cardatabase.domain.Car;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long>, PagingAndSortingRepository<Car, Long> {
	List<Car> findByBrand(@Param("brand") String brand);

	List<Car> findByColor(@Param("color") String color);

	List<Car> findByYyyy(Integer yyyy);

	List<Car> findByBrandAndModel(String brand, String model);

	List<Car> findByBrandOrColor(String brand, String color);

	List<Car> findByBrandOrderByYyyyAsc(String brand);

	@Query("select c from Car c where c.brand = ?1")
	List<Car> findByBrand1(String brand);

	@Query("select c from Car c where c.brand like %?1")
	List<Car> findByBrandEndsWith(String brand);
	
	
}
