package ifit.cluster.cassistant.repo;

import ifit.cluster.cassistant.domain.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepo extends CrudRepository<Topic, Long> {

    //void IncrementRate(Topic topic);

    //boolean checkEmail(String email);

    //Topic getTopic(Long topicID);
}
