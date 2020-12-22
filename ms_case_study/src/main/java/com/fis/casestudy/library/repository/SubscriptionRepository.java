package com.fis.casestudy.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.casestudy.library.model.Subscriber;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscriber, String>
{

}
