package com.hackathon.group4.repositories;

import com.hackathon.group4.models.DAOMessage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<DAOMessage, Integer> {

  @Query(value = "SELECT * FROM messages m WHERE m.id_user = ?1", nativeQuery = true)
  public List<DAOMessage> findByUserId(Integer userId);

}
