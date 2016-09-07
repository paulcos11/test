package com.flemby.repository;

import com.flemby.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Paul on 25/06/2016.
 */
public interface CalendarRepository extends JpaRepository<Calendar, Integer>  {

}
