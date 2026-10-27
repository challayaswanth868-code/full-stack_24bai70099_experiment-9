package com.example.exp9fs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest @AutoConfigureMockMvc
class StudentControllerTest {
 @Autowired MockMvc mockMvc;
 @Test void listStudentsReturnsJson() throws Exception {mockMvc.perform(get("/api/students")).andExpect(status().isOk()).andExpect(jsonPath("$[0].name").value("Yaswanth")).andExpect(jsonPath("$[0].course").value("AIML"));}
 @Test void studentByIdReturnsRecord() throws Exception {mockMvc.perform(get("/api/students/1")).andExpect(status().isOk()).andExpect(jsonPath("$.id").value(1));}
 @Test void missingStudentReturns404() throws Exception {mockMvc.perform(get("/api/students/99")).andExpect(status().isNotFound());}
}
