package com.demo.practice.practiceproject.cyclic;

import org.springframework.stereotype.Component;

@Component
public class CyclicClass {
    private final ClassCyclic classCyclic;

    public CyclicClass(ClassCyclic classCyclic) {
        this.classCyclic = classCyclic;
    }

    public void doCyclicClass() {
        System.out.println("CyclicClass");
    }

    public void doClassCyclic() {
        classCyclic.doClassCyclic();
    }

}
