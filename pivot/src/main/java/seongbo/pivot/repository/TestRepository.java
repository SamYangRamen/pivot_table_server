package seongbo.pivot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import seongbo.pivot.DAO.entity.TestTableEntity;

public interface TestRepository extends JpaRepository<TestTableEntity, Integer> {
  TestTableEntity findByIdx(Integer idx);

  @Query(value = "SELECT MAX(m.idx) AS idx FROM TestTableEntity m")
  public Integer max();
  // TestTableEntity save(String data);
}
