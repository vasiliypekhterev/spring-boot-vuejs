package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Card {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Enumerated(value = EnumType.STRING)
   private CardType type;

   @Column(nullable = false)
   private String title;

   @Column
   private String description;

   @Column
   private Integer estimation;

   @Enumerated(value = EnumType.STRING)
   private CardStatus status;

   @JsonIgnoreProperties("cards")
   @ManyToMany
   @JoinTable(name="card_user",
           joinColumns = @JoinColumn(name = "card_id", referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
   private List<User> users;

    public Card() {
    }

    public Card(CardType type, String title, String description, Integer estimation, CardStatus status, List<User> owners) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.estimation = estimation;
        this.status = status;
        this.users = owners;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEstimation() {
        return estimation;
    }

    public void setEstimation(Integer estimation) {
        this.estimation = estimation;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
