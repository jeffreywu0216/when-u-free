package com.whenufree;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.whenufree.services.EmailService;
import com.whenufree.services.FriendGroupService;
import com.whenufree.services.TimeSlotService;
import com.whenufree.services.UserService;
import com.whenufree.dao.GroupFreeTimeDao;
import com.whenufree.model.FreeTime;
import com.whenufree.model.FriendGroup;
import com.whenufree.model.GroupFreeTime;
import com.whenufree.model.TimeSlot;
import com.whenufree.model.User;

import java.util.List;

@SpringBootApplication
public class WhenufreeApplication {

    @Autowired
    UserService userService;
    
    @Autowired
    TimeSlotService timeSlotService;
    
    @Autowired
    FriendGroupService friendGroupService;
    
    @Autowired
    GroupFreeTimeDao groupFreeTimeDao;
    
  //  public TimeSlotService getTimeSlotService(){
 //   	return timeSlotService;
  //  }

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public static void main(String[] args) {
	SpringApplication.run(WhenufreeApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner runner() {
	return args -> {

	    User u = userService.findByUserId(1L);
	    if(u != null && u.getPasswordHash().length() < 50){
		u.setPasswordHash(bCryptPasswordEncoder.encode(u.getPasswordHash()));
		userService.save(u);
	    }
	  
	    
		// User u = userService.findByUserId((long) 1);
		// FriendGroup fg = friendGroupService.findByFriendGroupId((long) 1);
		// List<TimeSlot> tsList = friendGroupService.getAllGroupTimeSlots(fg);
		// List<GroupFreeTime> gft = friendGroupService.timeSlotsToGroupFreeTimes(fg, tsList);
		// //friendGroupService.addUser(fg, u);
		// System.out.println(friendGroupService.findUsers(fg));
		// System.out.println(tsList);
		// System.out.println(tsList.size());
		// System.out.println(gft);
		// System.out.println(gft.size());
		// //friendGroupService.saveGroupFreeTimes(gft);
		// System.out.println(friendGroupService.getGroupFreeTimes(fg));

		
		// User u = userService.findByUserId((long) 1);
		// User u2 = userService.findByUserId((long) 4);
		// User u3 = userService.findByUserId((long) 5);
		
		// FriendGroup fg = friendGroupService.findByFriendGroupId((long) 1);
		// FriendGroup fg2 = friendGroupService.findByFriendGroupId((long) 21);
		/*
		List<TimeSlot> tsList = friendGroupService.getAllGroupTimeSlots(fg);
		List<GroupFreeTime> gft = friendGroupService.timeSlotsToGroupFreeTimes(fg, tsList);
		//friendGroupService.addUser(fg, u);
		System.out.println(friendGroupService.findUsers(fg));
		System.out.println(tsList);
		System.out.println(tsList.size());
		System.out.println(gft);
		System.out.println(gft.size());
		//friendGroupService.saveGroupFreeTimes(gft);
		//friendGroupService.deleteFriendGroup((long) 2);
		System.out.println(friendGroupService.getGroupFreeTimes(fg));*/
		//System.out.println(fg2.getConnections());
		//System.out.println(friendGroupService.findByUser(u));
		//friendGroupService.addUser(fg2, u2);
		//System.out.println(friendGroupService.getTimeSlotByGroupFreeTime((long) 1));

		//friendGroupService.saveGroupFreeTimes(groupFreeTimesList);
		//friendGroupService.addUser(fg, u3);
		//EmailService email=new EmailService();
		//email.send("junjie2412@gmail.com","hello", "how are you?");
		/*
		StringBuilder sb = new StringBuilder();
		StringBuilder test = new StringBuilder();
		System.out.println(sb);
		System.out.println(sb.append("SU/10:00S-S11:00S"));
		System.out.println(test.append(sb));
		System.out.println(test.substring(0, 2));
		System.out.println(test.substring(3, 11));
		System.out.println(test.substring(11, 16));
		sb.delete(11, 16);*/
		/*
		friendGroupService.sendMessage(u2, fg, "hey whats up");
		friendGroupService.sendMessage(u, fg, "so you guys free tonight?");
		friendGroupService.sendMessage(u2, fg, "sorry, got a huge project coming up");
		friendGroupService.sendMessage(u, fg, "that's fine, we just finished");
		friendGroupService.sendMessage(u2, fg, "maybe next week");*/
	};
    }
}
