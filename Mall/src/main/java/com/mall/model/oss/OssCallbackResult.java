package com.mall.model.oss;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OssCallbackResult {

	private String filename;
	// 文件名称

	private String height;
	// 图片文件的高

	private String mimeType;
	// 文件的mimeType

	private String size;
	// 文件大小

	private String width;
	// 图片文件的宽

}
