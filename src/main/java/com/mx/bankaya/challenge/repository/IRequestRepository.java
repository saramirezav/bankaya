package com.mx.bankaya.challenge.repository;

import com.mx.bankaya.challenge.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface that manages CRUD Request
 * @author Sarahy Ramirez
 */
public interface IRequestRepository extends JpaRepository<Request,Integer> {
}
