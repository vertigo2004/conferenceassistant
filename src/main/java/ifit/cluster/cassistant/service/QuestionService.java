package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo questionRepo;
}
