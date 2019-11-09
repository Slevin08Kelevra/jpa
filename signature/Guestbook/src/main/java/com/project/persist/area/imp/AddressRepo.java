package com.project.persist.area.imp;

import org.springframework.data.repository.CrudRepository;

import com.project.persist.area.repo.Address;

public interface AddressRepo extends CrudRepository<Address, Long> {
}
