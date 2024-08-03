package org.com.service;

import java.util.Optional;

import org.com.model.Flat;
import org.com.repo.FlatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlatService {

	@Autowired
	FlatRepo flatRepo;
	
	public Flat addDetail(Flat flat)
	{
		Optional<Flat> alreadyExists=flatRepo.findById(flat.getFlatId());
		System.out.println(alreadyExists);
		if(alreadyExists.isEmpty())
		{
			flatRepo.save(flat);
		}
		return flat;
	}
}
