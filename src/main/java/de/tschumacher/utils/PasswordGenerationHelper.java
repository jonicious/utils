/*
   Copyright 2015 Tobias Schumacher

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package de.tschumacher.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.codec.Utf8;

public class PasswordGenerationHelper {

	public static String generateSalt() {
		return RandomStringUtils.randomAlphanumeric(15);
	}

	public static String generateSalt(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public static String salt(String password, String salt)
			throws NoSuchAlgorithmException {
		String saltedPassword = password + "{" + salt + "}";
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		byte[] digest = messageDigest.digest(Utf8.encode(saltedPassword));
		return new String(Hex.encode(digest));
	}

}
