package com.matera.cursoferias.digitalbank;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private final Printer portuguesePrinter;
    private final Printer englishPrinter;

    public AppStartupRunner(Printer portuguesePrinter, Printer englishPrinter) {
        this.portuguesePrinter = portuguesePrinter;
        this.englishPrinter = englishPrinter;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        portuguesePrinter.print();
        englishPrinter.print();
    }

}
