package seongbo.pivot.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import seongbo.pivot.DAO.entity.CellEntity;

public interface CellRepository extends JpaRepository<CellEntity, Integer> {

  @Transactional
  void deleteBySheetIdAndRowAndCol(Integer sheetId, Integer Row, Integer Col);
}
