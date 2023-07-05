package com.estore.api.estoreapi.persistence;

import java.io.IOException;

import com.estore.api.estoreapi.model.Buyer;

/**
 * Defines the interface for Buyer object persistence
 * 
 * @author Team 2
 */
public interface BuyerDAO {
    /**
     * Retrieves all {@linkplain Buyer buyers}
     * 
     * @return An array of {@link Buyer buyers} objects, may be empty
     * 
     * @throws IOException if an issue with underlying storage
     */
    Buyer[] getBuyers() throws IOException;

    /**
     * Retrieves a {@linkplain Buyer buyer} with the given id
     * 
     * @param id The id of the {@link Buyer buyer} to get
     * 
     * @return a {@link Buyer buyer} object with the matching id
     * <br>
     * null if no {@link Buyer buyer} with a matching id is found
     * 
     * @throws IOException if an issue with underlying storage
     */
    Buyer getBuyer(int id) throws IOException;

    /**
     * Creates and saves a {@linkplain Buyer buyer}
     * 
     * @param buyer {@linkplain Buyer buyer} object to be created and saved
     * <br>
     * The id of the buyer object is ignored and a new uniqe id is assigned
     *
     * @return new {@link Buyer buyer} if successful, false otherwise 
     * 
     * @throws IOException if an issue with underlying storage
     */
    Buyer createBuyer(Buyer buyer) throws IOException;

    /**
     * Updates and saves a {@linkplain Buyer buyer}
     * 
     * @param {@link Buyer buyer} object to be updated and saved
     * 
     * @return updated {@link Buyer buyer} if successful, null if
     * {@link Buyer buyer} could not be found
     * 
     * @throws IOException if underlying storage cannot be accessed
     */
    Buyer updateBuyer(Buyer buyer) throws IOException;

    /**
     * Deletes a {@linkplain Buyer buyer} with the given id
     * 
     * @param id The id of the {@link Buyer buyer}
     * 
     * @return true if the {@link Buyer buyer} was deleted
     * <br>
     * false if buyer with the given id does not exist
     * 
     * @throws IOException if underlying storage cannot be accessed
     */
    boolean deleteBuyer(int id) throws IOException;
}
