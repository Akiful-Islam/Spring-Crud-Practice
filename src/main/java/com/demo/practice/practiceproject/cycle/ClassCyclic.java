package com.demo.practice.practiceproject.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassCyclic {
    private CyclicClass cyclicClass;

    @Autowired
    public void setCyclicClass(CyclicClass cyclicClass) {
        this.cyclicClass = cyclicClass;
    }

    public String doClassCyclic() {
        return "Class of Cyclic";
    }

    public String doCyclicClass() {
        return cyclicClass.doCyclicClass() + " in " + doClassCyclic();
    }
}
