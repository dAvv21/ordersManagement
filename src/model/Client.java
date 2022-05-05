package model;


/**
 * Class that contains data for a client stored in client table
 */
public class Client {
    private int id;
    private String name;
    private String address;
    private String email;

    /**
     * Client constructor with no parameters
     */
    public Client() {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    /**
     * Client constructor with parameters
     * @param name name of client
     * @param address address of client
     * @param email email of client
     */
    public Client(String name,String address,String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    /**
     * Client constructor with parameters
     * @param id primary key of a client
     * @param name |--|
     * @param address |--|
     * @param email |--|
     */
    public Client(int id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }


    /**
     * Returns id value
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id value
     * @param idClient
     */
    public void setId(int idClient) {
        this.id = idClient;
    }

    /**
     * Returns name of a client
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of a client
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets address of a client
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets adress of a client
     * @param address adress of a client
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns email of a client
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email of a client
     * @param email email of a client
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method for printing data of client
     * @return String
     */
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
