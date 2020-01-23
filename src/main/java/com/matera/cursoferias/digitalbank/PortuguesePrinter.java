package com.matera.cursoferias.digitalbank;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("pt")
public class PortuguesePrinter implements Printer {

    @Override
    public void print() {
        System.out.println("Olá mundo!");
    }

}
