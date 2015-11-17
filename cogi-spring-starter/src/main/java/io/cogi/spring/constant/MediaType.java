package io.cogi.spring.constant;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Spring 의 {@link org.springframework.http.MediaType} 확장이 불가하여 재작성
 * 추가로 확장자{@link MediaType#extension} 변수가 추가됨
 *
 * @since 1.0.0
 * @author yongseoklee
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MediaType extends MimeType {

    private static final long serialVersionUID = -2122437252483521533L;

    /**
     * Public constant mime type for <b>wildcard</b>
     */
    public static final MediaType ALL;

    /**
     * Simple string for {@link MediaType#ALL}
     */
    public static final String ALL_VALUE = "*/*";

    /**
     * Public constant mime type for <b>html</b>
     */
    public static final MediaType TEXT_HTML;

    /**
     * Extension for {@link MediaType#TEXT_HTML}
     */
    public static final String TEXT_HTML_EXTENSION = "html";

    /**
     * Simple string for {@link MediaType#TEXT_HTML}
     */
    public static final String TEXT_HTML_VALUE = "text/html";

    /**
     * Public constant mime type for <b>txt</b>
     */
    public static final MediaType TEXT_PLAIN;

    /**
     * Extension for {@link MediaType#TEXT_PLAIN}
     */
    public static final String TEXT_PLAIN_EXTENSION = "txt";

    /**
     * Simple string for {@link MediaType#TEXT_PLAIN}
     */
    public static final String TEXT_PLAIN_VALUE = "text/plain";

    /**
     * Public constant mime type for <b>csv</b>
     */
    public static final MediaType TEXT_CSV;

    /**
     * Extension for {@link MediaType#TEXT_PLAIN}
     */
    public static final String TEXT_CSV_EXTENSION = "csv";

    /**
     * Simple string for {@link MediaType#TEXT_PLAIN}
     */
    public static final String TEXT_CSV_VALUE = "text/plain";

    /**
     * Public constant mime type for <b>json</b>
     */
    public static final MediaType APPLICATION_JSON;

    /**
     * Extension for {@link MediaType#APPLICATION_JSON}
     */
    public static final String APPLICATION_JSON_EXTENSION = "json";

    /**
     * Simple string for {@link MediaType#APPLICATION_JSON}
     */
    public static final String APPLICATION_JSON_VALUE = "application/json";

    /**
     * Public constant mime type for <b>jsonp</b>
     */
    public static final MediaType APPLICATION_JSONP;

    /**
     * Extension for {@link MediaType#APPLICATION_JSONP}
     */
    public static final String APPLICATION_JSONP_EXTENSION = "jsonp";

    /**
     * Simple string for {@link MediaType#APPLICATION_JSONP}
     */
    public static final String APPLICATION_JSONP_VALUE = "application/javascript";

    /**
     * Public constant mime type for <b>xml</b>
     */
    public static final MediaType APPLICATION_XML;

    /**
     * Extension for {@link MediaType#APPLICATION_XML}
     */
    public static final String APPLICATION_XML_EXTENSION = "xml";

    /**
     * Simple string for {@link MediaType#APPLICATION_XML}
     */
    public static final String APPLICATION_XML_VALUE = "application/xml";

    /**
     * Public constant mime type for <b>Microsoft Excel 2003</b>
     */
    public static final MediaType APPLICATION_XLS;

    /**
     * Extension for {@link MediaType#APPLICATION_XLS}
     */
    public static final String APPLICATION_XLS_EXTENSION = "xls";

    /**
     * Simple string for {@link MediaType#APPLICATION_XLS}
     */
    public static final String APPLICATION_XLS_VALUE = "application/vnd.ms-excel";

    /**
     * Public constant mime type for <b>Microsoft Excel 2007</b>
     */
    public static final MediaType APPLICATION_XLSX;

    /**
     * Extension for {@link MediaType#APPLICATION_XLSX}
     */
    public static final String APPLICATION_XLSX_EXTENSION = "xlsx";

    /**
     * Simple string for {@link MediaType#APPLICATION_XLSX}
     */
    public static final String APPLICATION_XLSX_VALUE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    /**
     * Public constant mime type for <b>jpg</b>
     */
    public static final MediaType IMAGE_JPG;

    /**
     * Extension for {@link MediaType#IMAGE_JPG}
     */
    public static final String IMAGE_JPG_EXTENSION = "jpg";

    /**
     * Simple string for {@link MediaType#IMAGE_JPG}
     */
    public static final String IMAGE_JPG_VALUE = "image/jpg";

    /**
     * Public constant mime type for <b>jpeg</b>
     */
    public static final MediaType IMAGE_JPEG;

    /**
     * Extension for {@link MediaType#IMAGE_JPEG}
     */
    public static final String IMAGE_JPEG_EXTENSION = "jpeg";

    /**
     * Simple string for {@link MediaType#IMAGE_JPEG}
     */
    public static final String IMAGE_JPEG_VALUE = "image/jpeg";

    /**
     * Public constant mime type for <b>pjpg</b>
     */
    public static final MediaType IMAGE_PJPG;

    /**
     * Extension for {@link MediaType#IMAGE_JPG}
     */
    public static final String IMAGE_PJPG_EXTENSION = "pjpg";

    /**
     * Simple string for {@link MediaType#IMAGE_JPG}
     */
    public static final String IMAGE_PJPG_VALUE = "image/pjpg";

    /**
     * Public constant mime type for <b>gif</b>
     */
    public static final MediaType IMAGE_GIF;

    /**
     * Extension for {@link MediaType#IMAGE_GIF}
     */
    public static final String IMAGE_GIF_EXTENSION = "gif";

    /**
     * Simple string for {@link MediaType#IMAGE_GIF}
     */
    public static final String IMAGE_GIF_VALUE = "image/gif";

    /**
     * Public constant mime type for <b>png</b>
     */
    public static final MediaType IMAGE_PNG;

    /**
     * Extension for {@link MediaType#IMAGE_PNG}
     */
    public static final String IMAGE_PNG_EXTENSION = "png";

    /**
     * Simple string for {@link MediaType#IMAGE_PNG}
     */
    public static final String IMAGE_PNG_VALUE = "image/png";

    static {
        ALL = parseMediaType(ALL_VALUE);

        TEXT_HTML = parseMediaType(TEXT_HTML_EXTENSION, TEXT_HTML_VALUE);
        TEXT_PLAIN = parseMediaType(TEXT_PLAIN_EXTENSION, TEXT_PLAIN_VALUE);
        TEXT_CSV = parseMediaType(TEXT_CSV_EXTENSION, TEXT_CSV_VALUE);

        APPLICATION_JSON = parseMediaType(APPLICATION_JSON_EXTENSION, APPLICATION_JSON_VALUE);
        APPLICATION_JSONP = parseMediaType(APPLICATION_JSONP_EXTENSION, APPLICATION_JSONP_VALUE);
        APPLICATION_XML = parseMediaType(APPLICATION_XML_EXTENSION, APPLICATION_XML_VALUE);
        APPLICATION_XLS = parseMediaType(APPLICATION_XLS_EXTENSION, APPLICATION_XLS_VALUE);
        APPLICATION_XLSX = parseMediaType(APPLICATION_XLSX_EXTENSION, APPLICATION_XLSX_VALUE);

        IMAGE_JPG = parseMediaType(IMAGE_JPG_EXTENSION, IMAGE_JPG_VALUE);
        IMAGE_JPEG = parseMediaType(IMAGE_JPEG_EXTENSION, IMAGE_JPEG_VALUE);
        IMAGE_PJPG = parseMediaType(IMAGE_PJPG_EXTENSION, IMAGE_PJPG_VALUE);
        IMAGE_GIF = parseMediaType(IMAGE_GIF_EXTENSION, IMAGE_GIF_VALUE);
        IMAGE_PNG = parseMediaType(IMAGE_PNG_EXTENSION, IMAGE_PNG_VALUE);
    }

    private String extension;

    public MediaType(String extension, String type) {
        super(type);
        this.extension = extension;
    }

    public MediaType(String extension, String type, String subtype) {
        super(type, subtype);
        this.extension = extension;
    }

    public MediaType(String extension, String type, String subtype, Charset charSet) {
        super(type, subtype, charSet);
        this.extension = extension;
    }

    public MediaType(String extension, String type, String subtype, Map<String, String> parameters) {
        super(type, subtype, parameters);
        this.extension = extension;
    }

    public static MediaType parseMediaType(String mediaType) {
        return parseMediaType(null, mediaType);
    }

    public static MediaType parseMediaType(String extension, String mediaType) {
        MimeType type = MimeTypeUtils.parseMimeType(mediaType);
        return new MediaType(extension, type.getType(), type.getSubtype(), type.getParameters());
    }

    public static org.springframework.http.MediaType asSpringMediaType(MediaType mediaType) {
        return new org.springframework.http.MediaType(mediaType.getType(), mediaType.getSubtype(),
                mediaType.getParameters());
    }

}
