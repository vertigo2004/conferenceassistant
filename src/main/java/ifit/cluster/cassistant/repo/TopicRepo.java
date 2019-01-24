package ifit.cluster.cassistant.repo;

import ifit.cluster.cassistant.domain.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepo extends CrudRepository<Topic, Long> {
    Topic getById(Long id);

}
