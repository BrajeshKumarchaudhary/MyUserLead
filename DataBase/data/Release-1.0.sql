INSERT INTO `leadData`.`country`(`id`,`country_name`,`country_code`)VALUES(1,"INDIA","IN");


INSERT INTO `leadData`.`state`
(`id`,
`state_name`,
`state_code`,
`country_code`)
VALUES
(1,"Andaman and Nicobar Islands","IN-AN","IN"),(2,"Andhra Pradesh","IN-AP","IN"),
(3,"Arunachal Pradesh","IN-AR","IN"),(4,"Assam","IN-AS","IN"),
(5,"Bihar","IN-BR","IN"),(6,"Chandigarh","IN-CH","IN"),
(7,"Chhattisgarh","IN-CT","IN"),(8,"Daman and Diu","IN-DD","IN"),
(9,"Delhi","IN-DL","IN"),(10,"Dadra and Nagar Haveli","IN-DN","IN"),
(11,"Goa","IN-GA","IN"),(12,"Gujarat","IN-GJ","IN"),
(13,"Himachal Pradesh","IN-HP","IN"),(14,"Haryana","IN-HR","IN"),
(15,"Jharkhand","IN-JH","IN"),(16,"Jammu and Kashmir","IN-JK","IN"),
(17,"Karnataka","IN-KA","IN"),(18,"Kerala","IN-KL","IN"),
(19,"Lakshadweep","IN-LD","IN"),(20,"Maharashtra","IN-MH","IN"),
(21,"Meghalaya","IN-ML","IN"),(22,"Manipur","IN-MN","IN"),
(23,"Madhya Pradesh","IN-MP","IN"),(24,"Mizoram","IN-MZ","IN"),
(25,"Nagaland","IN-MP","NL"),(26,"Orissa","IN-OR","IN"),
(27,"Punjab","IN-PB","IN"),(28,"Pondicherry","IN-PY","IN"),
(29,"Rajasthan","IN-RJ","IN"),(30,"Sikkim","IN-SK","IN"),
(31,"Tamil Nadu","IN-TN","IN"),(32,"Tripura","IN-TR","IN"),
(33,"Uttaranchal","IN-UL","IN"),(34,"Uttar Pradesh","IN-UP","IN"),
(35,"West Bengal","IN-WB","IN");




INSERT INTO `leadData`.`workList`
(`id`,
`work_name`,
`work_code`)
VALUES
(1,"MAINTENANCE","W_MN"),(2,"NEW","W_NW"),
(3,"STATIC WEB APPLICATION","W_ST"),(4,"DYNAMIC WEB APPLICATION","W_DY"),
(5,"BACKEND DEVELOPEMENT","W_BC"),(6,"FRONTEND DEVELOPEMENT","W_FT"),
(7,"REST WEB API","W_RT");
