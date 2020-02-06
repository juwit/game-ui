package com.miage.altea.game_ui.pokemonTypes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miage.altea.game_ui.GameUI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(PokemonTypeServiceImpl.class)
@AutoConfigureWebClient(registerRestTemplate = true)
@TestPropertySource(properties = "pokemon.service.url=http://localhost:8080")
class PokemonTypeServiceImplTest {

    @Autowired
    PokemonTypeServiceImpl pokemonTypeService;

    @Autowired
    MockRestServiceServer server;

    @Test
    void listPokemonsTypes_shouldCallTheRemoteService() throws IOException {
        // given
        var response = Files.readString(new ClassPathResource("/rest/pokemon-types.json").getFile().toPath());
        server.expect(requestTo("http://localhost:8080/pokemon-types/"))
                .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));

        var pokemons = pokemonTypeService.listPokemonsTypes();



    }

    @Test
    void pokemonServiceImpl_shouldBeAnnotatedWithService(){
        assertNotNull(PokemonTypeServiceImpl.class.getAnnotation(Service.class));
    }

}