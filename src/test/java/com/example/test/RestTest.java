package com.example.test;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;


public class RestTest {
    /*
    * 1. API тестирование.
    Задача: Используя этот сервис с тестовым REST-API https://reqres.in/, написать 2 теста.
    Первый – получить список пользователей (GET  https://reqres.in/api/users?page=2), замапить
    *  на объект и проверить, что все поля пришли (достаточно на notNull).
    Второй – создать пользователя (POST https://reqres.in/api/users) с данными из примера
    * на сайте: подготовить тело запроса, отправить запрос с телом, замапить ответ на объект и проверить,
    * что в ответе те же самые значения из запроса.

    Автотесты необходимо написать,  используя данный стек:
    Java, testNG, restAssured.
    * */


    RequestSpecification requestSpec = given()
               .baseUri("https://reqres.in");

    private static void accept(User p) {
        assertNotNull(p.getEmail());
        assertNotNull(p.getFirst_name());
        assertNotNull(p.getLast_name());
        assertNotNull(p.getAvatar());
    }

    @Test(groups = {"rest"})
    public void getSecondPageOfUsers(){
        String json = requestSpec.when().
                get("/api/users?page=2").asString();

        List<User> person = from(json).getList("data", User.class);
        person.forEach(com.example.test.RestTest::accept);
    }

    @Test(groups = {"rest"})
    public void createUser(){

        Map<String,String> testData = new HashMap<>();
        testData.put("name","morpheus");
        testData.put("job","leader");

        String json = requestSpec.
                header("Content-Type", "application/json").
                when().
                body(testData).
                post("/api/users").asString();



        PersonPOST person = from(json).getObject("", PersonPOST.class);
        assertEquals(person.getName(), testData.get("name"));
        assertEquals(person.getJob(), testData.get("job"));
    }

    @Test
    public void getSecondPageOfUsers_checkResponseCode_expect200(){
        requestSpec.when().
                get("/api/users?page=2").then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void getSecondPageOfUsers_checkPageNumber(){
        requestSpec.when().
                get("/api/users?page=2").then()
                .assertThat()
                .body("page", equalTo(2));
    }

    @Test
    public void getSecondPageOfUsers_checkPageItemCount(){
        requestSpec.when().
                get("/api/users?page=2").then()
                .assertThat()
                .body("per_page", equalTo(6));
    }

    @Test
    public void getSecondPageOfUsers_checkTotalElements(){
        requestSpec.when().
                get("/api/users?page=2").then()
                .assertThat()
                .body("total", equalTo(12));
    }

    @Test
    public void getSecondPageOfUsers_checkTotalPages(){
        requestSpec.when().
                get("/api/users?page=2").then()
                .assertThat()
                .body("total_pages", equalTo(2));
    }
}