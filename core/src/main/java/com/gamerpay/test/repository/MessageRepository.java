package com.gamerpay.test.repository;

import com.gamerpay.test.domain.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
