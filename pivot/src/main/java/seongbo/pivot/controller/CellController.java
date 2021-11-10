package seongbo.pivot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import seongbo.pivot.DTO.BasicDTO.CellDataDTO;
import seongbo.pivot.DTO.BasicDTO.CellInitDTO;
import seongbo.pivot.DTO.BasicDTO.CellLocationDTO;
import seongbo.pivot.DTO.BasicDTO.DTO;
import seongbo.pivot.DTO.BasicDTO.SheetInitDTO;
import seongbo.pivot.service.CellService;
import seongbo.pivot.service.SheetService;

@Slf4j
@Controller
@RestController
public class CellController {

  CellService cellService;

  @Autowired
  public CellController(CellService cellService) {
    this.cellService = cellService;
  }

  @PostMapping("POST/cell")
  @ResponseBody
  public Integer insertCellData(@RequestBody DTO<CellInitDTO> dto) {
    return cellService.insertCellDataService(dto.getDto());
  }

  @DeleteMapping("DELETE/cell")
  @ResponseBody
  public Integer deleteSheetData(@RequestBody DTO<CellLocationDTO> dto) {
    return cellService.deleteCellDataService(dto.getDto());
  }
}