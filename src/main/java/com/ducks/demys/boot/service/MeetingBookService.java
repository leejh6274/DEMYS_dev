package com.ducks.demys.boot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ducks.demys.boot.repository.Mb_AttachRepository;
import com.ducks.demys.boot.repository.MeetingBookRepository;
import com.ducks.demys.boot.vo.MeetingBook;

@Service
public class MeetingBookService {
   
   private MeetingBookRepository meetingBookRepository;
   private Mb_AttachRepository mb_AttachRepository;
   
   public MeetingBookService(MeetingBookRepository meetingBookRepository, Mb_AttachRepository mb_AttachRepository) {
      this.meetingBookRepository= meetingBookRepository;
      this.mb_AttachRepository = mb_AttachRepository;
   }
   
   public List<MeetingBook> getMeetingBookListByPJ_NUM(int PJ_NUM){
      return meetingBookRepository.getMeetingBookListByPJ_NUM(PJ_NUM);
   }
   
   public List<MeetingBook> getSearchMeetingbook(Object PJ_NUM, String searchKeywordTypeCode, String searchKeyword) {
      List<MeetingBook> meetingbook = meetingBookRepository.getSearchMeetingbook(PJ_NUM, searchKeywordTypeCode, searchKeyword);
      return meetingbook;
   }
   
   public MeetingBook getMeetingBookByMB_NUM(int MB_NUM){
      return meetingBookRepository.getMeetingBookByMB_NUM(MB_NUM);
   }
   
   public void registMeetingBook(MeetingBook meetingBook) {
      meetingBook.setMB_NUM(meetingBookRepository.selectMeetingBookSequenceNextValue());
      meetingBookRepository.registMeetingBook(meetingBook);
      
      if(meetingBook.getMb_attach()!= null) {
    	  meetingBook.getMb_attach().setMB_NUM(meetingBook.getMB_NUM());
    	  mb_AttachRepository.registMb_Attach(meetingBook.getMb_attach());
      }
   }
   
   public void modifyMeetingBook(MeetingBook meetingBook) {
      meetingBookRepository.modifyMeetingBook(meetingBook);
   }
   
   public void removeMeetingBook(int MB_NUM) {
      meetingBookRepository.removeMeetingBook(MB_NUM);
   }
}