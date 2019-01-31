package ifit.cluster.cassistant.repositories;

import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

    List<Topic> findBySpeaker(String speaker);

    List<Topic> findByNameOrSpeaker(String name, String speaker);

    List<Topic> findByLikes(User user);

    List<Topic> findAllByOrderBySpeakerAsc();

    List<Topic> findAllByOrderBySpeakerDesc();

    int countBySpeaker(String speaker);

}
