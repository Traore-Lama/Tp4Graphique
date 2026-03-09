package sio.tp4.models;

public class Releve
{
    private String dateReleve;
    private int valeurReleve;

    public Releve(String dateReleve, int valeurReleve)
    {
        this.dateReleve = dateReleve;
        this.valeurReleve = valeurReleve;
    }

    public String getDate()
    {
        return this.dateReleve;
    }

    public int getValeurReleve()
    {
        return this.valeurReleve;
    }

    public void setDateReleve(String dateReleve)
    {
        this.dateReleve = dateReleve;
    }

    public void setValeurReleve(int valeurReleve)
    {
        this.valeurReleve = valeurReleve;
    }

}
