package ezen.springmvc.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
@AllArgsConstructor
public class Member {
	private String id;
	private String password;
	private String name;
	private int age;
}









