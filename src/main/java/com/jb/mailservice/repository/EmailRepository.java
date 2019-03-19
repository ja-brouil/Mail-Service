package com.jb.mailservice.repository;

import com.jb.mailservice.model.EmailEntry;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepository extends CrudRepository<EmailEntry, Integer>{

}
