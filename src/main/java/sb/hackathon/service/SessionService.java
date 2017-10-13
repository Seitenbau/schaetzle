package sb.hackathon.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import sb.hackathon.model.Session;
import sb.hackathon.model.Story;

@Service
public class SessionService
{
  @Autowired
  private SessionStore store;

  public void saveSession(Session session)
  {
    store.getSessionMap().put(session.getUuid(), session);
  }

  public Session getById(String sessionId)
  {
    if(sessionId.equals("test123")){
      Session session = new Session();
      session.setUuid("test123");
      session.setStories(new ArrayList<>());
      Story story = new Story();
      story.setTitle("Schätzle ist cool!");
      story.setExternalId("SCHEATZLE-123");

      session.getStories().add(story);
      return session;
    }

    return store.getSessionMap().get(sessionId);
  }
}
