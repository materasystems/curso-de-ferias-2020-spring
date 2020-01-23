package com.matera.cursoferias.digitalbank;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("en")
public class EnglishPrinter implements Printer {

    @Override
    public void print() {
        System.out.println("Hello world!");
    }

}
