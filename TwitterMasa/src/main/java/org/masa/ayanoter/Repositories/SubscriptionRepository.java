package org.masa.ayanoter.Repositories;


import org.masa.ayanoter.models.Subscription;
import org.masa.ayanoter.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
    List<Subscription> findByFromUser(User from_user_id);
}
