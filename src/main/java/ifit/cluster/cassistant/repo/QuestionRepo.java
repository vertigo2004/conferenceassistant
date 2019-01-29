package ifit.cluster.cassistant.repo;

import ifit.cluster.cassistant.domain.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends CrudRepository<QuestionRepo, Long> {

    void IncrementRate(Question question);

    boolean checkEmail(String email);

    void updateState(Question question);

}
