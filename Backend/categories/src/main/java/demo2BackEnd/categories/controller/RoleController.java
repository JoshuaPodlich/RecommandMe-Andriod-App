package demo2BackEnd.categories.controller;

import demo2BackEnd.categories.model.*;
import demo2BackEnd.categories.repository.AdminRepository;
import demo2BackEnd.categories.repository.BanUserRepository;
import demo2BackEnd.categories.repository.GuestRepository;
import demo2BackEnd.categories.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "Role Controller", description = "control all roles (Admin, User, Guest) API")
public class RoleController {
    @Autowired
    BanUserRepository banUser;

    @Autowired
    UserRepository user;

    @Autowired
    GuestRepository guest;

    @Autowired
    AdminRepository admin;

    @Operation(summary = "Find all banned users info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all banned users",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Banned user not found",
                    content = @Content) })
    @GetMapping("BanUser/info")
    List<BanUser> GetAllBanUser(){
        return banUser.findAll();
    }

    @Operation(summary = "Find a banned user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the banned user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @GetMapping("BanUser/info/{id}")
    BanUser BanUserByID(@PathVariable("id") long id)
    {
        return banUser.findById(id).orElse(null);
    }

    @Operation(summary = "Find all users info")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all users",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Users not found",
                    content = @Content) })
    @GetMapping("User/info")
    List<User> GetAllUser(){
        return user.findAll();
    }

    @Operation(summary = "Find a user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @GetMapping("User/info/{id}")
    User UserByID(@PathVariable("id") long id)
    {
        return user.findById(id).orElse(null);
    }

    @Operation(summary = "Find a user by the username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Username",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @GetMapping("User/get/{username}")
    User GetUserByUsername(@PathVariable("username") String username){
        return user.findByUsername(username);
    }

    @Operation(summary = "Find a user by the username and password")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid Username + password",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @GetMapping("User/get/{username}/{password}")
    User UserByUsernameANDPassword(@PathVariable("username") String username, @PathVariable("password") String password){
        return user.findByUsernameAndPassword(username, password);
    }

    @GetMapping("User/info/banned")
    List<User> GetUserByBoolean(){
        return user.findByBannedTrue();
    }

    @GetMapping("Guest/info")
    List<Guest> GetAllGuest(){
        return guest.findAll();
    }

    @GetMapping("Guest/info/{id}")
    Guest GuestById(@PathVariable("id") long id)
    {
        return guest.findById(id).orElse((null));
    }

    @Operation(summary = "Find all admins")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all admins",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid operation",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Admins not found",
                    content = @Content) })
    @GetMapping("Admin/info")
    List<Admin> GetAllAdmin(){
        return admin.findAll();
    }

    @Operation(summary = "Register a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Register succeed",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Registration not working",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Register not finish",
                    content = @Content) })
    @PostMapping("User/register")
    User PostUserByPath(@RequestBody User newUser){
        user.save((newUser));
        return newUser;
    }

    @PostMapping("Guest/post")
    Guest PostGuestByPath(@RequestBody Guest g){
        guest.save(g);
        return g;
    }

    @Operation(summary = "Post a admin by user_uuid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Admin register succeed",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid user UUID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @PostMapping("Admin/register/{userid}")
    public String PostAdminByPath(@PathVariable("userid") UUID userid){
        User usr = user.findByUserID(userid);
        Admin newAdmin = new Admin();
        if(usr == null){
            return "Can't find the user under UUID - " + userid + " , please check the userid!";
        }else{
            usr.setAdmin(true);
            user.save(usr);
            newAdmin.setUser(usr);
            newAdmin.setUserid(userid);
            admin.save(newAdmin);
            return "Administrator registered: " + userid;
        }
    }

    @DeleteMapping("Admin/delete/{id}")
    public String DeleteAdmin(@PathVariable("id") long id){
        Admin ad = admin.findById(id).orElse(null);
        if(ad != null){
            User usr = user.findByUserID(ad.getUserid());
            usr.setAdmin(false);
            user.save(usr);
            admin.delete(ad);
            return "Admin: " + ad.getUserid() + " delete successfully!";
        }else{
            return "There is no admin found in record!";
        }
    }

    @Operation(summary = "Fill a reason for the ban reason")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the banned user and comment done",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Banned user not found",
                    content = @Content) })
    //fill a reason for the ban reason
    @PutMapping("BanUser/post/{id}/{reason}/{admin_id}")
    public String UpdateBanUserbyPath(@PathVariable("id") long id, @PathVariable("reason") String reason, @PathVariable("admin_id") UUID admin_id){
        User usr = user.findByUserID(admin_id);
        if(usr != null){
            Admin ad = admin.findByUser(usr);
            if(ad != null){
                BanUser newBanUser = new BanUser();
                newBanUser = banUser.findById(id).orElse(null);
                newBanUser.setReasons(reason);
                banUser.save((newBanUser));
                return "updated done";
            }
            else{
                return "Please check your admin id!";
            }
        }else{
            return "There is no id found in record!";
        }

    }

    @Operation(summary = "Ban a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user and banned",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BanUser.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid ID",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    //ban user
    @PostMapping("User/ban/{userid}")
    public String UpdateBannedStatus(@RequestBody BanUser bu, @PathVariable("userid") UUID userid){
        User us = user.findByUserID(userid);
        if(us != null){
            us.setBanned(true);
            user.save(us);
            bu.setUserid(userid);
            bu.setUser(us);
            banUser.save(bu);
            return "banned and saved";
        }else{
            return "There is no user found in record!";
        }
    }

    @DeleteMapping("BanUser/delete/{id}")
    public String ReviveABannedUser(@PathVariable("id") long id){
        BanUser bu = banUser.findById(id).orElse(null);
        if(bu != null){
            User usr = user.findByUserID(bu.getUserid());
            usr.setBanned(false);
            user.save(usr);
            banUser.delete(bu);
            return "User: " + bu.getUserid() + " unlock successfully!";
        }else{
            return "There is no banned user found in record!";
        }
    }
}
