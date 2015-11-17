package io.cogi.spring.security.authentication.encoding;

import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

/**
 * Salt 입력가능한 BCryptPasswordEncoder
 *
 * @since 1.0.0
 * @author yongseoklee
 */
@SuppressWarnings("deprecation")
@Slf4j
@Component
public class BCryptPasswordEncoder implements PasswordEncoder {

    private static final Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");

    /**
     * 비밀번호 암호화
     *
     * @param rawPass 평문 비밀번호
     * @param salt Salt 키
     * @return 암호화된 비밀번호
     */
    @Override
    public String encodePassword(String rawPass, Object salt) {
        return BCrypt.hashpw(rawPass, String.valueOf(salt));
    }

    /**
     * 비밀번호 검증
     *
     * @param encPass 암호화된 비밀번호
     * @param rawPass 평문 비밀번호
     * @param salt Salt 키
     * @return true or false
     */
    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        if (encPass == null || encPass.length() == 0) {
            log.warn("Empty encoded password");
            return false;
        }

        if (!BCRYPT_PATTERN.matcher(encPass).matches()) {
            log.warn("Encoded password does not look like BCrypt");
            return false;
        }

        return encPass.equals(BCrypt.hashpw(rawPass, String.valueOf(salt)));
    }

    /**
     * Salt 키 생성기
     * 
     * @return Salt 키
     */
    public String generatorSalt() {
        return BCrypt.gensalt();
    }

}
