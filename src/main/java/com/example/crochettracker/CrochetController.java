package com.example.crochettracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin(origins = {"https://crochet-tracker-gl7dtbm7qq-nw.a.run.app","https://crochet-tracker-gl7dtbm7qq-nw.a.run.app/crochet/{crochetId}","http://localhost:3002","http://localhost:3000"})
public class CrochetController {

    @Autowired
    CrochetRepository crochetRepository;


    @GetMapping("/crochet")
    public String getCrochet () {
        return "getting crochet projects";
    }

    @CrossOrigin
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

    @PutMapping("/crochet/projects/{projectId}")
    public String changeCrochetProject (@RequestBody CrochetProject text) {
        this.crochetRepository.save(text);
        System.out.println("Updated " + text);
        return "Crochet project updated okay";
    }

    @DeleteMapping("/crochet/{projectId}")
    @Transactional
    public String deleteCrochetProject(@PathVariable int projectId) {
        System.out.println("crochet project = " + projectId);
        int deleted = this.crochetRepository.deleteCrochetProjectByProjectId(projectId);
        if (deleted > 0) {
            return "Crochet project removed okay";
        }
        return "Crochet Id doesn't exist";
    }

}
