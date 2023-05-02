package com.demo.practice.practiceproject.cyclic;

import org.springframework.stereotype.Component;

@Component
public class ClassCyclic {
    private final CyclicClass cyclicClass;

    public ClassCyclic(CyclicClass cyclicClass) {
        this.cyclicClass = cyclicClass;
    }

    public void doClassCyclic() {
        System.out.println("ClassCyclic");
    }

    public void doCyclicClass() {
        cyclicClass.doCyclicClass();
    }
}
