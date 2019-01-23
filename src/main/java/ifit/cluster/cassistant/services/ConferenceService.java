package ifit.cluster.cassistant.services;

import ifit.cluster.cassistant.domain.Conference;
import ifit.cluster.cassistant.repositories.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;

    public List<Conference> getAllConferencies() {
        Iterable<Conference> all = conferenceRepository.findAll();
        Iterator<Conference> iterator = all.iterator();
        return Stream.generate(iterator::next).collect(Collectors.toList());
    }

    public Conference getConference(Long id) {
        return conferenceRepository.findById(id).get();
    }
}
