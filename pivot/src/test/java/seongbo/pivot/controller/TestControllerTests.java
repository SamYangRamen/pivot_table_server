package seongbo.pivot.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import sun.awt.image.ImageWatched.Link;

@SpringBootTest(classes = {TestController.class})
@AutoConfigureMockMvc
public class TestControllerTests {

  private MockMvc mockMvc;

  @Autowired
  public TestControllerTests(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @BeforeEach
  public void before() {
    mockMvc =
        MockMvcBuilders
            .standaloneSetup(TestController.class)
            .alwaysExpect(
                MockMvcResultMatchers.status().isOk()
            ).build();
  }

  @Test
  public void checkGetTestMethod() throws Exception {
    MultiValueMap<String, String> info = new LinkedMultiValueMap<>();

    info.add("num", "456");
    mockMvc.perform(
            MockMvcRequestBuilders
                .get("/GET/test")
                .params(info)
        ).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().json("{'num':123456}"))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void checkPostTestMethod() throws Exception {
    MultiValueMap<String, String> info = new LinkedMultiValueMap<>();

    info.add("num", "456");
    mockMvc.perform(
            MockMvcRequestBuilders
                .post("/POST/test")
                .params(info)
        ).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().json("{'num':123456}"))
        .andDo(MockMvcResultHandlers.print());
  }
}