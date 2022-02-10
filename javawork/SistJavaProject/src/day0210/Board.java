package day0210;

public class Board {
  String name;
  String subject;
  String content;

  public Board(String name, String subject, String content) {
    super();
    this.name = name;
    this.subject = subject;
    this.content = content;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


}
