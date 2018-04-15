package com.example.demo.controller;

import com.example.demo.model.Card;
import com.example.demo.model.CardStatus;
import com.example.demo.model.CardType;
import com.example.demo.model.User;
import com.example.demo.service.CardService;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController()
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CardService cardService;

    public BackendController(CardService cardService, UserService userService) {
        this.cardService = cardService;
        this.userService = userService;
    }

    @RequestMapping(path = "/get-users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(path = "/get-cards")
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.findAll();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @RequestMapping(path = "/get-types")
    public ResponseEntity<List<String>> getAllTypes() {
        List<String> types = Stream.of(CardType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return new ResponseEntity<>(types, HttpStatus.OK);
    }

    @RequestMapping(path = "/get-statuses")
    public ResponseEntity<List<String>> getAllStatuses() {
        List<String> statuses = Stream.of(CardStatus.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        return new ResponseEntity<>(statuses, HttpStatus.OK);
    }

    @RequestMapping(path = "/update-card-status", method = RequestMethod.POST)
    public ResponseEntity updateCardStatus(@RequestBody Card card) {
        Card existingCard = cardService.findById(card.getId());
        if (existingCard == null){
            LOGGER.info("No card with such id");
            return new ResponseEntity("No card with such id", HttpStatus.NOT_FOUND);
        }
        existingCard.setStatus(card.getStatus());
        Card updated;
        try {
            LOGGER.info("Start updating card");
            updated = cardService.updateCard(existingCard);
        } catch (Exception e) {
            return new ResponseEntity(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @RequestMapping(path = "/update-card", method = RequestMethod.POST)
    public ResponseEntity updateCard(@RequestBody Card card) {
        try {
            LOGGER.info("Start updating card");
            Card updated = cardService.updateCard(card);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/remove-card", method = RequestMethod.POST)
    public ResponseEntity removeCard(@RequestBody int id) {
        try {
            LOGGER.info("Start updating card");
            cardService.removeCard(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/get-user", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@RequestParam(name = "id") int id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(path = "/get-card", method = RequestMethod.GET)
    public ResponseEntity<Card> getCard(@RequestParam(name = "id") int id) {
        if (id <= 0){
            return new ResponseEntity<>(new Card(), HttpStatus.OK);
        }
        Card card = cardService.findById(id);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }
}
