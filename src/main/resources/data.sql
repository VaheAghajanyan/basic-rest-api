insert into user_details(id, birth_date, name) values
                                                   (1000, current_date(), 'Vahe'),
                                                   (1001, current_date(), 'Ranga'),
                                                   (1002, current_date(), 'Poghos');
insert into post(id, description, user_id) values
                                               (2001, 'I want to Learn AWS', 1001),
                                               (2002, 'I want to Learn Gcloud', 1001),
                                               (2003, 'I want to Learn Azure', 1002),
                                               (2004, 'I want to Learn Spring Boot', 1002)