package com.mafiuza.pokedex;

import com.mafiuza.pokedex.repository.PokedexRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import reactor.core.publisher.Flux;
import com.mafiuza.pokedex.model.Pokemon;


@SpringBootApplication
public class PokedexApplication {

	public static void main(String[] args) { SpringApplication.run(PokedexApplication.class, args);}

	@Bean
    CommandLineRunner init (ReactiveMongoOperations operations,
                            PokedexRepository repository ){
	    return  args -> {
            Flux<Pokemon> pokedexFlux =Flux.just(

                    new Pokemon(null,"Bulbassauro","Semente","OverGrow",6.09),
                    new Pokemon(null,"Charizard","Fogo","Blaze",96.05),
                    new Pokemon(null,"Pikachu","Raio","Raio do Trovão",2.09),
                    new Pokemon(null,"Blastoise","Marisco","Torrent",6.09))

                    //Serve para salvar os dados persistindo em memória
                    .flatMap(repository::save);

            pokedexFlux
                    .thenMany(repository.findAll())
                    .subscribe(System.out::println);

        };
    }

	}


