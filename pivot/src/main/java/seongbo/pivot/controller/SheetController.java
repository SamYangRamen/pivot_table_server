package seongbo.pivot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import seongbo.pivot.DTO.BasicDTO.DTO;
import seongbo.pivot.DTO.BasicDTO.TestData;
import seongbo.pivot.service.SheetService;

@Slf4j
@Controller
@RestController
public class SheetController {

  SheetService sheetService;

  @Autowired
  public SheetController(SheetService sheetService) {
    this.sheetService = sheetService;
  }

  @GetMapping("/test")
  @ResponseBody
  public TestData testMethod(@RequestParam("num") Integer num) {
    try {
      TestData testData = new TestData();
      testData.setNum(num + 123);
      return testData;
    } catch(Exception e) {
      TestData testData = new TestData();
      testData.setNum(8888);
      return testData;
    }
  }
}
