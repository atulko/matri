package com.address.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.address.entity.Address;
import com.address.service.AddressService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/address")
public class AddressController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

	@Autowired
	private AddressService service;


	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this endpoint is not secure";
	}

	@PostMapping("/saveAddress")
	@ResponseStatus(HttpStatus.CREATED)
	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Address saveAddress(@RequestBody Address address) {
		return service.saveAddress(address);
	}

	/*
	 * @PostMapping("/new") public String addNewUser(@RequestBody UserInfo userInfo)
	 * { return service.addUser(userInfo); }
	 */

	@PostMapping("/saveAllAddress")
	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Address> addAddresses(@RequestBody List<Address> addresses) {
		return service.saveAddresses(addresses);
	}

	@GetMapping("/getAllAddress")
	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<Address>> findAllAddress() {
		return ResponseEntity.ok(service.getAddress());
	}

	@GetMapping("/addressById/{id}")
	// @PreAuthorize("hasAuthority('ROLE_USER')")
	public Address findAddressById(@PathVariable int id) {
		return service.getAddressById(id);
	}

	@GetMapping("/address/{city}")
	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Address findAddressByCity(@PathVariable String city) {
		return service.getAddressByCity(city);
	}

	@PutMapping("/update")
	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Address updateAddress(@RequestBody Address address) {
		return service.updateAddress(address);
	}

	@DeleteMapping("/delete/{id}")
	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String deleteAddress(@PathVariable int id) {
		return service.deleteAddress(id);
	}

	/*
	 * @GetMapping("/address/{employeeId}") public ResponseEntity<AddressResponse>
	 * getAddressByEmployeeId(@PathVariable("employeeId") int employeeId) {
	 * AddressResponse addressResponse = service.findAddressByBrideId(employeeId);
	 * return ResponseEntity.status(HttpStatus.OK).body(addressResponse); }
	 */

	/*
	 * @GetMapping("/with-brides") // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	 * public List<Address> findAllWithBrides() {
	 * LOGGER.info("All address with Bride"); List<Address> addressList=
	 * service.getAddress();
	 * addressList.forEach(address->address.setBrideList(brideClient.findByAddressId
	 * (address.getAddressId()))); return addressList; }
	 */
}
