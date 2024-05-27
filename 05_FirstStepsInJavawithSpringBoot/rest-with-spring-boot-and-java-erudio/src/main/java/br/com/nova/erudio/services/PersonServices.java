package br.com.nova.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nova.erudio.exception.ResourceNotFoundException;
import br.com.nova.erudio.mapper.dozerMapper;
import br.com.nova.erudio.mapper.custom.PersonMapper;
import br.com.nova.erudio.model.Person;
import br.com.nova.erudio.repositories.PersonRepository;
import br.com.nova.erudio.vo.v1.PersonVO;
import br.com.nova.erudio.vo.v2.PersonVOV2;

@Service
public class PersonServices {


	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() {
		return dozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO findByid(Long id) {

		logger.info("Find one person");

		var entity = repository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		return dozerMapper.parseObject(entity, PersonVO.class);
	}

	public PersonVO create(PersonVO person) {
		
		logger.info("Create One PersonVO");
		var entity = dozerMapper.parseObject(person, Person.class);
		var vo =  dozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public PersonVOV2 createV2(PersonVOV2 person) {
		
		logger.info("Create One PersonVOV2");
		var entity = mapper.convertVoToEntity(person);
		var vo =  mapper.convertEntityToVO(repository.save(entity));
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		
		logger.info("Updating person");
		
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		entity.setFirstname(person.getFirstname());
		entity.setLastname(person.getLastname());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo =  dozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}

	public void delete(Long id) {
		logger.info("Delete person");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

		repository.delete(entity);
	}

	
}
