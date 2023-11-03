package com.lib.fin.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.lib.fin.commons.CommonVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO extends CommonVO implements UserDetails{
	
	private String emp_no;

	@NotBlank(message = "비밀번호를 입력하세요")
//	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*\\\\W)(?=\\\\S+$).{6,12}", message = "비밀번호는 6~12자 영문 소문자, 숫자, 특수문자를 하나 이상 포함해야 합니다.")
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*\\W)(?=\\S+$).{6,12}", message = "비밀번호는 6~12자 영문 소문자, 숫자, 특수문자를 하나 이상 포함해야 합니다.")
	
	private String password;
	
	private String passwordCheck;
	
	@NotBlank(message = "이름을 입력하세요.")
	private String name;
	@Email(message = "이메일 형식에 맞지 않습니다.")
	private String email;
	
	private Date birth;
	@NotBlank(message = "핸드폰 번호를 입력하세요")
	private String phone;
	
	private String emp_team;
	
	private String emp_position;
	
	private int remain_holiday;
	
	private String authority;
	
	private Date emp_in_date;
	
	private Date emp_out_date;
	
	private List<ComVO> comVOs;

	
	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	@Override
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for(ComVO comVO:comVOs) {
			authorities.add(new SimpleGrantedAuthority(comVO.getCd_nm()));
		}
			
		return authorities;
	}

    // 시큐리티의 userName
    // -> 따라서 얘는 인증할 때 id를 봄
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return emp_no;
	}
	////
    @Override
	public String getPassword() {
		return password;
	}

    
    
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	


	
	
	
}
