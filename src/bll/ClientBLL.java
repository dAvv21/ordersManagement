package bll;

import bll.validators.EmailValidator;
import bll.validators.Validators;
import dao.ClientDAO;
import model.Client;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * In this class are made the calls for the query methods for the Clients table.
 */

public class ClientBLL {

    private List<Validators<Client>> validators;
    private ClientDAO clientDAO;

    /**
     * ClientBLL constructor
     */
    public ClientBLL() {
        validators = new ArrayList<Validators<Client>>();
        validators.add(new EmailValidator());
        clientDAO = new ClientDAO();
    }

    /**
     * This method calls the insert method in OrderDAO and the method from the above for creating clients table displayed view
     * @param clientList list of clients
     * @return JTable
     */
    public JTable createTable(List<Client> clientList) {
        return clientDAO.createTable(clientList);
    }

    /**
     * Method for finding a client by id
     * @param id search id
     * @return Client
     */
    public Client findClientById(int id) {
        Client client = clientDAO.findById(id);
        if (client == null) {
            throw new NoSuchElementException("The client with id =\" + id + \" was not found!");
        }
        return client;
    }

    /**
     * Method for validating and insert a client
     * @param client client to be inserted
     * @return int
     */
    public int insertClient(Client client) {
        for (Validators i : validators) {
            i.validate(client);
        }
        return clientDAO.insert(client);
    }

    /**
     * Method for validating and editing a client in db
     * @param client client to be edited
     * @return int
     */
    public int editClient(Client client) {
        for (Validators i : validators) {
            i.validate(client);
        }
        return clientDAO.update(client);
    }

    /**
     * Method for deleting a client
     * @param id client id to be deleted
     * @return int (deletedID)
     */
    public int deleteClientById(int id) {
        int deletedId = clientDAO.delete(id);
        return deletedId;
    }

    /**
     * Method for finding all clients
     * @return list
     */
    public List<Client> findAllClients() {
        List<Client> list = clientDAO.findAll();
        if (list == null) {
            throw new NoSuchElementException("Clients were not found!");
        }
        return list;
    }


}
