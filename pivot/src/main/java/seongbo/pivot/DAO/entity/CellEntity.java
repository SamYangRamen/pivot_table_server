package seongbo.pivot.DAO.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
//(access = AccessLevel.PRIVATE, force = true)
@Entity
@Table(name = "CELL_INFO")
@IdClass(CellEntityPK.class)
public class CellEntity {

  @Id
  private Integer sheetId;
  @Id
  private Integer row;
  @Id
  private Integer col;
  private String data;
  private String dataType;

  @ManyToOne(targetEntity = SheetEntity.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "sheetId", insertable = false, updatable = false)
  private SheetEntity SHEET_INFO;
}