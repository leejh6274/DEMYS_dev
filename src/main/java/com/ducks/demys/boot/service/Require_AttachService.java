package com.ducks.demys.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ducks.demys.boot.repository.Require_AttachRepository;
import com.ducks.demys.boot.vo.Product_Attach;
import com.ducks.demys.boot.vo.Require_Attach;

@Service
public class Require_AttachService {
	
	private Require_AttachRepository require_AttachRepository;
	
	public Require_AttachService(Require_AttachRepository require_AttachRepository) {
		this.require_AttachRepository= require_AttachRepository;
	}
	
	public List<Require_Attach> getRequire_AttachListByREQUIRE_NUM(int REQUIRE_NUM){
		return require_AttachRepository.getRequire_AttachListByREQUIRE_NUM(REQUIRE_NUM);
	}

	
	public Require_Attach getRqatByRQAT_NUM(int RQAT_NUM) {
		return require_AttachRepository.getRqatByRQAT_NUM(RQAT_NUM);
	}
	
	public Require_Attach getRqatByREQUIRE_NUM(int REQUIRE_NUM) {
		return require_AttachRepository.getRqatByREQUIRE_NUM(REQUIRE_NUM);
	}
	
	public void registRequire_Attach(Require_Attach rqat) {
		rqat.setRQAT_NUM(require_AttachRepository.selectRequire_AttachSequenceNextValue());
		require_AttachRepository.registRequire_Attach(rqat);
	}
	
	public void removeRequire_Attach(int RQAT_NUM) {
		require_AttachRepository.removeRequire_Attach(RQAT_NUM);
	}
	
	public void removeRequire_AttachAll(int REQUIRE_NUM) {
		require_AttachRepository.removeRequire_AttachAll(REQUIRE_NUM);
	}
	
}
