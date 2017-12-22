package org.masa.ayanoter.Repositories;

import org.masa.ayanoter.models.User;
import org.springframework.data.repository.CrudRepository;

import java.sql.Blob;

public interface UserRepository extends CrudRepository<User, Integer> {
         User findByLogin(String login);
}
