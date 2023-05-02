package com.demo.practice.practiceproject.cycle;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class ClassCyclic {
    private final CyclicClass cyclicClass;

    public ClassCyclic(CyclicClass cyclicClass) {
        this.cyclicClass = cyclicClass;
    }

    public String doClassCyclic() {
        return "Class of Cyclic";
    }

    public String doCyclicClass() {
        return cyclicClass.doCyclicClass() + " in " + doClassCyclic();
    }
}
