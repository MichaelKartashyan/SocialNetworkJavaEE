package DB;

import Models.Comment;
import Models.Post;
import Models.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;
    private  static String imagePath = "/image/avatarDefault.jpg";
    private static String defaultValues = "Не указано";
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/social_network?serverTimezone=UTC","root","");

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static boolean isExist(String email) {
        boolean tru = false;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from users where email=?");
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                tru = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tru;
    }

    public static boolean addUser(Users user) {
        int rows = 0;

        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users"+
                    "(u_name,surname,password,email,university,about,birthdate,gender,city,phone,image_path,followers_count,subscribers_count,post_count)"+
                    "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,defaultValues);
            preparedStatement.setString(6,defaultValues);
            preparedStatement.setString(7,user.getBirthdate());
            preparedStatement.setString(8,user.getGender());
            preparedStatement.setString(9,defaultValues);
            preparedStatement.setInt(10,0);
            preparedStatement.setString(11,imagePath);
            preparedStatement.setInt(12,0);
            preparedStatement.setInt(13,0);
            preparedStatement.setInt(14,0);
            rows = preparedStatement.executeUpdate();
        }catch (Exception e){e.printStackTrace();}

        return rows>0;
    }

    public static Users logIn(String email, String password) {
        Users user = new Users();
        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users " +
                    "WHERE email=? AND password=?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                user = new Users(resultSet.getLong("id"),
                        resultSet.getString("u_name"),
                        resultSet.getString("surname"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("university"),
                        resultSet.getString("about"),
                        resultSet.getString("birthdate"),
                        resultSet.getString("gender"),
                        resultSet.getString("city"),
                        resultSet.getInt("phone"),
                        resultSet.getString("image_path"),
                        resultSet.getInt("followers_count"),
                        resultSet.getInt("subscribers_count"),
                        resultSet.getInt("post_count")
                        );
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }



    public static Users getUser(Long id) {
        Users user = new Users();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users " +
                    "WHERE id=?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                user = new Users(resultSet.getLong("id"),
                        resultSet.getString("u_name"),
                        resultSet.getString("surname"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("university"),
                        resultSet.getString("about"),
                        resultSet.getString("birthdate"),
                        resultSet.getString("gender"),
                        resultSet.getString("city"),
                        resultSet.getInt("phone"),
                        resultSet.getString("image_path"),
                        resultSet.getInt("followers_count"),
                        resultSet.getInt("subscribers_count"),
                        resultSet.getInt("post_count")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }




    public static Users getUserById(Long id) {
        Users user = new Users();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users " +
                    "WHERE id=?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                user = new Users(resultSet.getLong("id"),
                        resultSet.getString("u_name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("university"),
                        resultSet.getString("about"),
                        resultSet.getString("birthdate"),
                        resultSet.getString("gender"),
                        resultSet.getString("city"),
                        resultSet.getInt("phone"),
                        resultSet.getString("image_path"),
                        resultSet.getInt("followers_count"),
                        resultSet.getInt("subscribers_count"),
                        resultSet.getInt("post_count")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }


    public static Users getUserByEmail(String email) {
        Users user = new Users();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users " +
                    "WHERE email=?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                user = new Users(resultSet.getLong("id"),
                        resultSet.getString("u_name"),
                        resultSet.getString("surname"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("university"),
                        resultSet.getString("about"),
                        resultSet.getString("birthdate"),
                        resultSet.getString("gender"),
                        resultSet.getString("city"),
                        resultSet.getInt("phone"),
                        resultSet.getString("image_path"),
                        resultSet.getInt("followers_count"),
                        resultSet.getInt("subscribers_count"),
                        resultSet.getInt("post_count")
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static boolean updateUser(Users user) {
        int row = 0;

        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE users " +
                    "SET u_name=?, " +
                    " surname=?, password=?, email=?,university=?,about=?,city=?,phone=?,image_path=?,followers_count=?,subscribers_count=?,post_count=? " +
                    "WHERE id=?");

            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getUniversity());
            statement.setString(6, user.getAbout());
            statement.setString(7, user.getCity());
            statement.setInt(8, user.getPhone());
            statement.setString(9, user.getImagePath());
            statement.setInt(10, user.getFollowersCount());
            statement.setInt(11, user.getSubscribersCount());
            statement.setInt(12, user.getPostCount());
            statement.setLong(13, user.getId());

            row = statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return row>0;
    }

    public static boolean addPost(Post post) {
        int rows = 0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO posts "+
                    "(post_text,date,user_id,count_like,for_user) "+
                    "VALUES (?,?,?,?,?)");
            preparedStatement.setString(1,post.getPostText());
            preparedStatement.setTimestamp(2,post.getDate());
            preparedStatement.setLong(3,post.getUser().getId());
            preparedStatement.setInt(4,post.getCountLike());
            preparedStatement.setLong(5,post.getForUsers());
            rows = preparedStatement.executeUpdate();
        }catch (Exception e){e.printStackTrace();}
        return rows>0;
    }

    public static ArrayList<Post> getPostsById(Long id) {

        ArrayList<Post> posts = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT p.id, p.post_text, p.date,p.count_like,p.for_user, " +
                            " u.id as id_poster, " +
                            "u.u_name, u.surname,u.image_path" +
                            " from posts p " +
                            "inner join users u on p.user_id = u.id where p.for_user=?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                posts.add(new Post(
                                resultSet.getLong("p.id"),
                                resultSet.getString("post_text"),
                                resultSet.getTimestamp("date"),
                                new Users(
                                        resultSet.getLong("id_poster"),
                                        resultSet.getString("u_name"),
                                        resultSet.getString("surname"),
                                        resultSet.getString("image_path")
                                ),
                                resultSet.getInt("count_like"),
                                DBManager.getComments(resultSet.getLong("p.id")),
                                resultSet.getLong("for_user")
                        )
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return posts;
    }


    public static ArrayList<Post> getPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT p.id, p.post_text, p.date,p.count_like " +
                            "u.id as id_poster, " +
                            "u.u_name, u.surname,u.image_path" +
                            " from posts p " +
                            "inner join users u on p.user_id = u.id ");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                posts.add(new Post(
                                resultSet.getLong("p.id"),
                                resultSet.getString("post_text"),
                                resultSet.getTimestamp("date"),
                                new Users(
                                        resultSet.getLong("id_poster"),
                                        resultSet.getString("u_name"),
                                        resultSet.getString("surname"),
                                        resultSet.getString("image_path")
                                ),
                                resultSet.getInt("count_like"),
                        resultSet.getLong("for_user")
                        )
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return posts;
    }

    public static Post getPost(Long id) {
        Post post = new Post();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT p.id, p.post_text, p.date,p.count_like, " +
                    " u.id as id_poster, " +
                    "u.u_name, u.surname,u.image_path" +
                    " from posts p " +
                    "inner join users u on p.user_id = u.id where p.id=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                post = new Post(
                                resultSet.getLong("p.id"),
                                resultSet.getString("post_text"),
                                resultSet.getTimestamp("date"),
                                new Users(
                                        resultSet.getLong("id_poster"),
                                        resultSet.getString("u_name"),
                                        resultSet.getString("surname"),
                                        resultSet.getString("image_path")
                                ),
                                resultSet.getInt("count_like"),
                                resultSet.getLong("for_user")
                );
            }

        }catch (Exception e){e.printStackTrace();}
        return post;
    }

    public static boolean isLikedPost(Long idUser, Long idPost) {
        int do_like=0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT do_like " +
                    "FROM like_post " +
                    "WHERE id_user=? AND id_post=? ");
            preparedStatement.setLong(1,idUser);
            preparedStatement.setLong(2,idPost);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                do_like = resultSet.getInt("do_like");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return do_like>0;
    }

    public static boolean updatePost(Post post) {
        int row = 0;

        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE posts " +
                    "SET  count_like=? " +
                    "WHERE id=?");


            statement.setInt(1, post.getCountLike());
            statement.setLong(2, post.getId());

            row = statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

        return row>0;
    }

    public static void updateLikePost(Long userId, Long postId, int doLike) {
        try{
            PreparedStatement statement = connection.prepareStatement("UPDATE like_post " +
                    "SET do_like=? " +
                    "WHERE id_post=? AND id_user=?  ");

            statement.setInt(1, doLike);
            statement.setLong(2, postId);
            statement.setLong(3, userId);

            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean isLikeExist(Long userId, Long postId) {
        boolean do_like = true;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * " +
                    "FROM like_post " +
                    "WHERE id_user=? AND id_post=? ");
            preparedStatement.setLong(1,userId);
            preparedStatement.setLong(2,postId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                do_like = false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return do_like;
    }

    public static boolean addLikePost(Long userId, Long postId) {
        int rows=0;

        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO like_post " +
                    "(id_user, id_post, do_like)" +
                    "VALUES (?,?,?)");
            preparedStatement.setLong(1,userId);
            preparedStatement.setLong(2,postId);
            preparedStatement.setInt(3,1);
            rows = preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rows>0;
    }


    public static boolean deletePost(Long id) {
        int rows =0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM posts"+
                    " WHERE id=?");
            preparedStatement.setLong(1,id);
            rows = preparedStatement.executeUpdate();
        }catch (Exception e){e.printStackTrace();}

        return rows>0;
    }

    public static ArrayList<Comment> getComments(Long id){
        ArrayList<Comment> comments = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * from comments c " +
                            "inner join users u on c.user_id = u.id WHERE post_id = ?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                comments.add(new Comment(
                                resultSet.getLong("id"),
                                resultSet.getString("comment"),
                                  resultSet.getLong("post_id"),
                                new Users(
                                        resultSet.getLong("u.id"),
                                        resultSet.getString("u_name"),
                                        resultSet.getString("surname"),
                                        resultSet.getString("image_path")
                                ),
                                resultSet.getTimestamp("date")
                        )
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return comments;
    }

    public static boolean addComment(Comment comment) {
        int row = 0;

        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO comments"+
                    "(comment,post_id,user_id,date)"+
                    "VALUES(?,?,?,?)");
            preparedStatement.setString(1,comment.getComment());
            preparedStatement.setLong(2,comment.getPostId());
            preparedStatement.setLong(3,comment.getUser().getId());
            preparedStatement.setTimestamp(4,comment.getDate());


            row = preparedStatement.executeUpdate();
        }catch (Exception e){e.printStackTrace();}

        return row>0;
    }

    public static ArrayList<Users> getAllUsers() {
        ArrayList<Users> users = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * from users ");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                users.add(new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("u_name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("university"),
                        resultSet.getString("about"),
                        resultSet.getString("birthdate"),
                        resultSet.getString("gender"),
                        resultSet.getString("city"),
                        resultSet.getInt("phone"),
                        resultSet.getString("image_path"),
                        resultSet.getInt("followers_count"),
                        resultSet.getInt("subscribers_count"),
                        resultSet.getInt("post_count")
                        )
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return users;
    }

    public static boolean deleteComment(Long id) {
        int rows =0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM comments"+
                    " WHERE id=?");
            preparedStatement.setLong(1,id);
            rows = preparedStatement.executeUpdate();
        }catch (Exception e){e.printStackTrace();}

        return rows>0;
    }

    public static boolean isFollow(Long userMe, Long userFollower) {
        boolean tru = false;
        int rows = 0;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from followers where id_follower=? AND id_subscriber=?");
            preparedStatement.setLong(1,userMe);
            preparedStatement.setLong(2,userFollower);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.next()){

                preparedStatement = connection.prepareStatement("INSERT INTO followers (id_follower,id_subscriber) VALUES (?,?)");
                preparedStatement.setLong(1,userMe);
                preparedStatement.setLong(2,userFollower);
                rows = preparedStatement.executeUpdate();
                if(rows>0){
                    tru = true;
                    return tru;
                }
            }else{
                Long idRow = resultSet.getLong("id");
                preparedStatement = connection.prepareStatement("DELETE from followers WHERE id=?");
                preparedStatement.setLong(1,idRow);
                rows = preparedStatement.executeUpdate();
                if(rows>0){
                    tru = false;
                    return  tru;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return tru;
    }

    public static boolean isFollowToMe(Long userMe, Long userId) {
        boolean tru = true;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * " +
                    "FROM followers " +
                    "WHERE id_follower=? AND id_subscriber=? ");
            preparedStatement.setLong(1,userMe);
            preparedStatement.setLong(2,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                tru = false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return tru;
    }

    public static ArrayList<Post> getPostsForHome(Long id) {
        ArrayList<Post> posts = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT p.id, p.post_text, p.date,p.count_like,p.for_user," +
                            "   u.id as id_poster, u.u_name, u.surname,u.image_path," +
                            "   f.id as id_follow, f.id_follower, f.id_subscriber" +
                            "    from posts p " +
                            "  inner join users u on p.user_id = u.id " +
                            "   INNER JOIN followers f on p.user_id = f.id_subscriber  where f.id_follower=?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                posts.add(new Post(
                                resultSet.getLong("p.id"),
                                resultSet.getString("post_text"),
                                resultSet.getTimestamp("date"),
                                new Users(
                                        resultSet.getLong("id_poster"),
                                        resultSet.getString("u_name"),
                                        resultSet.getString("surname"),
                                        resultSet.getString("image_path")
                                ),
                                resultSet.getInt("count_like"),
                                DBManager.getComments(resultSet.getLong("p.id")),
                                resultSet.getLong("for_user")
                        )
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return posts;
    }

    public static ArrayList<Users> getFollowers(Long id) {
        ArrayList<Users> users = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT u.id,u.u_name,u.surname,u.image_path from users u " +
                            "INNER JOIN followers f on u.id = f.id_subscriber WHERE f.id_follower = ? ");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                users.add(new Users(
                                resultSet.getLong("id"),
                                resultSet.getString("u_name"),
                                resultSet.getString("surname"),
                                resultSet.getString("image_path")
                        )
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return users;
    }
}
