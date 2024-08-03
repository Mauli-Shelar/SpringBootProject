package org.com.service;

import java.util.List;
import java.util.Optional;

import org.com.exceptionHandler.exception.FlatNotAvailable;
import org.com.model.Flat;
import org.com.model.Person;
import org.com.repo.FlatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlatService {

	@Autowired
	FlatRepo flatRepo;

	public Flat addDetail(Flat flat) {
		Optional<Flat> alreadyExists = flatRepo.findById(flat.getFlatId());
		System.out.println(alreadyExists);
		if (alreadyExists.isEmpty()) {
			flatRepo.save(flat);
		}
		return flat;
	}

	public List<Person> allPerson(Integer flatId) {
		Optional<Flat> flat = flatRepo.findById(flatId);
		if (flat.isPresent()) {
			List<Person> personAll = flat.get().getFamilyMembers();
			return personAll;
		} else {
			throw new FlatNotAvailable("Flat Number : " + flatId + " not available");
		}
	}
}
