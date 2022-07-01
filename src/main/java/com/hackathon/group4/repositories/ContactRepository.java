package com.hackathon.group4.repositories;

import com.hackathon.group4.models.DAOContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<DAOContact, Integer> {

}
