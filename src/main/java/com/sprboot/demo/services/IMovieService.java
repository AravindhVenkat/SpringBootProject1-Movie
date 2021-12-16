package com.sprboot.demo.services;

import java.util.List;



import com.sprboot.demo.entities.Movie;

public interface IMovieService {

	List<Movie> allmovies();
	Movie getmovie(int id);
	boolean addmovie(Movie m);

	boolean updatemovie(Movie m);

	String deletemovie(int id);
	List<Movie> findByMgenre(String mgenre);
	void deleteByMgenre(String mgenre);
	List<Movie> findAllByMidRange(int stid,int endid);
}
