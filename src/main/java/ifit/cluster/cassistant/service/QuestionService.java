package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Question;
import ifit.cluster.cassistant.domain.Topic;
import ifit.cluster.cassistant.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    public List<Question> sortQuestion(Iterable<Question> questions) {
        List<Question> questionList = StreamSupport
                .stream(questions.spliterator(), false)
                .collect(Collectors.toList());
        Collections.sort(questionList, new Comparator<Question>() {
            @Override
            public int compare(Question o1, Question o2) {
                return o2.getRate().compareTo(o1.getRate());
            }
        });
        return questionList;
    }
}
