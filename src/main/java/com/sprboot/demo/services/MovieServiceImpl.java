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
public class MovieServiceImpl implements IMovieService
{
	@Autowired
	MovieRepository mr;

	@Override
	public List<Movie> allmovies()
	{
		return mr.findAll();
	}

	@Override
	public Movie getmovie(int id)
	{
		Optional<Movie> m= mr.findById(id);
		if(m.isPresent())
			return m.get();	
		else
			throw new IdnotfoundException("id not found");	
	}

	@Override
	public boolean addmovie(Movie m)
	{
		if(mr.save(m)!=null)
		return true;
		else
		return false;
	}

	@Override
	public boolean updatemovie(Movie m)
	{
		if(mr.save(m)!=null)
		return true;
		else
			return false;
	}

	@Override
	public String deletemovie(int id)
	{
		 mr.deleteById(id);
		 return "Movie deleted successfully";
	}

	@Override
	public List<Movie> findByMgenre(String mgenre)
	{
		return mr.findByMgenre(mgenre);
	}

	@Override
	public void deleteByMgenre(String mgenre)
	{
		mr.deleteByMgenre(mgenre);
	}

	@Override
	public List<Movie> findAllByMidRange(int stid, int endid)
	{
		return mr.findAllByMidRange(stid, endid);
	}
}
