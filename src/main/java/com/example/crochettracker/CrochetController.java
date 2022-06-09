package com.example.crochettracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins = {"https://crochet-tracker-gl7dtbm7qq-nw.a.run.app/"})
public class CrochetController {

    @Autowired
    CrochetRepository crochetRepository;

    @CrossOrigin
    @GetMapping("/crochet")
    public String getCrochet () {
        return "getting crochet projects";
    }

    @GetMapping("/crochet/projects")
    public List<CrochetProject> getCrochetProjects () {
        return crochetRepository.findAll();
    }

    @PostMapping("/crochet/projects")
    public String addCrochetProject (@RequestBody CrochetProject text) {
        this.crochetRepository.save(text);
        System.out.println("Added " + text);
        return "Crochet project saved okay";
    }

    @DeleteMapping("/crochet/{crochetId}")
    @Transactional
    public String deleteCrochetProject(@PathVariable int crochetId) {
        System.out.println("crochet project = " + crochetId);
        int deleted = this.crochetRepository.deleteCrochetProjectByProjectId(crochetId);
        if (deleted > 0) {
            return "Crochet project removed okay";
        }
        return "Crochet Id doesn't exist";
    }

}
