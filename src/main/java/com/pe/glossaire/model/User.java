package com.pe.glossaire.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;




import javax.persistence.*;
import javax.validation.constraints.NotNull;

    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;


        public  String  name;

        public  String  login;

        public User(){

        }

        public User(String name, String login) {
            this.name = name;
            this.login = login;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }
    }
