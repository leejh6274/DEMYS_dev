package com.ducks.demys.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ducks.demys.boot.repository.RequireRepository;
import com.ducks.demys.boot.repository.Require_AttachRepository;
import com.ducks.demys.boot.vo.Product;
import com.ducks.demys.boot.vo.Require;

@Service
public class RequireService {
   
   private RequireRepository requireRepository;
   private Require_AttachRepository require_AttachRepository;
   
   public RequireService(RequireRepository requireRepository, Require_AttachRepository require_AttachRepository) {
      this.requireRepository = requireRepository;
      this.require_AttachRepository = require_AttachRepository;
   }

   public List<Require> getRequireListByPJ_NUM(int PJ_NUM){
      return requireRepository.getRequireListByPJ_NUM(PJ_NUM);
   }
   
   public List<Require> getSearchRequire(String searchKeywordTypeCode, String searchKeyword, int PJ_NUM) {
      List<Require> require = requireRepository.getSearchRequire(searchKeywordTypeCode, searchKeyword,PJ_NUM);
      return require;
   }

   public Require getRequireByREQUIRE_NUM(int REQUIRE_NUM){
      Require requireList = requireRepository.getRequireByREQUIRE_NUM(REQUIRE_NUM);
      return requireList;
   }
   
   public void registRequire(Require require) {
      require.setREQUIRE_NUM(requireRepository.selectRequireSequenceNextValue());
      requireRepository.registRequire(require);
      
      if(require.getRequire_attach() != null) {
    	  require.getRequire_attach().setREQUIRE_NUM(require.getREQUIRE_NUM());
    	  require_AttachRepository.registRequire_Attach(require.getRequire_attach());
      }
   }
   
   public void modifyRequire(Require require) {
      requireRepository.modifyRequire(require);
   }
   
   public void removeRequire(int REQUIRE_NUM) {
      requireRepository.removeRequire(REQUIRE_NUM);
   }
}