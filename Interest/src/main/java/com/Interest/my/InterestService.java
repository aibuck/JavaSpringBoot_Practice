package com.Interest.my;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InterestService {
	private final InterestRepository interestRepository;
	
	public List<InterestEntity> getList(){
		return this.interestRepository.findAll();
	}
	
	public void addInter(InterestEntity interestEntity) {
		this.interestRepository.save(interestEntity);
	}
	
	public InterestEntity getInter(Integer id) {
		Optional<InterestEntity> defInter=
				this.interestRepository.findById(id);
		if(defInter.isPresent()) {
			return defInter.get();
		}else {
			return null;
		}
	}
	
	public void updateInter(InterestEntity interestEntity, String name, String chemi, String about) {
		interestEntity.setName(name);
		interestEntity.setChemi(chemi);
		interestEntity.setAbout(about);
		this.interestRepository.save(interestEntity);
	}
	
	public void deleteInter(InterestEntity interestEntity) {
		this.interestRepository.delete(interestEntity);
	}


		
}

