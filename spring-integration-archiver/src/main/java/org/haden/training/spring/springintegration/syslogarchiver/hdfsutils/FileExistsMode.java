package org.haden.training.spring.springintegration.syslogarchiver.hdfsutils;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;


public enum FileExistsMode {

	/**
	 * Raise an exception in case the file to be written already exists.
	 */
	FAIL,

	/**
	 * If the file already exists, do nothing.
	 */
	IGNORE,

	/**
	 * If the file already exists, replace it.
	 */
	REPLACE;

	
	public static FileExistsMode getForString(String fileExistsModeAsString) {

		Assert.hasText(fileExistsModeAsString,
				"'fileExistsModeAsString' must neither be null nor empty.");

		final FileExistsMode[] fileExistsModeValues = FileExistsMode.values();

		for (FileExistsMode fileExistsMode : fileExistsModeValues) {
			if (fileExistsModeAsString.equalsIgnoreCase(fileExistsMode.name())) {
				return fileExistsMode;
			}
		}

		throw new IllegalArgumentException("Invalid fileExistsMode '"
				+ fileExistsModeAsString
				+ "'. The (case-insensitive) supported values are: "
				+ StringUtils.arrayToCommaDelimitedString(fileExistsModeValues));

	}

}
