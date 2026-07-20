-- Insert Cities
INSERT INTO City (City_ID, Name, Country) VALUES
(1, 'Riyadh', 'Saudi Arabia'),
(2, 'Jeddah', 'Saudi Arabia'),
(3, 'AlKhobar', 'Saudi Arabia'),
(4, 'AlUla', 'Saudi Arabia');

-- Insert Users
INSERT INTO User (User_ID, First_Name, Last_Name, Email, Password, Phone, Role) VALUES 
(1, 'Ali', 'Ahmed', 'ali@email.com', 'password123', '0501234567', 'Customer'),
(2, 'Sara', 'Khalid', 'sara@email.com', 'securepass', '0509876543', 'Organizer'),
(3, 'Admin', 'User', 'admin@email.com', 'adminpass', '0512345678', 'Admin'),
(4, 'Mohammed', 'Salman', 'mohammed@email.com', 'pass123', '0523456789', 'Customer'),
(5, 'Fatima', 'Hassan', 'fatima@email.com', 'securepass', '0539876543', 'Customer'),
(6, 'Yousef', 'AlHarbi', 'yousef@email.com', 'pass456', '0548765432', 'Customer'),
(7, 'Layla', 'Nasser', 'layla@email.com', 'mypass', '0557654321', 'Customer'),
(8, 'Ahmed', 'Tariq', 'ahmedtariq@email.com', 'pass1', '0500000001', 'Organizer'),
(9, 'Nora', 'Faisal', 'nora@email.com', 'pass2', '0500000002', 'Organizer'),
(10, 'Omar', 'Yazid', 'omaryazid@email.com', 'pass3', '0500000003', 'Organizer'),
(11, 'Lina', 'Saeed', 'lina@email.com', 'pass4', '0500000004', 'Organizer'),
(12,'Shekha','Sami','Shekhasgmail.com','SSDQW123!','0500100304','Customer'),
(13,'Saude','Saleh','Sudez@gmai.com','SSSZ96','0500107304','Customer'),
(14,'Maryam','Sami','Maryy90@gmail.com','M23do08','0500147304','Customer');
-- Insert Organizers
INSERT INTO Organizer (User_ID, Description) VALUES
(2, 'Organizes hiking and adventure trips'),
(8, 'Provides guided city tours'),
(9, 'Specializes in AlUla tourism'),
(10, 'Entertainment events in Riyadh'),
(11, 'Watersports and diving in Jeddah');

-- Insert Administrator
INSERT INTO Administrator (User_ID, Permissions) VALUES
(3, 'Full Access');

-- Insert Trip Events 
INSERT INTO TripEvent (Event_ID, Name, Date, City_ID, Price, Category, Available_Seat, User_ID) VALUES
(1, 'Rock Climbing', '2025-08-20', 4, 250.00, 'Adventure', 15, 2),
(2, 'Dadan Tour', '2025-07-15', 4, 60.00, 'Adventure', 25, 2),
(3, 'Maraya Hall Tour', '2025-07-22', 4, 90.00, 'Cultural', 30, 9),
(4, 'National Museum', '2025-06-30', 1, 10.00, 'Cultural', 50, 10),
(5, 'Riyadh Season', '2025-11-30', 1, 200.00, 'Entertainment', 40, 10),
(6, 'Diving Trips', '2025-06-29', 2, 365.00, 'Adventure', 10, 11),
(7, 'Ithra Visit', '2025-07-14', 3, 35.00, 'Cultural', 20, 8),
(8, 'Escape Room', '2025-09-10', 3, 260.00, 'Entertainment', 10, 8);

-- Insert Bookings
INSERT INTO Booking (Booking_ID, User_ID, Event_ID, Booking_Status, Payment_Status) VALUES
(1, 1, 1, 'Confirmed', 'Paid'),
(2, 4, 2, 'Pending', 'Unpaid'),
(3, 5, 7, 'Confirmed', 'Paid'),
(4, 6, 8, 'Confirmed', 'Paid'),
(5, 7, 3, 'Confirmed', 'Paid'),
(6, 12, 5, 'Confirmed', 'Paid'),
(7, 13, 4, 'Confirmed', 'Paid'),
(8, 14, 6, 'Confirmed', 'Paid');
-- Insert Payments
INSERT INTO Payment (Payment_ID, Booking_ID, Amount, Payment_Method, Status) VALUES
(1, 1, 250.00, 'Credit Card', 'Completed'),
(2, 3, 250.00, 'Cash', 'Pending');

-- Insert Reviews
INSERT INTO ReviewRating (Review_ID, User_ID, Event_ID, Rating, Comment, Date) VALUES
(1, 1, 5, 5, 'Amazing experience!', '2025-06-11'),
(2, 1, 4, 4, 'Very informative tour.', '2025-07-16');

-- Insert Notifications
INSERT INTO Notification (Notification_ID, User_ID, Type, Message, Date_Time) VALUES
(1, 1, 'Booking Confirmation', 'Your trip has been booked.', '2025-06-05 10:00:00'),
(2, 2, 'Payment Reminder', 'Payment for City Tour is pending.', '2025-07-10 15:00:00');

-- Insert Services
INSERT INTO Service (Service_ID, Name, Price, Description, Event_ID) VALUES
(1, 'Photography Package', 50.00, 'Professional photography during the event.', 1),
(2, 'VIP Transport', 100.00, 'Luxury transportation for the tour.', 2);

-- Insert Flights
INSERT INTO Flight (Flight_ID, Airline_Name, Flight_Num, Departure_APT, Arrival_APT, Event_ID) VALUES
(1, 'Saud Airlines', 'SV101', 'DMM', 'ULA', 1),
(2, 'Saud Airlines', 'SV101', 'RUH', 'RUH', 4),
(3, 'Saud Airlines', 'SV101', 'RUH', 'DMM', 8),
(4, 'Saud Airlines', 'SV101', 'JED', 'ULA', 2),
(5, 'Saud Airlines', 'SV101', 'RUH', 'ULA', 3),
(6, 'Saud Airlines', 'SV101', 'ULA', 'JED', 6);
-- Insert Train Trips 
INSERT INTO TrainTrip (TrainTrip_ID, TrainTrip_Num, Departure_STN, Arrival_STN, Event_ID) VALUES
(1, 'SAR', 'AlKhobar Station', 'Riyadh Station', 5),
(2, 'SAR', 'Riyadh Station', ' AlKhobar Station', 7);

