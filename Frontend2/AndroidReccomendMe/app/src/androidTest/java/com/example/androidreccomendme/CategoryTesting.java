package com.example.androidreccomendme;

import com.example.androidreccomendme.MainMenu;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.AllOf.allOf;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.*;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagKey;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.StringEndsWith.endsWith;

// Mock the RequestServerForService class
@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest   // large execution time
public class CategoryTesting {

    private static final int SIMULATED_DELAY_MS = 500;

    @Rule   // needed to launch the activity
    public ActivityScenarioRule<MainMenu> activityRule = new ActivityScenarioRule<MainMenu>(MainMenu.class);

    /**
     * Start the server and run this test
     */
/*
    @Test
    public void ProfileTest(){

        onView(withId(R.id.btnLog)).perform(click());
        onView(withId(R.id.usernameText)).perform(replaceText("CaelanH"));
        onView(withId(R.id.passwordText)).perform(replaceText("herzberg99"));
        onView(withId(R.id.loginBtn)).perform(click());
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.btnProfileMenu)).perform(click());

        onView(withId(R.id.textUsername)).check(matches(withText("CaelanH")));
        onView(withId(R.id.btnUsername)).perform(click());
        onView(withId(R.id.EditTextUser)).perform(replaceText("Alexander"));
        onView(withId(R.id.btnUserChange)).perform(click());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }



        onView(withId(R.id.btnPassword)).perform(click());
        onView(withId(R.id.editCurrentPassword)).perform(replaceText("herzberg99"));
        onView(withId(R.id.editNewPassword)).perform(replaceText("TheBerg"));
        onView(withId(R.id.buttonChangePassword)).perform(click());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        onView(withId(R.id.btnPassword)).perform(click());
        onView(withId(R.id.editCurrentPassword)).perform(replaceText("ThBerg"));
        onView(withId(R.id.buttonChangePassword)).perform(click());
        onView(withId(R.id.passLabel)).check(matches(withText("Current Password is not correct")));
        onView(withId(R.id.editCurrentPassword)).perform(replaceText("TheBerg"));
        onView(withId(R.id.editNewPassword)).perform(replaceText("herzberg99"));
        onView(withId(R.id.buttonChangePassword)).perform(click());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }





        onView(withId(R.id.textUsername)).check(matches(withText("Alexander")));
        onView(withId(R.id.btnUsername)).perform(click());
        onView(withId(R.id.EditTextUser)).perform(replaceText("CaelanH"));
        onView(withId(R.id.btnUserChange)).perform(click());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        onView(withId(R.id.textUsername)).check(matches(withText("CaelanH")));
        onView(withId(R.id.btnLogOut)).perform(click());






    }

 */


