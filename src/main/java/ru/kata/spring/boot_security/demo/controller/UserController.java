package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;

@RestController
public class UserController {

    @GetMapping("/user-data")
    public ResponseEntity<User> showUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
//если вы просите меня удалить данный код, то пожалуйста, прочтите сообщение,
// в котором я указал логику действий

//AuthController
//Он обрабатывает GET-запросы к эндпоинту /user-data,
//извлекает объект User, представляющий текущего вошедшего в систему пользователя,
//из объекта Authentication и возвращает его в виде ответа HTTP с кодом состояния 200 (OK).

//Authorize.js
//Выполняет асинхронный запрос fetch к эндпоинту /user-data
// для получения данных о пользователе в формате JSON.
// Затем он обрабатывает полученные данные и обновляет
// пользовательский интерфейс в соответствии с ними.



