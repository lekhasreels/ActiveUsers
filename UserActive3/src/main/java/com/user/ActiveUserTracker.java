package com.user;

import java.util.ArrayList;
import java.util.List;

public class ActiveUserTracker {
	 public static void main(String[] args) {
	        // Simulate user logins
	        for (int i = 1; i <= 10; i++) {
	            User user = new User("User" + i);
	            addUser(user);

	            // Simulate user activity
	            Thread activityThread = new Thread(() -> {
	                try {
	                    Thread.sleep(5000); // Simulate activity for 5 seconds
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                removeUser(user);
	            });
	            activityThread.start();
	        }

	        // Print active user count on the homepage
	        System.out.println("Total Active Users on Homepage: " + getActiveUserCount());
	    }

	private static List<User> activeUsers = new ArrayList<>();

    public static synchronized void addUser(User user) {
        activeUsers.add(user);
    }

    public static synchronized void removeUser(User user) {
        activeUsers.remove(user);
    }

    public static synchronized int getActiveUserCount() {
        return activeUsers.size();
    }
}
