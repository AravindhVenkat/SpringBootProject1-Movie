package com.sprboot.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprboot.demo.entities.Movie;
import com.sprboot.demo.responses.Responseinfo;
import com.sprboot.demo.services.IMovieService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api
@RestController
public class MyRestController {
	@Autowired
	IMovieService ms;
	
	@ApiOperation("Used To Fetch All Movies")
	@GetMapping("/movies")
	List<Movie> allmovies() {
		return ms.allmovies();
	}
	@ApiOperation("Used To Fetch movie with particular ID")
	@GetMapping("/movies/{mid}")
	public Movie getmovie(@ApiParam("id to search for")@PathVariable("mid") int id) {
		return ms.getmovie(id);
	}
	
	@ApiOperation("Used To Post Movies")
	@PostMapping("/movies")
	ResponseEntity<Responseinfo> addmovie(@Validated @RequestBody Movie m,HttpServletRequest req) {
		Responseinfo ri=new Responseinfo();
		if(ms.addmovie(m)) {
			ri.setUri(req.getRequestURI());
			ri.setMessage("inserted");
			ri.setStatusCode(HttpStatus.CREATED.value());
			ri.setStatusName(HttpStatus.CREATED);	
		}	
		return new ResponseEntity(ri,HttpStatus.CREATED);
	}
	
	@ApiOperation("Used To Put All Movies")
	@PutMapping("/movies")
	public ResponseEntity<Responseinfo> updatemovie(@Validated @RequestBody Movie m,HttpServletRequest req) {
		Responseinfo ri=new Responseinfo();
		if(ms.updatemovie(m)) {
			ri.setUri(req.getRequestURI());
			ri.setMessage("updated");
			ri.setStatusCode(HttpStatus.CREATED.value());
			ri.setStatusName(HttpStatus.CREATED);
		}
		return new ResponseEntity(ri,HttpStatus.CREATED);
	}
	
	@ApiOperation("Used To Delete Movie with particular id")
	@DeleteMapping("/movies/{mid}")
	public String deletemovie(@ApiParam("id to delete for")@PathVariable("mid") int id) {
		return ms.deletemovie(id);
	}
	
	@ApiOperation("Used To Fetch All Movies by genre")
	@GetMapping("/movies/genre/{mgenre}")
	public List<Movie> getbyname(@ApiParam("genre to search for")@PathVariable("mgenre") String mgenre) {
		return ms.findByMgenre(mgenre);
	}
	
	@ApiOperation("Used To Delete movies by Genre")
	@DeleteMapping("/movies/del/{mgenre}")
	public String deletemoviebygenre(@ApiParam("genre to delete for")@PathVariable("mgenre") String mgenre) {
		ms.deleteByMgenre(mgenre);
		return "deleted ";
	}
	@ApiOperation("Used To Fetch movies by id st end")
	@GetMapping("/movies/id/{st}/{end}")
	public List<Movie> getbyname(@ApiParam("Enter starting id")@PathVariable("st")int stid,@ApiParam("Enter ending id")@PathVariable("end")int endid) {
		return ms.findAllByMidRange(stid, endid);
	}
	
	//@GetMapping("/movies/{mgenre}")
	//public Movie getmoviebycat(@PathVariable("mgenre") String genre) {
		//return ms.getmoviebycat(genre);
	//}
	

}
