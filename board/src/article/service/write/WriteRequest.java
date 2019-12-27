package article.service.write;

import article.model.Writer;

import java.util.Map;

// 게시글에 필요한 정보를 담아서 service에 전달.
public class WriteRequest {
    private Writer writer;
    private String title;
    private String content;

    public WriteRequest(Writer writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Writer getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void validate(Map<String, Boolean> errors) {
        if (title == null || title.trim().isEmpty()) {
            errors.put("title", Boolean.TRUE);
        }
    }

}
