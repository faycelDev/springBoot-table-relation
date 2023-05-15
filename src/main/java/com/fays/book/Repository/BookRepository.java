package com.fays.book.Repository;

import com.fays.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {

List<Book> findByAuteur (String auteur);


}
