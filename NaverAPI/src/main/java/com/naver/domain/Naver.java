package com.naver.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Naver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	private LocalDateTime dateTime;
	@Column(name = "a_values")
	private Double aValues;
	@Column(name = "b_values")
	private Double bValues;
	@Column(name = "c_values")
	private Double cValues;
	@Column(name = "d_values")
	private Double dValues;
	@Column(name = "e_values")
	private Double eValues;
	@Column(name = "f_values")
	private Double fValues;
	@Column(name = "g_values")
	private Double gValues;
	@Column(name = "h_values")
	private Double hValues;
	@Column(name = "i_values")
	private Double iValues;
	@Column(name = "j_values")
	private Double jValues;
	@Column(name = "l_values")
	private Double lValues;
	@Column(name = "m_values")
	private Double mValues;
	@Column(name = "n_values")
	private Double nValues;
	@Column(name = "o_values")
	private Double oValues;
	@Column(name = "p_values")
	private Double pValues;
	@Column(name = "q_values")
	private Double qValues;
	@Column(name = "s_values")
	private Double sValues;
	@Column(name = "t_values")
	private Double tValues;
	@Column(name = "u_values")
	private Double uValues;
	@Column(name = "v_values")
	private Double vValues;
	@Column(name = "w_values")
	private Double wValues;
}
