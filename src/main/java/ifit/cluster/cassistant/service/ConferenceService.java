package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.repo.ConferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceService{

    private final ConferenceRepo conferenceRepo;

    @Autowired
    public ConferenceService(ConferenceRepo conferenceRepo) {
        this.conferenceRepo = conferenceRepo;
    }

    public Conference getById(Long id){
        return conferenceRepo.getById(id);
    }

    public Iterable<Conference> getAll(){
        return conferenceRepo.findAll();
    }

    public Conference saveConference(Conference conference){
        return conferenceRepo.save(conference);
    }

    public void deleteConference(Long id){
        conferenceRepo.deleteById(id);
    }

}
