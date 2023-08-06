package com.example.Lombok;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDetail {

	@Id
	private int id;
	private String name;
	private String phone;
	private int age;
}
