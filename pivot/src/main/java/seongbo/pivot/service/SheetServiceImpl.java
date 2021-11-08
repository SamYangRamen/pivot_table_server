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
    Integer maxIdx;

    try {
      maxIdx = sheetRepository.findFirstByOrderByIdxDesc().getIdx();
    } catch (Exception e) {
      maxIdx = 0;
    }

    sheetRepository.save(
        new SheetEntity(maxIdx + 1, dto.getSheetName(), dto.getRow(), dto.getCol()));
    return 1;
  }
}
