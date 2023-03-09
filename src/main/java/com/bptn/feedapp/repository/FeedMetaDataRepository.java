package com.bptn.feedapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bptn.feedapp.jpa.FeedMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedMetaDataRepository extends JpaRepository<FeedMetaData, Integer> {
	
}
