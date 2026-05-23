package com.workintech.zoo.controller;



import com.workintech.zoo.entity.Koala;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/workintech/koalas")
public class KoalaController {

    // Koalaları tutacak map
    private Map<Integer, Koala> koalas;

    // Controller bean oluşunca map initialize edilir
    @PostConstruct
    public void init() {

        koalas = new HashMap<>();

        koalas.put(
                1,
                new Koala(1, "Momo", 12.5, 20, "Female")
        );

        koalas.put(
                2,
                new Koala(2, "Koko", 15.0, 18, "Male")
        );
    }

    // GET ALL
    @GetMapping
    public List<Koala> getKoalas() {

        return new ArrayList<>(koalas.values());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Koala getKoalaById(@PathVariable Integer id) {

        return koalas.get(id);
    }

    // POST
    @PostMapping
    public Koala addKoala(@RequestBody Koala koala) {

        koalas.put(koala.getId(), koala);

        return koala;
    }

    // PUT
    @PutMapping("/{id}")
    public Koala updateKoala(@PathVariable Integer id,
                             @RequestBody Koala koala) {

        koalas.put(id, koala);

        return koala;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public Koala deleteKoala(@PathVariable Integer id) {

        return koalas.remove(id);
    }
}