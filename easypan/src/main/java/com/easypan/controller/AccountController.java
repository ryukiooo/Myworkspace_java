package com.easypan.controller;

import java.io.IOException;
import java.util.List;

import com.easypan.annotation.GlobalInterceptor;
import com.easypan.annotation.VerifyParam;
import com.easypan.entity.constants.Constants;
import com.easypan.entity.dto.CreateImageCode;
import com.easypan.entity.enums.VerifyRegexEnum;
import com.easypan.entity.query.UserInfoQuery;
import com.easypan.entity.po.UserInfo;
import com.easypan.entity.vo.ResponseVO;
import com.easypan.exception.BusinessException;
import com.easypan.service.EmailCodeService;
import com.easypan.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户信息 Controller
 */
@RestController("accountController")
public class AccountController extends ABaseController{

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private EmailCodeService emailCodeService;
	@GetMapping("checkCode")
	public void checkCode(HttpServletResponse response, HttpSession session, Integer type) throws
			IOException {
		CreateImageCode vCode = new CreateImageCode(130, 38, 5, 10);
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		String code = vCode.getCode();

		if (type == null || type == 0) {
			session.setAttribute(Constants.CHECK_CODE_KEY, code);
		} else {
			session.setAttribute(Constants.CHECK_CODE_KEY_EMAIL, code);
		}
		vCode.write(response.getOutputStream());
	}

	@PostMapping("sendEmailCode")
	@GlobalInterceptor(checkParams = true)
	public ResponseVO sendEmailCode(HttpSession session,
									@VerifyParam(required = true ,regex = VerifyRegexEnum.EMAIL,max = 150) String email,
									@VerifyParam(required = true) String checkCode,
									@VerifyParam(required = true) Integer type){
		try {
			if(!checkCode.equalsIgnoreCase((String) session.getAttribute(Constants.CHECK_CODE_KEY_EMAIL))){
				throw new BusinessException("checkCode error");
			}
			emailCodeService.sendEmailCode(email,type);

			return getSuccessResponseVO(null);
		}finally {
			session.removeAttribute(Constants.CHECK_CODE_KEY_EMAIL);
		}

	}

	@PostMapping("register")
	@GlobalInterceptor(checkParams = true)
	public ResponseVO register(HttpSession session,
									@VerifyParam(required = true,regex = VerifyRegexEnum.EMAIL,max = 150) String email,
									@VerifyParam(required = true) String nickName,
									@VerifyParam(required = true,regex = VerifyRegexEnum.PASSWORD) String password,
									@VerifyParam(required = true) String checkCode,
									@VerifyParam(required = true) String emailCode){
		try {
			if(!checkCode.equalsIgnoreCase((String) session.getAttribute(Constants.CHECK_CODE_KEY_EMAIL))){
				throw new BusinessException("checkCode error");
			}
			userInfoService.register(email,nickName,password,emailCode);

			return getSuccessResponseVO(null);
		}finally {
			session.removeAttribute(Constants.CHECK_CODE_KEY_EMAIL);
		}

	}




}