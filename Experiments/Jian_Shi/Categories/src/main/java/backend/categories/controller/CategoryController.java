package backend.categories.controller;


import backend.categories.model.*;
import backend.categories.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
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


    @GetMapping("Book/info")
    List<BookCategory> GetAllBook(){
        return bookCategoryRepository.findAll();
    }

    @GetMapping("Movie/info")
    List<MovieCategory> GetAllMovie(){
        return movieCategoryRepository.findAll();
    }

    @GetMapping("Restaurant/info")
    List<RestaurantCategory> GetAllRestaurant(){
        return restaurantCategoryRepository.findAll();
    }

    @GetMapping("TVShow/info")
    List<TVShowCategory> GetAllTVShow(){
        return tvShowCategoryRepository.findAll();
    }

    @GetMapping("VideoGame/info")
    List<VideoGameCategory> GetAllVideoGame(){
        return videoGameCategoryRepository.findAll();
    }



    @PostMapping("Book/post")
    BookCategory PostBookByPath(@RequestBody BookCategory newBook){
        bookCategoryRepository.save(newBook);
        return newBook;
    }

    @PostMapping("Movie/post")
    MovieCategory PostMovieByPath(@RequestBody MovieCategory newMovie){
        movieCategoryRepository.save(newMovie);
        return newMovie;
    }

    @PostMapping("Restaurant/post")
    RestaurantCategory PostRestaurantByPath(@RequestBody RestaurantCategory newRestaurant){
        restaurantCategoryRepository.save(newRestaurant);
        return newRestaurant;
    }

    @PostMapping("TVShow/post")
    TVShowCategory PostTVShowByPath(@RequestBody TVShowCategory newTVShow){
        tvShowCategoryRepository.save(newTVShow);
        return newTVShow;
    }

    @PostMapping("VideoGame/post")
    VideoGameCategory PostVideoGame(@RequestBody VideoGameCategory newVideoGame){
        videoGameCategoryRepository.save(newVideoGame);
        return newVideoGame;
    }
}
