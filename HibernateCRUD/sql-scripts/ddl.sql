CREATE TABLE `user` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `username` varchar(45) NOT NULL,
   `password` varchar(45) NOT NULL,
   `firstname` varchar(45) NOT NULL,
   `lastname` varchar(45) DEFAULT NULL,
   `address` varchar(45) DEFAULT NULL,
   `phone` bigint(15) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1
 
