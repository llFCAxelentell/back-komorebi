package com.itesm.komorebi.komorebi.repository;

import com.itesm.komorebi.komorebi.models.Video;
import com.itesm.komorebi.komorebi.models.VideoID;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface VideoRepository extends CrudRepository<Video, VideoID> {
}