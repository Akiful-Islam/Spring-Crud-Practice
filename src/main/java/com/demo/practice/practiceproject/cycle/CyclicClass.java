package com.demo.practice.practiceproject.cycle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class CyclicClass {
    private final ClassCyclic classCyclic;

    public CyclicClass(ClassCyclic classCyclic) {
        this.classCyclic = classCyclic;
    }

    public String doCyclicClass() {
        return "Cyclic of Class";
    }

    public String doClassCyclic() {
        return classCyclic.doClassCyclic() + " in " + doCyclicClass();
    }

}
