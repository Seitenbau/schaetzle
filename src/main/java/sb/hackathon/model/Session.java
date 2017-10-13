package sb.hackathon.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Session
{
  private String uuid;

  private List<Story> stories = new ArrayList<>();

  private User scrumMaster;

  private List<User> users = new ArrayList<>();
}
