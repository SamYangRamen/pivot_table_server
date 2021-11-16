package seongbo.pivot.service;

import java.util.List;
import seongbo.pivot.DAO.entity.SheetEntity;
import seongbo.pivot.DTO.BasicDTO.SheetInfoDTO;
import seongbo.pivot.DTO.BasicDTO.SheetInitDTO;

public interface SheetService {

  public Integer initSheetDataService(SheetInitDTO dto);

  public Integer deleteSheetDataService(Integer sheetId);

  public List<SheetEntity> getSheetInfoListService();
}
