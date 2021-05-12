package http;


import lombok.Data;

/**
 * @author lryepoch
 * @date 2020/6/29 18:25
 * @description TODO
 */
@Data
public class Email {
    private String rc;
    private String cc;
    private String head;
    private String content;

}
