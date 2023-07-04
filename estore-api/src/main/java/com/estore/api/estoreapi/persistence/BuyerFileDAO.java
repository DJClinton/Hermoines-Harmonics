package com.estore.api.estoreapi.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

import com.estore.api.estoreapi.model.Buyer;
import com.estore.api.estoreapi.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Implements the functionality for JSON file-based peristance for Buyers
 * 
 * {@literal @}Component Spring annotation instantiates a single instance of this
 * class and injects the instance into other classes as needed
 * 
 * @author Team 2
 */
@Component
public class BuyerFileDAO implements BuyerDAO {
    private static final Logger LOG = Logger.getLogger(BuyerFileDAO.class.getName());
    Map<Integer, Buyer> buyers;   // Provides a local cache of the buyer objects
                                // so that we don't need to read from the file
                                // each time
    private ObjectMapper objectMapper;  // Provides conversion between Buyer
                                        // objects and JSON text format written
                                        // to the file
    private static int nextId;  // The next Id to assign to a new product
    private String filename;    // Filename to read from and write to

    /**
     * Creates a Buyer File Data Access Object
     * 
     * @param filename Filename to read from and write to
     * @param objectMapper Provides JSON Object to/from Java Object serialization and deserialization
     * 
     * @throws IOException when file cannot be accessed or read from
     */
    public BuyerFileDAO(@Value("${buyers.file}") String filename, ObjectMapper objectMapper) throws IOException {
        this.filename = filename;
        this.objectMapper = objectMapper;
        load();  // load the buyers from the file
    }

    /**
     * Generates the next id for a new {@linkplain Product product}
     * 
     * @return The next id
     */
    private synchronized static int nextId() {
        int id = nextId;
        ++nextId;
        return id;
    }


    /**
     * Generates an array of {@linkplain Buyer buyers} from the tree map
     * 
     * @return  The array of {@link Buyer buyers}, may be empty
     */
    private Buyer[] getBuyersArray() {
        ArrayList<Buyer> buyerArrayList = new ArrayList<>();

        for (Buyer buyer : buyers.values()) {
            buyerArrayList.add(buyer);
        }

        Buyer[] buyerArray = new Buyer[buyerArrayList.size()];
        buyerArrayList.toArray(buyerArray);
        return buyerArray;
    }

    /**
     * Saves the {@linkplain Buyer buyers} from the map into the file as an array of JSON objects
     * 
     * @return true if the {@link Buyer buyers} were written successfully
     * 
     * @throws IOException when file cannot be accessed or written to
     */
    private boolean save() throws IOException {
        Buyer[] buyerArray = getBuyersArray();

        // Serializes the Java Objects to JSON objects into the file
        // writeValue will thrown an IOException if there is an issue
        // with the file or reading from the file
        objectMapper.writeValue(new File(filename), buyerArray);
        return true;
    }

    /**
     * Loads {@linkplain Buyer buyers} from the JSON file into the map
     * <br>
     * Also sets next id to one more than the greatest id found in the file
     * 
     * @return true if the file was read successfully
     * 
     * @throws IOException when file cannot be accessed or read from
     */
    private boolean load() throws IOException {
        buyers = new TreeMap<>();
        nextId = 0;

        // Deserializes the JSON objects from the file into an array of buyers
        // readValue will throw an IOException if there's an issue with the file
        // or reading from the file
        Buyer[] buyerArray = objectMapper.readValue(new File(filename),Buyer[].class);

        // Add each product to the tree map and keep track of the greatest id
        for (Buyer buyer : buyerArray) {
            buyers.put(buyer.getId(), buyer);
            if (buyer.getId() > nextId)
                nextId = buyer.getId();
        }
        // Make the next id one greater than the maximum from the file
        ++nextId;

        return true;
    }

    /**
    ** {@inheritDoc}
     */
    @Override
    public Buyer[] getBuyers() {
        synchronized(buyers) {
            return getBuyersArray();
        }
    }

    /**
    ** {@inheritDoc}
     */
    @Override
    public Buyer getBuyer(int id) {
        synchronized(buyers) {
            if (buyers.containsKey(id))
                return buyers.get(id);
            else
                return null;
        }
    }

    /**
    ** {@inheritDoc}
     */
    @Override
    public Buyer createBuyer(Buyer buyer) throws IOException {
        synchronized(buyers) {
            buyers.put(buyer.getId(), buyer);
            save(); // may throw an IOException
            return buyer;
        }
    }

    /**
    ** {@inheritDoc}
     */
    @Override
    public Buyer updateBuyer(Buyer buyer) throws IOException {
        synchronized(buyers) {
            if (!buyers.containsKey(buyer.getId()))
                return null;  // buyer does not exist

            buyers.put(buyer.getId(), buyer);
            save(); // may throw an IOException
            return buyer;
        }
    }

    /**
    ** {@inheritDoc}
     */
    @Override
    public boolean deleteBuyer(int id) throws IOException {
        synchronized(buyers) {
            if (buyers.containsKey(id)) {
                buyers.remove(id);
                return save();
            }
            else
                return false;
        }
    }
}