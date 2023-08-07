package com.gamestore.model;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

    @Entity
    @Table(name = "users")
    public class User {
        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String firstName;
        @Column
        private String lastName;

        @Column(unique = true)
        private String email;

        @Column
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private String password;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "profile_id", referencedColumnName = "id")
        private UserProfile userProfile;

        public User() {
        }

        public User(String firstName, String lastName, String email, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public UserProfile getUserProfile() {
            return userProfile;
        }

        public void setUserProfile(UserProfile userProfile) {
            this.userProfile = userProfile;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    ", userProfile=" + userProfile +
                    '}';
        }
    }
