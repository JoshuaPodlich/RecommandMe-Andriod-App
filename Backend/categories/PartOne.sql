USE recommand_me;
SELECT * FROM movie_category;
SELECT * FROM restaurant_category;
SELECT * FROM tvshow_category;
SELECT * FROM video_game_category;
UPDATE movie_category SET types = 'Horror, Mystery, Thriller' WHERE movie_id = "14";

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "When the Riddler, a sadistic serial killer, begins murdering key political figures in Gotham, Batman is forced to investigate the city's hidden corruption and question his family's involvement.",
"Matt Reeves", "English", "The Batman", "https://imgur.com/y1OQDfu", "Cinema", "March 18, 2022", "0", "178", "Action, Drama, Crime", "https://www.youtube.com/watch?v=mqqft2x_Aa4", "PG-13" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States, Australia", "A well-to-do husband who allows his wife to have affairs in order to avoid a divorce becomes a prime suspect in the disappearance of her lovers.",
"Adrian Lyne", "English", "Deep Water", "https://imgur.com/JBeX8mJ", "hulu", "March 18, 2022", "0", "115", "Drama, Suspense, Thriller", "https://www.youtube.com/watch?v=h0zqe_As_qo", "R" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "In 1979, a group of young filmmakers set out to make an adult film in rural Texas, but when their reclusive, elderly hosts catch them in the act, the cast find themselves fighting for their lives.",
"Ti West", "English", "X", "https://imgur.com/K3T5Y0L", "Cinema", "March 18, 2022", "0", "105", "Horror", "https://www.youtube.com/watch?v=Awg3cWuHfoc", "R" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "After accidentally crash-landing in 2022, time-traveling fighter pilot Adam Reed teams up with his 12-year-old self for a mission to save the future.",
"Shawn Levy", "English", "The Adam Project", "https://imgur.com/Nt86APX", "NETFLIX", "March 11, 2022", "0", "106", "Action, Drama, Comedy", "https://www.youtube.com/watch?v=IE8HIsIrq4o", "PG-13" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "A 13-year-old girl named Meilin turns into a giant red panda whenever she gets too excited.",
"Domee Shi", "English", "Turning Red", "https://imgur.com/pxI296f", "Disney+", "March 11, 2022", "0", "100", "Animation, Thriller, Comedy", "https://www.youtube.com/watch?v=XdKzUbAiswE", "PG" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "A man breaks into a tech billionaire's empty vacation home, but things go sideways when the arrogant mogul and his wife arrive for a last-minute getaway.",
"Charlie McDowell", "English", "Windfall", "https://imgur.com/UAnL8oo", "NETFLIX", "March 18, 2022", "0", "92", "Crime, Drama, Thriller", "https://www.youtube.com/watch?v=IE8HIsIrq4o", "R" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "In a post-apocalyptic world, six soldiers on a covert mission must transport a mysterious package across a frozen archipelago. Noomi Rapace stars.",
"Adam Berg", "English", "Svart krabba", "https://imgur.com/vvnNHZh", "NETFLIX", "March 11, 2022", "0", "114", "Action, Drama, Comedy", "https://www.youtube.com/watch?v=IE8HIsIrq4o", "TV-MA" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "A woman who raised herself in the marshes of the deep South becomes a suspect in the murder of a man she was once involved with.",
"Olivia Newman", "English", "Where the Crawdads Sing", "https://imgur.com/d3j10UY", "Cinema", "July 15, 2022", "0", "106", "Drama, Mystery", "https://www.youtube.com/watch?v=PY3808Iq0Tg", "" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "A reclusive romance novelist on a book tour with her cover model gets swept up in a kidnapping attempt that lands them both in a cutthroat jungle adventure.",
"Aaron Nee, Adam Nee", "English", "The Lost City", "https://imgur.com/Engf0RT", "Cinema", "March 25, 2022", "0", "112", "Drama, Mystery", "https://www.youtube.com/watch?v=nfKO9rYDmE8", "PG-13" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "The horrors of modern dating seen through one young woman's defiant battle to survive her new boyfriend's unusual appetites.",
"Mimi Cave", "English", "Fresh", "https://imgur.com/piJDCFx", "hulu", "March 4, 2022", "0", "114", "Comedy, Horror, Thriller", "https://www.youtube.com/watch?v=wKk5VAK1GZQ", "R" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "Two robbers steal an ambulance after their heist goes awry.",
"Michael Bay", "English", "Ambulance", "https://imgur.com/nBaiSoa", "Cinema", "April 8, 2022", "0", "136", "Action, Crime, Drama", "https://www.youtube.com/watch?v=7NU-STboFeI", "R" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "The raucous exploits of a blended family of 12, the Bakers, as they navigate a hectic home life while simultaneously managing their family business.",
"Gail Lerner", "English", "Cheaper by the Dozen", "https://imgur.com/sHPWXlh", "Disney+", "March 18, 2022", "0", "107", "Adventure, Comedy, Family", "https://www.youtube.com/watch?v=Wq8Nsc5r2So", "PG" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "Street-smart Nathan Drake is recruited by seasoned treasure hunter Victor 'Sully' Sullivan to recover a fortune amassed by Ferdinand Magellan, and lost 500 years ago by the House of Moncada.",
"Ruben Fleischer", "English", "Uncharted", "https://imgur.com/9Dk85La", "Cinema", "February 18, 2022", "0", "116", "Action, Adventure", "https://www.youtube.com/watch?v=eHp3MbsCbMg", "PG-13" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "25 years after a streak of brutal murders shocked the quiet town of Woodsboro, Calif., a new killer dons the Ghostface mask and begins targeting a group of teenagers to resurrect secrets from the town's deadly past.",
"Matt Bettinelli, OlpinTyler Gillett", "English", "Scream", "https://imgur.com/OTI6g1a", "Cinema", "January 14, 2022", "0", "114", "Horror, Mystery, Thriller", "https://www.youtube.com/watch?v=beToTslH17s", "R" );

