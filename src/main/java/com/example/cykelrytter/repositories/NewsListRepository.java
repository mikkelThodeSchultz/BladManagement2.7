package com.example.cykelrytter.repositories;

import com.example.cykelrytter.model.NewsList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsListRepository extends JpaRepository<NewsList,Long> {
}
