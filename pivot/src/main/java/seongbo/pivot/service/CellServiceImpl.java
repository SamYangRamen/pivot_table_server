package seongbo.pivot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seongbo.pivot.DAO.entity.CellEntity;
import seongbo.pivot.DTO.BasicDTO.CellInitDTO;
import seongbo.pivot.DTO.BasicDTO.CellLocationDTO;
import seongbo.pivot.repository.CellRepository;
import seongbo.pivot.repository.SheetRepository;

@Slf4j
@Service
public class CellServiceImpl implements CellService {

  CellRepository cellRepository;
  SheetRepository sheetRepository;

  @Autowired
  public CellServiceImpl(CellRepository cellRepository, SheetRepository sheetRepository) {
    this.cellRepository = cellRepository;
    this.sheetRepository = sheetRepository;
  }

  @Override
  public Integer insertCellDataService(CellInitDTO dto) {
    String dataType;

    try {
      Double.parseDouble(dto.getData());
      dataType = "N";
    } catch (NumberFormatException e) {
      dataType = "S";
    }

    try {
      cellRepository.save(
          new CellEntity(dto.getSheetId(), dto.getRow(), dto.getCol(), dto.getData(), dataType,
              sheetRepository.getById(dto.getSheetId()))
      );
    } catch (Exception e) {
      return 0;
    }
    return 1;
  }

  @Override
  public Integer deleteCellDataService(CellLocationDTO dto) {
    try {
      cellRepository.deleteBySheetIdAndRowAndCol(dto.getSheetId(), dto.getRow(), dto.getCol());
    } catch (Exception e) {
      return 0;
    }

    return 1;
  }
}
