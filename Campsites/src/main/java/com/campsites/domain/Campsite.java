package com.campsites.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Campsite {

	@Id
	private String campName;
	private String campType;
	private Float lat;
	private Float lng;
	private String address;
	private Integer numNormCamp;
	private Integer numCarCamp;
	private Integer numGlamping;
	private Integer numCaravan;
	private Integer numRestroom;
	private Integer numShowerRoom;
	private Integer numSink;
	private Integer numFireExtinguisher;
	private Integer numFireExtinguisherWater;
	private Integer numFireSand;
	private Integer numFireDetector;
	private String OtherFacilities1;
	private String OtherFacilities2;
}