    @Test
    public void CategoryMovieTest(){

        onView(withId(R.id.btnMovies)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }

        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.textViewName)).check(matches(withText("The Batman")));
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.textViewDesc)).check(matches(withText("When the Riddler, a sadistic serial killer, begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement.")));
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.buttonView)).perform(click());



        onView(withId(R.id.InfoTitle)).check(matches(withText("The Batman")));
        onView(withId(R.id.InfoMainText1)).check(matches(withText("Date: \nMarch 18, 2022")));
        onView(withId(R.id.InfoMainText2)).check(matches(withText("Platform: \nCinema")));
        onView(withId(R.id.InfoMainText3)).check(matches(withText("Score: \n8")));
        onView(withId(R.id.InfoMainText4)).check(matches(withText("")));
        onView(withId(R.id.InfoDescription)).check(matches(withText("When the Riddler, a sadistic serial killer, begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement.")));
        onView(withId(R.id.InfoExtra1)).check(matches(withText("Runtime: \n178")));

        onView(withId(R.id.InfoExtra2)).check(matches(withText("Director: \nMatt Reeves")));
        onView(withId(R.id.InfoExtra3)).check(matches(withText("Language: \nEnglish")));
        onView(withId(R.id.InfoExtra4)).check(matches(withText("Country of Origin: \nUnited States")));
        onView(withId(R.id.InfoExtra5)).check(matches(withText("Genre: \nAction, Drama, Crime")));
        onView(withId(R.id.InfoExtra6)).check(matches(withText("")));
        onView(withId(R.id.btnHomeInfo)).perform(click());

    }

    @Test
    public void CategoryRestaurantTest(){

        onView(withId(R.id.btnResturaunt)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.textViewName)).check(matches(withText("CornBred")));
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.textViewDesc)).check(matches(withText("Cornbred specializes in delivering amazing guest experiences with award-winning barbecue, made from scratch trimmings, and chef inspired entrees, in the beautifully renovated Historic Train Depot in Downtown Ames. We also have a fully stocked bar featuring our signature Aguas Frescas cocktails, ever-rotating 24 beers on tap, and craft bottled and draft sodas, Including “Potter’s Delite” our interpretation of butter beer from Harry Potter.")));
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.buttonView)).perform(click());


        onView(withId(R.id.InfoTitle)).check(matches(withText("CornBred")));
        onView(withId(R.id.InfoMainText1)).check(matches(withText("Address: \n526 Main St Ste 106 Ames, IA 50010")));
        onView(withId(R.id.InfoMainText2)).check(matches(withText("Phone: \n(515) 715-1066")));
        onView(withId(R.id.InfoMainText3)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText4)).check(matches(withText("")));
        onView(withId(R.id.InfoDescription)).check(matches(withText("Cornbred specializes in delivering amazing guest experiences with award-winning barbecue, made from scratch trimmings, and chef inspired entrees, in the beautifully renovated Historic Train Depot in Downtown Ames. We also have a fully stocked bar featuring our signature Aguas Frescas cocktails, ever-rotating 24 beers on tap, and craft bottled and draft sodas, Including “Potter’s Delite” our interpretation of butter beer from Harry Potter.")));
        onView(withId(R.id.InfoExtra1)).check(matches(withText("Score: \n8")));

        onView(withId(R.id.InfoExtra2)).check(matches(withText("Price Range: \n$$")));
        onView(withId(R.id.InfoExtra3)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra4)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra5)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra6)).check(matches(withText("")));
        onView(withId(R.id.btnHomeInfo)).perform(click());


    }

    @Test
    public void CategoryTVTest(){

        onView(withId(R.id.btnTV)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.textViewName)).check(matches(withText("The Tourist")));
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.textViewDesc)).check(matches(withText("When a man wakes up in the Australian outback with no memory, he must use the few clues he has to discover his identity before his past catches up with him")));
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.buttonView)).perform(click());


        onView(withId(R.id.InfoTitle)).check(matches(withText("The Tourist")));
        onView(withId(R.id.InfoMainText1)).check(matches(withText("PG: \nTV-MA")));
        onView(withId(R.id.InfoMainText2)).check(matches(withText("Platform: \nHBO MAX")));
        onView(withId(R.id.InfoMainText4)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText3)).check(matches(withText("Genre: \nDrama,Mystery,Thriller")));
        onView(withId(R.id.InfoDescription)).check(matches(withText("When a man wakes up in the Australian outback with no memory, he must use the few clues he has to discover his identity before his past catches up with him")));
        onView(withId(R.id.InfoExtra1)).check(matches(withText("Episodes: \n1")));

     //   onView(withId(R.id.InfoExtra2)).check(matches(withText("Director: \nnull")));
        onView(withId(R.id.InfoExtra3)).check(matches(withText("Subtitle: \nEnglish,Espanio")));
      //  onView(withId(R.id.InfoExtra4)).check(matches(withText("Made in: \nThe null")));
        onView(withId(R.id.InfoExtra5)).check(matches(withText("Stars: \nJamine Dornan, Danilelle Macdonald, Shalom Brue-Franklin")));
        onView(withId(R.id.InfoExtra6)).check(matches(withText("Score: \n0.0")));
        onView(withId(R.id.btnHomeInfo)).perform(click());



    }

    @Test
    public void CategoryVideoGameTest(){
        onView(withId(R.id.btnVideogames)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.textViewName)).check(matches(withText("Anno: Mutationem")));
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.textViewDesc)).check(matches(withText("In this sci-fi action-adventure game with RPG elements, you become Ann: a highly-skilled combat-trained lone wolf on a personal mission in a giant Metropolis.")));
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.buttonView)).perform(click());



        onView(withId(R.id.InfoTitle)).check(matches(withText("Anno: Mutationem")));
        onView(withId(R.id.InfoMainText1)).check(matches(withText("Price: \n$25")));
        onView(withId(R.id.InfoMainText2)).check(matches(withText("Platform: \nPlayStation 4, PC")));
        onView(withId(R.id.InfoMainText3)).check(matches(withText("Score: \n0.0")));
        onView(withId(R.id.InfoMainText4)).check(matches(withText("")));
        onView(withId(R.id.InfoDescription)).check(matches(withText("In this sci-fi action-adventure game with RPG elements, you become Ann: a highly-skilled combat-trained lone wolf on a personal mission in a giant Metropolis.")));
        onView(withId(R.id.InfoExtra1)).check(matches(withText("Main Story Hours: \n13 hrs")));

        onView(withId(R.id.InfoExtra2)).check(matches(withText("Date: \nMarch 17, 2022")));
        onView(withId(R.id.InfoExtra3)).check(matches(withText("Publisher: \nLightning Games")));
        onView(withId(R.id.InfoExtra4)).check(matches(withText("Producer: \nThinkingStars")));
        onView(withId(R.id.InfoExtra5)).check(matches(withText("Genre: \nAction, Platformer")));
        onView(withId(R.id.InfoExtra6)).check(matches(withText("AgeLimit: \nNone")));
        onView(withId(R.id.btnHomeInfo)).perform(click());


    }


        @Test
    public void CategoryBookTest(){
        onView(withId(R.id.btnBooks)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.textViewName)).check(matches(withText("Fiona and Jane")));
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.textViewDesc)).check(matches(withText("Fiona and Jane are best friends, navigating their tumultuous teenage years together, as well as their family histories and all that comes with them. But when Fiona moves across the country, their bond weakens and threatens to break. This novel about the power of female friendship will give you a gorgeous peek into both women's perspectives on a shared story that has as many facets as they do.")));
        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.buttonView)).perform(click());



        onView(withId(R.id.InfoTitle)).check(matches(withText("Fiona and Jane")));
        onView(withId(R.id.InfoMainText1)).check(matches(withText("Author: \nJean Chen Ho")));
        onView(withId(R.id.InfoMainText2)).check(matches(withText("Price: \n$16.99")));
        onView(withId(R.id.InfoMainText3)).check(matches(withText("Score: \n0")));
        onView(withId(R.id.InfoMainText4)).check(matches(withText("")));
        onView(withId(R.id.InfoDescription)).check(matches(withText("Fiona and Jane are best friends, navigating their tumultuous teenage years together, as well as their family histories and all that comes with them. But when Fiona moves across the country, their bond weakens and threatens to break. This novel about the power of female friendship will give you a gorgeous peek into both women's perspectives on a shared story that has as many facets as they do.")));
        onView(withId(R.id.InfoExtra1)).check(matches(withText("Pages: \n288")));

        onView(withId(R.id.InfoExtra2)).check(matches(withText("ISBN10: \n978-0593296042")));
        onView(withId(R.id.InfoExtra3)).check(matches(withText("ISBN13: \nnull")));
        onView(withId(R.id.InfoExtra5)).check(matches(withText("Publisher: \nnull")));
        onView(withId(R.id.InfoExtra6)).check(matches(withText("Date: \nJanuary 4, 2022")));
        onView(withId(R.id.InfoExtra4)).check(matches(withText("Language: \nnull")));


        onView(withId(R.id.btnHomeInfo)).perform(click());



    }




