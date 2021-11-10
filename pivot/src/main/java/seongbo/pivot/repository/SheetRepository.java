package seongbo.pivot.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import seongbo.pivot.DAO.entity.SheetEntity;

public interface SheetRepository extends JpaRepository<SheetEntity, Integer> {

  @Transactional
  void deleteBySheetIdAndSheetName(Integer sheetId, String sheetName);

  SheetEntity findFirstByOrderBySheetIdDesc();
}
