package demo2BackEnd.categories.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo2BackEnd.categories.model.BanUser;
import demo2BackEnd.categories.model.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc controller;

    @Test
    public void role_controller_test_1() throws Exception{
        controller.perform(get("/User/info")).andExpect(status().isOk()).andExpect(jsonPath("$[0].username", is("WalkingDeaDJ")));
        controller.perform(get("/User/info/2")).andExpect(status().isOk());
        controller.perform(get("/BanUser/info")).andExpect(status().isOk());
        controller.perform(get("/BanUser/info/1")).andExpect(status().isOk());
        controller.perform(get("/User/get/WalkingDeaDJ")).andExpect(status().isOk());
        controller.perform(get("/User/get/WalkingDeaDJ/asbadsfiashd123@")).andExpect(status().isOk());
        controller.perform(get("/User/info/banned")).andExpect(status().isOk());
        controller.perform(get("/Guest/info")).andExpect(status().isOk());
        controller.perform(get("/Guest/info/1")).andExpect(status().isOk());
        controller.perform(get("/Admin/info")).andExpect(status().isOk()).andExpect(jsonPath("$[0].user.email", is("JS@iastate.edu")));
        controller.perform(post("/User/register")).andExpect(status().is(400));
        controller.perform(post("/Guest/post")).andExpect(status().is(400));
        controller.perform(delete("/BanUser/delete/5")).andExpect(status().isOk());
        controller.perform(post("/User/ban/f2e88289-ca90-43f4-9ee9-6eb11ec0ec95").content(asJsonString((new BanUser("Dirty Words!")))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        controller.perform(post("/Admin/register/f2e88289-ca90-43f4-9ee9-6eb11ec0ec95")).andExpect(status().isOk());
        controller.perform(delete("/Admin/delete/5")).andExpect(status().isOk());
    }

    @Test
    public void comment_controller_test_1() throws Exception{
        controller.perform(get("/Comment/info")).andExpect(status().isOk()).andExpect(jsonPath("$[0].rating", is(8)));
        controller.perform(post("/Comment/post/09de46ca-c78e-4c6c-8a98-b076b492cc3c/Movie/What").content(asJsonString(new Comment("Good", false, 8))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        controller.perform(post("/Comment/post/09de46ca-c78e-4c6c-8a98-b076b492cc3c/Book/Miss").content(asJsonString(new Comment("Good", false, 8))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        controller.perform(post("/Comment/post/09de46ca-c78e-4c6c-8a98-b076b492cc3c/Restaurant/CN").content(asJsonString(new Comment("Good", false, 8))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        controller.perform(post("/Comment/post/09de46ca-c78e-4c6c-8a98-b076b492cc3c/TVShow/Crazy Week").content(asJsonString(new Comment("Good", false, 8))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        controller.perform(post("/Comment/post/09de46ca-c78e-4c6c-8a98-b076b492cc3c/VideoGame/Test").content(asJsonString(new Comment("Good", false, 8))).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void comment_controller_test_2() throws Exception {
        controller.perform(get("/Comment/get/ca24411f-ae01-4aa0-82a7-632788436763")).andExpect(status().isOk());
        controller.perform(get("/Comment/info/1")).andExpect(status().isOk());
    }
    // Category Comment controller
    @Test
    public void category_comment_controller_test() throws Exception{
        controller.perform(get("/MovieComment/get/info")).andExpect(status().isOk());
        controller.perform(get("/Book/get/info")).andExpect(status().isOk());
        controller.perform(get("/Restaurant/get/info")).andExpect(status().isOk());
        controller.perform(get("/TVShowComment/get/info")).andExpect(status().isOk());
        controller.perform(get("/VideoGame/get/info")).andExpect(status().isOk());
    }

    // category controller
    @Test
    public void category_test() throws Exception{
        controller.perform(get("/Book/info")).andExpect(status().isOk());
        controller.perform(get("/Book/info/2")).andExpect(status().isOk());
        controller.perform(get("/Book/get/Spiderman")).andExpect(status().isOk());
        controller.perform(get("/Movie/info")).andExpect(status().isOk());
        controller.perform(get("/Book/info/1")).andExpect(status().isOk());
        controller.perform(get("/Book/get/CodyCody")).andExpect(status().isOk());
        controller.perform(get("/MovieComment/get/info")).andExpect(status().isOk());
        controller.perform(get("/Restaurant/info/1")).andExpect(status().isOk());
        controller.perform(get("/TVShow/info")).andExpect(status().isOk());
        controller.perform(get("/TVShow/get/name")).andExpect(status().isOk());
        controller.perform(get("/TVShow/info/1")).andExpect(status().isOk());
        controller.perform(get("/VideoGame/info")).andExpect(status().isOk());
        controller.perform(get("/VideoGame/info/1")).andExpect(status().isOk());
        controller.perform(get("/Book/info/1")).andExpect(status().isOk());
        controller.perform(get("/VideoGame/get/name")).andExpect(status().isOk());
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
