package com.sprboot.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprboot.demo.entities.Movie;
import com.sprboot.demo.exceptions.IdnotfoundException;
import com.sprboot.demo.repository.MovieRepository;
@Transactional
@Service("ms")
public class MovieServiceImpl implements IMovieService{
	@Autowired
	MovieRepository mr;

	@Override
	public List<Movie> allmovies() {
		// TODO Auto-generated method stub
		return mr.findAll();
	}

	@Override
	public Movie getmovie(int id) {
		// TODO Auto-generated method stub
		Optional<Movie> m= mr.findById(id);
		if(m.isPresent())
			return m.get();	
		else
			throw new IdnotfoundException("id not found");	
	}

	@Override
	public boolean addmovie(Movie m) {
		// TODO Auto-generated method stub
		if(mr.save(m)!=null)
		return true;
		else
		return false;
	}

	@Override
	public boolean updatemovie(Movie m) {
		// TODO Auto-generated method stub
		if(mr.save(m)!=null)
		return true;
		else
			return false;
	}

	@Override
	public String deletemovie(int id) {
		// TODO Auto-generated method stub
		 mr.deleteById(id);
		 return "Movie deleted successfully";
	}

	@Override
	public List<Movie> findByMgenre(String mgenre) {
		// TODO Auto-generated method stub
		return mr.findByMgenre(mgenre);
	}

	@Override
	public void deleteByMgenre(String mgenre) {
		// TODO Auto-generated method stub
		mr.deleteByMgenre(mgenre);
	}
	/*@Override
	public Movie getmoviebycat(String genre) {
		// TODO Auto-generated method stub
		return mr.findBy(null, null)
	}*/

	@Override
	public List<Movie> findAllByMidRange(int stid, int endid) {
		// TODO Auto-generated method stub
		return mr.findAllByMidRange(stid, endid);
	}

}
