package com.miage.altea.game_ui.controller;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    @Test
    void controllerShouldBeAnnotated(){
        assertNotNull(IndexController.class.getAnnotation(Controller.class)); //<1>
    }

    @Test
    void index_shouldReturnTheNameOfTheIndexTemplate() {
        var indexController = new IndexController();
        var viewName = indexController.index();

        assertEquals("index", viewName); //<2>
    }

    @Test
    void index_shouldBeAnnotated() throws NoSuchMethodException {
        var indexMethod = IndexController.class.getMethod("index");
        var getMapping = indexMethod.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/"}, getMapping.value()); //<3>
    }

}