package com.mafiuza.pokedex.repository;

import com.mafiuza.pokedex.model.Pokemon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PokedexRepository extends ReactiveMongoRepository<Pokemon,String> {
}
