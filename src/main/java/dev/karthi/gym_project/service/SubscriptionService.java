package dev.karthi.gym_project.service;

import dev.karthi.gym_project.entity.Subscription;
import dev.karthi.gym_project.dao.SubscriptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionDao subscriptionDao;

    public Subscription addSubscription(Subscription subscription) {
        return subscriptionDao.save(subscription);
    }

    public Subscription getSubscriptionById(String id) {
        return subscriptionDao.findById(id).orElse(null);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionDao.findAll();
    }

    public Subscription updateSubscription(String id, Subscription subscription) {
        Subscription existing = subscriptionDao.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setMemberId(subscription.getMemberId());
        existing.setStartDate(subscription.getStartDate());
        existing.setEndDate(subscription.getEndDate());
        existing.setAmount(subscription.getAmount());
        existing.setStatus(subscription.getStatus());
        existing.setPaymentDate(subscription.getPaymentDate());

        return subscriptionDao.save(existing);
    }

    public boolean deleteSubscription(String id) {
        if (subscriptionDao.existsById(id)) {
            subscriptionDao.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Subscription> getActiveSubscriptions() {
        return subscriptionDao.findActiveSubscriptions();
    }

    public List<Subscription> getSubscriptionsByMember(String memberId) {
        return subscriptionDao.findByMemberId(memberId);
    }

    public List<Subscription> getSubscriptionsByStatus(String status) {
        return subscriptionDao.findByStatus(status);
    }
}