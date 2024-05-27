package br.com.nova.erudio.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.nova.erudio.model.Person;
import br.com.nova.erudio.vo.v2.PersonVOV2;

@Service
public class PersonMapper {
	
	public PersonVOV2 convertEntityToVO(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setFirstname(person.getFirstname());
		vo.setLastname(person.getLastname());
		vo.setBirthday(new Date());
		vo.setAddress(person.getAddress());
		vo.setGender(person.getGender());
		return vo;
	}

	public Person convertVoToEntity(PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setFirstname(person.getFirstname());
		entity.setLastname(person.getLastname());
		//entity.setBirthday(new Date());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return entity;
	}

}
