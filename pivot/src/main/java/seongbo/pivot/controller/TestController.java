package seongbo.pivot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import seongbo.pivot.DTO.BasicDTO.DTO;
import seongbo.pivot.DTO.BasicDTO.TestData;

@Slf4j
@RestController
public class TestController {

  @GetMapping("/GET/test")
  @ResponseBody
  public TestData getTestMethod(@RequestParam("num") Integer num) {
    try {
      TestData testData = new TestData();
      testData.setNum(num + 123000);
      return testData;
    } catch (Exception e) {
      TestData testData = new TestData();
      testData.setNum(8888);
      return testData;
    }
  }

  @PostMapping("/POST/test")
  @ResponseBody
  public TestData postTestMethod(@RequestBody DTO<Integer> dto) {
    try {
      TestData testData = new TestData();
      testData.setNum(dto.getDto() + 123000);
      return testData;
    } catch (Exception e) {
      TestData testData = new TestData();
      testData.setNum(8888);
      return testData;
    }
  }
}