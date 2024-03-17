package com.address.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.address.entity.Address;
import com.address.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;

	/*
	 * @Autowired private ModelMapper mapper;
	 */
	// @Autowired
	// private UserInfoRepository repo;

	// @Autowired
	// private PasswordEncoder passwordEncoder;

	public Address saveAddress(Address address) {
		System.out.println("Address-service called:");
		return repository.save(address);
	}

	public List<Address> saveAddresses(List<Address> addresses) {
		return repository.saveAll(addresses);
	}

	public List<Address> getAddress() {
		return repository.findAll();
	}

	public Address getAddressById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Address getAddressByCity(String city) {
		return repository.findByCity(city);
	}

	public String deleteAddress(int id) {
		repository.deleteById(id);
		return "address removed !! " + id;
	}

	public Address updateAddress(Address address) {
		System.out.println("Address loaded from request body is:" + address);
		Address existingAddress = repository.findById(address.getAddressId()).orElse(null);
		existingAddress.setCity(address.getCity());
		existingAddress.setDistrict(address.getDistrict());
		existingAddress.setCountry(address.getCountry());
		return repository.save(existingAddress);
	}

	/*
	 * public String addUser(UserInfo userInfo) {
	 * userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
	 * repo.save(userInfo); return "user added to system "; }
	 */

	/*
	 * public AddressResponse findAddressByBrideId(int brideId) { Optional<Address>
	 * addressByBrideId = repository.findAddressByBrideId(brideId); AddressResponse
	 * addressResponse = mapper.map(addressByBrideId, AddressResponse.class); return
	 * addressResponse; }
	 */

}
