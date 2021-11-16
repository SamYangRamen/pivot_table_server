package seongbo.pivot.service;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seongbo.pivot.DAO.entity.SheetEntity;
import seongbo.pivot.DTO.BasicDTO.SheetInfoDTO;
import seongbo.pivot.DTO.BasicDTO.SheetInitDTO;
import seongbo.pivot.repository.SheetRepository;

@Slf4j
@Service
public class SheetServiceImpl implements SheetService {

  SheetRepository sheetRepository;

  @Autowired
  public SheetServiceImpl(SheetRepository sheetRepository) {
    this.sheetRepository = sheetRepository;
  }

  @Override
  public Integer initSheetDataService(SheetInitDTO dto) {
    Integer maxSheetId;

    try {
      maxSheetId = sheetRepository.findFirstByOrderBySheetIdDesc().getSheetId();
    } catch (Exception e) {
      maxSheetId = 0;
    }

    SheetEntity sheetEntity = new SheetEntity();
    sheetEntity.setSheetId(maxSheetId + 1);
    sheetEntity.setSheetName(dto.getSheetName());
    sheetEntity.setMaxRow(dto.getMaxRow());
    sheetEntity.setMaxCol(dto.getMaxCol());
    sheetRepository.save(sheetEntity);
    return maxSheetId + 1;
  }

  @Override
  public Integer deleteSheetDataService(Integer sheetId) {
    try {
      sheetRepository.deleteById(sheetId);
    } catch (Exception e) {
      return 0;
    }

    return 1;
  }

  @Override
  public List<SheetEntity> getSheetInfoListService() {
    try {
      return sheetRepository.findAll();
      /*
      List<SheetEntity> selectedData = sheetRepository.findAll();
      List<SheetInfoDTO> returnData = new ArrayList<>();
      for(SheetEntity item : selectedData) {
        returnData.add(new SheetInfoDTO(item.getSheetId(), item.getSheetName(), item.getMaxRow(), item.getMaxCol()));
      }

      return returnData;
      */
    } catch (Exception e) {
      return null;
    }
  }
}
