package Models;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Post {
    private Long id;
    private String postText;
    private Timestamp date;
    private Users user;
    private int countLike;
    private ArrayList<Comment> comments;
    private Long forUsers;

    public Post() {
    }

    public Post(String postText, Timestamp date, Users user, int countLike,Long forUsers) {
        this.postText = postText;
        this.date = date;
        this.user = user;
        this.countLike = countLike;
        this.forUsers = forUsers;
    }

    public Post(Long id, String postText, Timestamp date, Users user, int countLike,Long forUsers) {
        this.id = id;
        this.postText = postText;
        this.date = date;
        this.user = user;
        this.countLike = countLike;
        this.forUsers = forUsers;
    }

    public Post(Long id, String postText, Timestamp date, Users user, int countLike, ArrayList<Comment> comments,Long forUsers) {
        this.id = id;
        this.postText = postText;
        this.date = date;
        this.user = user;
        this.countLike = countLike;
        this.comments = comments;
        this.forUsers = forUsers;
    }

    public Post(String postText, Timestamp date, Users user, int countLike, ArrayList<Comment> comments, Long forUsers) {
        this.postText = postText;
        this.date = date;
        this.user = user;
        this.countLike = countLike;
        this.comments = comments;
        this.forUsers = forUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
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

    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int countLike) {
        this.countLike = countLike;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public Long getForUsers() {
        return forUsers;
    }

    public void setForUsers(Long forUsers) {
        this.forUsers = forUsers;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postText='" + postText + '\'' +
                ", date=" + date +
                ", user=" + user +
                ", countLike=" + countLike +
                '}';
    }
}
