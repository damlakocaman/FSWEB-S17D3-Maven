package com.workintech.zoo.controller;
import com.workintech.zoo.entity.Kangaroo;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/workintech/kangaroos")
public class KangarooController {

    private Map<Integer, Kangaroo> kangaroos;

    @PostConstruct
    public void init() {

        kangaroos = new HashMap<>();

        kangaroos.put(
                1,
                new Kangaroo(1, "Jack", 1.80, 85.0, "Male", true)
        );

        kangaroos.put(
                2,
                new Kangaroo(2, "Ruby", 1.65, 70.0, "Female", false)
        );
    }

    // GET ALL
    @GetMapping
    public List<Kangaroo> getKangaroos() {

        return new ArrayList<>(kangaroos.values());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Kangaroo getKangarooById(@PathVariable Integer id) {

        return kangaroos.get(id);
    }

    // POST
    @PostMapping
    public Kangaroo addKangaroo(@RequestBody Kangaroo kangaroo) {

        kangaroos.put(kangaroo.getId(), kangaroo);

        return kangaroo;
    }

    // PUT
    @PutMapping("/{id}")
    public Kangaroo updateKangaroo(@PathVariable Integer id,
                                   @RequestBody Kangaroo kangaroo) {

        kangaroos.put(id, kangaroo);

        return kangaroo;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public Kangaroo deleteKangaroo(@PathVariable Integer id) {

        return kangaroos.remove(id);
    }
}
