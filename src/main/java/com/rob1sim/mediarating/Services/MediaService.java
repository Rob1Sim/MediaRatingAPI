package com.rob1sim.mediarating.Services;

import com.rob1sim.mediarating.Entity.Media;
import com.rob1sim.mediarating.Repositories.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaService {
    private final MediaRepository mediaRepository;
    @Autowired
    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }
    public Media save(Media media){
        return mediaRepository.save(media);
    }
}
