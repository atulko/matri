package com.address.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.address.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	Address findByCity(String name);

	@Query(nativeQuery = true, value = "SELECT ea.id, ea.city, ea.state FROM gfgmicroservicesdemo.address ea join gfgmicroservicesdemo.bride e on e.id = ea.bride_id where ea.bride_id=:brideId")
	Optional<Address> findAddressByBrideId(@Param("brideId") int brideId);

}
