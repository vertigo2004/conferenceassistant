package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.repo.ConferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceService{
    @Autowired
    private ConferenceRepo conferenceRepo;

    public Conference getById(Long id){
        Conference conference = conferenceRepo.getById(id);
        return conference;
    }
    public Iterable<Conference> getAll(){
        return conferenceRepo.findAll();
    }
}
