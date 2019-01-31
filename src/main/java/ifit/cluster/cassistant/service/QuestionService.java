package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.State;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

//    Question IncrementRate(Question question){
//        question.setRate(question.getRate() + 1);
//        return question;
//    }

//    boolean checkEmail(String email) {
//        return questionRepo.checkEmail(email);
//    }

//    void updateState(Question question, State state) {
//        question.setState(state);
//    }

    public Question getQuestion(Long questionID) {
        return questionRepo.findById(questionID).get();

    }
}
