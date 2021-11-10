package seongbo.pivot.DAO.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor //(access = AccessLevel.PRIVATE, force = true)
@Entity
@Table(name = "SHEET_INFO")
public class SheetEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer sheetId;
  private String sheetName;
  private Integer maxRow;
  private Integer maxCol;

  /*
  @OneToMany(mappedBy = "sheetEntity", cascade = CascadeType.ALL)
  @JoinColumn(name = "sheetId")
  private List<CellEntity> cellEntities = new ArrayList<>();
  */
}