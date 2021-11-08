package seongbo.pivot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import seongbo.pivot.DTO.BasicDTO.DTO;
import seongbo.pivot.DTO.BasicDTO.TestNumData;
import seongbo.pivot.DTO.BasicDTO.TestStringData;
import seongbo.pivot.service.TestService;

@Slf4j
@RestController
public class TestController {

  TestService testService;

  @Autowired
  public TestController(TestService testService) {
    this.testService = testService;
  }

  @GetMapping("/GET/test")
  @ResponseBody
  public TestNumData getTestMethod(@RequestParam("num") Integer num) {
    try {
      TestNumData testData = new TestNumData();
      testData.setData(num + 123000);
      return testData;
    } catch (Exception e) {
      TestNumData testData = new TestNumData();
      testData.setData(8888);
      return testData;
    }
  }

  @PostMapping("/POST/test")
  @ResponseBody
  public TestStringData postTestMethod(@RequestBody DTO<String> dto) {
    try {
      TestStringData testData = new TestStringData();
      testData.setData("Complete");
      testService.insertTestData(dto.getDto());
      return testData;
    } catch (Exception e) {
      TestStringData testData = new TestStringData();
      testData.setData("UNKNOWN ERROR");
      return testData;
    }
  }
}