package com.hackathon.group4.service;

import com.hackathon.group4.models.ConfigurationDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ConfigurationService {

  public ResponseEntity create(ConfigurationDTO configuration);

  public ResponseEntity update(ConfigurationDTO configuration);

  public ResponseEntity<List<ConfigurationDTO>> findByUserId(Integer userId);

}
