package com.estore.api.estoreapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.estore.api.estoreapi.persistence.BuyerDAO;
import com.estore.api.estoreapi.model.Buyer;

/**
 * Handles the REST API requests for the Buyer resource
 * <p>
 * {@literal @}RestController Spring annotation identifies this class as a REST
 * API
 * method handler to the Spring framework
 * 
 * @author SWEN Faculty
 */

@RestController
@RequestMapping("account")
public class BuyerController {
    private static final Logger LOG = Logger.getLogger(InventoryController.class.getName());
    private BuyerDAO buyerDao;

    /**
     * Creates a REST API controller to reponds to requests
     * 
     * @param buyerDao The {@link BuyerDAO Buyer Data Access Object} to perform CRUD
     *                 operations
     *                 <br>
     *                 This dependency is injected by the Spring Framework
     */
    public BuyerController(BuyerDAO buyerDao) {
        this.buyerDao = buyerDao;
    }

    /**
     * Responds to the GET request for a {@linkplain Buyer buyer} for the given id
     * 
     * @param id The id used to locate the {@link Buyer buyer}
     * 
     * @return ResponseEntity with {@link Buyer buyer} object and HTTP status of OK
     *         if found<br>
     *         ResponseEntity with HTTP status of NOT_FOUND if not found<br>
     *         ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getBuyer(@PathVariable int id) {
        LOG.info("GET /account/" + id);
        try {
            Buyer buyer = buyerDao.getBuyer(id);
            if (buyer == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            return new ResponseEntity<Buyer>(buyer, HttpStatus.OK);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Responds to the GET request for all {@linkplain Buyer buyers}
     * 
     * @return ResponseEntity with array of {@link Buyer buyer} objects (may be
     *         empty) and
     *         HTTP status of OK<br>
     *         ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     * 
     *         TODO only admin should be able to see full list of buyers
     */
    @GetMapping("")
    public ResponseEntity<Buyer[]> getBuyers() {
        LOG.info("GET /account");
        try {
            Buyer[] buyers = buyerDao.getBuyers();
            return new ResponseEntity<Buyer[]>(buyers, HttpStatus.OK);
        } catch (IOException ioe) {
            LOG.log(Level.SEVERE, ioe.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Creates a {@linkplain Buyer buyer} with the provided buyer object
     * 
     * @param buyer - The {@link Buyer buyer} to create
     * 
     * @return ResponseEntity with created {@link Buyer buyer} object and HTTP
     *         status of CREATED<br>
     *         ResponseEntity with HTTP status of CONFLICT if {@link Buyer buyer}
     *         object already exists<br>
     *         ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @PostMapping("")
    public ResponseEntity<Buyer> createBuyer(@RequestBody Buyer buyer) {
        LOG.info("POST /account " + buyer);

        try {
            for (Buyer existingBuyer : buyerDao.getBuyers()) {
                if (existingBuyer.getEmail().equals(buyer.getEmail())) {
                    return new ResponseEntity<Buyer>(HttpStatus.CONFLICT);
                }
            }

            buyer = buyerDao.createBuyer(buyer);
            return new ResponseEntity<Buyer>(buyer, HttpStatus.CREATED);

        } catch (IOException ioe) {
            LOG.log(Level.SEVERE, ioe.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Updates the {@linkplain Buyer buyer} with the provided {@linkplain Buyer
     * buyer} object, if it exists
     * 
     * @param buyer The {@link Buyer buyer} to update
     * 
     * @return ResponseEntity with updated {@link Buyer buyer} object and HTTP
     *         status of OK if updated<br>
     *         ResponseEntity with HTTP status of NOT_FOUND if not found<br>
     *         ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @PutMapping("")
    public ResponseEntity<Buyer> updateBuyer(@RequestBody Buyer buyer) {
        LOG.info("PUT /account " + buyer);

        try {
            buyer = buyerDao.updateBuyer(buyer);

            if (buyer == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Buyer>(buyer, HttpStatus.OK);

        } catch (IOException ioe) {
            LOG.log(Level.SEVERE, ioe.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a {@linkplain Buyer buyer} with the given id
     * 
     * @param id The id of the {@link Buyer buyer} to deleted
     * 
     * @return ResponseEntity HTTP status of OK if deleted<br>
     *         ResponseEntity with HTTP status of NOT_FOUND if not found<br>
     *         ResponseEntity with HTTP status of INTERNAL_SERVER_ERROR otherwise
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Buyer> deleteBuyer(@PathVariable int id) {
        LOG.info("DELETE /account/" + id);

        try {
            if (!buyerDao.deleteBuyer(id)) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException ioe) {
            LOG.log(Level.SEVERE, ioe.getLocalizedMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}