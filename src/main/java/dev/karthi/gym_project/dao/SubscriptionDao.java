package dev.karthi.gym_project.dao;

import dev.karthi.gym_project.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface SubscriptionDao extends JpaRepository<Subscription, String> {

    List<Subscription> findByMemberId(String memberId);

    @Query("SELECT s FROM Subscription s WHERE s.endDate >= CURRENT_DATE")
    List<Subscription> findActiveSubscriptions();

    @Query("SELECT s FROM Subscription s WHERE s.endDate < CURRENT_DATE")
    List<Subscription> findExpiredSubscriptions();

    @Query("SELECT s FROM Subscription s WHERE s.endDate >= CURRENT_DATE AND s.endDate <= :date")
    List<Subscription> findSubscriptionsEndingSoon(@Param("date") LocalDate date);
}