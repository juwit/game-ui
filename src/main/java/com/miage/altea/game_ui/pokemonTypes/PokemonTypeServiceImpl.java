package com.miage.altea.game_ui.pokemonTypes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    private RestTemplate restTemplate;

    @Value("${pokemon.service.url}")
    private String pokemonTypeServiceUrl;

    public PokemonTypeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<PokemonType> listPokemonsTypes() {
        return List.of(restTemplate.getForObject(pokemonTypeServiceUrl + "/pokemon-types/", PokemonType[].class));
    }
}
