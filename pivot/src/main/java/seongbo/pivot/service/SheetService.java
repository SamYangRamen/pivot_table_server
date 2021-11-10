package seongbo.pivot.service;

import seongbo.pivot.DTO.BasicDTO.SheetInitDTO;

public interface SheetService {

  public Integer initSheetDataService(SheetInitDTO dto);

  public Integer deleteSheetDataService(Integer sheetId);
}
