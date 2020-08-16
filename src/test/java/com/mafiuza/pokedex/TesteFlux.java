package com.mafiuza.pokedex;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestExecutionListeners;
import reactor.core.publisher.Flux;


public class TesteFlux {

    @Test
    void testeFlux1() {
        Flux.empty();
    }

    @Test
    void testeFlux2(){
        Flux<String>flux=Flux.just("Pokedex");
        flux.subscribe(System.out::println);

    }

    @Test
    void TesteFlux3(){
        Flux<String>flux=Flux.just("Sharizard","Blastoise","Picachu");
        flux.subscribe(System.out::println);
    }

}