INSERT INTO movie_category 
(country_of_origin, description, director, language, name, pic, platform, release_date, score, time_length, types, url, pglevel)
VALUES
("United States", "A cash-strapped Nicolas Cage agrees to make a paid appearance at a billionaire super fan's birthday party, but is really an informant for the CIA since the billionaire fan is a drug kingpin and gets cast in a Tarantino movie.",
"Tom Gormican", "English", "The Unbearable Weight of Massive Talent", "https://imgur.com/PrkiUFQ", "Cinema", "April 22, 2022", "0", "105", "Action, Comedy, Crime", "https://www.youtube.com/watch?v=CKTRbKch2K4", "" );



SELECT * FROM book_category;

INSERT INTO book_category 
(isbn_10, isbn_13, author, description, language, name, pages, pic, place, price, publisher, release_date, score)
VALUES
("0593296044", "978-0593296042", "Jean Chen Ho", "Fiona and Jane are best friends, navigating their tumultuous teenage years together, as well as their family histories and all that comes with them. But when Fiona moves across the country, their bond weakens and threatens to break. This novel about the power of female friendship will give you a gorgeous peek into both women's perspectives on a shared story that has as many facets as they do.",
"English", "Fiona and Jane", "288", "https://imgur.com/EJSUy3B", "Amazon", "$16.99", "Viking", "January 4, 2022", "0");


SELECT * FROM video_game_category;
UPDATE video_game_category SET description = 'The legendary disc throwing game, Windjammers, finally gets a sequel! Windjammers 2 will combine everything fans love about the classic title with entirely hand-drawn 2D animations and both local and online multiplayer to create the ultimate windjamming experience.' WHERE id = "11";

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "In this sci-fi action-adventure game with RPG elements, you become Ann: a highly-skilled combat-trained lone wolf on a personal mission in a giant Metropolis.",
 "13 hrs", "Anno: Mutationem", "https://imgur.com/pXkgXXK", "PlayStation 4, PC", "24.99", "ThinkingStars", "Lightning Games", "March 17, 2022", "0", "Action, Platformer", "https://www.youtube.com/watch?v=a2E-MyMWksA");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "Determine the destiny of Rome as you conquer foreign lands and navigate political intrigue in the turn-based RPG Expeditions: Rome.",
 "38 hrs", "Expeditions: Rome", "https://imgur.com/GK0wMei", "PC", "44.99", "Logic Artists", "THQ Nordic", "January 20, 2022", "0", "RPG", "https://www.youtube.com/watch?v=WJfTCJwF6BM");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "The King of Fighters XV continues SNK's long-running fighting game franchise.", 
