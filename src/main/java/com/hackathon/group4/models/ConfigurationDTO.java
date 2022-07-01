package com.hackathon.group4.models;

import java.util.List;
import lombok.Data;

@Data
public class ConfigurationDTO {

  private Integer idMessage;

  private Integer type;

  private String title;

  private String message;

  private Integer idUser;

  private List<ContactDTO> contacts;

}
