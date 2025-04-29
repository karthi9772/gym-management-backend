package dev.karthi.gym_project.dao;


import dev.karthi.gym_project.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionDao extends JpaRepository<Subscription, String> {

    @Query("SELECT s FROM Subscription s WHERE s.status = 'active'")
    List<Subscription> findActiveSubscriptions();

    @Query("SELECT s FROM Subscription s WHERE s.memberId = ?1")
    List<Subscription> findByMemberId(String memberId);

    @Query("SELECT s FROM Subscription s WHERE s.status = ?1")
    List<Subscription> findByStatus(String status);

    // You can add more custom queries as needed
}