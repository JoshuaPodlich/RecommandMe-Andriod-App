package demo2BackEnd.categories.controller;

import demo2BackEnd.categories.model.*;
import demo2BackEnd.categories.repository.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Category Controller", description = "control all categories (Movie, Book, Restaurant, Video Game, TV Show) API")
public class CategoryController {
    @Autowired
    BookCategoryRepository bookCategoryRepository;

    @Autowired
    MovieCategoryRepository movieCategoryRepository;

    @Autowired
    RestaurantCategoryRepository restaurantCategoryRepository;

    @Autowired
    VideoGameCategoryRepository videoGameCategoryRepository;

    @Autowired
    TVShowCategoryRepository tvShowCategoryRepository;

    @Operation(summary = "Get all books info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all books",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No books found",
                    content = @Content) })
    @GetMapping("Book/info")
    List<BookCategory> GetAllBook(){
        return bookCategoryRepository.findAll();
    }

    @Operation(summary = "Get book info by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content) })
    @GetMapping("Book/info/{id}")
    BookCategory BookByID(@PathVariable("id") long id){
        return bookCategoryRepository.findById(id).orElse(null);
    }

    @GetMapping("Book/get/{name}")
    BookCategory BookByName(@PathVariable("name") String name){
        return bookCategoryRepository.findByName(name);
    }

    @Operation(summary = "Get all movies info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all movies",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No movies found",
                    content = @Content) })
    @GetMapping("Movie/info")
    List<MovieCategory> GetAllMovie(){
        return movieCategoryRepository.findAll();
    }

    @GetMapping("Movie/get/{name}")
    MovieCategory MovieByName(@PathVariable("name") String name){
        return movieCategoryRepository.findByName(name);
    }

    @Operation(summary = "Get movie info by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the movie",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found",
                    content = @Content) })
    @GetMapping("Movie/info/{id}")
    MovieCategory MovieByID(@PathVariable("id") long id){
        return movieCategoryRepository.findById(id).orElse(null);
    }

    @Operation(summary = "Get all restaurants info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all restaurants",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No restaurants found",
                    content = @Content) })
    @GetMapping("Restaurant/info")
    List<RestaurantCategory> GetAllRestaurant(){
        return restaurantCategoryRepository.findAll();
    }

    @GetMapping("Restaurant/get/{name}")
    RestaurantCategory RestaurantByName(@PathVariable("name") String name){
        return restaurantCategoryRepository.findByName(name);
    }

    @Operation(summary = "Get restaurant info by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the restaurant",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Restaurant not found",
                    content = @Content) })
    @GetMapping("Restaurant/info/{id}")
    RestaurantCategory RestaurantByID(@PathVariable("id") long id){
        return restaurantCategoryRepository.findById(id).orElse(null);
    }

    @Operation(summary = "Get all tv shows info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all tv shows",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No tv shows found",
                    content = @Content) })
    @GetMapping("TVShow/info")
    List<TVShowCategory> GetAllTVShow(){
        return tvShowCategoryRepository.findAll();
    }

    @GetMapping("TVShow/get/{name}")
    TVShowCategory TVShowByName(@PathVariable("name") String name){
        return tvShowCategoryRepository.findByName(name);
    }

    @Operation(summary = "Get tv show info by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the tv show",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "TV show not found",
                    content = @Content) })
    @GetMapping("TVShow/info/{id}")
    TVShowCategory TVShowByID(@PathVariable("id") long id){
        return tvShowCategoryRepository.findById(id).orElse(null);
    }

    @Operation(summary = "Get all video games info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all video games",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No video games found",
                    content = @Content) })
    @GetMapping("VideoGame/info")
    List<VideoGameCategory> GetAllVideoGame(){
        return videoGameCategoryRepository.findAll();
    }

    @Operation(summary = "Get video game info by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the video game",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Video game not found",
                    content = @Content) })
    @GetMapping("VideoGame/info/{id}")
    VideoGameCategory VideoGameShowByID(@PathVariable("id") long id){
        return videoGameCategoryRepository.findById(id).orElse(null);
    }

    @GetMapping("VideoGame/get/{name}")
    VideoGameCategory VideoGameByName(@PathVariable("name") String name){
        return videoGameCategoryRepository.findByName(name);
    }

    @Operation(summary = "Post a book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Done",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) })})
    @PostMapping("Book/post")
    BookCategory PostBookByPath(@RequestBody BookCategory newBook){
        bookCategoryRepository.save(newBook);
        return newBook;
    }

    @Operation(summary = "Post a movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Done",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) })})
    @PostMapping("Movie/post")
    MovieCategory PostMovieByPath(@RequestBody MovieCategory newMovie){
        movieCategoryRepository.save(newMovie);
        return newMovie;
    }

    @Operation(summary = "Post a restaurant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Done",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) })})
    @PostMapping("Restaurant/post")
    RestaurantCategory PostRestaurantByPath(@RequestBody RestaurantCategory newRestaurant){
        restaurantCategoryRepository.save(newRestaurant);
        return newRestaurant;
    }

    @Operation(summary = "Post a tv show")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Done",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) })})
    @PostMapping("TVShow/post")
    TVShowCategory PostTVShowByPath(@RequestBody TVShowCategory newTVShow){
        tvShowCategoryRepository.save(newTVShow);
        return newTVShow;
    }

    @Operation(summary = "Post a video game")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Done",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) })})
    @PostMapping("VideoGame/post")
    VideoGameCategory PostVideoGame(@RequestBody VideoGameCategory newVideoGame){
        videoGameCategoryRepository.save(newVideoGame);
        return newVideoGame;
    }
}
