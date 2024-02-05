package com.workintech.project1.SpringBootIntro;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    Map<Long,Animal> animalsMap = new HashMap<>();

    @PostMapping("/")
    public Animal save(@RequestBody Animal animal){
        animalsMap.put(animal.getId(),animal);
        return animalsMap.get(animal.getId());
    }

    @GetMapping("/")
    public List<Animal> findAll(){
return animalsMap.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal findById(@PathVariable long id){
        return animalsMap.get(id);
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable long id, @RequestBody Animal animal){
        animalsMap.put(id,new Animal(id,animal.getName()));
        return animalsMap.get(id);
    }

    @DeleteMapping("/{id}")
    public Animal remove(@PathVariable long id){
        Animal student = animalsMap.get(id);
        animalsMap.remove(id);
        return student;
    }

}
