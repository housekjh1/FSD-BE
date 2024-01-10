package com.naver.domain.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PoolADTO {

	private LocalDateTime dateTime;
	private Double data1;
	private Double data2;
	private Double data3;
	private Double data4;
}
