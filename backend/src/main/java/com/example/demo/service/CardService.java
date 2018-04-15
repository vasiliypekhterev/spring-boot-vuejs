package com.example.demo.service;

import com.example.demo.model.Card;

import java.util.List;

public interface CardService {

    Card createCard(Card card);
    Card updateCard(Card card);
    void removeCard(int id);
    List<Card> findAll();
    Card findById(int id);
}
