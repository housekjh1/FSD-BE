package com.recycle.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Center {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String centerName;
	private String address;
	private Float lat;
	private Float lon;
	private String items;
	private String operCenter;
	private String operDigits;
	private String operName;
	private String wDOpentime;
	private String wDClosetime;
	private String hDOpentime;
	private String hDClosetime;
	private String hDInfo;
	private String managDigits;
	private String managCenter;
}