"None", "King of Fighters XV", "https://imgur.com/hyJKAR1", "PC, Xbox Series X|S, PlayStation 4, PlayStation 5", "59.99", "SNK Corporation", "SNK Corporation", "February 17, 2022", "0", "Fighting", "https://www.youtube.com/watch?v=_o7Ip64-Sio");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "In the mysterious world of Kirby and the Forgotten Land, Kirby can freely navigate 3D areas using his special copy abilities. What lies in store for Kirby as he explores a world filled with abandoned structures from a past civilization?", 
"10 hrs", "Kirby and the Forgotten Land", "https://imgur.com/ZQoGI8w", "Nintendo Switch", "59.99", "HAL Laboratory", "Nintendo", "March 25, 2022", "0", "Platformer", "https://www.youtube.com/watch?v=H3LAkr0ANgw");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "Lost Ark is a free-to-play, massively multiplayer online action role-playing adventure game that takes players on a journey in a world that has descended into chaos to find the fabled shards of the Lost Ark.", 
"36 hrs", "Lost Ark", "https://imgur.com/uuWfjYR", "PC", "19.99", "Smilegate, Tripodstudio", "Amazon Games", "February 11, 2022", "0", "Action, RPG, Persistent Online, Free-to-Play", "https://www.youtube.com/watch?v=Udwbd5X0zbg");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "Step into a world of dark fantasy and revel in the exhilarating, action-packed battles! Stranger of Paradise: Final Fantasy Origin explores a bold new vision of the Final Fantasy series with action RPG gameplay designed in the collaboration with Team Ninja.", 
"18 hrs", "Stranger of Paradise: Final Fantasy Origin", "https://imgur.com/f7Fp9ky", "PC, Xbox Series X|S, Xbox One, PlayStation 4, PlayStation 5", "59.99", "Team Ninja", "Square Enix", "March 18, 2022", "0", "Action, RPG", "https://www.youtube.com/watch?v=no-MCGxZcsQ");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "Embark on an epic adventure full of whimsy, wonder, and high-powered weaponry! Bullets, magic, and broadswords collide across this chaotic fantasy world brought to life by the unpredictable Tiny Tina in Tiny Tina's Wonderlands, a wild fantasy loot-em-up from the creators of Borderlands.", 
"12 hrs", "Tiny Tina's Wonderlands", "https://imgur.com/ImnPdb5", "PC, Xbox Series X|S, Xbox One, PlayStation 4, PlayStation 5", "59.99", "Gearbox Software", "2K Games", "March 25, 2022", "0", "Action, RPG, First-Person", "https://www.youtube.com/watch?v=0-RAqyHU48M");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "Total War: Warhammer III plunges players into a cataclysmic conflict between ruinous daemonic powers and the sentinels of the mortal world. Each choice you make will shape the reality-shattering conflict to come.", 
"29 hrs", "Total War: Warhammer III", "https://imgur.com/P46mgQc", "PC", "59.99", "Creative Assembly", "SEGA", "February 17, 2022", "0", "Strategy", "https://www.youtube.com/watch?v=cFGT5MKWofE");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "Three nations battle for control of the dwindling resources of salt and iron in Triangle Strategy, a tactical RPG from Square Enix.", 
"31 hrs", "Triangle Strategy", "https://imgur.com/MoF8Ope", "Nintendo Switch", "59.99", "ArtDink", "Square Enix", "March 4, 2022", "0", "RPG", "https://www.youtube.com/watch?v=7nhTJ-Evv_U");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "Discover a dark fantasy reimagining of the Wild West, where lawmen and gunslingers share the frontier with fantastical creatures, in the surreal frontier action RPG Weird West.", 
"None", "Weird West", "https://imgur.com/bmduqzI", "PlayStation 4, Xbox One, PC", "39.99", "WolfEye Studios", "Devolver Digital", "March 31, 2022", "0", "Action, RPG", "https://www.youtube.com/watch?v=bjTv0Vh4am4");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "The legendary disc throwing game, Windjammers, finally gets a sequel! Windjammers 2 will combine everything fans love about the classic title with entirely hand-drawn 2D animations and both local and online multiplayer to create the ultimate windjamming experience.", 
"1 hr", "Windjammers 2", "https://imgur.com/Izm91kn", "PlayStation 5, PlayStation 4, Xbox One, Nintendo Switch, PC, Stadia", "19.99", "DotEmu", "DotEmu", "January 20, 2022", "0", "Action, Sports", "https://www.youtube.com/watch?v=Rl251UhCrks");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "Return to the ring in the 2022 entry in the WWE 2K franchise. WWE 2K22 features a redesigned engine, new MyGM and MyFACTION modes, new controls, upgraded visuals, and more.", 
"3 hrs", "WWE 2K22", "https://imgur.com/zWc6qwO", "Xbox Series X|S, Xbox One, PlayStation 5, PlayStation 4, PC", "59", "Visual Concepts", "2K Games", "March 11, 2022", "0", "Wrestling", "https://www.youtube.com/watch?v=NYzxYzM3Rj8");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "Gran Turismo 7 builds on 22 years of experience to bring you the best features from the history of the franchise.", 
"21 hrs", "Gran Turismo 7", "https://imgur.com/Y0EWHlk", "PlayStation 4, PlayStation 5", "69.99", "Polyphony Digital", "Sony Interactive Entertainment", "March 4, 2022", "0", "Racing, Simulation", "https://www.youtube.com/watch?v=1tBUsXIkG1A");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "Horizon: Forbidden West continues Aloy’s story as she moves west to a far-future America to brave a majestic, but dangerous frontier where she’ll face awe-inspiring machines and mysterious new threats.", 
"28 hrs", "Horizon Forbidden West", "https://imgur.com/6ITtISZ", "PlayStation 4, PlayStation 5", "59", "Guerrilla Games", "Sony Interactive Entertainment", "February 18, 2022", "0", "Sci-Fi, Action, Adventure, RPG, Open-World", "https://www.youtube.com/watch?v=UxDWGW7Z67I");

INSERT INTO video_game_category
(age_limit, description, ms_hour, name, pic, platform, price, producer, publisher, release_date, score, type, url)
VALUES
("None", "Take a trip across a lush skateboarding utopia that is filled to the brim with eccentric characters and vibrant locations that are begging to be explored in OlliOlli World.", 
"6 hrs", "OlliOlli World", "https://imgur.com/pNmFSeE", "PC, PlayStation 4, PlayStation 5, Xbox One, Xbox Series X|S, Nintendo Switch", "29.99", "Roll7", "Private Division", "February 8, 2022", "0", "Private Division", "https://www.youtube.com/watch?v=-OrHNwx6Yik");

