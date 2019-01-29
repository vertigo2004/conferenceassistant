package ifit.cluster.cassistant.service;

import com.sun.org.apache.bcel.internal.generic.NEW;
import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.State;
import ifit.cluster.cassistant.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    void IncrementRate(Question question){
        question.setRate(question.getRate() + 1);
    }

    boolean checkEmail(String email) {
        return questionRepo.checkEmail(email);
    };

    void updateState(Question question, State state) {
        question.setState(state);
    };
}
