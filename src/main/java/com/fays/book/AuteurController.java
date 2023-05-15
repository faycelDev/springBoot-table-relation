package com.fays.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuteurController {


    @Autowired


    private AuteurRepository auteurRepository;

    @GetMapping(value = "/auteur")
    public List<Auteur> getAllAuteurList() {
        return auteurRepository.findAll();
    }

    @GetMapping(value ="/auteur{id}")

    public Auteur getAuteurById(@PathVariable("id") Long id) {

        return auteurRepository.findById(id).get();
    }

    @PostMapping(value = "/auteur")
    public void create(@RequestBody Auteur auteur){

            auteurRepository.save(auteur);
    }

    @PutMapping(value = "/auteur{id}")
    public void updateAuteurById(@PathVariable ("id") Long id, @RequestBody Auteur auteur){
            var auteur2 = auteurRepository.findById(id);

        if(auteur2.isPresent()){
            auteur.setId(id);
            auteurRepository.save(auteur);
        }
    }

    @DeleteMapping(value = "/auteur{id}")
    public void deleteById(@PathVariable ("id") Long id){
        auteurRepository.deleteById(id);
    }
}
