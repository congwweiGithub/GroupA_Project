package com.mall.util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import com.mall.model.ums.UmsMenu;
import com.mall.repository.ums.UmsMenuRepository;


@Component
public class LoginUtil {

	@Autowired
	private UmsMenuRepository wiredUmsMenuRepository;

	private static UmsMenuRepository umsMenuRepository;

	@PostConstruct
	private void start() {
		LoginUtil.umsMenuRepository = this.wiredUmsMenuRepository;
	}

	public static List<UmsMenu> getMenuList() {
		return umsMenuRepository.findAll();
	}

	public static List<UmsRole> getRoleList() {
		UmsRole role = UmsRole.builder()//
				.id(5l).name("超级管理员")//
				.description("拥有所有查看和操作功能")//
				.adminCount(0)//
				.status(1)//
				.sort(0)//
				.build();
		List<UmsRole> list = List.of(role);
		return list;
	}
}

@Data
@SuperBuilder
class UmsRole implements Serializable {
	private Long id;
	private String name;
	private String description;
	private Integer adminCount;
	private Date createTime;
	private Integer status;
	private Integer sort;

	private static final long serialVersionUID = 1L;

}
