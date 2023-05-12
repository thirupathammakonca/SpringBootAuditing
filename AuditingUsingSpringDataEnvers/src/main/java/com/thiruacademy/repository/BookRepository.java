package com.thiruacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.thiruacademy.entity.Book;
@Repository
public interface BookRepository extends RevisionRepository<Book, Integer, Integer>, JpaRepository<Book, Integer> {

}
