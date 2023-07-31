package com.se.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.se.entity.Customer;
import com.se.entity.Token;
import com.se.service.CustomerService;
import com.se.service.JwtService;
import com.se.service.MailerService;
import com.se.service.TokenService;

@Controller
public class HomeController {
	@Autowired
	CustomerService Cservice;
	@Autowired
	HttpServletRequest req;
	@Autowired
	BCryptPasswordEncoder pe;
	@Autowired
	MailerService mailer;
	@RequestMapping({ "/admin", "/admin/home/index" })
	public String admin(Model model) {
		String maKH = req.getRemoteUser();
		Customer item = Cservice.FindCustomeṛ̣̣̣ById(maKH);
		Boolean flag = req.isUserInRole("ADMIN");
		String role = "ADMIN";
		if (flag) {
			model.addAttribute("quyen", role);
		} else {
			role = "STAF";
			model.addAttribute("quyen", role);
		}
		model.addAttribute("acc", item);

		return "../static/admin/layout_admin";
	}
	/*
	 * @RequestMapping({ "/home" }) public String home(Model model) {
	 * 
	 * return "../static/admin/layout_admin"; }
	 */
	@RequestMapping("/user/sign-in")
	public String login(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập!");
		return "users/sign-in";
	}
	@RequestMapping("/user/sign-in/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công!");
		return "redirect:/user/home";
	}
	@RequestMapping("/user/logoff/success")
	public String logoff(Model model) {
		return "redirect:/user/home";
	}
	@RequestMapping("/user/sign-up")
	public String signup(Model model) {
		return "users/sign-up";
	}
	@RequestMapping({"/user/home","/"})
	public String home(Model model) {
		return "users/index";
	}
	@RequestMapping("/user/unauthoried")
	public String unauthoried(Model model) {
		return "redirect:/user/home";
	}
	@Autowired
    private JwtService jwtservice;

    @Autowired
    private TokenService tokenService;
    
	@PostMapping(value = "/rest/login")
    public ResponseEntity<String> login(@RequestBody Customer user, HttpServletRequest request){
		String result = "";
		HttpStatus httpStatus = null;
		try {
			Customer login = Cservice.FindCustomeṛ̣̣̣ById(user.getMaKhachHang());
			System.out.println(login.getPassword());
			System.out.println(user.getPassword());
			  if (user == null || login == null) {
		            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		                    .body("Account does not exist please create an account!");
		        }else if (user.getPassword().equalsIgnoreCase(login.getPassword())) {
		        	result = jwtservice.generateToken(user.getMaKhachHang());
		        	System.err.println(result);
		        	httpStatus = HttpStatus.OK;
		        	 Token token = new Token();
				        token.setToken(jwtservice.generateToken(user.getMaKhachHang()));
				        token.setTokenExpDate(jwtservice.generateExpirationDate());
				        token.setCustomer(user);
				        token.setCreatedAt(new Date());
				        tokenService.createToken(token);
				        return new ResponseEntity<String>(result , httpStatus);
				}else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST)
		                    .body("password is not valid!");
				} 
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro!");
		}
      
    }

}
