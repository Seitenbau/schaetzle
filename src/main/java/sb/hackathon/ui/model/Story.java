package sb.hackathon.ui.model;


import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Story
{
  private String uuid;

  private String externalId;

  private String externalUrl;

  private String title;

  private String content;

  private List<Estimate> estimates = new ArrayList<>();

  private Integer resultingEstimate;
}
