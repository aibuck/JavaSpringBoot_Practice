package com.mysite.sbb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoListApplicationTests {
	
	@Autowired
	private TodoRepository todoRepository;

	@Test
	void contextLoads() {
		TodoEntity todo1 = new TodoEntity();
		todo1.setContent("밥먹기");
		todo1.setCompleted(Boolean.TRUE);
		this.todoRepository.save(todo1);
		
		TodoEntity todo2 = new TodoEntity();
		todo2.setContent("밥먹기");
		todo2.setCompleted(Boolean.TRUE);
		this.todoRepository.save(todo2);
	}

}
