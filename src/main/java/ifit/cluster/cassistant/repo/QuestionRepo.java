package ifit.cluster.cassistant.repo;

import ifit.cluster.cassistant.domain.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepo extends CrudRepository<Question, Long> {
}
