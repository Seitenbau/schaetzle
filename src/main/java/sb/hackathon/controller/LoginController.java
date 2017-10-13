package sb.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import sb.hackathon.model.Session;
import sb.hackathon.model.User;
import sb.hackathon.service.LoginService;
import sb.hackathon.service.SessionService;

@Slf4j
@Controller
public class LoginController
{

  @Autowired
  private LoginService loginService;

  @Autowired
  private SessionService sessionService;

  @GetMapping("/start/{sessionId}")
  public String loginView(Model model, @PathVariable("sessionId") String sessionId)
  {
    log.info("login get");
    User user = new User();
    user.setSessionId(sessionId);
    model.addAttribute("user", user);
    return "login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute("user") User user, Model model)
  {
    log.info("login post" + user.getName());
    loginService.setUser(user);
    return "redirect:/voting";
  }

  @GetMapping("/voting")
  public String scan(Model model)
  {
    log.info("voting ");
    User user = loginService.getUser();
    model.addAttribute("user", user);
    Session session = sessionService.getById(user.getSessionId());
    model.addAttribute("sch_session", session);

    return "vote";
  }

  @PostMapping
  public String vote()
  {
    return "redirect:/voting";
  }

}
