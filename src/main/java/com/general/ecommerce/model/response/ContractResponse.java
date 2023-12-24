package com.general.ecommerce.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(value = "NetworkingResponse", description = "encapsulates an api response")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ContractResponse<T> {

  //    @ApiModelProperty(value = "The http response status", accessMode =
  // ApiModelProperty.AccessMode.READ_ONLY)
  //    private ResponseError error;

  private T response;

  @ApiModelProperty(
      value = "String",
      example = "Tue Jan 12 16:36:32 EST 2021",
      notes = "Request Timestamp in format EEE MMM dd HH:mm:ss z yyyy")
  @Builder.Default
  private String timestamp =
      DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy", Locale.getDefault())
          .format(ZonedDateTime.now());

  private String path;
}
