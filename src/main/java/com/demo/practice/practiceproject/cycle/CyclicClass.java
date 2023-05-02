package com.demo.practice.practiceproject.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CyclicClass {
    private ClassCyclic classCyclic;

    @Autowired
    public void setClassCyclic(ClassCyclic classCyclic) {
        this.classCyclic = classCyclic;
    }

    public String doCyclicClass() {
        return "Cyclic of Class";
    }

    public String doClassCyclic() {
        return classCyclic.doClassCyclic() + " in " + doCyclicClass();
    }

}
