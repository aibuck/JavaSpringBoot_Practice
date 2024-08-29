package com.Interest.my;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController

public class InterestController {
	private final InterestService interestService;
	
	@GetMapping(path="/inters")
	public List<InterestEntity> getUserList(){
		List<InterestEntity> questionList = this.interestService.getList();
		return questionList;
	}
	
	@PostMapping(path="/addinter")
	public InterestEntity addUser(@RequestBody InterestEntity InterestEntity) {
		this.interestService.addInter(InterestEntity);
		return InterestEntity;
	}
	
	@PostMapping(path="/updateinter/{id}")
	public Integer updateUser(@PathVariable("id") Integer id, @RequestBody InterestEntity InterestEntity) {
		InterestEntity myinter = this.interestService.getInter(id);
		
		if(myinter != null) {
			this.interestService.updateInter(myinter, InterestEntity.getName(), InterestEntity.getChemi(), InterestEntity.getAbout());
		}
		return id;
	}
		
	@PostMapping(path="/deleteinter/{id}")
	public Integer deleteUser(@PathVariable("id") Integer id) {
		InterestEntity myinter = this.interestService.getInter(id);
		if(myinter != null) {
			this.interestService.deleteInter(myinter);
		}
		return id;
	}
}
