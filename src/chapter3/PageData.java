package chapter3;

public class PageData {
    String html;
    WikiPage wikiPage;
    String content;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public WikiPage getWikiPage() {
        return wikiPage;
    }

    public void setWikiPage(WikiPage wikiPage) {
        this.wikiPage = wikiPage;
    }


    public boolean hasAttribute(String test) {
        return true;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
