package com.hackathon.group4.controllers;

import com.hackathon.group4.models.ConfigurationDTO;
import com.hackathon.group4.service.ConfigurationService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

  private final ConfigurationService configurationService;

  public ConfigurationController(
      ConfigurationService configurationService) {
    this.configurationService = configurationService;
  }

  @PostMapping("/create")
  public ResponseEntity create(@RequestBody ConfigurationDTO configuration) {
    return this.configurationService.create(configuration);
  }

  @PutMapping("/update")
  public ResponseEntity update(@RequestBody ConfigurationDTO configuration) {
    return this.configurationService.create(configuration);
  }

  @GetMapping("/find/user/{userId}")
  public ResponseEntity<List<ConfigurationDTO>> findByUserId(
      @PathVariable("userId") Integer userId) {
    return this.configurationService.findByUserId(userId);
  }

}
