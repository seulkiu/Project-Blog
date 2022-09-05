package site.metacoding.red.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import site.metacoding.red.domain.users.Users;

@RequiredArgsConstructor
@Controller
public class BoardsController {
	
	private final HttpSession session;

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
		Users principal = (Users) session.getAttribute("principal");
		if(principal == null) {
			return "redirect:/loginForm";
		}else {
			return "boards/writeForm";
		}
		
	}
}
