package ifit.cluster.cassistant.repo;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.domain.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TopicRepo extends CrudRepository<Topic, Long> {
    Topic getById(Long id);
    List<Topic> findAllByConferenceOrderByRateDesc(Conference conf);

}
