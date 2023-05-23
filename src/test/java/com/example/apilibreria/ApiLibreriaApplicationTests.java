package com.example.apilibreria;

import com.example.apilibreria.repositories.AutorRepository;
import com.example.apilibreria.repositories.LibroRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApiLibreriaApplicationTests {
    @Autowired
    MockMvc mvc;
    @Autowired
    AutorRepository autorRepository;
    @Autowired
    LibroRepository libroRepository;


    //String tokenAdmin;
    //@BeforeAll
    //void getToken() throws Exception {
    //    tokenAdmin = authenticate("alex", "cancelo");
    //}
    @Test
    void contextLoads() {
        assert autorRepository.count() == 10;
        assert libroRepository.count() == 10;
    }
    @Test
    void listTest() throws Exception {
        mvc.perform(get("/author/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombre").value("Alejandro"))
                .andExpect(jsonPath("$[0].primerapellido").value("Cancelo"))
                .andExpect(jsonPath("$[0].segundoapellido").value("Hurtado"))
                .andExpect(jsonPath("$[0].imagen").value("prueba imagen"));
    }

    @Test
    void creationTest() throws Exception{
        long autorCount = autorRepository.count();

        String testAutor = "{\"nombre\": \"Jairo\", \"primerapellido\": \"Romero\", \"segundoapellido\":  \"Valencia\", \"imagen\": \"prueba imagen\"}";

        mvc.perform(post("/autor/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(testAutor))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
    @Test
    void detailTest() throws Exception {
        mvc.perform(get("/autor/1/").contentType(MediaType.APPLICATION_JSON))
                        //.header("Authorization", "Bearer" + tokenAdmin)) Cuando implemente la seguridad
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("bob"))
                .andExpect(jsonPath("$.age").value(19))
                .andExpect(jsonPath("$.yearsLeft").value(23));
    }
    @Test
    void updateTest() throws Exception {
        String testAutor = "{\"nombre\": \"Jairo\", \"primerapellido\": \"Romero\", \"segundoapellido\":  \"Valencia\", \"imagen\": \"prueba imagen\"}";

        mvc.perform(put("/autor/2/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testAutor))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nombre").value("Gonzalo"))
                .andExpect(jsonPath("$.primerapellido").value("Pulido"))
                .andExpect(jsonPath("$.segundoapellido").value("Sanchez"))
                .andExpect(jsonPath("$.imagen").value("Prueba Imagen 1"));
    }
    @Test
    void deleteTest() throws Exception {
        long autorCount = autorRepository.count();

        mvc.perform(delete("/autor/3/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
        assert autorRepository.count() == autorCount - 1;
    }
}
