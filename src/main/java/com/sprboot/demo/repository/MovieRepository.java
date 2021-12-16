package com.sprboot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprboot.demo.entities.Movie;

@Repository("mr")
public interface MovieRepository extends JpaRepository<Movie, Integer>{
	List<Movie> findByMgenre(String mgenre);
	void deleteByMgenre(String mgenre);
	
	@Query("select m from Movie m where m.mid between :st and :end")
	List<Movie> findAllByMidRange(@Param("st")int stid,@Param("end")int endid);
}