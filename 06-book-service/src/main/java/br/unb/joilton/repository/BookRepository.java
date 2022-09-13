package br.unb.joilton.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unb.joilton.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
