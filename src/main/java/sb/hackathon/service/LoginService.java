package sb.hackathon.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import sb.hackathon.model.User;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoginService
{
  @Setter
  @Getter
  private User user;

}
