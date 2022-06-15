package demo2BackEnd.categories.model;

import demo2BackEnd.categories.model.User;
import demo2BackEnd.categories.repository.UserRepository;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import org.apache.logging.log4j.util.Strings;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.ValueSource;

import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCase {
    //Specifying the request method
    @Test
    public void test_user_info(){
        when().request("GET", "/User/info").then().statusCode(200);
    }

    @Test
    public void test_user_info_id(){
        when().request("GET", "/User/info/1").then().statusCode(200);
    }

    @Test
    public void test_comment_info(){
        when().request("GET", "Comment/info").then().statusCode(200);
    }

    @Test
    public void test_user_info_failed(){
        when().request("GET", "/User/info/'1'").then().statusCode(400);
    }


    //moive test
    @Test
    public  void test_moive_info(){ when().request("GET", "/Movie/info").then().statusCode(200);}

    @Test
    public void test_moive_info_id(){
        when().request("GET", "/Movie/info/1").then().statusCode(200);
    }

    //Resturant
    @Test
    public  void test_rs_info(){ when().request("GET", "/Restaurant/info").then().statusCode(200);}

    @Test
    public void test_rs_info_id(){
        when().request("GET", "/Restaurant/info/1").then().statusCode(200);
    }
    //Measure response time
    @Test
    public void measure_comment_info_response_time(){
        Response response = RestAssured.get("Comment/info");
        long timeInMS = response.time();
        long timeInS = response.timeIn(TimeUnit.SECONDS);
        assertEquals(timeInS, timeInMS/1000);
    }

    @Test
    public void test_movie_response_time(){
        when().get("Movie/info").then().time(lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    public void test_Rs_response_time(){
        when().get("Restaurant/info").then().time(lessThan(5L), TimeUnit.SECONDS);
    }

    @Test
    public void test_Bk_response_time(){
        when().get("Book/info").then().time(lessThan(5L), TimeUnit.SECONDS);
    }
    //Logging test details
    @Test
    public void log_request(){
        given().log().all().when().get("Admin/info").then().statusCode(200);
    }

    @Test
    public void log_request1(){
        given().log().all().when().get("Restaurant/info").then().statusCode(200);
    }

    @Test
    public void log_request2(){
        when().get("User/info").then().log().body().statusCode(200);
    }

    @Test
    public void log_request3(){
        when().get("Movie/info").then().log().body().statusCode(200);
    }

    @Test
    public void log_request4(){
        when().get("VideoGame/info").then().log().body().statusCode(200);
    }

    @Test
    public void log_request5(){
        when().get("TVShow/info").then().log().body().statusCode(200);
    }
    @Test
    public void log_valid(){
        when().get("/Book/info").then().log().ifValidationFails().statusCode(200);
        given().log().ifValidationFails().when().get("/Book/info").then().statusCode(200);
    }

    @InjectMocks
    User user;

    @Mock
    UserRepository usrRepo;

//    @Test
//    public void get_user_by_id_test(){
//        when(usrRepo.getById(Long.valueOf(1))).thenReturn(new User(1L, "WalkingDeaDJ", "asbadsfiashd123@", "JS@iastate.edu", null, "male", false, false));
//    }

    @ParameterizedTest
    @NullSource
    public void setUsername_return_true_for_null(String username){
        assertTrue(Strings.isBlank(username));
    }

}
