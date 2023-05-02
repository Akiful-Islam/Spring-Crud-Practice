package com.demo.practice.practiceproject.controller;

import com.demo.practice.practiceproject.cycle.ClassCyclic;
import com.demo.practice.practiceproject.cycle.CyclicClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CycleController {
    private final CyclicClass cyclicClass;
    private final ClassCyclic classCyclic;

    public CycleController(CyclicClass cyclicClass, ClassCyclic classCyclic) {
        this.cyclicClass = cyclicClass;
        this.classCyclic = classCyclic;
    }

    @GetMapping("/cyclic-class")
    public String cyclicClass() {
        return cyclicClass.doCyclicClass();
    }
    @GetMapping("/class-cyclic")
    public String classCyclic() {
        return classCyclic.doClassCyclic();
    }

    @GetMapping("/cyclic-class-cyclic")
    public String cyclicClassCyclic() {
        return cyclicClass.doClassCyclic();
    }

    @GetMapping("/class-cyclic-class")
    public String classCyclicClass() {
        return classCyclic.doCyclicClass();
    }
}
