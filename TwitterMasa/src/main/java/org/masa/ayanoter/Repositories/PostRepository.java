package org.masa.ayanoter.Repositories;

import org.masa.ayanoter.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
