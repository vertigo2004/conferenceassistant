package ifit.cluster.cassistant.repo;

import ifit.cluster.cassistant.domain.Conference;
import org.springframework.data.repository.CrudRepository;

public interface ConferenceRepo extends CrudRepository<Conference, Long> {
    Conference getById(Long id);
}
