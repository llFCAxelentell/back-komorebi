package com.itesm.komorebi.komorebi.controllers;

import com.itesm.komorebi.komorebi.dto.VideoDTO;
import com.itesm.komorebi.komorebi.models.Video;
import com.itesm.komorebi.komorebi.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/record")
public class VideoController {

    @Autowired
    VideoService videoService;

    //Create
    //Insert a tuple
    @PostMapping("/save")
    public VideoDTO save(@RequestBody VideoDTO videoDTO) throws Exception{
        videoService.createVideo(videoDTO);
        return videoDTO;
    }

    //Read
    //Select 1 tuple
    @GetMapping("/read/{agent_name}/{timestamp}")
    public ResponseEntity<Video> getOne(@PathVariable("agent_name") String agent_name, @PathVariable("timestamp") String timestamp){
        if(!videoService.existsId(agent_name,timestamp))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(videoService.getOne(agent_name,timestamp));
    }

    //Select all tuples
    @GetMapping("/all")
    public ResponseEntity<Iterable<Video>> getAll(){
        return ResponseEntity.ok(videoService.lista());
    }

    //Update a tuple
    @PutMapping("/update")
    public ResponseEntity<Video> update(@RequestBody VideoDTO videoDTO){
        if(!videoService.existsId(videoDTO.getAgent_name(), videoDTO.getTimestamp()))
            return new ResponseEntity("no existe, no se puede actualziar", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(videoService.update(videoDTO));
    }

    //Delete a tuple
    @DeleteMapping("/delete/{agent_name}/{timestamp}")
    public ResponseEntity<?> delete(@PathVariable("agent_name") String agent_name, @PathVariable("timestamp") String timestamp){
        if(!videoService.existsId(agent_name,timestamp))
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        videoService.delete(agent_name,timestamp);
        return new ResponseEntity("video eliminado", HttpStatus.OK);
    }
}
