package com.mysite.sbb;

import java.util.List;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/todo")
@RequiredArgsConstructor
@Controller
public class TodoController {
	
	private final TodoService todoService;
	

	@GetMapping("")
	public String list(Model model) {
		List<TodoEntity> todoEntityList = this.todoService.getList();
		model.addAttribute("todoEntityList", todoEntityList);
		return "todolist";
	}
	
	@PostMapping("/create")
	public String todoCreate(@RequestParam("content") String content) {
	    this.todoService.create(content);
	    return "redirect:/todo";
	}
	
	@PostMapping("/delete/{id}")
	public String todoDelete(@PathVariable Integer id) {
		this.todoService.delete(id);
		return "redirect:/todo";
	}
	
	@PostMapping("/update/{id}")
	public String todoUpdate(@RequestBody String content, @PathVariable Integer id) {
	    this.todoService.update(id, content);
	    return "redirect:/todo";
	    //Todo : 업데이트 기능 구현
	}
}

