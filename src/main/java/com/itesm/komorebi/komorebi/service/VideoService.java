package com.itesm.komorebi.komorebi.service;

import com.itesm.komorebi.komorebi.dto.VideoDTO;
import com.itesm.komorebi.komorebi.models.Video;
import com.itesm.komorebi.komorebi.models.VideoID;
import com.itesm.komorebi.komorebi.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {
    @Autowired
    VideoRepository videoRepository;

    //CREATE
    public void createVideo(final VideoDTO videoDTO){
        Video v = new Video();
        v.setAgent_name(videoDTO.getAgent_name());
        v.setTimestamp(videoDTO.getTimestamp());
        v.setStaff_id(videoDTO.getStaff_id());
        v.setVideo_id(videoDTO.getVideo_id());
        v.setDuration(videoDTO.getDuration());
        v.setCategory(videoDTO.getCategory());
        v.setTags(videoDTO.getTags());
        v.setNotes(videoDTO.getNotes());
        v.setCustomer(videoDTO.getCustomer());
        v.setConfiguration(videoDTO.getConfiguration());
        v.setSuccessful_outcome(videoDTO.getSuccessful_outcome());
        v.setChat(videoDTO.getChat());
        videoRepository.save(v);
    }

    //READ
    public Iterable<Video> lista(){
        return videoRepository.findAll();
    }

    public Video getOne(String agent_name, String timestamp){
        VideoID videoID = new VideoID(agent_name, timestamp);
        return videoRepository.findById(videoID).get();
    }

    public boolean existsId(String agent_name, String timestamp){
        VideoID videoID = new VideoID(agent_name, timestamp);
        return videoRepository.existsById(videoID);
    }

    //UPDATE
    public Video update(VideoDTO videoDTO){
        VideoID videoID = new VideoID(videoDTO.getAgent_name(), videoDTO.getTimestamp());
        Video video = videoRepository.findById(videoID).get();
        video.setAgent_name(videoDTO.getAgent_name());
        video.setTimestamp(videoDTO.getTimestamp());
        video.setStaff_id(videoDTO.getStaff_id());
        video.setVideo_id(videoDTO.getVideo_id());
        video.setDuration(videoDTO.getDuration());
        video.setCategory(videoDTO.getCategory());
        video.setTags(videoDTO.getTags());
        video.setNotes(videoDTO.getNotes());
        video.setCustomer(videoDTO.getCustomer());
        video.setConfiguration(videoDTO.getConfiguration());
        video.setSuccessful_outcome(videoDTO.getSuccessful_outcome());
        video.setChat(videoDTO.getChat());
        return videoRepository.save(video);
    }

    //DELETE
    public void delete(String agent_name, String timestamp){
        VideoID videoID = new VideoID(agent_name, timestamp);
        videoRepository.deleteById(videoID);
    }
}
