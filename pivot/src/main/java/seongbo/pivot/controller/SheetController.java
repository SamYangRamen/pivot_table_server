package seongbo.pivot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import seongbo.pivot.DTO.BasicDTO.DTO;
import seongbo.pivot.DTO.BasicDTO.SheetRangeDTO;
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

  @PostMapping("POST/sheet")
  @ResponseBody
  public Integer initSheetData(@RequestBody DTO<SheetRangeDTO> dto) {
    return sheetService.initSheetDataService(dto.getDto());
  }
}
