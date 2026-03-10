package sio.tp4.models;

import java.util.ArrayList;

public class Client
{
    private String nom;
    private int numero;
    private ArrayList<Releve> releves;

    public Client(String nom, int numero) {
        this.nom = nom;
        this.numero = numero;
        this.releves = new ArrayList<>();
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

    public ArrayList<Releve> getReleves() {
        return releves;
    }

    public void setReleves(ArrayList<Releve> releves) {
        this.releves = releves;
    }

    public void addReleve(Releve r)
    {
        this.releves.add(r);
    }

    public int calculConso()
    {
        int conso = 0;

        if (releves.isEmpty())
        {
            conso = 0;
        }
        else if (releves.size() == 1)
        {
            conso = releves.get(0).getValeurReleve();
        }
        else
        {
            conso = releves.getLast().getValeurReleve() - releves.get(releves.size() - 2).getValeurReleve();
        }

        return conso;
    }

    public boolean verifValeur(int valeur)
    {
        if (releves.getLast().getValeurReleve() > valeur)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
