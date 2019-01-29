package ifit.cluster.cassistant.repo;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.State;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepo extends CrudRepository<QuestionRepo, Long> {

    void IncrementRate(Question question);

    boolean checkEmail(String email);

    State updateState(Question question);

}
