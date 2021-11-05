package seongbo.pivot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seongbo.pivot.DTO.BasicDTO.SheetRangeDTO;
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
  public Integer initSheetDataService(SheetRangeDTO dto) {
    return sheetRepository.initSheetDataRepo(dto);
  }
}
