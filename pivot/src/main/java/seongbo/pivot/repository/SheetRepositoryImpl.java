package seongbo.pivot.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import seongbo.pivot.DTO.BasicDTO.SheetRangeDTO;

@Slf4j
@Service
public class SheetRepositoryImpl implements SheetRepository {

  @Override
  public Integer initSheetDataRepo(SheetRangeDTO dto) {
    return 0;
  }
}
