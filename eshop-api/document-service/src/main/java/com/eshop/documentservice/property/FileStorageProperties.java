package com.eshop.documentservice.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The @ConfigurationProperties(prefix = "file") annotation binds all the
 * properties with prefix file to the corresponding fields of this POJO class on
 * application startup.
 *
 */
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {

	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
}
