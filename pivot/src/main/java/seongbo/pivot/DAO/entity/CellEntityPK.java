package seongbo.pivot.DAO.entity;

import java.io.Serializable;
import javax.persistence.Column;
import lombok.Data;

@Data
public class CellEntityPK implements Serializable {

  @Column(name = "sheetId")
  private Integer sheetId;

  @Column(name = "row")
  private Integer row;

  @Column(name = "col")
  private Integer col;
}
