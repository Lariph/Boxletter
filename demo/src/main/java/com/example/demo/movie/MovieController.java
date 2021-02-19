package com.example.demo.movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/")
public class MovieController {
    
    @Autowired
    private MovieRepository movies;

    @GetMapping("/listar")
    public List<Movie> list() {
        return this.movies.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @PostMapping("/inserir")
    public Movie add(@RequestBody Movie newmovie){
        return this.movies.save(newmovie);
    }

    @GetMapping("/remover/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") Long id){
        Movie movie = movies.findById(id).orElse(null);
        this.movies.delete(movie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }

    @GetMapping("/atualizar/{id}")
    public ResponseEntity<Movie> refresh(@PathVariable("id") Long id, @RequestBody Movie movie){
        Movie newmovie = movies.findById(id).orElse(null);
        newmovie.setName(movie.getName());
        newmovie.setRate(movie.getRate());
        newmovie.setReview(movie.getReview());
        return ResponseEntity.ok(this.movies.save(newmovie));
    }
}
