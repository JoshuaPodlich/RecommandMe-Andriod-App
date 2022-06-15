package demo2BackEnd.categories.controller;

import demo2BackEnd.categories.model.*;
import demo2BackEnd.categories.repository.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryCommentController {
    @Autowired
    MovieCommentRepository movieCommentRepository;

    @Autowired
    RestaurantCommentRepository restaurantCommentRepository;

    @Autowired
    TVShowCommentRepository tvShowCommentRepository;

    @Autowired
    VideoGameCommentRepository videoGameCommentRepository;

    @Autowired
    BookCommentRepository bookCommentRepository;

    @GetMapping("MovieComment/get/info")
    List<MovieComment> MvComment(){
        return movieCommentRepository.findAll();
    }

    @Operation(summary = "Find all book info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book info not found",
                    content = @Content) })
    @GetMapping("Book/get/info")
    List<BookComment> BkComment() { return bookCommentRepository.findAll(); }


    @Operation(summary = "Find all Resturant  info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all resturant info",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Banned user not found",
                    content = @Content) })
    @GetMapping("Restaurant/get/info")
    List<RestaurantComment> RSComment(){
        return restaurantCommentRepository.findAll();
    }


    @Operation(summary = "Find all TVShowComment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found TVShowComment",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "TVShowComment found",
                    content = @Content) })
    @GetMapping("TVShowComment/get/info")
    List<TVShowComment> TvComment(){
        return tvShowCommentRepository.findAll();
    }


    @Operation(summary = "Find VideoGame info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all VideoGmae",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "VideoGame found",
                    content = @Content) })
    @GetMapping("VideoGame/get/info")
    List<VideoGameComment> GameComment(){
        return videoGameCommentRepository.findAll();
    }


}
