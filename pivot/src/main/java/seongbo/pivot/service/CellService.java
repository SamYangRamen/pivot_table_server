package seongbo.pivot.service;

import javax.transaction.Transactional;
import seongbo.pivot.DTO.BasicDTO.CellInitDTO;
import seongbo.pivot.DTO.BasicDTO.CellLocationDTO;

public interface CellService {

  public Integer insertCellDataService(CellInitDTO dto);

  @Transactional
  public Integer deleteCellDataService(CellLocationDTO dto);
}
