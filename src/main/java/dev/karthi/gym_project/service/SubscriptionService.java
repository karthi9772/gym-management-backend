package dev.karthi.gym_project.service;

import dev.karthi.gym_project.entity.Subscription;
import dev.karthi.gym_project.dao.SubscriptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionDao subscriptionDao;

    public Subscription addSubscription(Subscription sub) {
        return subscriptionDao.save(sub);
    }

    public Subscription getSubscriptionById(String id) {
        Optional<Subscription> sub = subscriptionDao.findById(id);
        return sub.orElse(null);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionDao.findAll();
    }

    public Subscription updateSubscription(String id, Subscription sub) {
        sub.setId(id);
        return subscriptionDao.save(sub);
    }

    public void deleteSubscription(String id) {
        subscriptionDao.deleteById(id);
    }

    public List<Subscription> getSubscriptionsByMemberId(String memberId) {
        return subscriptionDao.findByMemberId(memberId);
    }

    public List<Subscription> getActiveSubscriptions() {
        return subscriptionDao.findActiveSubscriptions();
    }

    public List<Subscription> getExpiredSubscriptions() {
        return subscriptionDao.findExpiredSubscriptions();
    }

    public List<Subscription> getSubscriptionsEndingSoon() {
        LocalDate todayPlus7 = LocalDate.now().plusDays(7);
        return subscriptionDao.findSubscriptionsEndingSoon(todayPlus7);
    }
}