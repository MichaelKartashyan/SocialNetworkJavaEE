package Models;

import java.sql.Timestamp;

public class Comment {
    private Long id;
    private String comment;
    private Long postId;
    private Users user;
    private Timestamp date;

    public Comment() {
    }

    public Comment(String comment, Long postId, Users user, Timestamp date) {
        this.comment = comment;
        this.postId = postId;
        this.user = user;
        this.date = date;
    }

    public Comment(Long id, String comment, Long postId, Users user, Timestamp date) {
        this.id = id;
        this.comment = comment;
        this.postId = postId;
        this.user = user;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }



    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
