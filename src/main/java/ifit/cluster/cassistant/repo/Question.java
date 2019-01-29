package ifit.cluster.cassistant.repo;

import ifit.cluster.cassistant.domain.State;
import org.springframework.data.repository.CrudRepository;

public interface Question extends CrudRepository<Question, Long> {

    void IncrementRate(Question question);

    boolean checkEmail(String email);

    State updateState(Question question);

}
