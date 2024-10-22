//package org.example.demodanya.try2.controllers;
//
//
//import lombok.RequiredArgsConstructor;
//import org.junit.Test;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//import java.beans.ConstructorProperties;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest // Эта аннотация говорит Spring Boot, что мы хотим загрузить контекст приложения для тестов.
//@AutoConfigureMockMvc // Эта аннотация необходима для автоматической настройки MockMvc, который будет использоваться для тестирования контроллеров
//public class UserAccessControllerTest {
//
//    // Автоматически инъектируем MockMvc,
//    // который будет использоваться для отправки запросов и проверки ответов контроллеров
//
//    private MockMvc mockMvc;
//
//    //В этом методе мы тестируем, что замоканный пользователь с ролью "USER"
//    // может получить доступ к ресурсу /books/by-title. Ожидается, что запрос завершится со статусом 200 OK.
//    @Test //Каждый из методов помечен аннотацией @Test (из JUnit 5) и аннотацией @WithMockUser для указания,
//    // что тесты будут выполняться от имени "пользователя" с ролью "USER"
//    @WithMockUser(username = "user", roles = {"USER"})
//    public void testUserAccess() throws Exception {
//        mockMvc.perform(get("/books/by-title")).andExpect(status().isOk());
//    }
//
//    //В этом методе мы тестируем, что замоканный пользователь с ролью "USER"
//    // НЕ может получить доступ к ресурсу /books/update. Ожидается, что запрос завершится со статусом 403 Forbidden.
//    @Test
//    @WithMockUser(username = "user", roles = {"USER"})
//    public void testUserNotAccess() throws Exception {
//        mockMvc.perform(get("/books/update")).andExpect(status().isForbidden());
//    }
//
//    //Этот тест проверяет другой защищенный маршрут (в данном случае /some/protected/route) и ожидает,
//    // что доступ к нему также будет запрещен для обычного пользователя
//    @Test
//    @WithMockUser(username = "user", roles = {"USER"})
//    public void testCannonAccessProtected() throws Exception {
//        mockMvc.perform(get("/publisher")).andExpect(status().isForbidden());
//    }
//}
