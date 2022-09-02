package site.metacoding.red.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class BoardsController {

	// @PostMapping("/boards/{id}/delete")
	// @PostMapping("/boards/{id}/update")
	
	
	@GetMapping({"/", "/boards"}) // 메인페이지
	public String getBoardList() {
		return "boards/main";
	}
	
	@GetMapping("/boards/{id}") // 상세보기
	public String getBoardList(@PathVariable Integer id) {
		return "boards/detail";
	}
	
	@GetMapping("/boards/writeForm")
	public String writeForm() {
		return "boards/writeForm";
	}
}
