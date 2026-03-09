package sio.tp4.models;
import java.util.ArrayList;

public class Agent
{
    private String nom;
    private int numero;
    private ArrayList<Client> clients ;

    public Agent(String nom, int numero) {
        this.nom = nom;
        this.numero = numero;
        this.clients = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client c)
    {
        this.clients.add(c);
    }
}
