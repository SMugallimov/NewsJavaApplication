package com.synergyproject.newsjavaapp.repository;

import com.synergyproject.newsjavaapp.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}