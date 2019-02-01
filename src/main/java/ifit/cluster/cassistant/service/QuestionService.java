package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.State;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    Question IncrementRate(Question question){
        question.setRate(question.getRate() + 1);
        return question;
    }

    boolean checkEmail(String email) {
        return false;
    }

    void updateState(Question question, String new_state) {
        Set<State> stateSet = new HashSet<>();
        stateSet.add(State.valueOf(new_state));
        question.setState(stateSet);
    }

    public Question getQuestion(Long questionID) {
        return questionRepo.findById(questionID).get();

    }
}
