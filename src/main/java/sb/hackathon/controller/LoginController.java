package sb.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import sb.hackathon.model.Session;
import sb.hackathon.model.User;
import sb.hackathon.service.LoginService;

@Slf4j
@Controller
public class LoginController
{

  @Autowired
  private LoginService loginService;

  @GetMapping("/start")
  public String loginView(Model model)
  {
    log.info("login get");
    model.addAttribute("user", new User());
    return "login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute("user") User user, Model model)
  {
    log.info("login hallo " + user.getName());
    loginService.setUser(user);
    return "redirect:/scan";
  }

  @GetMapping("/scan")
  public String scan(Model model)
  {
    log.info("scan ");
    User user = loginService.getUser();
    model.addAttribute("user", user);
    model.addAttribute("session", new Session());

    return "scan";
  }

}
