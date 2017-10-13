package sb.hackathon.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import lombok.Getter;
import sb.hackathon.model.Session;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionStore
{
  @Getter
  private Map<String, Session> sessionMap = new HashMap<>();
}
