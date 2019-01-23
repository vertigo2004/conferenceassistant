package ifit.cluster.cassistant.repositories;

import ifit.cluster.cassistant.domain.Conference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends CrudRepository<Conference, Long> {
}
