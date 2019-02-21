package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.User;
import ifit.cluster.cassistant.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public void deleteQuestion(Long id){
        questionRepo.deleteById(id);
    }

    public List<Question> sortQuestion(List<Question> questions){
        Collections.sort(questions, new Comparator<Question>() {
            @Override
            public int compare(Question o1, Question o2) {
                int result = o1.getState().compareTo(o2.getState());
                if (result == 0) {
                    result = o2.getLikes().size() - o1.getLikes().size();
                }
                return result;
            }
        });
        return questions;
    }

}
