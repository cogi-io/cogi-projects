package io.cogi.spring.util.matcher;

import lombok.Data;
import io.cogi.spring.constant.MediaType;

/**
 * Json 요청 판단
 *
 * @since 1.0.0
 * @author yongseoklee​
 */
@Data
public class JsonRequestMatcher extends MediaTypeRequestMatcher {

    @Override
    public MediaType getMediaType() {
        return MediaType.APPLICATION_JSON;
    }

}
