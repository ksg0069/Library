package com.lib.fin.approval;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.lib.fin.commons.Pager;
import com.lib.fin.member.MemberVO;

@Mapper
public interface ApprovalDAO {
	
	//fileADD
	public int setFileAdd(ApprovalFileVO approvalFileVO)throws Exception;
	
	//draft Add
	public int setDraft(ApprovalDocVO approvalDocVO)throws Exception;
	
	//draft detail
	public ApprovalDocVO getDraftDetail(ApprovalDocVO approvalDocVO)throws Exception;

	//his add
	public int setApprovalHis(ApprovalHisVO approvalHisVO)throws Exception;
	
	//docList
	public List<ApprovalDocVO> getAppDocList(Map<String, Object> params)throws Exception;
	
	public List<ApprovalHisVO> getAppLine(String doc_no)throws Exception;
	
	public int docApproval(Map<String,Object> param)throws Exception;
	
	public int docBaseApproval(Map<String,Object> param)throws Exception;
	
	//signAdd
	public int addSign(MemberVO memberVO)throws Exception;
	
	//update
	public int setTempUpdate(ApprovalDocVO approvalDocVO)throws Exception;

	public Long getTotal(Map<String, Object> params)throws Exception;
}
