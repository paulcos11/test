package com.flemby.repository;

import com.flemby.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

	List<Event> findByType(String type);

	Event findBySlideShow(String slideShow);

	List<Event> findByPublishedDateBetweenOrderByPublishedDateDesc(Date date, Date publishedDate);


	List<Event> findAllByOrderByPublishedDateDesc();
}
