package seongbo.pivot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seongbo.pivot.DAO.entity.SheetEntity;
import seongbo.pivot.DTO.BasicDTO.SheetRangeDTO;

public interface SheetRepository extends JpaRepository<SheetEntity, Integer> {
  SheetEntity findFirstByOrderByIdxDesc();
}
