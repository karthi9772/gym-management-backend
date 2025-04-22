package dev.karthi.gym_project.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.karthi.gym_project.entity.Subscriptions;

@Repository
public interface SubscriptionDao extends JpaRepository<Subscriptions, String>{

}
