package seongbo.pivot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seongbo.pivot.DAO.entity.SheetEntity;
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
    return 1;
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
}