/*

    @Test
    public void SearchTest(){


        onView(withId(R.id.searchCategory)).perform(typeText("d"));
        onView(withId(R.id.btnSearch)).perform(click());
        onView(withId(R.id.searchText)).check(matches(withText("Not a Valid Item, Try Again.")));
        onView(withId(R.id.searchCategory)).perform(replaceText("The Batman"));
        onView(withId(R.id.btnSearch)).perform(click());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.InfoTitle)).check(matches(withText("The Batman")));
        onView(withId(R.id.InfoMainText1)).check(matches(withText("Date: \nMarch 18, 2022")));
        onView(withId(R.id.InfoMainText2)).check(matches(withText("Platform: \nCinema")));
        onView(withId(R.id.InfoMainText3)).check(matches(withText("Score: \n8")));
        onView(withId(R.id.InfoMainText4)).check(matches(withText("")));
        onView(withId(R.id.InfoDescription)).check(matches(withText("When the Riddler, a sadistic serial killer, begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement.")));
        onView(withId(R.id.InfoExtra1)).check(matches(withText("Runtime: \n178")));

        onView(withId(R.id.InfoExtra2)).check(matches(withText("Director: \nMatt Reeves")));
        onView(withId(R.id.InfoExtra3)).check(matches(withText("Language: \nEnglish")));
       // onView(withId(R.id.InfoExtra4)).check(matches(withText("Country of Origin: \nUnited States")));
        onView(withId(R.id.InfoExtra5)).check(matches(withText("Genre: \nAction, Drama, Crime")));
        onView(withId(R.id.InfoExtra6)).check(matches(withText("")));
        onView(withId(R.id.btnHomeInfo)).perform(click());

        onView(withId(R.id.searchCategory)).perform(replaceText("CornBred"));
        onView(withId(R.id.btnSearch)).perform(click());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        onView(withId(R.id.InfoTitle)).check(matches(withText("CornBred")));
        onView(withId(R.id.InfoMainText1)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText2)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText3)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText4)).check(matches(withText("")));
        onView(withId(R.id.InfoDescription)).check(matches(withText("Cornbred specializes in delivering amazing guest experiences with award-winning barbecue, made from scratch trimmings, and chef inspired entrees, in the beautifully renovated Historic Train Depot in Downtown Ames. We also have a fully stocked bar featuring our signature Aguas Frescas cocktails, ever-rotating 24 beers on tap, and craft bottled and draft sodas, Including “Potter’s Delite” our interpretation of butter beer from Harry Potter.\"")));
        onView(withId(R.id.InfoExtra1)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra2)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra3)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra4)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra5)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra6)).check(matches(withText("")));
        onView(withId(R.id.btnHomeInfo)).perform(click());


        onView(withId(R.id.searchCategory)).perform(typeText("Fiona and Jane"));
        onView(withId(R.id.btnSearch)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }

        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.buttonView)).perform(click());
        onView(withId(R.id.InfoTitle)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText1)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText2)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText3)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText4)).check(matches(withText("")));
        onView(withId(R.id.InfoDescription)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra1)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra2)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra3)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra4)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra5)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra6)).check(matches(withText("")));
        onView(withId(R.id.btnHomeInfo)).perform(click());

        onView(withId(R.id.searchCategory)).perform(typeText("The Tourist"));
        onView(withId(R.id.btnSearch)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }

        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.buttonView)).perform(click());
        onView(withId(R.id.InfoTitle)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText1)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText2)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText3)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText4)).check(matches(withText("")));
        onView(withId(R.id.InfoDescription)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra1)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra2)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra3)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra4)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra5)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra6)).check(matches(withText("")));
        onView(withId(R.id.btnHomeInfo)).perform(click());

        onView(withId(R.id.searchCategory)).perform(typeText("Anno: Mutationem"));
        onView(withId(R.id.btnSearch)).perform(click());
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }

        onData(allOf()).inAdapterView(withId(R.id.MovieList)).atPosition(0).onChildView(withId(R.id.buttonView)).perform(click());
        onView(withId(R.id.InfoTitle)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText1)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText2)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText3)).check(matches(withText("")));
        onView(withId(R.id.InfoMainText4)).check(matches(withText("")));
        onView(withId(R.id.InfoDescription)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra1)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra2)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra3)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra4)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra5)).check(matches(withText("")));
        onView(withId(R.id.InfoExtra6)).check(matches(withText("")));
        onView(withId(R.id.btnHomeInfo)).perform(click());






    }
 */




}

