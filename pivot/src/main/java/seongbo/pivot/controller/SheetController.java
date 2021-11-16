package seongbo.pivot.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import seongbo.pivot.DAO.entity.SheetEntity;
import seongbo.pivot.DTO.BasicDTO.DTO;
import seongbo.pivot.DTO.BasicDTO.SheetInfoDTO;
import seongbo.pivot.DTO.BasicDTO.SheetInitDTO;
import seongbo.pivot.service.CellService;
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
  public Integer initSheetData(@RequestBody DTO<SheetInitDTO> dto) {
    sheetService.initSheetDataService(dto.getDto());
    return 1;
  }

  @DeleteMapping("DELETE/sheet")
  @ResponseBody
  public Integer deleteSheetData(@RequestBody DTO<Integer> dto) {
    return sheetService.deleteSheetDataService(dto.getDto());
  }

  @GetMapping("GET/sheetInfo")
  @ResponseBody
  public List<SheetEntity> getSheetInfoList() {
    return sheetService.getSheetInfoListService();
  }
}
