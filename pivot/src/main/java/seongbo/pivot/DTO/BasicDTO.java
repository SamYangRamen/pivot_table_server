package seongbo.pivot.DTO;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BasicDTO {

  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class DTO<T> {
    T dto;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class TestData {
    private Integer num;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class CellDataDTO {
    private Integer sheetId;
    private boolean isPivot;
    private Integer rowKey;
    private Integer colKey;
    private String data;
    private String dataType;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class SheetRangeDTO {
    private Integer row;
    private Integer col;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class SheetDataDTO {
    private Integer sheetId;
    private SheetRangeDTO sheetRange;
    private List<CellDataDTO> cells;
  }
}
