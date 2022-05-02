package com.sergheikot.usmwebschedule.jpa.repository;

import com.sergheikot.usmwebschedule.jpa.domain.DateItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateItemRepository extends JpaRepository<DateItem, Integer> {
}
