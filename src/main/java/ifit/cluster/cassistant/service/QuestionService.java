package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepo questionRepo;

    @Autowired
    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public Question getById(Long id){
        return questionRepo.getById(id);
    }

    public Question likeQuestion(Long id, User user){
        Question question = questionRepo.getById(id);
        question.getLikes().add(user);
        return questionRepo.save(question);
    }

    public Question saveQuestion(Question question){
        return questionRepo.save(question);
    }

}
