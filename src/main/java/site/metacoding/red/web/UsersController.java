package site.metacoding.red.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;
import site.metacoding.red.domain.users.Users;
import site.metacoding.red.domain.users.UsersDao;
import site.metacoding.red.web.dto.request.users.JoinDto;
import site.metacoding.red.web.dto.request.users.LoginDto;

@RequiredArgsConstructor // DI
@Controller
public class UsersController {

	private final UsersDao usersDao; // 컴퍼지션
	private final HttpSession session; //스프링이 서버시작시에 IoC컨테이너에 보관함. 이것이 DI
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/login") // 로그인만 예외로 select인데 poast로 함.
	public String login(LoginDto loginDto) {
		Users usersPS = usersDao.login(loginDto); // DB에서 들고온건 PS를 붙여줌
		if (usersPS != null) {// 로그인 인증됨.
			session.setAttribute("principal", usersPS);
			//principal-인증된 유저
			return "redirect:/"; // boards의 main
		} else { // 인증안됨.
			return "redirect:/loginFrom";
		}
	}

	@PostMapping("/join")
	public String join(JoinDto joinDto) {
		usersDao.insert(joinDto);
		return "redirect:/loginForm";
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		return "users/loginForm";
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "users/joinForm";
	}
}
