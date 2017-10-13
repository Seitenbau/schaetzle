package sb.hackathon.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Session
{
  private String uuid;

  private List<Story> stories = new ArrayList<>();

  public Story storyForEstimation()
  {
    return stories.stream()
        .filter(s -> s.getEstimates().isEmpty())
        .findFirst().orElseGet(() -> stories.get(0));
  }

  private User scrumMaster;

  private List<User> users = new ArrayList<>();
}
