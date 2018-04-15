package com.example.demo.service;

import com.example.demo.model.Card;
import com.example.demo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card createCard(Card card) {
        return null;
    }

    @Override
    public Card updateCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void removeCard(int id) {
        Card card = findById(id);
        cardRepository.delete(card);
    }

    @Override
    public List<Card> findAll() {
        Iterable<Card> cards = cardRepository.findAll();
        List<Card> list = new ArrayList<>();
        cards.forEach(list::add);
        return list;
    }

    @Override
    public Card findById(int id) {
        Optional<Card> card = cardRepository.findById(id);
        if (!card.isPresent()) {
            return null;
        }
        return card.get();
    }
}
