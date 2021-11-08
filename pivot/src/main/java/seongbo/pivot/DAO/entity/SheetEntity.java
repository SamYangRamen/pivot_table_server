package seongbo.pivot.DAO.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
@Table(name="SHEET_INFO")
public class SheetEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Integer idx;
  private final String SheetName;
  private final Integer row;
  private final Integer col;
}