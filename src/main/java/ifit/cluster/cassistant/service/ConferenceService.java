package ifit.cluster.cassistant.service;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.repo.ConferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService{
    @Autowired
    private ConferenceRepo conferenceRepo;

    public Conference getById(Long id){
        Conference conference = conferenceRepo.findById(id).get();
        return conference;
    }

    public List<Conference> findAll() {
        return (List<Conference>) conferenceRepo.findAll();
    }

}
