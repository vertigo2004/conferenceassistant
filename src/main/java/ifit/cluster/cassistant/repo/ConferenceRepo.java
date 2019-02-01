package ifit.cluster.cassistant.repo;

import ifit.cluster.cassistant.domain.Conference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepo extends CrudRepository<Conference, Long> {

    //Conference getById(Long id);

  //  Iterable<Conference> findAll();

}
