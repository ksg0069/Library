package com.lib.fin.approval;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ApprovalService {
	
	@Value("${fin.upload}")
	private String path;
	
	@Value("${fin.approval.draft}")
	private String approvalName;
	
	@Autowired
	private ApprovalDAO approvalDAO;
	
	public int setDraft(ApprovalDocVO approvalDocVO, MultipartFile[] files)throws Exception{
		
		int result= approvalDAO.setDraft(approvalDocVO);
		
		for(MultipartFile multipartFile: files) {
			
			if(multipartFile.isEmpty()) {
				continue;
			}
		}
		return result;
	}

}
