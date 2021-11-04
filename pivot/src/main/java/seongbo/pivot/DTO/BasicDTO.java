package seongbo.pivot.DTO;

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
    Integer num;
  }
}
