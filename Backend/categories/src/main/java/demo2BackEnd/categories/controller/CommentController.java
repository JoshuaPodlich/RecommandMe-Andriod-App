package demo2BackEnd.categories.controller;

import demo2BackEnd.categories.model.*;
import demo2BackEnd.categories.repository.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class CommentController  {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MovieCategoryRepository movieCategoryRepository;

    @Autowired
    MovieCommentRepository movieCommentRepository;

    @Autowired
    BookCommentRepository bookCommentRepository;

    @Autowired
    BookCategoryRepository bookCategoryRepository;

    @Autowired
    RestaurantCategoryRepository restaurantCategoryRepository;

    @Autowired
    RestaurantCommentRepository restaurantCommentRepository;

    @Autowired
    TVShowCommentRepository tvShowCommentRepository;

    @Autowired
    TVShowCategoryRepository tvShowCategoryRepository;

    @Autowired
    VideoGameCategoryRepository videoGameCategoryRepository;

    @Autowired
    VideoGameCommentRepository videoGameCommentRepository;


    @Operation(summary = "Find all Comments info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all Comments",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Comments not found",
                    content = @Content) })
    @GetMapping("Comment/info")
    List<Comment> GetAllComment(){
        return commentRepository.findAll();
    }



    @Operation(summary = "Comment a moive by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post done",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie/UserId not found",
                    content = @Content) })
    @PostMapping("Comment/post/{userid}/Movie/{name}")
    public String CommentByUserMovie(@RequestBody Comment newComment, @PathVariable("userid") UUID userid, @PathVariable("name") String name){
        User usr = userRepository.findByUserID(userid);
        MovieComment mvComment = new MovieComment(); 
        if(usr == null){
            return "Your current id is: " + userid + "If you are not register, please register, otherwise contact support";
        }else{
            usr.setComment(true);
            newComment.setUser(usr);
            MovieCategory mv = movieCategoryRepository.findByName(name);
            if(mv == null){
                return "The " + name + " movie not found, please try again";
            }else{
                newComment.setMvCategory(mv);
                commentRepository.save(newComment);
                mvComment.setMovie(mv);
                mvComment.setUser(usr);
                movieCommentRepository.save(mvComment);
                long total_mv_score = 0;
                for(long i = 1; i <= commentRepository.count(); i++){
                    Comment sameItem = commentRepository.findByComment_id(i);
                    if(mv == sameItem.getMvCategory()){
                        total_mv_score += sameItem.getRating();
                    }
                }
                mv.setScore(total_mv_score/movieCommentRepository.countCommentByName(mv));
                movieCategoryRepository.save(mv);
                userRepository.save(usr);
                return "Comment Done";
            }
        }
    }


    @Operation(summary = "Post a book Comment by UserId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post a book Comment By userId",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "BookId/UserId not found",
                    content = @Content) })
    @PostMapping("Comment/post/{userid}/Book/{name}")
    public String CommentByUserBook(@RequestBody Comment newComment, @PathVariable("userid") UUID userid, @PathVariable("name") String name){
        User usr = userRepository.findByUserID(userid);
        BookComment bkComment = new BookComment();
        if(usr == null){
            return "Your current id is: " + userid + "If you are not register, please register, otherwise contact support";
        }else{
            usr.setComment(true);
            newComment.setUser(usr);
            BookCategory bk = bookCategoryRepository.findByName(name);
            if(bk == null){
                return "The " + name + " book not found, please try again";
            }else{
                newComment.setBkCategory(bk);
                commentRepository.save(newComment);
                bkComment.setBook(bk);
                bkComment.setUser(usr);
                bookCommentRepository.save(bkComment);
                long total_bk_score = 0;
                for(long i = 1; i <= commentRepository.count(); i++){
                    Comment sameItem = commentRepository.findByComment_id(i);
                    if(bk == sameItem.getBkCategory()){
                        total_bk_score += sameItem.getRating();
                    }
                }
                bk.setScore(total_bk_score/bookCommentRepository.countCommentByName(bk));
                bookCategoryRepository.save(bk);
                userRepository.save(usr);
                return "Comment Done";
            }
        }
    }



    @Operation(summary = "Post a resturant commmet by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Resturants comment posted users",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Resturant ID/UserId not found",
                    content = @Content) })
    @PostMapping("Comment/post/{userid}/Restaurant/{name}")
    public String CommentByUserRestaurant(@RequestBody Comment newComment, @PathVariable("userid") UUID userid, @PathVariable("name") String name){
        User usr = userRepository.findByUserID(userid);
        RestaurantComment rsComment = new RestaurantComment();
        if(usr == null){
            return "Your current id is: " + userid + "If you are not register, please register, otherwise contact support";
        }else{
            usr.setComment(true);
            newComment.setUser(usr);
            RestaurantCategory rs = restaurantCategoryRepository.findByName(name);
            if(rs == null){
                return "The " + name + " movie not found, please try again";
            }else{
                newComment.setRsCategory(rs);
                commentRepository.save(newComment);
                rsComment.setRestaurant(rs);
                rsComment.setUser(usr);
                restaurantCommentRepository.save(rsComment);
                long total_rs_score = 0;
                for(long i = 1; i <= commentRepository.count(); i++){
                    Comment sameItem = commentRepository.findByComment_id(i);
                    if(rs == sameItem.getRsCategory()){
                        total_rs_score += sameItem.getRating();
                    }
                }
                rs.setScore(total_rs_score/restaurantCommentRepository.countCommentByName(rs));
                restaurantCategoryRepository.save(rs);
                userRepository.save(usr);
                return "Comment Done";
            }
        }
    }


    @Operation(summary = "Post a TVShow comment by userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Posted TVShow comment",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "TVShowId/ UserId not found",
                    content = @Content) })
    @PostMapping("Comment/post/{userid}/TVShow/{name}")
    public String CommentByUserTVShow(@RequestBody Comment newComment, @PathVariable("userid") UUID userid, @PathVariable("name") String name) {
        User usr = userRepository.findByUserID(userid);
        TVShowComment tvShowComment = new TVShowComment();
        if (usr == null) {
            return "Your current id is: " + userid + "If you are not register, please register, otherwise contact support";
        } else {
            usr.setComment(true);
            newComment.setUser(usr);
            TVShowCategory tvShow = tvShowCategoryRepository.findByName(name);
            if (tvShow == null) {
                return "The " + name + " tv show not found, please try again";
            } else {
                newComment.setTvShowCategory(tvShow);
                commentRepository.save(newComment);
                tvShowComment.setTvShow(tvShow);
                tvShowComment.setUser(usr);
                tvShowCommentRepository.save(tvShowComment);
                long total_tv_score = 0;
                for(long i = 1; i <= commentRepository.count(); i++){
                    Comment sameItem = commentRepository.findByComment_id(i);
                    if(tvShow == sameItem.getTvShowCategory()){
                        total_tv_score += sameItem.getRating();
                    }
                }
                tvShow.setScore(total_tv_score / tvShowCommentRepository.countCommentByName(tvShow));
                tvShowCategoryRepository.save(tvShow);
                userRepository.save(usr);
                return "Comment Done";
            }
        }
    }


    @Operation(summary = "Post a VideoGame Comment by a UserId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Posted VideoGame Comment",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "VideoGame/UserId not found",
                    content = @Content) })
    @PostMapping("Comment/post/{userid}/VideoGame/{name}")
    public String CommentByUserVideoGame(@RequestBody Comment newComment, @PathVariable("userid") UUID userid, @PathVariable("name") String name){
        User usr = userRepository.findByUserID(userid);
        VideoGameComment videoGameComment = new VideoGameComment();
        if(usr == null){
            return "Your current id is: " + userid + "If you are not register, please register, otherwise contact support";
        }else{
            usr.setComment(true);
            newComment.setUser(usr);
            VideoGameCategory vg = videoGameCategoryRepository.findByName(name);
            if(vg == null){
                return "The " + name + " video game not found, please try again";
            }else{
                newComment.setVideoGameCategory(vg);
                commentRepository.save(newComment);
                videoGameComment.setVideoGameCategory(vg);
                videoGameComment.setUser(usr);
                videoGameCommentRepository.save(videoGameComment);
                long total_game_score = 0;
                for(long i = 1; i <= commentRepository.count(); i++){
                    Comment sameItem = commentRepository.findByComment_id(i);
                    if(vg == sameItem.getVideoGameCategory()){
                        total_game_score += sameItem.getRating();
                    }
                }
                vg.setScore(total_game_score / videoGameCommentRepository.countCommentByName(vg));
                videoGameCategoryRepository.save(vg);
                userRepository.save(usr);
                return "Comment Done";
            }
        }
    }


    @Operation(summary = "Find all Comments by users info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all Comments by userid",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "UserID not found",
                    content = @Content) })
    @GetMapping("Comment/get/{userid}")
    User UserByUserID(@PathVariable("userid") UUID uid){
        return userRepository.findByUserID(uid);
    }

    @Operation(summary = "Find all Commentsinfo by Userid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all Comment Info By users",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Comments info not found",
                    content = @Content) })
    @GetMapping("Comment/info/{id}")
    Comment CommentByID(@PathVariable("id") long id){
        return commentRepository.findById(id).orElse(null);
    }


    @Operation(summary = "Find all Comment edittext by users info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Find Comments edittext by userid",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Comment edittext not found",
                    content = @Content) })
    @PutMapping("Comment/info/edittext/{id}")
    Comment UpdateText(@PathVariable("id") long id, @RequestBody Comment newReviewText){
        Comment user = commentRepository.findById(id).orElse(null);
        user.setReviewText(newReviewText.getReviewText());
        return commentRepository.save(user);
    }


    @Operation(summary = "delete  comments by userid ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "delete comments by userid",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Failed to delete comment",
                    content = @Content) })
    @DeleteMapping("Comment/delete/{id}")
    public String DeleteAComment(@PathVariable("id") long id){
        commentRepository.deleteById(id);
        return "delete done";
    }
}
