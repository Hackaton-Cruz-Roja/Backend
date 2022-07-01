package com.hackathon.group4.service;

import com.hackathon.group4.models.ConfigurationDTO;
import com.hackathon.group4.models.ContactDTO;
import com.hackathon.group4.models.DAOContact;
import com.hackathon.group4.models.DAOMessage;
import com.hackathon.group4.models.DAOUser;
import com.hackathon.group4.repositories.ContactRepository;
import com.hackathon.group4.repositories.MessageRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

  private MessageRepository messageRepository;

  public ConfigurationServiceImpl(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  @Override
  public ResponseEntity create(ConfigurationDTO configuration) {
    try {
      DAOMessage message = this.mapToMessageEntity(configuration);
      this.messageRepository.save(message);
      return new ResponseEntity(null, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @Override
  public ResponseEntity update(ConfigurationDTO configuration) {
    try {
      DAOMessage message = this.mapToMessageEntity(configuration);
      this.messageRepository.save(message);
      return new ResponseEntity(null, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<List<ConfigurationDTO>> findByUserId(Integer userId) {
    try {
      List<DAOMessage> daoMessages = this.messageRepository.findByUserId(userId);
      List<ConfigurationDTO> configurations = new ArrayList<>();
      for (DAOMessage message: daoMessages) {
        ConfigurationDTO configuration = mapToConfiguration(message);
        configurations.add(configuration);
      }
      return new ResponseEntity<>(configurations, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  private DAOMessage mapToMessageEntity(ConfigurationDTO configuration) {
    DAOMessage message = new DAOMessage();
    message.setIdMessage(configuration.getIdMessage());
    message.setMessage(configuration.getMessage());
    DAOUser user = new DAOUser();
    user.setIdUser(configuration.getIdUser());
    message.setUser(user);
    message.setTitle(configuration.getTitle());
    List<DAOContact> daoContacts = new ArrayList<>();
    List<ContactDTO> contactsDTO = configuration.getContacts();
    for(ContactDTO contactDTO :contactsDTO) {
      DAOContact contact = this.maptoContactEntity(contactDTO);
      daoContacts.add(contact);
    }
    message.setContact(daoContacts);
    return message;
  }

  private DAOContact maptoContactEntity(ContactDTO contactDTO) {
    DAOContact contact = new DAOContact();
    contact.setIdContact(contactDTO.getIdContact());
    contact.setFullname(contactDTO.getFullname());
    contact.setPhone(contactDTO.getPhone());
    contact.setPhoto(contactDTO.getPhoto());
    return contact;
  }

  private ConfigurationDTO mapToConfiguration(DAOMessage daoMessage) {
    ConfigurationDTO configurationDTO = new ConfigurationDTO();
    configurationDTO.setIdMessage(daoMessage.getIdMessage());
    configurationDTO.setTitle(daoMessage.getTitle());
    configurationDTO.setType(daoMessage.getType());
    List<ContactDTO> contacts = new ArrayList<>();
    List<DAOContact> daoContacts = daoMessage.getContact();
    for(DAOContact daoContact :daoContacts) {
      ContactDTO contactDTO = mapToContactDTO(daoContact);
      contacts.add(contactDTO);
    }
    configurationDTO.setContacts(contacts);
    return configurationDTO;
  }

  private ContactDTO mapToContactDTO(DAOContact contact) {
    ContactDTO contactDTO = new ContactDTO();
    contactDTO.setIdContact(contact.getIdContact());
    contactDTO.setFullname(contact.getFullname());
    contactDTO.setPhone(contact.getPhone());
    contactDTO.setPhoto(contact.getPhoto());
    return contactDTO;
  }
}
