package seongbo.pivot.DAO;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BasicDAO {

  @Data
  @RequiredArgsConstructor
  @NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
  @Entity
  public static class TestData {

    @Id
    private Integer num;
  }
}
